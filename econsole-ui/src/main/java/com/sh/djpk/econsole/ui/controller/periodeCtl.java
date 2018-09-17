package com.sh.djpk.econsole.ui.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sh.djpk.share.dto.periodeDto;
import com.sh.djpk.share.model.RestResponse.HttpMethod;
import com.sh.djpk.share.util.ClientsUtil;

@ManagedBean
@ViewScoped
public class periodeCtl  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<periodeDto> period;
	
	@PostConstruct
    public void init() {
		
		List<Map<String, Object>> lst = ClientsUtil.callWsListResponse(
				"/periode/all", null, HttpMethod.GET,
				null);
//		System.out.println("========================================="+lst);
		period = new ArrayList<periodeDto>();
		for (Map<String, Object> mpl : lst){
			period.add(new periodeDto(mpl.get("id").toString(),mpl.get("name").toString()));
		}
		
		
	}

	public List<periodeDto> getPeriod() {
		return period;
	}

	public void setPeriod(List<periodeDto> period) {
		this.period = period;
	}

	
	
}
