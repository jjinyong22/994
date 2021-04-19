package co.kr.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import co.kr.vo.Insta_replyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	SqlSession sql;
	
	@Override
	public List<Insta_replyVO> readReply(int bno) throws Exception {
		return sql.selectList("boardMapper.readReply",bno);
		}

	@Override
	public void writerReply(Insta_replyVO vo) throws Exception {
		sql.insert("boardMapper.writeReply",vo);
		
	}

	@Override
	public void deletereply(int rno) throws Exception {
		sql.delete("boardMapper.deleteReply",rno);
	}
	@Override
	public void deletereply2(int rno) throws Exception {
		sql.delete("boardMapper.deleteReply2",rno);
	}
}
