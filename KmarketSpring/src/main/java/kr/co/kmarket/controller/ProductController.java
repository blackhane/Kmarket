package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.ProductVO;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("product/list")
	public String list(String arg0, String arg1,Model model) {

		List<ProductVO> products = service.selectProducts(arg0,arg1);

		model.addAttribute("cate1", arg0);
		model.addAttribute("cate2", arg1);
		model.addAttribute("products", products);

		return "product/list";
	}
}