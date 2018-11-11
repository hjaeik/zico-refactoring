package org.zico.notice.vo;

import java.util.Date;

/**
 * @ClassName   : NoticeVO.java
 * @Description : 공지사항 VO
 * @Author      : mantos
*/

public class NoticeVo {
	private int 	noticeNo;
	private int 	noticeHits;
	private String 	noticeMemberId;
	private String 	noticeTitle;
	private String 	noticeContents;
	private Date	noticeRegdate;
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public int getNoticeHits() {
		return noticeHits;
	}
	public void setNoticeHits(int noticeHits) {
		this.noticeHits = noticeHits;
	}
	public String getNoticeMemberId() {
		return noticeMemberId;
	}
	public void setNoticeMemberId(String noticeMemberId) {
		this.noticeMemberId = noticeMemberId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public Date getNoticeRegdate() {
		return noticeRegdate;
	}
	public void setNoticeRegdate(Date noticeRegdate) {
		this.noticeRegdate = noticeRegdate;
	}
}
