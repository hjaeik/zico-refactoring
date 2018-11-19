package org.zico.member.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zico.member.vo.MemberVo;

/**
 * @ClassName   : MemberService.java
 * @Description : 회원관리 Service
 * @Author      : Mantos
*/
@Service
public interface MemberService {
	
	/*
	 *  로그인 처리
	 *  @param MemberVo
	 *  @return int
	*/
	public MemberVo loginMember(MemberVo memberVo);
	
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
	public List<MemberVo> selectMember();

	/*
	 *  회원 아이디 검색
	 *  @param String(memberId)
	 *  @return int
	 */
	public int selectMemberId(String memberId);
}
