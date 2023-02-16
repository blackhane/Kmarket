package kr.co.kmarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.Cate1VO;
import kr.co.kmarket.vo.Cate2VO;
import kr.co.kmarket.vo.ProductVO;

/*
 * 날짜 : 2023/02/10 
 * 이름 : 이민혁
 * 내용 : Admin DAO 기능구현 
 * 
 */

@Mapper
@Repository
public interface AdminDAO {
	
	public void insertAdmin();
	
	//관리자 상품등록 
	public void insertAdminProduct(ProductVO pv);
	
	//관리자 상품등록 Cate1 조회
	public List<Cate1VO> selectProductCate1s();
	
	//관리자 상품등록 Cate1 로 Cate2를 조회
	public List<Cate2VO> selectProductCate2s(int cate1);
	
	//상품 목록 페이징 작업
	public int selectCountTotal();
	
	//관리자 상품 목록
	public List<ProductVO> selectAdminProductList(int start);
	
	public void updateAdmin();
	public void deleteAdmin();
	

}
