package kr.co.kmarket.dao;

public class ProductDAO {

<<<<<<< Updated upstream
=======
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductVO;

@Mapper
@Repository
public interface ProductDAO {
	public List<ProductVO> selectProduct(String param);
	public List<ProductVO> selectProducts(String cate1, String cate2);

	
>>>>>>> Stashed changes
}
