package com.spring.controller;

import java.util.HashMap;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.form.LoginForm;

@RestController
public class LoginController {
	
	
	@RequestMapping("/checklogin")
	public ResponseEntity<?> Checklogin(@Valid @RequestBody LoginForm form) {
		String user = form.getUsername();
		String pass = form.getPassword();
		HashMap<String, String> result = new HashMap<>();
		if(user.equals("dat114") && pass.equals("123123")) {
			result.put("status", "OK");
		}else {
			result.put("status", "Fail");
		}
		return ResponseEntity.ok(result);
	}
	@RequestMapping("/xc")
	public HashMap<String, String> xc() {

		HashMap<String, String> result = new HashMap<>();

			result.put("status", "OK");
		return result;
	}
}
