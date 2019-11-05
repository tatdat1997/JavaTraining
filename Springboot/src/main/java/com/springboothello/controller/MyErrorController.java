package com.springboothello.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create MyErrorController class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */
@Controller
public class MyErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param request
	 * @param http
	 * @return Error page
	 */
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, HttpSession http) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		// If have error status
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			// If have error status: NOT_FOUND
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "error-404";
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				// If have error status: INTERNAL_SERVER_ERROR
				return "error-500";
			}
		}
		return "error";
	}
}
