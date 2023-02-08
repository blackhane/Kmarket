package kr.co.kmarket.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CsVO {

	private int no;
	private String group;
	private int parent;
	private int comment;
	private String cate;
	private String title;
	private int hit;
	private String content;
	private String uid;
	private String regip;
	private String rdate;
	
	public String getRdate() {
		return rdate.substring(2, 10);
	}
	
}
