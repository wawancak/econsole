package com.sh.djpk.econsole.ui.controller.pelaporan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sh.djpk.share.model.RestResponse.HttpMethod;
import com.sh.djpk.share.util.ClientsUtil;


@ManagedBean
public class Pelaporan {
	
	public static final Logger LOGGER = LoggerFactory
			.getLogger(Pelaporan.class);
	
	
		
	public Pelaporan() {
		selectOneJenisLaporan = getDataSelectOneJenisLaporan();
	}



	List<Map<String, Object>> selectOneJenisLaporan = new ArrayList<Map<String,Object>>();
	Map<String, Object> selectedJenisLaporan = new HashMap<String, Object>();
	
	
	
	public List<Map<String, Object>> getDataSelectOneJenisLaporan(){
		List<Map<String, Object>> l = ClientsUtil.callWsListResponse("/global_param/get_all_data", null, HttpMethod.GET, "global_param_parent=JENIS_LAPORAN");
		return l;
	}



	public List<Map<String, Object>> getSelectOneJenisLaporan() {
		return selectOneJenisLaporan;
	}



	public void setSelectOneJenisLaporan(
			List<Map<String, Object>> selectOneJenisLaporan) {
		this.selectOneJenisLaporan = selectOneJenisLaporan;
	}



	public Map<String, Object> getSelectedJenisLaporan() {
		return selectedJenisLaporan;
	}



	public void setSelectedJenisLaporan(Map<String, Object> selectedJenisLaporan) {
		this.selectedJenisLaporan = selectedJenisLaporan;
	}



	
}
