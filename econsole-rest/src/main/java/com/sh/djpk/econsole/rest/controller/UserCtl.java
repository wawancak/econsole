package com.sh.djpk.econsole.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sh.djpk.econsole.rest.service.UserSvc;
import com.sh.djpk.share.model.RestResponse;

@RestController
@RequestMapping("/user")
public class UserCtl {

	
	public static final Logger LOGGER = LoggerFactory
			.getLogger(UserCtl.class);

	@Autowired UserSvc userSvc;
	
	@RequestMapping(value = "/get_all", method = RequestMethod.GET)
	public RestResponse getAll() {
		LOGGER.info("GET ALL");
		RestResponse response = new RestResponse(RestResponse.OK_REST_STATUS,
				"OK", null);
		response.setContents(userSvc.getAll());
		return response;
	}
}
