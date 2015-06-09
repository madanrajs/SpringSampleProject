package com.aakam.sample.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.aakam.sample.ApplicationConfig;
import com.aakam.sample.MvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class, MvcConfig.class })
@WebAppConfiguration
public class TestUserController {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private static Logger logger = LoggerFactory
			.getLogger(TestUserController.class);

	@Before
	public void setUp() {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	public void testGetUserResource() throws Exception {

		mockMvc.perform(get("/user")).andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void testGetUser() throws Exception {

		mockMvc.perform(post("/user")).andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

}