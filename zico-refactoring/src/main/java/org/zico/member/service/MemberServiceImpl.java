package org.zico.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zico.member.dao.MemberDao;
import org.zico.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberdao;

	@Override
	public int loginMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVo> selectMember() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
