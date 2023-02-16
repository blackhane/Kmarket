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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.Cate2VO;
import kr.co.kmarket.vo.CsVO;
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
	
	//관리자 index
	@GetMapping("admin")
	public String index(Model model) {
		
		List<CsVO> cslist = service.selectNoticeList();
		
		model.addAttribute("csList", cslist);
		
		return "admin/index";
	}
	
	//관리자 상품 목록 - 2023/02/15
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
	
	//관리자 상품 등록 1차 카테고리 - 2023/02/15
	@GetMapping("admin/product/register")
	public String register(Model model) {
		
		List<Cate1VO> cate1 = service.selectProductCate1s();
		
		model.addAttribute("cate1",cate1);
		
		return "admin/product/register";
	}
	
	//관리자 상품 등록 2차 카테고리 - 2023/02/15
	@ResponseBody 
	@GetMapping("admin/selectCate2")
	public Map<String, List<Cate2VO>> selectCate2(int cate1) {
		
		List<Cate2VO> cate2s = service.selectProductCate2s(cate1);
		
		Map<String, List<Cate2VO>> map = new HashMap<>();
		
		map.put("result", cate2s);
		
		System.out.println("cate2 : " + cate2s);
		
		return map;
	}
	
	//관리자 상품 삭제 - 2023/02/16
	@ResponseBody
	@GetMapping("admin/productDelete")
	public Map<String, Integer> productDelete (@RequestParam("prodNo") List<Integer> prodNo) {
		
		for(int no : prodNo) {
			service.productDelete(no);
		}
		
		Map<String, Integer> resultMap = new HashMap<>();
		
		resultMap.put("result", prodNo.size());
		
		/*System.out.println("result : " + result);
		System.out.println("resultMap : " + resultMap);*/
		
		return resultMap;
	}
	
	//상품등록 - 2023/02/13
	@PostMapping("admin/product/register")
	public String register(ProductVO pv, HttpServletRequest req) {
		
		String ip = req.getRemoteAddr();
		pv.setIp(ip);
		
		service.insertAdminProduct(pv);
		
		return "redirect:/admin/product/list";
	}
}
