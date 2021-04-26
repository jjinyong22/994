package co.kr.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.service.InstaService;
import co.kr.service.ReplyService;
import co.kr.vo.InstaVO;
import co.kr.vo.Insta_replyVO;

@Controller
public class InstaController {

	@Inject
	InstaService instaService;
	
	@Inject
	ReplyService replyService;
	
	@RequestMapping(value="deleteinsta", method=RequestMethod.GET)
	public String deleteInsta(@RequestParam("bno") int insta_bno
			) throws Exception{
		replyService.deleteReply2(insta_bno);
		instaService.deleteInsta(insta_bno);
		
		return "redirect:/insta";
	}
	
	
	@RequestMapping(value="deletereply", method=RequestMethod.POST)
	public String deletereply(@RequestParam("rno")int rno,
			@RequestParam("bno")int bno,
			RedirectAttributes re,Model model,
			InstaVO instaVO) throws
	Exception{
		model.addAttribute("insta_bno",instaVO.getInsta_bno());	
		replyService.deleteReply(rno);
		re.addAttribute("insta_bno",bno);
		return "redirect:/instadetail";
	}
	
	@RequestMapping(value="reply_write", method=RequestMethod.POST)
	public String replyWriter(InstaVO instaVO,Insta_replyVO vo,
			@RequestParam("bno")int bno,
			@RequestParam("replywriter")String writer,
			@RequestParam("replycontent")String content,
			@RequestParam("reply_img")String reply_img,
			RedirectAttributes re
			) throws Exception{
		
		vo.setBno(bno);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setReply_img(reply_img);
		
		replyService.wirterReply(vo);
		
		re.addAttribute("insta_bno",bno);
		return "redirect:/instadetail";
	}
	
	@RequestMapping(value="instadetail" ,method = RequestMethod.GET)
	public String read(InstaVO instaVO,Model model
						) throws Exception {
		model.addAttribute("read",instaService.read(instaVO.getInsta_bno()));
		List<Insta_replyVO> replyList = replyService.readReply(instaVO.getInsta_bno());
		model.addAttribute("replyList",replyList);
			
			
			return "jsp/instadetail";
	}
	
	@RequestMapping(value="/insta", method = RequestMethod.GET)
	public String instalist(Model model) throws Exception {
		
		model.addAttribute("instalist",instaService.instalist());
		return "jsp/insta";
	}

	@RequestMapping(value="/instaaddhome", method = RequestMethod.GET)
	public String instaadd() {
		return "jsp/instaadd";
	}
	
	@RequestMapping(value="/instaadd", method = RequestMethod.POST)
	public String insta(MultipartHttpServletRequest request,HttpSession session,
							@RequestParam("insta_int")String INT,
							@RequestParam("insta_IMAGE")MultipartFile img,
							@RequestParam("insta_name")String name,
							@RequestParam("profile")String profile
							)throws Exception {
		InstaVO instaVO = new InstaVO();
		Integer code = instaService.maxCode();
		if(code == null) {
			code = 0;
		}
		MultipartFile multiFile = img;
		
		String fileName = null;
		String path=null;
		OutputStream out = null;
		if(multiFile != null) {
			fileName = multiFile.getOriginalFilename();
			path = request.getSession().getServletContext()
					.getRealPath("resources/img/"+fileName);
			System.out.println("업로드경로:"+path);
			File file = new File(path);//업로드될 파일이 생성
			try {
				out = new FileOutputStream(file);
				BufferedInputStream bis =
					new BufferedInputStream(
						multiFile.getInputStream());
				byte[] buffer = new byte[8106];//8K 크기
				int read = 0;
				while((read = bis.read(buffer) ) > 0) {
					out.write(buffer,0,read);
				}//파일로 출력
				if(out != null) out.close();//사용한 객체를 닫음
				if(bis != null) bis.close();//사용한 객체를 닫음
			}catch(Exception e) {
			}
		}
		instaVO.setInsta_bno(code+1);
		instaVO.setInsta_int(INT);
		instaVO.setInsta_image(fileName);
		instaVO.setInsta_love(0);
		instaVO.setInsta_name(name);
		instaVO.setInsta_profile(profile);
		instaService.Instaadd(instaVO);
		
		return "redirect:/insta";
	}
}
