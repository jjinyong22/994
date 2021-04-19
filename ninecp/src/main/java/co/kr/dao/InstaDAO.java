package co.kr.dao;

import java.util.List;

import co.kr.vo.InstaVO;
import co.kr.vo.Insta_addVO;

public interface InstaDAO {

	public List<InstaVO> instalist() throws Exception;
	
	public void Instaadd(InstaVO instaVO);
	public List<Insta_addVO> getInsta_addVO(Integer code);
	public Integer maxCode();
	public void serInsta_add(Insta_addVO iadd);
	
	public InstaVO read(int bno) throws Exception;
	
	public void deleteInsta(int insta_bno) throws Exception;
	
	
}
