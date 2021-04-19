package co.kr.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import co.kr.dao.ReplyDAO;
import co.kr.vo.Insta_replyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO dao;
	
	
	@Override
	public List<Insta_replyVO> readReply(int bno) throws Exception {
		
		return dao.readReply(bno);
	}


	@Override
	public void wirterReply(Insta_replyVO vo) throws Exception {
		dao.writerReply(vo);
	}


	@Override
	public void deleteReply(int rno) throws Exception {
		dao.deletereply(rno);
	}
	@Override
	public void deleteReply2(int rno) throws Exception {
		dao.deletereply2(rno);
	}
}
