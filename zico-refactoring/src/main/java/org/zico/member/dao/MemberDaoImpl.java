package org.zico.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zico.member.controller.MemberController;
import org.zico.member.vo.MemberVo;

/**
 * @ClassName   : MemberDaoImpl.java
 * @Description : 회원관리 Dao
 * @Author      : Mantos
*/
@Repository
public class MemberDaoImpl implements MemberDao {

	private static final Logger logger = LoggerFactory.getLogger(MemberDaoImpl.class);
	
	@Autowired
	private SqlSession sqlSession;

	/*
	 *  로그인 처리
	 *  @param MemberVo
	 *  @return int
	*/
	@Override
	public MemberVo loginMember(MemberVo memberVo) {		
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.loginMember", memberVo);
	}

	/*
	 *  회원등록
	 *  @param MemberVo
	 *  @return int
	*/
	@Override
	public int insertMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("member.insertMember", memberVo);
	}

	/*
	 *  회원 삭제
	 *  @param MemberVo
	 *  @return int
	*/
	@Override
	public int deleteMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("member.deleteMember", memberVo);
	}

	/*
	 *  회원 수정
	 *  @param MemberVo
	 *  @return int
	 */
	@Override
	public int updateMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.update("member.updateMember", memberVo);
	}

	/*
	 *  회원 조회
	 *  @param MemberVo
	 *  @return List<MemberVo>
	 */
	@Override
	public List<MemberVo> selectListMember() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("member.selectMember");
	}

	/*
	 *  회원 아이디 검색
	 *  @param String(memberId)
	 *  @return int
	 */
	@Override
	public int selectMemberId(String memberId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.selectMemberId", memberId);
	}
	
}
	

