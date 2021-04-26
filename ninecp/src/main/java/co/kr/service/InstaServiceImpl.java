package co.kr.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.dao.InstaDAO;
import co.kr.vo.InstaVO;
import co.kr.vo.Insta_addVO;
@Service
public class InstaServiceImpl implements InstaService {

	@Inject
	private InstaDAO instaDAO;
	
	@Override
	public void Instaadd(InstaVO instaVO) {
		instaDAO.Instaadd(instaVO);
	}

	@Override
	public List<Insta_addVO> getInsta_addVO(Integer code) {
		return instaDAO.getInsta_addVO(code);
	}

	@Override
	public Integer maxCode() {
		return instaDAO.maxCode();
	}

	@Override
	public void setItem_add(Insta_addVO iadd) {
		instaDAO.serInsta_add(iadd);
	}

	@Override
	public List<InstaVO> instalist() throws Exception {
		return instaDAO.instalist();
	}

	@Override
	public InstaVO read(int bno) throws Exception {
		return instaDAO.read(bno);
	}

	@Override
	public void deleteInsta(int insta_bno) throws Exception {
		instaDAO.deleteInsta(insta_bno);
	}


}
