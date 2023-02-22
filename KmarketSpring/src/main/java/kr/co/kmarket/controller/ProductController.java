package kr.co.kmarket.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.entity.MemberEntity;
import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.CartVO;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.OrderVO;
import kr.co.kmarket.vo.ProductVO;
import kr.co.kmarket.vo.ReviewVO;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private MemberService service1;
	
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
	public String cart(Model model, String uid, String arg0) {
		List<CartVO> carts = service.selectCarts(uid);
		
		model.addAttribute("arg0",arg0);
		model.addAttribute("carts",carts);
		
		return "product/cart";
	}

	@PostMapping("product/cart/delete")
	@ResponseBody
	public String deleteCart(@RequestParam(value="checkBoxArr[]")List<String> checkBoxArr) {
		
		int result = 0;
		
		for(int i = 0; i < checkBoxArr.size(); i++) {
			service.deleteCart(checkBoxArr.get(i));
		}	
		
		return result + "";
	}
	
	@GetMapping("product/order")
	public String orderList(Model model, String param1, String count, String uid) {
		
		ProductVO product = service.selectProduct(param1);
		MemberVO user = service1.selectUser(uid);
		
		model.addAttribute("product",product);
		model.addAttribute("user",user);
		model.addAttribute("count",count);
		return "product/order";
	}

	@PostMapping("product/order")
	@ResponseBody
	public List<CartVO> orderList(Model model, @RequestParam(value="checkBoxArr[]")List<String> checkBoxArr) {
		//System.out.println(checkBoxArr);
		//System.out.println(checkBoxArr.get(0));
		
		List<CartVO> carts = new ArrayList<>();
		
		for(int i = 0; i < checkBoxArr.size(); i++) {
			
			CartVO cart = service.selectOrder(checkBoxArr.get(i));
		
			carts.add(cart);
		}
		
		//System.out.println(carts.get(0));
		//System.out.println(carts.get(1));
		
		model.addAttribute("carts", carts);
		
		return carts;
	}

}