package org.zico.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zico.common.dto.Page;
import org.zico.notice.vo.NoticeVo;

/**
 * @ClassName   : NoticeDaoImpl.java
 * @Description : 공지사항 Dao
 * @Author      : Mantos
*/

@Repository
public class NoticeDaoImpl implements NoticeDao{

	@Autowired
	private SqlSession sqlSession;
	
	/*
	 *  공지사항 등록
	 *  @param NoticeVo
	 *  @return int
	*/
	@Override
	public int insertNotice(NoticeVo noticeVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 *  공지사항 삭제
	 *  @param NoticeVo
	 *  @return int
	*/
	@Override
	public int deleteNotice(NoticeVo noticeVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 *  공지사항 수정
	 *  @param NoticeVo
	 *  @return int
	*/
	@Override
	public int updateNotice(NoticeVo noticeVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 *  공지사항 조회
	 *  @param Page
	 *  @return List<NoticeVo>
	*/
	@Override
	public List<NoticeVo> selectListNotice(Page page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("notice.selectListNotice", page);
	}

	/*
	 *  공지사항 상세조회
	 *  @param 
	 *  @return NoticeVo
	 */
	@Override
	public NoticeVo selectNotice(int noticeNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("notice.selectNotice", noticeNo);
	}

	/*
	 *  공지사항 총 데이터 개수 조회
	 *  @param 
	 *  @return int
	 */
	@Override
	public int selectTotalCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("notice.selectTotalCnt");
	}
	
	

}
