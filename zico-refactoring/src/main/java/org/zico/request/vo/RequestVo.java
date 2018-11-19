package org.zico.request.vo;

/**
 * @ClassName   : RequestVO.java
 * @Description : 요청 VO
 * @Author      : mantos
*/

public class RequestVo {
	private int 	requestNo;
	private int 	storeNo;
	private int 	requestPeople;
	private int 	requestTotalprice;
	private String	requestMemberId;
	private String	requestStatus;
	private String 	requestPay;
	
	public int getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(int requestNo) {
		this.requestNo = requestNo;
	}
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public int getRequestPeople() {
		return requestPeople;
	}
	public void setRequestPeople(int requestPeople) {
		this.requestPeople = requestPeople;
	}
	public int getRequestTotalprice() {
		return requestTotalprice;
	}
	public void setRequestTotalprice(int requestTotalprice) {
		this.requestTotalprice = requestTotalprice;
	}
	public String getRequestMemberId() {
		return requestMemberId;
	}
	public void setRequestMemberId(String requestMemberId) {
		this.requestMemberId = requestMemberId;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getRequestPay() {
		return requestPay;
	}
	public void setRequestPay(String requestPay) {
		this.requestPay = requestPay;
	}
	
	
}
