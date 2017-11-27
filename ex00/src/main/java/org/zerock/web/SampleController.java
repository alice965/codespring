package org.zerock.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("/doA")
	public void doA() {
		logger.info("doA Called............");
	}
	
	@RequestMapping("doB")
	public void doB() {
		logger.info("doB Called............");
	}
	
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {
		logger.info("doC Called............");
		
		return "result";
	}
	
	@RequestMapping("doD")
	public String doD(Model model) {
		ProductVO product = new ProductVO("SampleP", 10000);
		logger.info("doD");
		model.addAttribute(product);
		return "productDetail";
	}
	@RequestMapping("doE")
	public String doE(RedirectAttributes rttr) {
		logger.info("doE called but redirected to doF");
		rttr.addFlashAttribute("msg", "test test test");
		return "redirect:/doF";
	}
	@RequestMapping("doF")
	public void doF(@ModelAttribute("msg") String msg) {
		logger.info("doF Called...." + msg);
	}
	
}
