package org.zico.member.vo;

/**
 * @ClassName   : MemberVO.java
 * @Description : 회원 VO
 * @Author      : mantos
*/

public class MemberVo {
	private String 	memberId;
	private String 	memberName;
	private String 	memberPassword;
	private String 	memberPhone;
	private String 	memberPwdHint;
	private String 	memberPwdAnswer;
	private Integer memberGrade;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public Integer getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(Integer memberGrade) {
		this.memberGrade = memberGrade;
	}
	public String getMemberPwdHint() {
		return memberPwdHint;
	}
	public void setMemberPwdHint(String memberPwdHint) {
		this.memberPwdHint = memberPwdHint;
	}
	public String getMemberPwdAnswer() {
		return memberPwdAnswer;
	}
	public void setMemberPwdAnswer(String memberPwdAnswer) {
		this.memberPwdAnswer = memberPwdAnswer;
	}
	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", memberName=" + memberName + ", memberPassword=" + memberPassword
				+ ", memberPhone=" + memberPhone + ", memberGrade=" + memberGrade + ", memberPwdHint=" + memberPwdHint
				+ ", memberPwdAnswer=" + memberPwdAnswer + "]";
	}
	
}
