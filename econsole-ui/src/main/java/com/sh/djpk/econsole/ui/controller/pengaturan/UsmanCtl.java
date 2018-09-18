package com.sh.djpk.econsole.ui.controller.pengaturan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sh.djpk.econsole.ui.controller.pelaporan.Pelaporan;
import com.sh.djpk.share.model.User;
import com.sh.djpk.share.model.RestResponse.HttpMethod;
import com.sh.djpk.share.util.ClientsUtil;
import com.sh.djpk.share.util.NumberUtils;
import com.sh.djpk.share.util.StringUtils;

@ManagedBean
@ViewScoped
public class UsmanCtl implements Serializable {
	public static final Logger LOGGER = LoggerFactory.getLogger(UsmanCtl.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Map<String, Object>> listUser = new ArrayList<Map<String, Object>>();

	private String searchIndexUsername;

	public UsmanCtl() {
		this.listUser = getDataListUser(null);
	}

	public List<Map<String, Object>> getDataListUser(String username) {
		Map<String, Object> othersParam = new HashMap<String, Object>();
		othersParam.put("username", StringUtils.surroundString(username, "%%"));
		List<Map<String, Object>> l = ClientsUtil.callWsListResponse(
				"/user/get_all_paging/0/1000", othersParam, HttpMethod.POST,
				"order_by=", "direction=");
		return l;
	}

	public void eventChangeUsername(ValueChangeEvent event) {
		LOGGER.info("<<eventChangeUsername>>");
		String val = event.getNewValue().toString();
		LOGGER.info("<<val={}>>", val);
		this.listUser = getDataListUser(val);
	}

	public String indexButtonAdd() {
		System.out.println("masuk sini");
		return "_detail";
	}

	public List<Map<String, Object>> getListUser() {
		return listUser;
	}

	public void setListUser(List<Map<String, Object>> listUser) {
		this.listUser = listUser;
	}

	public String getSearchIndexUsername() {
		return searchIndexUsername;
	}

	public void setSearchIndexUsername(String searchIndexUsername) {
		this.searchIndexUsername = searchIndexUsername;
	}

}
