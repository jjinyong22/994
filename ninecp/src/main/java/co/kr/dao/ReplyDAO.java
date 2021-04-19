package co.kr.dao;

import java.util.List;

import co.kr.vo.Insta_replyVO;

public interface ReplyDAO {

	public List<Insta_replyVO> readReply(int bno) throws Exception;
	
	public void writerReply(Insta_replyVO vo) throws Exception;
	
	public void deletereply(int rno) throws Exception;
	public void deletereply2(int rno) throws Exception;
}
