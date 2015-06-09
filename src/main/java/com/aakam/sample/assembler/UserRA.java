package com.aakam.sample.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.aakam.sample.dto.User;
import com.aakam.sample.rest.UserController;

@Component
public class UserRA implements ResourceAssembler<User, Resource<User>> {

	@Override
	public Resource<User> toResource(User user) {
		Resource<User> resource = new Resource<User>(user);
		resource.add(linkTo(UserController.class).withSelfRel());
		return resource;
	}

}