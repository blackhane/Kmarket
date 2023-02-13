package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.ProductVO;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("product/list")
	public String list() {
		
		
		
		return "product/list";
	}
}
