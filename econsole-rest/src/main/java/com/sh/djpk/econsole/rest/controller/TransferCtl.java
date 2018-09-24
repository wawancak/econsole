package com.sh.djpk.econsole.rest.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sh.djpk.econsole.rest.service.TransferSvc;
import com.sh.djpk.econsole.rest.service.TransferSvc;
import com.sh.djpk.share.model.RestResponse;

@RestController
@RequestMapping("/ref_transfer")
public class TransferCtl {

	public static final Logger LOGGER = LoggerFactory
			.getLogger(TransferCtl.class);
	
	@Autowired TransferSvc transferSvc;
	
	@RequestMapping(value = "/listTransfer", method = RequestMethod.GET)
	public RestResponse getTransfer() {
		LOGGER.info("GET ALL TRANSFER");
		RestResponse response = new RestResponse(RestResponse.OK_REST_STATUS,
				"OK", null);
		List<HashMap>  lst = transferSvc.getAllPemda();
		response.setTotalRecords(lst.size());
		response.setContents(lst);
		return response;
	}
}
