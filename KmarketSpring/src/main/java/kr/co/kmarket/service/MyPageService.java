package kr.co.kmarket.service;

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
		return dao.selectMyOrder(param1, param2, param3);
	}
	//포인트내역
	public List<PointVO> selectMyPoint(String uid, String param2, String param3){
		return dao.selectMyPoint(uid, param2, param3);
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
