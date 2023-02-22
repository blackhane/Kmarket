package kr.co.kmarket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.CartVO;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.ProductVO;
import kr.co.kmarket.vo.ReviewVO;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("product/list")
	public String list(String arg0, String arg1, String arg2, String pg, Model model) {
		int currentPage = service.getCurrentPage(pg);
        int arg3 = service.getLimitStart(currentPage);

        int total = service.selectCountTotal(arg0,arg1);
        int lastPageNum = service.getLastPageNum(total);
        int pageStartNum = service.getPageStartNum(total, arg3);
        int groups[] = service.getPageGroup(currentPage, lastPageNum);

		List<ProductVO> products = service.selectProducts(arg0,arg1,arg2,arg3);
		
		model.addAttribute("arg0", arg0);
		model.addAttribute("arg1", arg1);
		model.addAttribute("arg2", arg2);
		model.addAttribute("cate1", arg0);
		model.addAttribute("cate2", arg1);
		model.addAttribute("pg", pg);
		model.addAttribute("groups", groups);
		model.addAttribute("products", products);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("pageStartNum", pageStartNum);
		
		return "product/list";
	}
	
	@GetMapping("product/view")
	public String view(String arg0, String arg1, String arg2, String pg, String param1, Model model) {
		
		int currentPage = service.getCurrentPage(pg);
        int param2 = service.getLimitStart(currentPage);

        int total = service.selectReviewCountTotal(param1,param2);
        int lastPageNum = service.getLastPageNum(total);
        int pageStartNum = service.getPageStartNum(total, param2);
        int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		ProductVO prod = service.selectProduct(param1);
		List<ReviewVO> reviews = service.selectReviews(param1);
		
		model.addAttribute("arg0", arg0);
		model.addAttribute("arg1", arg1);
		model.addAttribute("arg2", arg2);
		model.addAttribute("pg", pg);
		model.addAttribute("prod", prod);
		model.addAttribute("reviews", reviews);
		model.addAttribute("param1", param1);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("groups", groups);
		
		return "product/view";
	}
	
	@PostMapping("product/cart/add")
	@ResponseBody
	public String addCart(CartVO cart) {
		//장바구니 추가
		int result = service.addCart(cart);
		
		return result+"";
	}
	
	@GetMapping("product/cart")
	public String cart(Model model, String uid) {
		List<CartVO> carts = service.selectCarts(uid);
		
		model.addAttribute("carts",carts);
		
		return "product/cart";
	}

	@GetMapping("product/cart/delete")
	public String deleteCart(int cartNo, String uid) {
		service.deleteCart(cartNo,uid);
		
		return "redirect:product/cart?uid="+uid;
	}


}
