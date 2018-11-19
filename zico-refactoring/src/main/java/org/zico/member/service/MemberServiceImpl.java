package org.zico.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zico.member.dao.MemberDao;
import org.zico.member.vo.MemberVo;

/**
 * @ClassName   : MemberServiceImpl.java
 * @Description : 회원관리 Service
 * @Author      : Mantos
*/
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberdao;

	/*
	 *  로그인 처리
	 *  @param MemberVo
	 *  @return int
	*/
	@Override
	public MemberVo loginMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return memberdao.loginMember(memberVo);
	}
	
	/*
	 *  회원등록
	 *  @param MemberVo
	 *  @return int
	*/
	@Override
	public int insertMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return memberdao.insertMember(memberVo);
	}

	/*
	 *  회원 삭제
	 *  @param MemberVo
	 *  @return int
	*/
	@Override
	public int deleteMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return memberdao.deleteMember(memberVo);
	}

	/*
	 *  회원 수정
	 *  @param MemberVo
	 *  @return int
	 */
	@Override
	public int updateMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return memberdao.updateMember(memberVo);
	}

	/*
	 *  회원 조회
	 *  @param MemberVo
	 *  @return List<MemberVo>
	 */
	@Override
	public List<MemberVo> selectMember() {
		// TODO Auto-generated method stub
		return memberdao.selectListMember();
	}

	/*
	 *  회원 아이디 검색
	 *  @param String(memberId)
	 *  @return int
	 */
	@Override
	public int selectMemberId(String memberId) {
		// TODO Auto-generated method stub
		return memberdao.selectMemberId(memberId);
	}
	
}
