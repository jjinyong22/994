package co.kr.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import co.kr.vo.IntroVO;

@Repository
public class IntroDAOImpl implements IntroDAO {
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<IntroVO> list() throws Exception{
		return sqlSession.selectList("boardMapper.introlist");
	}
	
	@Override
	public void Introadd(IntroVO introVO){
		sqlSession.insert("boardMapper.introadd", introVO);
	}

	@Override
	public Integer Intromaxnum() {
		return sqlSession.selectOne("boardMapper.intromaxnum");
	}

	@Override
	public IntroVO introread(int intnum) throws Exception {
		
		return sqlSession.selectOne("boardMapper.introread",intnum);
	}

	@Override
	public void introupdate(IntroVO introvo) {
		sqlSession.update("boardMapper.introupdate",introvo);
	}
	
}
