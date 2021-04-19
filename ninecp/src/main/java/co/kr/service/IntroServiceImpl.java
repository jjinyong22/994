package co.kr.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import co.kr.dao.IntroDAO;
import co.kr.vo.IntroVO;

@Service
public class IntroServiceImpl implements IntroService{

	@Inject
	private IntroDAO dao;
	
	@Override
	public List<IntroVO> list() throws Exception{
		return dao.list();
	}

	@Override
	public void Introadd(IntroVO introVO) {
		dao.Introadd(introVO);
	}

	@Override
	public Integer Intromaxnum() {
		return dao.Intromaxnum();
	}

	@Override
	public IntroVO introread(int intnum) throws Exception {
		return dao.introread(intnum);
	}

	@Override
	public void introupdate(IntroVO introvo) {
		dao.introupdate(introvo);
	}
	
}
