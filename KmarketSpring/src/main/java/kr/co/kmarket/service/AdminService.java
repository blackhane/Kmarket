package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.AdminDAO;
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.Cate2VO;
import kr.co.kmarket.vo.ProductVO;

/*
 * 날짜 : 2023/02/10
 * 이름 : 이민혁
 * 내용 : Admin Service 기능구현
 *
 */

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO dao;
	
	public void insertAdmin() {}
	
	public void insertAdminProduct(ProductVO pv) {
		//uuid
		dao.insertAdminProduct(pv);
	}
	
	public List<Cate1VO> selectProductCate1s() {
		return dao.selectProductCate1s();
	}
	
	public List<Cate2VO> selectProductCate2s(int cate1) {
		return dao.selectProductCate2s(cate1);
	}
	
	public void selectAdmin() {}
	public void selectAdmins() {}
	public void updateAdmin() {}
	public void deleteAdmin() {}
	
	

}
