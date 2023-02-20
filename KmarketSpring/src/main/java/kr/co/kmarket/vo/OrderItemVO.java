package kr.co.kmarket.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemVO {

	private int ordNO;
	private int prodNO;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int total;
	private String uid;
	
}
