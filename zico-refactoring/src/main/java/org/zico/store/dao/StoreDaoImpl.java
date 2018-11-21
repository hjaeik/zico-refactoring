package org.zico.store.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zico.common.dto.Page;
import org.zico.store.vo.StoreVo;

/**
 * @ClassName   : StoreDaoImpl.java
 * @Description : 매장 Dao
 * @Author      : Mantos
*/
@Repository
public class StoreDaoImpl implements StoreDao{

	@Autowired
	private SqlSession sqlSession;
	
	/*
	 *  매장 등록
	 *  @param StoreVo
	 *  @return int
	*/
	@Override
	public int insertStore(StoreVo storeVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("store.insertStore",storeVo);
	}

	/*
	 *  매장 삭제
	 *  @param StoreVo
	 *  @return int
	 */
	@Override
	public int deleteStore(int storeNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("store.deleteStore", storeNo);
	}

	/*
	 *  매장 수정
	 *  @param StoreVo
	 *  @return int
	 */
	@Override
	public int updateStore(StoreVo storeVo) {
		// TODO Auto-generated method stub
		return sqlSession.update("store.updateStore", storeVo);
	}

	/*
	 *  매장 조회
	 *  @param int(StoreNo)
	 *  @return int
	 */
	@Override
	public StoreVo selectStore(int storeNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("store.selectStore",storeNo);
	}

	/*
	 *  매장 조회
	 *  @param Page
	 *  @return List<StoreVo)
	 */
	@Override
	public List<StoreVo> selectListStore(Page page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("store.selectListStore",page);
	}

	/*
	 *  전체 데이터 개수 조회
	 *  @param 
	 *  @return int
	 */
	@Override
	public int selectTotalCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("store.selectTotalCnt");
	}

}
