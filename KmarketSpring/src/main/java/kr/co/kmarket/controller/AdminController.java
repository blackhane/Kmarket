package kr.co.kmarket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.ProductVO;

/*
 * 담당 : 이민혁
 * 내용기록
 * 2023-02-10
 * 컨트롤러, 서비스, 통합구현 기본
 * 
 */

@Controller
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("admin")
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("admin/product/list")
	public String list() {
		return "admin/product/list";
	}
	
	@GetMapping("admin/product/register")
	public String register(Model model) {
		
		List<Cate1VO> cate1 = service.selectProductCate1s();
		
		model.addAttribute("cate1",cate1);
		
		return "admin/product/register";
	}
	
	@ResponseBody
	@GetMapping("")
	public String selectCate2(int cate1) {
		return "";
	}
	
	//상품등록
	@PostMapping("admin/product/register")
	public String register(ProductVO pv, HttpServletRequest req) {
		
		String ip = req.getRemoteAddr();
		pv.setIp(ip);
		
		service.insertAdminProduct(pv);
		
		return "redirect:/admin/product/list";
		
	}
	
	

}
