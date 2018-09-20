package com.sh.djpk.econsole.ui.controller.pelaporan;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sh.djpk.share.model.RestResponse.HttpMethod;
import com.sh.djpk.share.util.ClientsUtil;
import com.sh.djpk.share.util.NumberUtils;

@ManagedBean
@ViewScoped
public class Pelaporan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Logger LOGGER = LoggerFactory
			.getLogger(Pelaporan.class);

	private boolean isDisableCbOthers = true;

	public Pelaporan() {
		selectOneJenisLaporan = getDataSelectOneJenisLaporan();
		selectOnePeriodeLaporan = getDataSelectOnePeriodeLaporan();
		selectOneDownload = getDataSelectOneDownload();
		// selectOneOthers = getDataSelectOthers(4);
	}

	List<Map<String, Object>> selectOneJenisLaporan = new ArrayList<Map<String, Object>>();
	String selectedJenisLaporan;

	List<Map<String, Object>> selectOneOthers = new ArrayList<Map<String, Object>>();
	String selectedOthers;

	List<Map<String, Object>> selectOnePeriodeLaporan = new ArrayList<Map<String, Object>>();
	String selectedPeriodeLaporan;

	List<Map<String, Object>> selectOneDownload = new ArrayList<Map<String, Object>>();
	String selectedDownload;

	List<Map<String, Object>> dataPencarian = new ArrayList<Map<String, Object>>();

	public List<Map<String, Object>> getDataSelectOneJenisLaporan() {
		List<Map<String, Object>> l = ClientsUtil.callWsListResponse(
				"/global_param/get_all_data", null, HttpMethod.GET,
				"global_param_parent=JENIS_LAPORAN");
		return l;
	}

	public List<Map<String, Object>> getDataSelectOneDownload() {
		List<Map<String, Object>> l = ClientsUtil.callWsListResponse(
				"/global_param/get_all_data", null, HttpMethod.GET,
				"global_param_parent=DOWNLOAD");
		return l;
	}

	public List<Map<String, Object>> getDataSelectOnePeriodeLaporan() {
		List<Map<String, Object>> l = ClientsUtil.callWsListResponse(
				"/lra_report/get_periode", null, HttpMethod.GET);
		return l;
	}

	 public List<Map<String, Object>> ambilData() {
	 Map<String, Object> othersParam = new HashMap<String, Object>();
	 othersParam.put("value_cb", selectedOthers);
	 List<Map<String, Object>> l = ClientsUtil.callWsListResponse(
	 "/lra_report/get_lra_report_data", othersParam,
	 HttpMethod.POST, "tahun_anggaran=2016", "periode_id="
	 + selectedPeriodeLaporan, "kode_laporan="
	 + selectedJenisLaporan);
	 return l;
	 }

