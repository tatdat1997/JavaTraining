package com.springboothello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboothello.form.YourFormBean;

@Controller
public class AController {
	
	@GetMapping("/your")
	public String your(Model model){
		model.addAttribute("yourFormBean", new YourFormBean());
		return "TextAjax";
	}

	
//	@RequestMapping(value = "/actions/postForm", method = RequestMethod.POST) 
//	public String saveForm(Model model, 
//	        @RequestParam("additionalParam") Integer additionalParam, 
//	        @Valid YourFormBean yourFormBean,
//	        BindingResult bindingResult,
//	        RedirectAttributes redirectAttributes) {
//	    if (bindingResult.hasErrors()) {
//	        model.addAttribute("hasError", true);
//	        return "your/template :: yourFragment";
//	    }
//	    redirectAttributes.addAttribute("additionalParam", additionalParam);
//	    
//	    return "redirect:/another/page";
//	}

	@RequestMapping(value = "/postForm", method = RequestMethod.POST) 
	public String saveForm(Model model, HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(!username.isEmpty()) {
			model.addAttribute("msg","122313");
			return "TextAjax";
		}
		return "TextAjax";
	}
}
