package org.zico.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zico.common.dto.Page;
import org.zico.notice.Service.NoticeService;


/**
 * @ClassName   : NoticeController.java
 * @Description : 공지사항 Controller
 * @Author      : Mantos
*/
@Controller
//@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	/*
	 * 공지사항 초기화면
	 * @param
	 * @return
	 */
	@GetMapping("/notice")
	public String getList(Model model, Page page) {
		model.addAttribute("noticeList", noticeService.selectListNotice(page));
		model.addAttribute("totalCnt", noticeService.selectTotalCnt());
		model.addAttribute("page", page);
		return "/notice/list";
	}
	
	/*
	 * 공지사항내 페이지 이동시 화면
	 * @param
	 * @return
	 */
	@PostMapping("/notice")
	public String postList(Model model, Page page) {
		model.addAttribute("noticeList", noticeService.selectListNotice(page));
		model.addAttribute("totalCnt", noticeService.selectTotalCnt());
		model.addAttribute("page", page);
		return "/notice/list";		
	}
	
	/*
	 * 공지사항 상세페이지
	 * @param
	 * @return
	 * ##hits조작 방지를 위해 IP or 접속컴퓨터 정보 이용 하여 딜레이 작업필요 
	 */
	@GetMapping("/notice/{noticeNo}")
	public String getDetail(@PathVariable("noticeNo") int noticeNo, Model model) {
		model.addAttribute("notice",noticeService.selectNotice(noticeNo));
		return "/notice/detail";
	}
	
	/*
	 * [관리자]공지사항 입력
	 * @param
	 * @return
	 * ##Session 작업
	 */
	@GetMapping("/notice/insert")
	public String getinsert() {
		return "/notice/insert";
	}

	/*
	 * [관리자]공지사항 입력
	 * @param
	 * @return
	 * ##Session 작업
	 */
	@PostMapping("/notice/insert")
	public void postInsert() {
		
	}

	/*
	 * [관리자]공지사항 삭제
	 * @param
	 * @return
	 * ##Session 작업
	 */
	@GetMapping("/notice/delete")
	public void getdelete() {
		
	}
	
}
