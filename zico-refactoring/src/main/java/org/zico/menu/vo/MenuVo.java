package org.zico.menu.vo;

/**
 * @ClassName   : MenuVO.java
 * @Description : 매장내 메뉴 VO
 * @Author      : mantos
*/
public class MenuVo {
	private String 	menuName;
	private String 	menuImage;
	private String 	menuCategory;
	private int		menuPrice;
	private int		menuNo;
	private int		menuStoreNo;
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuImage() {
		return menuImage;
	}
	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}
	public String getMenuCategory() {
		return menuCategory;
	}
	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public int getMenuStoreNo() {
		return menuStoreNo;
	}
	public void setMenuStoreNo(int menuStoreNo) {
		this.menuStoreNo = menuStoreNo;
	}
	@Override
	public String toString() {
		return "MenuVo [menuName=" + menuName + ", menuImage=" + menuImage + ", menuCategory=" + menuCategory
				+ ", menuPrice=" + menuPrice + ", menuNo=" + menuNo + ", menuStoreNo=" + menuStoreNo + "]";
	}
	
}
