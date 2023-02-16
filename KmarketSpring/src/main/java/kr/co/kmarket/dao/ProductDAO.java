package kr.co.kmarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductVO;

@Mapper
@Repository
public interface ProductDAO {
	public List<ProductVO> selectProduct(String param);
	public List<ProductVO> selectProducts(String arg0, String arg1,String arg2,int arg3);
	public int selectCountTotal(String arg0, String arg1);
	
}
