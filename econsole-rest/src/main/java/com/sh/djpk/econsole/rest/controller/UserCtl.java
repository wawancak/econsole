package com.sh.djpk.econsole.rest.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sh.djpk.econsole.rest.service.UserSvc;
import com.sh.djpk.share.model.RestResponse;

@RestController
@RequestMapping("/user")
public class UserCtl {

	public static final Logger LOGGER = LoggerFactory.getLogger(UserCtl.class);

	@Autowired
	UserSvc userSvc;

	@RequestMapping(value = "/get_all_paging/{pageSequence}/{pageSize}", method = RequestMethod.POST)
	public RestResponse getAllPaging(
			@PathVariable(value = "pageSequence") int pageSequence,
			@PathVariable(value = "pageSize") int pageSize,
			@RequestParam(value = RestResponse.DIRECTION, required = false) String direction,
			@RequestParam(value = RestResponse.ORDER_BY, required = true) String orderBy,
			@RequestBody HashMap<String, Object> params) {
		LOGGER.info("GET ALL PAGING");
		LOGGER.info(
				"pageSequence={},pageSize={},direction={},order_by={},params={}",
				pageSequence, pageSize, direction, orderBy, params);
		RestResponse response = new RestResponse(RestResponse.OK_REST_STATUS,
				"OK", null);
		response.setContents(userSvc.getAllPaging(pageSize, pageSequence,
				direction, orderBy, params));
		return response;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public RestResponse insert(@RequestBody HashMap<String, Object> params) {
		LOGGER.info("INSERT");
		LOGGER.info("params={}", params);
		RestResponse response = new RestResponse(RestResponse.OK_REST_STATUS,
				"OK", null);
		response.setContents(userSvc.insert(params));
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public RestResponse update(@RequestBody HashMap<String, Object> params) {
		LOGGER.info("update");
		LOGGER.info("params={}", params);
		RestResponse response = new RestResponse(RestResponse.OK_REST_STATUS,
				"OK", null);
		response.setContents(userSvc.update(params));
		return response;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public RestResponse delete(@RequestBody HashMap<String, Object> params) {
		LOGGER.info("delete");
		LOGGER.info("params={}", params);
		RestResponse response = new RestResponse(RestResponse.OK_REST_STATUS,
				"OK", null);
		response.setContents(userSvc.delete(params));
		return response;
	}
}
