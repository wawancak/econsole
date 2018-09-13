package com.sh.djpk.econsole.rest.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sh.djpk.econsole.rest.service.LraReportSvc;
import com.sh.djpk.share.model.RestResponse;
import com.sh.djpk.share.util.JsonUtil;

@RestController
@RequestMapping("/lra_report")
public class LraReportCtl {

	public static final Logger LOGGER = LoggerFactory
			.getLogger(LraReportCtl.class);

	@Autowired
	LraReportSvc lraReportSvc;

	@RequestMapping(value = "/get_lra_report_data", method = RequestMethod.POST)
	public RestResponse getLraReportData(
			@RequestParam(value = "tahun_anggaran", required = true) int tahunAnggaran,
			@RequestParam(value = "periode_id", required = true) int periodeId,
			@RequestParam(value = "kode_laporan", required = true) int kodeLaporan,
			@RequestBody HashMap othersParam) {
		LOGGER.info("get_lra_report_data");
		RestResponse response = new RestResponse(RestResponse.OK_REST_STATUS,
				"OK", null);
		response.setContents(lraReportSvc.getLraReportData(tahunAnggaran,
				periodeId, kodeLaporan, othersParam));
		LOGGER.trace("response={}", JsonUtil.getJson(response));
		return response;
	}
}
