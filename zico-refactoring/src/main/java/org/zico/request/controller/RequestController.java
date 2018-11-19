package org.zico.request.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.zico.common.dto.Page;

/**
 * @ClassName   : RequestController.java
 * @Description : 주문 Controller
 * @Author      : Mantos
*/
public class RequestController {
	
	@GetMapping("/request")
	public String getList(Model model, Page page) {
		model.addAttribute("store");
		model.addAttribute("totalCnt");
		return null;
	}
	
	@PostMapping("/request")
	public String postList() {
		return null;
	}
	
	@GetMapping("/request/{storeNo}")
	public String getStore() {
		return null;
	}
	
	@PostMapping("/order/{storeNo}/pay")
	public String postPay() {
		return null;
	}
}
