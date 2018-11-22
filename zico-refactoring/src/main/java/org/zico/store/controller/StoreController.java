package org.zico.store.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zico.common.dto.Page;
import org.zico.notice.Service.NoticeService;
import org.zico.store.service.StoreService;
import org.zico.store.vo.StoreVo;

/**
 * @ClassName   : StoreController.java
 * @Description : 매장 Controller
 * @Author      : Mantos
*/
@Controller
public class StoreController {

	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
	
	@Autowired
	StoreService storeService;
	
	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/store")
	public String getStore(Model model, HttpSession session) {
		Page page = new Page();
		model.addAttribute("list",	noticeService.selectListNotice(page));
		return "/store/dashboard";
	}
	
	@GetMapping("/store/detail")
	public void getDetail(Model model, HttpSession session) {
		Page page = new Page();
		model.addAttribute("list",	noticeService.selectListNotice(page));
		int storeNo = (Integer) session.getAttribute("storeNo");
		model.addAttribute("store", storeService.selectStore(storeNo));
	}
	
	@GetMapping("/store/update")
	public void getUpdate(Model model, HttpSession session) {
		Page page = new Page();
		model.addAttribute("list",	noticeService.selectListNotice(page));
		int storeNo = (Integer) session.getAttribute("storeNo");
		model.addAttribute("store", storeService.selectStore(storeNo));
	}
	
	@PostMapping("/store/update")
	public String postUpdate(StoreVo storeVo, Page page, MultipartFile imgFile, Model model, HttpSession session) {
		
		String uuid = UUID.randomUUID().toString();
		String uploadName = uuid + "_" + imgFile.getOriginalFilename();
		model.addAttribute("uploadName", uploadName);
		
		try {
			OutputStream out = new FileOutputStream("c:\\uploadImage\\" + uploadName);
			FileCopyUtils.copy(imgFile.getInputStream(), out);
			
			if(imgFile.getContentType().startsWith("image")) {
				model.addAttribute("isImage", imgFile.getContentType().startsWith("image"));
				makeThumnail(uploadName);
			}
		} catch(Exception e) {
			logger.warn(e.getMessage());
		}
		
		storeVo.setStoreImage(uploadName);
		storeVo.setStoreMemberId(session.getAttribute("id").toString());
		
		logger.warn("WARN    :: " + storeVo.toString());
		
		storeService.updateStore(storeVo);
		return "redirect:/store/detail";
	}
	
	@GetMapping("/store/insert")
	public void getInsert(Model model) {
		Page page = new Page();
		model.addAttribute("list",	noticeService.selectListNotice(page));
	}
	
	@PostMapping("/store/insert")
	public String postInsert(StoreVo storeVo, Page page, MultipartFile imgFile, Model model, HttpSession session) {
		String uuid = UUID.randomUUID().toString();
		String uploadName = uuid + "_" + imgFile.getOriginalFilename();
		model.addAttribute("uploadName", uploadName);
		
		try {
			OutputStream out = new FileOutputStream("c:\\uploadImage\\" + uploadName);
			FileCopyUtils.copy(imgFile.getInputStream(), out);
			
			if(imgFile.getContentType().startsWith("image")) {
				model.addAttribute("isImage", imgFile.getContentType().startsWith("image"));
				makeThumnail(uploadName);
			}
		} catch(Exception e) {
			logger.warn("ERROR 	:: "+e.getMessage());
		}
		
		storeVo.setStoreImage(uploadName);
		storeVo.setStoreMemberId(session.getAttribute("id").toString());
		
		session.setAttribute("storeNo", storeService.insertStore(storeVo));
		logger.warn(session.getAttribute("storeNo") + "");
		return "redirect:/store";
	}
	
	@PostMapping("/store/delete")
	public String delete(HttpSession session) {
		int storeNo = (Integer)session.getAttribute("storeNo");
		storeService.deleteStore(storeNo);
		
		session.removeAttribute("storeNo");
		return "redirect:/store";
	}
	
	
	private String makeThumnail(String fileName) throws Exception {
		
		BufferedImage sourceImg = ImageIO.read(new File("c:\\uploadImage\\", fileName));
		BufferedImage destImg	= Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 368);
		String thumnailName = "c:\\uploadImage\\" + File.separator + "s_" + fileName;
		File newFile = new File(thumnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);

		return thumnailName;
	}
	
	
	@ResponseBody
	@GetMapping(value="/store/display", produces="image/jpeg")
	public byte[] display(String name) {
		try {
			FileInputStream in = new FileInputStream("c:\\uploadImage\\" + name);
			ByteArrayOutputStream bas = new ByteArrayOutputStream();
			FileCopyUtils.copy(in, bas);
			
			return bas.toByteArray();
		} catch(Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
}
