package org.zico.store.vo;

/**
 * @ClassName   : StoreVO.java
 * @Description : 거래점 VO
 * @Author      : mantos
*/

public class StoreVo {
	private int		storeNo;
	private String	storeName;
	private String	storeAddr;
	private String	storeTel;
	private String	storeCategory;
	private String	storeOpentime;
	private String	storeClosetime;
	private String	storeImage;
	private String	storeMemberId;
	
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddr() {
		return storeAddr;
	}
	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}
	public String getStoreTel() {
		return storeTel;
	}
	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}
	public String getStoreCategory() {
		return storeCategory;
	}
	public void setStoreCategory(String storeCategory) {
		this.storeCategory = storeCategory;
	}
	public String getStoreOpentime() {
		return storeOpentime;
	}
	public void setStoreOpentime(String storeOpentime) {
		this.storeOpentime = storeOpentime;
	}
	public String getStoreClosetime() {
		return storeClosetime;
	}
	public void setStoreClosetime(String storeClosetime) {
		this.storeClosetime = storeClosetime;
	}
	public String getStoreImage() {
		return storeImage;
	}
	public void setStoreImage(String storeImage) {
		this.storeImage = storeImage;
	}
	public String getStoreMemberId() {
		return storeMemberId;
	}
	public void setStoreMemberId(String storeMemberId) {
		this.storeMemberId = storeMemberId;
	}
	
	@Override
	public String toString() {
		return "StoreVo [storeNo=" + storeNo + ", storeName=" + storeName + ", storeAddr=" + storeAddr + ", storeTel="
				+ storeTel + ", storeCategory=" + storeCategory + ", storeOpentime=" + storeOpentime
				+ ", storeClosetime=" + storeClosetime + ", storeImage=" + storeImage + ", storeMemberId="
				+ storeMemberId + "]";
	}
	
	
}