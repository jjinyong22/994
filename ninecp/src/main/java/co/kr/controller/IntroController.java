package co.kr.controller;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import co.kr.service.IntroService;
import co.kr.vo.IntroVO;

@Controller
public class IntroController {

	@Inject
	IntroService introservice;

	
	@RequestMapping(value="/introadd", method = RequestMethod.GET)
	public ModelAndView introadd() {
		ModelAndView mav = new ModelAndView("jsp/introadd");
//		mav.addObject("introvo", new IntroVO());
		
		return mav;
	}
	
	@RequestMapping(value="/introadd", method= RequestMethod.POST)
	public String introadd2(
							MultipartHttpServletRequest request,
							HttpSession session,
							@RequestParam("introname")String introname,
							@RequestParam("introint")String introint,
							@RequestParam("introimg")MultipartFile introimg,
							@RequestParam("intropass")String intropass
							) throws Exception {
		System.out.println(introname);
		System.out.println(introimg);
		System.out.println(intropass);
		IntroVO introVO = new IntroVO();
		Integer num = introservice.Intromaxnum();
		if(num == null) {
				num = 0;
		}
				MultipartFile multiFile = introimg;
		
		String fileName = null;
		String path=null;
		OutputStream out = null;
		if(multiFile != null) {
			fileName = multiFile.getOriginalFilename();
			path = request.getSession().getServletContext()
					.getRealPath("resources/img/"+fileName);
			System.out.println("업로드경로:"+path);
			File file = new File(path);
			try {
				out = new FileOutputStream(file);
				BufferedInputStream bis =
					new BufferedInputStream(
						multiFile.getInputStream());
				byte[] buffer = new byte[8106];
				int read = 0;
				while((read = bis.read(buffer) ) > 0) {
					out.write(buffer,0,read);
				}
				if(out != null) out.close();
				if(bis != null) bis.close();
			}catch(Exception e) {
			}
		}
			introVO.setIntnum(num + 1);
			introVO.setIntname(introname);
			introVO.setIntint(introint);
			introVO.setIntimg(fileName);
			introVO.setIntpass(intropass);
			introservice.Introadd(introVO);
			
		return	"redirect:/intro";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "jsp/main";
	}
	
	@RequestMapping(value="/intro", method = RequestMethod.GET)
	public String introlist(Model model)throws Exception{

		model.addAttribute("introlist",introservice.list());
		
		return "jsp/intro";	
	}
	
	
	@RequestMapping(value="introdelete", method= RequestMethod.GET)
	public String introdelete(IntroVO introvo)throws Exception {
		
		introservice.introdelete(introvo.getIntnum());
		
		return "redirect:/intro";
	}
	
	@RequestMapping(value="/introupdate", method= RequestMethod.GET)
	public String introupdate(Model model,IntroVO introvo) throws Exception {
		
		model.addAttribute("introup",introservice.introread(introvo.getIntnum()));
		
		
		return "jsp/introupdate";
	}
	
	@RequestMapping(value="/introupdate", method= RequestMethod.POST)
	public String introupdate2(MultipartHttpServletRequest request,HttpSession session,
			@RequestParam("intnum")Integer num,
			@RequestParam("intname")String name,
			@RequestParam("intint")String intro,
			@RequestParam("intimg")MultipartFile img,
			@RequestParam("intpass")String pass
			)throws Exception {
		
		IntroVO introvo = new IntroVO();
		
		
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
		introvo.setIntnum(num);
		introvo.setIntname(name);
		introvo.setIntint(intro);
		introvo.setIntimg(fileName);
		introvo.setIntpass(pass);
		introservice.introupdate(introvo);
		
		
		
		return "redirect:/intro";
	}
	
	
	
	
}