//	public Map<String, Object> ambilData() {
//		Map<String, Object> othersParam = new HashMap<String, Object>();
//		othersParam.put("value_cb", selectedOthers);
//		Map<String, Object> l = ClientsUtil.callWsMapResponse(
//				"/lra_report/get_lra_report_data", othersParam,
//				HttpMethod.POST, "tahun_anggaran=2016", "periode_id="
//						+ selectedPeriodeLaporan, "kode_laporan="
//						+ selectedJenisLaporan);
//		return l;
//	}

	// public void chooseJenisLaporan(AjaxBehaviorEvent event){
	public void chooseJenisLaporan(ValueChangeEvent event) {
		LOGGER.info("<<chooseJenisLaporan>>");
		String val = event.getNewValue().toString();
		LOGGER.info("<<val={}>>", val);
		int kodeLaporan = NumberUtils.toInteger(val);
		selectOneOthers = new ArrayList<Map<String, Object>>();
		dataPencarian = new ArrayList<Map<String, Object>>();
		if (kodeLaporan == 2 || kodeLaporan == 3 || kodeLaporan == 4) {
			selectOneOthers = getDataSelectOthers(kodeLaporan);
		}
	}

	// TODO memilih download
	public void chooseDownload(ValueChangeEvent event) {
		LOGGER.info("<<chooseDownload>>");
		String val = event.getNewValue().toString();
		LOGGER.info("<<val={}>>", val);
		if ("JSON".equals(val)) {
			// InputStream stream =
			// FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/demo/images/boromir.jpg");
			// InputStream stream = new
			// StreamedContent file = new DefaultStreamedContent(stream,
			// "image/jpg", "downloaded_boromir.jpg");
		}
	}

	public List<Map<String, Object>> getDataSelectOthers(int jenisLaporan) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> l = ClientsUtil.callWsListResponse(
				"/lra_report/get_ref_pemda2", params, HttpMethod.POST,
				"kode_laporan=" + jenisLaporan, "tahun_anggaran=2016");
		// if (l != null && !l.isEmpty()) {
		// selectedOthers = (String) l.get(0).get("value_cb");
		// }
		return l;
	}

	public void cari() {
		LOGGER.info("<<CARI>>");
		LOGGER.info("jenis laporan = {}, periode laporan ={}, others={}",
				selectedJenisLaporan, selectedPeriodeLaporan, selectedOthers);
		int kodeLaporan = NumberUtils.toInteger(selectedJenisLaporan);
		if (kodeLaporan == 1 || kodeLaporan == 2 || kodeLaporan == 3
				|| kodeLaporan == 4) {
			dataPencarian = ambilData() ;
//			dataPencarian = ambilData() == null ? new ArrayList<Map<String, Object>>()
//					: (ArrayList<Map<String,Object>>)ambilData().get("list_tingkat1");
		}

	}

	public List<Map<String, Object>> getSelectOneJenisLaporan() {
		return selectOneJenisLaporan;
	}

	public void setSelectOneJenisLaporan(
			List<Map<String, Object>> selectOneJenisLaporan) {
		this.selectOneJenisLaporan = selectOneJenisLaporan;
	}

	public boolean isDisableCbOthers() {
		return isDisableCbOthers;
	}

	public void setDisableCbOthers(boolean isDisableCbOthers) {
		this.isDisableCbOthers = isDisableCbOthers;
	}

	public List<Map<String, Object>> getSelectOneOthers() {
		return selectOneOthers;
	}

	public void setSelectOneOthers(List<Map<String, Object>> selectOneOthers) {
		this.selectOneOthers = selectOneOthers;
	}

	public List<Map<String, Object>> getSelectOnePeriodeLaporan() {
		return selectOnePeriodeLaporan;
	}

	public void setSelectOnePeriodeLaporan(
			List<Map<String, Object>> selectOnePeriodeLaporan) {
		this.selectOnePeriodeLaporan = selectOnePeriodeLaporan;
	}

	public String getSelectedJenisLaporan() {
		return selectedJenisLaporan;
	}

	public void setSelectedJenisLaporan(String selectedJenisLaporan) {
		this.selectedJenisLaporan = selectedJenisLaporan;
	}

	public String getSelectedOthers() {
		return selectedOthers;
	}

	public void setSelectedOthers(String selectedOthers) {
		this.selectedOthers = selectedOthers;
	}

	public String getSelectedPeriodeLaporan() {
		return selectedPeriodeLaporan;
	}

	public void setSelectedPeriodeLaporan(String selectedPeriodeLaporan) {
		this.selectedPeriodeLaporan = selectedPeriodeLaporan;
	}

	public List<Map<String, Object>> getSelectOneDownload() {
		return selectOneDownload;
	}

	public void setSelectOneDownload(List<Map<String, Object>> selectOneDownload) {
		this.selectOneDownload = selectOneDownload;
	}

	public String getSelectedDownload() {
		return selectedDownload;
	}

	public void setSelectedDownload(String selectedDownload) {
		this.selectedDownload = selectedDownload;
	}

	public List<Map<String, Object>> getDataPencarian() {
		return dataPencarian;
	}

	public void setDataPencarian(List<Map<String, Object>> dataPencarian) {
		this.dataPencarian = dataPencarian;
	}

}
