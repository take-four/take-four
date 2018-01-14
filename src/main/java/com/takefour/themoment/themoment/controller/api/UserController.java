package com.takefour.themoment.themoment.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takefour.themoment.themoment.config.method.annotation.CurrentUser;
import com.takefour.themoment.themoment.model.User;

/**
 * Created by hanbyeol on 2018. 1. 3..
 */
@RestController
@RequestMapping("/apis/users")
public class UserController {

	@PostMapping
	private User signUp(@CurrentUser User user) {
		return user;
	}

}
