package org.zico.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;
import org.zico.member.service.MemberService;
import org.zico.member.vo.MemberVo;
import org.zico.web.HomeController;

/**
 * @ClassName   : MemberController.java
 * @Description : 회원 Controller
 * @Author      : Mantos
*/
@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/member/insert")
	public void getInsert() {
	}
	
	@PostMapping("/member/insert")
	public String postInsert(MemberVo memberVo) {
		memberService.insertMember(memberVo);
		return "/home";
	}
	
	@PostMapping("/logout")
	public String postLogout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		Object id = session.getAttribute("id");
		if(id != null) {
			session.removeAttribute("id");
			session.invalidate();	
			Cookie loginCookie = WebUtils.getCookie(request, "id");
			
			if(loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
			}
		}
		return "/home";
	}
	
	@PostMapping("/login/{remember}")
	public String postLogin(Model model,MemberVo memberVo, @PathVariable(value="remember") String remember) {

		memberVo = memberService.loginMember(memberVo);
		String redirectUrl = "redirect:/?status=fail";
		
		if(memberVo != null) {
			model.addAttribute("id",memberVo.getMemberId());
			model.addAttribute("grade",memberVo.getMemberGrade());
			model.addAttribute("cookie",remember);
			if(memberVo.getStoreNo() != null) {
				model.addAttribute("storeNo", memberVo.getStoreNo());
			}
			redirectUrl = "/home";
		}
		return redirectUrl;
	}
	
	@GetMapping("/member/duplicatecheck")
	@ResponseBody
	public int duplicatecheck(@RequestParam(value="id") String memberId) {		
		return memberService.selectMemberId(memberId);
	}
}
