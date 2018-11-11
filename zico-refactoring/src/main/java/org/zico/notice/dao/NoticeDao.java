package org.zico.notice.dao;

import java.util.List;

import org.zico.common.dto.Page;
import org.zico.notice.vo.NoticeVo;

/**
 * @ClassName   : NoticeDao.java
 * @Description : 공지사항 Dao
 * @Author      : Mantos
*/

public interface NoticeDao {
	
	/*
	 *  공지사항 등록
	 *  @param NoticeVo
	 *  @return int
	*/
	public int insertNotice(NoticeVo noticeVo);
	
	/*
	 *  공지사항 삭제
	 *  @param NoticeVo
	 *  @return int
	*/
	public int deleteNotice(NoticeVo noticeVo);
	
	/*
	 *  공지사항 수정
	 *  @param NoticeVo
	 *  @return int
	*/
	public int updateNotice(NoticeVo noticeVo);
	
	/*
	 *  공지사항 조회
	 *  @param Page
	 *  @return List<NoticeVo>
	*/
	public List<NoticeVo> selectListNotice(Page page);
	
	/*
	 *  공지사항 상세조회
	 *  @param int(noticeNo)
	 *  @return NoticeVo
	 */
	public NoticeVo selectNotice(int noticeNo);
	
	/*
	 *  공지사항 총 데이터 개수 조회
	 *  @param 
	 *  @return int
	 */
	public int selectTotalCnt();
}
