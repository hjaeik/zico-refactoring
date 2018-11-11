package org.zico.member.dao;

import java.util.List;

import org.zico.member.vo.MemberVo;

/**
 * @ClassName   : MemberDao.java
 * @Description : 회원관리 Dao
 * @Author      : Mantos
*/

public interface MemberDao {
	
	/*
	 *  로그인 처리
	 *  @param MemberVo
	 *  @return int
	*/
	public int loginMember(MemberVo memberVo);
	
	/*
	 *  회원등록
	 *  @param MemberVo
	 *  @return int
	*/
	public int insertMember(MemberVo memberVo);
	
	/*
	 *  회원 삭제
	 *  @param MemberVo
	 *  @return int
	*/
	public int deleteMember(MemberVo memberVo);
	
	/*
	 *  회원 수정
	 *  @param MemberVo
	 *  @return int
	 */
	public int updateMember(MemberVo memberVo);
	
	/*
	 *  회원 조회
	 *  @param MemberVo
	 *  @return List<MemberVo>
	 */
	public List<MemberVo> selectListMember();
	
	
}
