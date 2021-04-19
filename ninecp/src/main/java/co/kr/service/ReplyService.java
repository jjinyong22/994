package co.kr.service;

import java.util.List;

import co.kr.vo.Insta_replyVO;

public interface ReplyService {

	public List<Insta_replyVO> readReply(int bno) throws Exception;
	
	public void wirterReply(Insta_replyVO vo) throws Exception;
	
	public void deleteReply(int rno) throws Exception;
	public void deleteReply2(int rno) throws Exception;
}
