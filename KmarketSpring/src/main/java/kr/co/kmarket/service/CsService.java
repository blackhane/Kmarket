package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.CsDAO;
import kr.co.kmarket.vo.CsVO;

@Service
public class CsService {

	@Autowired
	private CsDAO dao;
	
	public List<CsVO> selectNotice(String group){
		if(group.equals("all")) {
			return dao.selectNotice();
		}else {
			return dao.selectNoticeByCate(group);
		}
	}
	public List<CsVO> selectQna(){
		return dao.selectQna();
	}
	
}