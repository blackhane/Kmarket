package kr.co.kmarket.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name= "km_product_order")
public class MyPageEntity {
	@Id
	private int ordNo;
	private String ordUid;
	private int ordCount;
	private int ordPrice;
	private int ordDiscount;
	private int ordDelivery;
	private int savePoint;
	private int usedPoint;
	private int totalPrice;
	private String recipname;
	private String recipHp;
	private String recipZip;
	private String recipAddr1;
	private String recipAddr2;
	private int ordPayment;
	private int ordComplete;
	private String ordDate;
	
}
