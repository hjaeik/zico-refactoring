package org.zico.menu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zico.common.dto.Page;
import org.zico.menu.controller.MenuController;
import org.zico.menu.dao.MenuDao;
import org.zico.menu.vo.MenuVo;

/**
 * @ClassName   : MenuServiceImpl.java
 * @Description : 매장내 메뉴 ServiceImpl
 * @Author      : mantos
*/
@Service
public class MenuServiceImpl implements MenuService{

	private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Autowired
	MenuDao menuDao; 
	
	/*
	 *  메뉴 등록
	 *  @param StoreVo
	 *  @return int
	*/
	@Override
	public int insertMenu(MenuVo menuVo) {
		// TODO Auto-generated method stub
		return menuDao.insertMenu(menuVo);
	}

	/*
	 *  메뉴 삭제
	 *  @param int(menuNo)
	 *  @return int
	*/
	@Override
	public int deleteMenu(int menuNo) {
		// TODO Auto-generated method stub
		return menuDao.deleteMenu(menuNo);
	}

	/*
	 *  메뉴 수정
	 *  @param menuVo
	 *  @return int
	*/
	@Override
	public int updateMenu(MenuVo menuVo) {
		// TODO Auto-generated method stub
		return menuDao.updateMenu(menuVo);
	}

	/*
	 *  메뉴 리스트 조회
	 *  @param Page
	 *  @return int
	*/
	@Override
	public List<MenuVo> selectListMenu(Page page,int menuStoreNo) {
		// TODO Auto-generated method stub
		Map<String, Integer> list = new HashMap<>();
		list.put("page", page.getPage());
		list.put("size", page.getSize());
		list.put("menuStoreNo", menuStoreNo);
		return menuDao.selectListMenu(list);
	}

	/*
	 *  메뉴 조회
	 *  @param int(menuNo)
	 *  @return menuVo
	*/
	@Override
	public MenuVo selectMenu(int menuNo) {
		// TODO Auto-generated method stub
		return menuDao.selectMenu(menuNo);
	}

	/*
	 *  메뉴 개수 조회
	 *  @param
	 *  @return int
	*/
	@Override
	public int selectTotalCnt(int menuStoreNo) {
		// TODO Auto-generated method stub
		return menuDao.selectTotalCnt(menuStoreNo);
	}

}
