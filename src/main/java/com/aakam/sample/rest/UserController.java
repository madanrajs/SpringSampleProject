package com.aakam.sample.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aakam.sample.assembler.UserRA;
import com.aakam.sample.dto.User;
import com.aakam.sample.view.UserView;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserRA userRA;

	@JsonView(UserView.Summary.class)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Resource<User> getUserWithResource() {

		User user = new User(1L, "fname", "lname");
		return userRA.toResource(user);
	}

	@JsonView(UserView.Summary.class)
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public User getUser() {
		User user = new User(1L, "fname", "lname");
		return user;
	}
}
