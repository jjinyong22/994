package co.kr.dao;

import java.util.List;

import co.kr.vo.IntroVO;

public interface IntroDAO {

	//인트로 조회
	public List<IntroVO> list() throws Exception;
	
	public void Introadd(IntroVO introVO);
	
	public Integer Intromaxnum();
	
	public IntroVO introread(int intnum) throws Exception;
	
	public void introupdate(IntroVO introvo);
	
}
