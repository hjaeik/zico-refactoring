package org.zico.menu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite;
import org.zico.common.dto.Page;
import org.zico.menu.vo.MenuVo;

/**
 * @ClassName   : MenuDaoImpl.java
 * @Description : 매장내 메뉴 DaoImpl
 * @Author      : mantos
*/
@Repository
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private SqlSession sqlSession;
	/*
	 *  메뉴  등록
	 *  @param StoreVo
	 *  @return int
	*/
	@Override
	public int insertMenu(MenuVo menuVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("menu.insertMenu", menuVo);
	}

	/*
	 *  메뉴 삭제
	 *  @param int(menuNo)
	 *  @return int
	*/
	@Override
	public int deleteMenu(int menuNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("menu.deleteMenu", menuNo);
	}

	/*
	 *  메뉴 수정
	 *  @param menuVo
	 *  @return int
	*/
	@Override
	public int updateMenu(MenuVo menuVo) {
		// TODO Auto-generated method stub
		return sqlSession.update("menu.updateMenu", menuVo);
	}

	/*
	 *  메뉴 리스트 조회
	 *  @param Page
	 *  @return int
	*/
	@Override
	public List<MenuVo> selectListMenu(Map<String, Integer> list) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("menu.selectListMenu", list);
	}

	/*
	 *  메뉴 조회
	 *  @param int(menuNo)
	 *  @return menuVo
	*/
	@Override
	public MenuVo selectMenu(int menuNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("menu.selectMenu", menuNo);
	}

	/*
	 *  메뉴 개수 조회
	 *  @param
	 *  @return int
	*/
	@Override
	public int selectTotalCnt(int menuStoreNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("menu.selectTotalCnt", menuStoreNo);
	}

}
