package com.sh.djpk.econsole.ui.controller.parameter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sh.djpk.share.model.RestResponse.HttpMethod;
import com.sh.djpk.share.util.ClientsUtil;

@ManagedBean
public class TransferCtl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public static final Logger LOGGER = LoggerFactory.getLogger(TransferCtl.class);
	
	List<Map<String, Object>> listTransfer;
	
	@PostConstruct
    public void init() {
		
		listTransfer = ClientsUtil.callWsListResponse(
				"/ref_transfer/listTransfer", null, HttpMethod.GET,
				null);
		
		
	}

	public List<Map<String, Object>> getListTransfer() {
		return listTransfer;
	}

	public void setListTransfer(List<Map<String, Object>> listTransfer) {
		this.listTransfer = listTransfer;
	}
	
 } 