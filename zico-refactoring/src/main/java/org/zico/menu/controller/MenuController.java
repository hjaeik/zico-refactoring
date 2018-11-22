package org.zico.menu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zico.common.dto.Page;
import org.zico.common.util.MediaUtils;
import org.zico.common.util.UploadFileUtils;
import org.zico.menu.service.MenuService;
import org.zico.menu.vo.MenuVo;
import org.zico.notice.Service.NoticeService;

/**
 * @ClassName   : MenuController.java
 * @Description : 매장내 메뉴 Service
 * @Author      : mantos
*/
@Controller
public class MenuController {

	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/store/menu")
	public String getMenu(Model model, HttpSession session) {
		Page page = new Page();
		int menuStoreNo = (Integer) session.getAttribute("storeNo");
		model.addAttribute("list",	noticeService.selectListNotice(page));
		model.addAttribute("page",page);
		model.addAttribute("menu",menuService.selectListMenu(page, menuStoreNo));
		model.addAttribute("total",menuService.selectTotalCnt(menuStoreNo));
		return "/menu/list";
	}
	
	@GetMapping("/store/menu/insert")
	public String getInsert(Model model, HttpSession session){
		Page page = new Page();
		model.addAttribute("list",	noticeService.selectListNotice(page));
		return "/menu/insert";
	}
	
	@PostMapping("/store/menu/insert")
	public String postInsert(MenuVo menuVo, HttpSession session) {
		menuVo.setMenuCategory("test");
		menuVo.setMenuStoreNo(Integer.parseInt(session.getAttribute("storeNo").toString()));
		menuService.insertMenu(menuVo);

		return "redirect:/store/menu";

	}	
	
	@PostMapping("/store/menu/delete")
	public String postDelete(@RequestParam(name = "menuNo") int menuNo) {
		menuService.deleteMenu(menuNo);
		return "redirect:/store/menu";
	}
	
	@GetMapping("/store/menu/update")
	public String getUpdate(@RequestParam(name = "menuNo") int menuNo, Model model) {
		Page page = new Page();
		model.addAttribute("list",	noticeService.selectListNotice(page));
		model.addAttribute("menu", menuService.selectMenu(menuNo));
		return "/menu/update";
	}
	
	@PostMapping("/store/menu/update")
	public String postUpdate(MenuVo menuVo, String imgName, HttpSession session) {
		menuVo.setMenuStoreNo(Integer.parseInt(session.getAttribute("storeNo").toString()));
		menuService.updateMenu(menuVo);
		return "redirect:/store/menu";
	}
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath + fileName);

			if (mType != null) {
				headers.setContentType(mType);

			} else {

				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",
						"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) {

		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		MediaType mType = MediaUtils.getMediaType(formatName);
		if (mType != null) {

			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			logger.warn("front : " + front);
			logger.warn("end : " + end);
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
		}
		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file, Model model) throws Exception {
		logger.warn("FILE uploadPath	:: " + uploadPath);
		logger.warn("originalName		:: " + file.getOriginalFilename());

		return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
	}
	
}
