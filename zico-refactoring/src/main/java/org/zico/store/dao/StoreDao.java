package org.zico.store.dao;

import java.util.List;

import org.zico.common.dto.Page;
import org.zico.store.vo.StoreVo;

/**
 * @ClassName   : StoreDao.java
 * @Description : 매장 Dao
 * @Author      : Mantos
*/
public interface StoreDao {
	
	/*
	 *  매장 등록
	 *  @param StoreVo
	 *  @return int
	*/
	public int insertStore(StoreVo storeVo);
	
	/*
	 *  매장 삭제
	 *  @param StoreVo
	 *  @return int
	 */
	public int deleteStore(int storeNo);

	/*
	 *  매장 수정
	 *  @param StoreVo
	 *  @return int
	 */
	public int updateStore(StoreVo storeVo);

	/*
	 *  매장 조회
	 *  @param int(StoreNo)
	 *  @return int
	 */
	public StoreVo selectStore(int storeNo);
	
	/*
	 *  매장 조회
	 *  @param Page
	 *  @return List<StoreVo)
	 */
	public List<StoreVo> selectListStore(Page page);
	
	/*
	 *  전체 데이터 개수 조회
	 *  @param 
	 *  @return int
	 */
	public int selectTotalCnt();
	
}
