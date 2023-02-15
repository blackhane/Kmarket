package kr.co.kmarket.service;

public class ProductService {

<<<<<<< Updated upstream
=======
	@Autowired
	private ProductDAO dao;
	
	public List<ProductVO> selectProduct(String param) {
		return dao.selectProduct(param);
	}
	public List<ProductVO> selectProducts(String cate1, String cate2) {
		return dao.selectProducts(cate1,cate2);
	}
	
>>>>>>> Stashed changes
}
