package kr.co.kmarket.controller;

import java.security.Principal;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.service.MyPageService;
import kr.co.kmarket.vo.CouponVO;
import kr.co.kmarket.vo.CsVO;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.OrderItemVO;
import kr.co.kmarket.vo.PointVO;
import kr.co.kmarket.vo.ReviewVO;

/*
 * 담당 : 박진휘
 * 내용기록
 * 2023-02-14
 * 기본 컨트롤러 작업완료
 */
@MapperScan("kr.co.kmarket.dao")
@Controller
public class MypageController {
	
	@Autowired
	private MyPageService service;
	
	@GetMapping("mypage/home")
	public String home(Principal principal, Model model) {
		String uid = principal.getName();
		
		MemberVO info = service.selectUserinfo(uid);
		List<OrderItemVO> order = service.selectLastOrder(uid);
		List<PointVO> point = service.selectLastPoint(uid);
		List<ReviewVO> review = service.selectLastReview(uid);
		List<CsVO> qna = service.selectLastQna(uid);
		
		model.addAttribute("info", info);
		model.addAttribute("order", order);
		model.addAttribute("point", point);
		model.addAttribute("review", review);
		model.addAttribute("qna", qna);
		
		return "mypage/home";
	}
	
	@GetMapping("mypage/order")
	public String order(Principal principal, Model model) {
		String uid = principal.getName();
		
		MemberVO info = service.selectUserinfo(uid);
		
		model.addAttribute("info", info);
		
		return "mypage/ordered";
	}
	
	@GetMapping("mypage/point")
	public String point(Principal principal, Model model) {
		String uid = principal.getName();
		
		MemberVO info = service.selectUserinfo(uid);
		
		model.addAttribute("info", info);
		
		return "mypage/point";
	}
	
	@GetMapping("mypage/coupon")
	public String coupon(Principal principal, Model model) {
		String uid = principal.getName();
		
		MemberVO info = service.selectUserinfo(uid);
		List<CouponVO> vo = service.selectMyCoupon(uid);
		
		model.addAttribute("info", info);
		model.addAttribute("vo", vo);
		
		return "mypage/coupon";
	}
	
	@GetMapping("mypage/review")
	public String review(Principal principal, Model model) {
		String uid = principal.getName();
		
		MemberVO info = service.selectUserinfo(uid);
		List<ReviewVO> vo = service.selectMyReview(uid);
		
		model.addAttribute("info", info);
		model.addAttribute("vo", vo);
		
		return "mypage/review";
	}
	
	@GetMapping("mypage/qna")
	public String qna(Principal principal, Model model) {
		String uid = principal.getName();
		
		MemberVO info = service.selectUserinfo(uid);
		List<CsVO> vo = service.selectMyQna(uid);
		
		model.addAttribute("info", info);
		model.addAttribute("vo", vo);
		
		return "mypage/qna";
	}
	
	@GetMapping("mypage/info")
	public String info(Principal principal, Model model) {
		String uid = principal.getName();
		
		MemberVO info = service.selectUserinfo(uid);
		
		model.addAttribute("info", info);
		
		return "mypage/info";
	}
	
}
