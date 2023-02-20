package kr.co.kmarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.CouponVO;
import kr.co.kmarket.vo.CsVO;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.OrderItemVO;
import kr.co.kmarket.vo.PointVO;
import kr.co.kmarket.vo.ReviewVO;

@Mapper
@Repository
public interface MyPageDAO {
	
	public MemberVO selectUserinfo(String uid);
	public List<OrderItemVO> selectLastOrder(String uid);
	public List<PointVO> selectLastPoint(String uid);
	public List<ReviewVO> selectLastReview(String uid);
	public List<CsVO> selectLastQna(String uid);
	
	
	//전체주문내역
	public List<OrderItemVO> selectMyOrder(String uid);
	//포인트내역
	public List<PointVO> selectMyPoint(String uid);
	//쿠폰
	public List<CouponVO> selectMyCoupon(String uid);
	//나의리뷰
	public List<ReviewVO> selectMyReview(String uid);
	//문의하기
	public List<CsVO> selectMyQna(String uid);
	
}
