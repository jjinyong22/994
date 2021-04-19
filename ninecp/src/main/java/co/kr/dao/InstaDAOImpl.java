package co.kr.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import co.kr.vo.InstaVO;
import co.kr.vo.Insta_addVO;

@Repository
public class InstaDAOImpl implements InstaDAO {

	@Inject
	private SqlSession session;

	@Override
	public void Instaadd(InstaVO instaVO) {
		session.insert("boardMapper.instaadd",instaVO);
	}

	@Override
	public List<Insta_addVO> getInsta_addVO(Integer code){
		return session.selectList("boardMapper.insta_add_add",code);
	}

	@Override
	public Integer maxCode() {
		return session.selectOne("boardMapper.maxCode");
	}

	@Override
	public void serInsta_add(Insta_addVO iadd) {
		session.insert("boardMapper.insta_add_add",iadd);		
	}

	@Override
	public List<InstaVO> instalist() throws Exception {
		
		return session.selectList("boardMapper.instalist");
	}

	@Override
	public InstaVO read(int bno) throws Exception {
		return session.selectOne("boardMapper.instaread",bno);
	}

	@Override
	public void deleteInsta(int insta_bno) throws Exception {
		session.delete("boardMapper.deleteInsta",insta_bno);
	}
	
}
