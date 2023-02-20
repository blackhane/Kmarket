package kr.co.kmarket.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MyPageDAO {
	public int countOrder();
}
