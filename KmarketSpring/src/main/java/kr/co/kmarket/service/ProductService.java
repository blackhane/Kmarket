package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.vo.ProductVO;

@Service
public class ProductService {

	@Autowired
	private ProductDAO dao;
	
	public List<ProductVO> selectProduct() {
		return dao.selectProduct();
	}
	
	public List<ProductVO> selectProducts(String cate1, String cate2) {
		return dao.selectProducts(cate1,cate2);
	}
	
}
