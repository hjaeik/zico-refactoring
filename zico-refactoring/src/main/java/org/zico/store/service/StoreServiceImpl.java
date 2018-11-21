package org.zico.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zico.common.dto.Page;
import org.zico.store.dao.StoreDao;
import org.zico.store.vo.StoreVo;

/**
 * @ClassName   : StoreServiceImpl.java
 * @Description : 매장 Service
 * @Author      : Mantos
*/
@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	StoreDao storedao;
	/*
	 *  매장 등록
	 *  @param StoreVo
	 *  @return int
	*/
	@Override
	public int insertStore(StoreVo storeVo) {
		// TODO Auto-generated method stub
		return storedao.insertStore(storeVo);
	}

	/*
	 *  매장 삭제
	 *  @param StoreVo
	 *  @return int
	 */
	@Override
	public int deleteStore(int storeNo) {
		// TODO Auto-generated method stub
		return storedao.deleteStore(storeNo);
	}

	/*
	 *  매장 수정
	 *  @param StoreVo
	 *  @return int
	 */
	@Override
	public int updateStore(StoreVo storeVo) {
		// TODO Auto-generated method stub
		return storedao.updateStore(storeVo);
	}

	/*
	 *  매장 조회
	 *  @param int(StoreNo)
	 *  @return int
	 */
	@Override
	public StoreVo selectStore(int storeNo) {
		// TODO Auto-generated method stub
		return storedao.selectStore(storeNo);
	}

	/*
	 *  매장 조회
	 *  @param Page
	 *  @return List<StoreVo)
	 */
	@Override
	public List<StoreVo> selectListStore(Page page) {
		// TODO Auto-generated method stub
		return storedao.selectListStore(page);
	}

	/*
	 *  전체 데이터 개수 조회
	 *  @param 
	 *  @return int
	 */
	@Override
	public int selectTotalCnt() {
		// TODO Auto-generated method stub
		return storedao.selectTotalCnt();
	}
	
}
