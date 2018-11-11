package org.zico.notice.Service;

import java.util.List;

import org.zico.common.dto.Page;
import org.zico.notice.vo.NoticeVo;

public interface NoticeService {
	
	/*
	 *  공지사항 등록
	 *  @param NoticeVo
	 *  @return String
	*/
	public String insertNotice(NoticeVo noticeVo);
	
	/*
	 *  공지사항 삭제
	 *  @param NoticeVo
	 *  @return String
	 */
	public String deleteNotice(NoticeVo  noticeVo);
	
	/*
	 *  공지사항 수정
	 *  @param NoticeVo
	 *  @return String
	 */
	public String updateNotice(NoticeVo noticeVo);
	
	/*
	 *  공지사항 조회
	 *  @param Page
	 *  @return List<NoticeVo>
	 */
	public List<NoticeVo> selectListNotice(Page page);
	
	/*
	 *  공지사항 조회
	 *  @param int(noticeNo)
	 *  @return List<NoticeVo>
	 */
	public NoticeVo selectNotice(int noticeNo);
	
	/*
	 *  공지사항 총 데이터 개수 조회
	 *  @param 
	 *  @return int
	 */
	public int selectTotalCnt();
	
}
