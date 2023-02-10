package kr.co.kmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MemberDAO;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.TermsVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// 일반 회원가입
	public int insertMember(MemberVO vo) {
		// 비밀번호 암호화 설정
		vo.setPass(passwordEncoder.encode(vo.getPass2()));
		
		int result = dao.insertMember(vo);
		return result;
	}
	
	// 판매자 회원가입
	public int insertSeller(MemberVO vo) {
		vo.setPass(passwordEncoder.encode(vo.getPass2()));
		
		int result = dao.insertSeller(vo);
		return result;
	}
	
	// 약관
	public TermsVO selectTerms(int type) {
		if(type == 1) {
			return dao.selectTerms();
		}else {
			return dao.selectTermsSeller();
		}
		
	}
	
}
