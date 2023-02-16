package kr.co.kmarket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.Cate2VO;
import kr.co.kmarket.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;

/*
 * 담당 : 이민혁
 * 내용기록
 * 2023-02-10
 * 컨트롤러, 서비스, 통합구현 기본
 * 
 */

@Slf4j
@Controller
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("admin")
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("admin/product/list")
	public String list(Model model, String pg) {
		
		int currentPage = service.getCurrentPage(pg);
		int start = service.getLimitStart(currentPage);
		
		int total = service.selectCountTotal();
		int lastPageNum = service.getLastPageNum(total);
		int pageStartNum = service.getPageStartNum(total, start);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		List<ProductVO> article = service.selectAdminProductList(start);
		
		model.addAttribute("article", article);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("groups", groups);
		
		/*System.out.println("currentPage : " + currentPage);
		System.out.println("lastPageNum : " + lastPageNum);
		System.out.println("pageStartNum : " + pageStartNum);
		System.out.println("groups[0] : " + groups[0]);*/
		
		return "admin/product/list";
	}
	
	@GetMapping("admin/product/register")
	public String register(Model model) {
		
		List<Cate1VO> cate1 = service.selectProductCate1s();
		
		model.addAttribute("cate1",cate1);
		
		return "admin/product/register";
	}
	
	@ResponseBody
	@GetMapping("admin/selectCate2")
	public Map<String, List<Cate2VO>> selectCate2(int cate1) {
		
		List<Cate2VO> cate2s = service.selectProductCate2s(cate1);
		
		Map<String, List<Cate2VO>> map = new HashMap<>();
		
		map.put("result", cate2s);
		
		System.out.println("cate2 : " + cate2s);
		
		return map;
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
