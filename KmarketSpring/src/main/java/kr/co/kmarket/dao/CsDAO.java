package kr.co.kmarket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.CsVO;

@Mapper
@Repository
public interface CsDAO {

	public List<CsVO> selectNotice();
	public List<CsVO> selectNoticeByCate(String group);

	public List<CsVO> selectQna();
	
}
