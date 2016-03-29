package com.soft2t.imk2tbaseframework.demo.module.demo.database;

public class DiseaseSelfCheckDescEntity extends WebInfoShowEntity {
	private static final long serialVersionUID = -4939112612840487684L;

	private String Gender;
	private String PlaceSN;
	private int OrderNo;

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getPlaceSN() {
		return PlaceSN;
	}

	public void setPlaceSN(String placeSN) {
		PlaceSN = placeSN;
	}

	public int getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(int orderNo) {
		OrderNo = orderNo;
	}
}
