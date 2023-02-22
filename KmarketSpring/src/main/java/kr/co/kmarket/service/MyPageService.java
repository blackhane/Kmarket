package kr.co.kmarket.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MyPageDAO;
import kr.co.kmarket.vo.CouponVO;
import kr.co.kmarket.vo.CsVO;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.OrderItemVO;
import kr.co.kmarket.vo.PointVO;
import kr.co.kmarket.vo.ReviewVO;

@Service
public class MyPageService {
	
	@Autowired
	private MyPageDAO dao;
	
	public MemberVO selectUserinfo(String uid) {
		return dao.selectUserinfo(uid);
	}
	public List<OrderItemVO> selectLastOrder(String uid) {
		return dao.selectLastOrder(uid);
	}
	public List<PointVO> selectLastPoint(String uid) {
		return dao.selectLastPoint(uid);
	}
	public List<ReviewVO> selectLastReview(String uid) {
		return dao.selectLastReview(uid);
	}
	public List<CsVO> selectLastQna(String uid) {
		return dao.selectLastQna(uid);
	}
	
	//전체주문내역
	public List<OrderItemVO> selectMyOrder(String param1, String param2, String param3){
		LocalDate day = LocalDate.now();
		System.out.println(param2);
		System.out.println(param3);
		if(param2.equals("1WEEK")) {
			param2 = LocalDate.now().minusWeeks(1).toString();
			param3 = LocalDate.now().toString();
		}else if(param2.equals("15DAY")){
			param2 = LocalDate.now().minusDays(15).toString();
			param3 = LocalDate.now().toString();
		}else if(param2.equals("1MONTH")){
			param2 = LocalDate.now().minusMonths(1).toString();
			param3 = LocalDate.now().toString();
		}else if(param2.equals("MONTHS")) {
			String[]result = date(day);
			param2 = result[0];
			param3 = result[1];
		}else if(param2.equals("1MONTHS")) {
			day = LocalDate.now().minusMonths(1);
			String[]result = date(day);
			param2 = result[0];
			param3 = result[1];
		}else if(param2.equals("2MONTHS")) {
			day = LocalDate.now().minusMonths(2);
			String[]result = date(day);
			param2 = result[0];
			param3 = result[1];
		}else if(param2.equals("3MONTHS")) {
			day = LocalDate.now().minusMonths(3);
			String[]result = date(day);
			param2 = result[0];
			param3 = result[1];
		}else if(param2.equals("4MONTHS")) {
			day = LocalDate.now().minusMonths(4);
			String[]result = date(day);
			param2 = result[0];
			param3 = result[1];
		}
		
		return dao.selectMyOrder(param1, param2, param3);
	}
	
	public String[] date(LocalDate date) {
		String[] day = new String[2];
		YearMonth month = YearMonth.from(date);
		String start = month.atDay(1).toString();
		String end = month.atEndOfMonth().toString();
		day[0] = start;
		day[1] = end;
		return day;
	}
	//포인트내역
	public List<PointVO> selectMyPoint(String uid){
		return dao.selectMyPoint(uid);
	}
	//쿠폰
	public List<CouponVO> selectMyCoupon(String uid){
		return dao.selectMyCoupon(uid);
	}
	//나의리뷰
	public List<ReviewVO> selectMyReview(String uid){
		return dao.selectMyReview(uid);
	}
	//문의하기
	public List<CsVO> selectMyQna(String uid){
		return dao.selectMyQna(uid);
	}
	//회원수정
	public void updateMember(MemberVO vo) {
		dao.updateMember(vo);
	}
}
