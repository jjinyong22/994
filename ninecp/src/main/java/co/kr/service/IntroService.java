package co.kr.service;

import java.util.List;

import co.kr.vo.IntroVO;

public interface IntroService {

	//인트로 목록 조회
	public List<IntroVO> list() throws Exception;
	
	public void Introadd(IntroVO introVO);
	
	public Integer Intromaxnum();
}
