package kr.co.kmarket.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.service.CsService;
import kr.co.kmarket.vo.CsVO;

/*
 * 담당 : 박진휘
 * 내용기록
 * 2023-02-28
 * 컨트롤러,서비스,통합구현 기본
*/
@Controller
@MapperScan("kr.co.kmarket.dao")
public class CsController {

	@Autowired
	private CsService service;
	
	//고객센터 메인
	@GetMapping("cs")
	public String index() {
		return "cs/index";
	}
	//공지사항 리스트
	@GetMapping("cs/notice/list")
	public String noticeList(Model model, String group) {
		List<CsVO> articles = service.selectNotice(group);
		model.addAttribute("articles", articles);
		model.addAttribute("group", group);
		return "cs/notice_list";
	}
	//공지사항 상세보기
	@GetMapping("cs/notice/view")
	public String noticeView(Model model, String group) {
		model.addAttribute("group", group);
		return "cs/notice_view";
	}
	//자주묻는질문 리스트
	@GetMapping("cs/faq/list")
	public String faqList(Model model, String group) {
		model.addAttribute("group", group);
		return "cs/faq_list";
	}
	//자주묻는질문 상세보기
	@GetMapping("cs/faq/view")
	public String faqView(Model model, String group) {
		model.addAttribute("group", group);
		return "cs/faq_view";
	}
	//문의하기 리스트
	@GetMapping("cs/qna/list")
	public String qnaList(Model model, String group) {
		List<CsVO> articles = service.selectQna();
		model.addAttribute("articles", articles);
		model.addAttribute("group", group);
		return "cs/qna_list";
	}
	//문의하기 상세보기
	@GetMapping("cs/qna/view")
	public String qnaView(Model model, String group) {
		model.addAttribute("group", group);
		return "cs/qna_view";
	}
	//문의하기 글쓰기
	@GetMapping("cs/qna/write")
	public String qnaWrite(Model model, String group) {
		model.addAttribute("group", group);
		return "cs/qna_write";
	}
	
}
