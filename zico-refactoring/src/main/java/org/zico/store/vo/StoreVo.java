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
	private String	storeImage;		//현재 DB에 이미지컬럼이 없음
	private String	memberId;
}