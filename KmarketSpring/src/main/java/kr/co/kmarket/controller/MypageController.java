package kr.co.kmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.service.MyPageService;
import kr.co.kmarket.vo.ProductVO;

/*
 * 담당 : 박진휘
 * 내용기록
 * 2023-02-14
 * 기본 컨트롤러 작업완료
 */
@Controller
public class MypageController {
	
	@Autowired
	private MyPageService service;
	
	@GetMapping("mypage/home")
	public String home() {
		return "mypage/home";
	}
	
	@GetMapping("mypage/order")
	public String order() {
		return "mypage/ordered";
	}
	
	@GetMapping("mypage/point")
	public String point() {
		return "mypage/point";
	}
	
	@GetMapping("mypage/coupon")
	public String coupon() {
		return "mypage/coupon";
	}
	
	@GetMapping("mypage/review")
	public String review() {
		return "mypage/review";
	}
	
	@GetMapping("mypage/qna")
	public String qna() {
		return "mypage/qna";
	}
	
	@GetMapping("mypage/info")
	public String info() {
		return "mypage/info";
	}
	
	// mypage 요약정보
	
	public String order(Model model, ProductVO vo) {
		
		
		return "mypage/home";
	}
	
	
	
	
	
}
