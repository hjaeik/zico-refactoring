package org.zico.menu.dao;

import java.util.List;
import java.util.Map;

import org.zico.menu.vo.MenuVo;

/**
 * @ClassName   : MenuDao.java
 * @Description : 매장내 메뉴 Dao
 * @Author      : mantos
*/
public interface MenuDao {

	/*
	 *  메뉴 등록
	 *  @param StoreVo
	 *  @return int
	*/
	public int insertMenu(MenuVo menuVo);
	
	/*
	 *  메뉴 삭제
	 *  @param int(menuNo)
	 *  @return int
	*/
	public int deleteMenu(int menuNo);
	
	/*
	 *  메뉴 수정
	 *  @param menuVo
	 *  @return int
	*/
	public int updateMenu(MenuVo menuVo);
	
	/*
	 *  메뉴 리스트 조회
	 *  @param Page
	 *  @return int
	*/
	public List<MenuVo> selectListMenu(Map<String, Integer> list);
	
	/*
	 *  메뉴 조회
	 *  @param int(menuNo)
	 *  @return menuVo
	*/
	public MenuVo selectMenu(int menuNo);
	
	/*
	 *  메뉴 개수 조회
	 *  @param
	 *  @return int
	*/
	public int selectTotalCnt(int menuStoreNo);
}
