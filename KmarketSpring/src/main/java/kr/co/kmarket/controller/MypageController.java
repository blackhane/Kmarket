package kr.co.kmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {
	
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
	
}
