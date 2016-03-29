package com.soft2t.imk2tbaseframework.demo.module.demo.database;

public class DiseaseSelfCheckPartEntity extends WebInfoShowEntity {
	private static final long serialVersionUID = -4939112612840487684L;

	private String SN;
	private String PlaceName;
	private int OrderNo;

	public String getSN() {
		return SN;
	}

	public void setSN(String sN) {
		SN = sN;
	}

	public String getPlaceName() {
		return PlaceName;
	}

	public void setPlaceName(String placeName) {
		PlaceName = placeName;
	}

	public int getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(int orderNo) {
		OrderNo = orderNo;
	}
}
