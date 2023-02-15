package kr.co.kmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MyPageDAO;
import kr.co.kmarket.vo.ProductVO;

@Service
public class MyPageService {
	
	@Autowired
	private MyPageDAO dao;
	
<<<<<<< Updated upstream
	public int countOrder(ProductVO vo) {
=======
	public int countOrder() {
>>>>>>> Stashed changes
		return dao.countOrder();
	}
	
}
