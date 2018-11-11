package org.zico.notice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zico.common.dto.Page;
import org.zico.notice.dao.NoticeDao;
import org.zico.notice.vo.NoticeVo;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	NoticeDao noticeDao;
	
	/*
	 *  공지사항 등록
	 *  @param NoticeVo
	 *  @return String
	*/
	@Override
	public String insertNotice(NoticeVo noticeVo) {
		// TODO Auto-generated method stub
		noticeDao.insertNotice(noticeVo);
		return null;
	}

	/*
	 *  공지사항 삭제
	 *  @param NoticeVo
	 *  @return String
	 */
	@Override
	public String deleteNotice(NoticeVo noticeVo) {
		// TODO Auto-generated method stub
		noticeDao.deleteNotice(noticeVo);
		return null;
	}

	/*
	 *  공지사항 수정
	 *  @param NoticeVo
	 *  @return String
	 */
	@Override
	public String updateNotice(NoticeVo noticeVo) {
		// TODO Auto-generated method stub
		noticeDao.updateNotice(noticeVo);
		return null;
	}

	/*
	 *  공지사항 조회
	 *  @param Page
	 *  @return List<NoticeVo>
	 */
	@Override
	public List<NoticeVo> selectListNotice(Page page) {
		// TODO Auto-generated method stub
		return noticeDao.selectListNotice(page);
	}

	/*
	 *  공지사항 조회
	 *  @param int(noticeNo)
	 *  @return NoticeVo
	 */
	@Override
	public NoticeVo selectNotice(int noticeNo) {
		// TODO Auto-generated method stub
		return noticeDao.selectNotice(noticeNo);
	}

	/*
	 *  공지사항 총 데이터 개수 조회
	 *  @param 
	 *  @return int
	 */
	@Override
	public int selectTotalCnt() {
		// TODO Auto-generated method stub
		return noticeDao.selectTotalCnt();
	}
}
