package org.zico.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zico.member.vo.MemberVo;

/**
 * @ClassName   : MemberDao.java
 * @Description : 회원관리 Dao
 * @Author      : Mantos
*/
@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession sqlSession;

	/*
	 *  로그인 처리
	 *  @param MemberVo
	 *  @return int
	*/
	@Override
	public int loginMember(MemberVo memberVo) {
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
}
	

