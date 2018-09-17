package com.sh.djpk.econsole.ui.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sh.djpk.share.dto.periodeDto;

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
		period = new ArrayList<periodeDto>();
		period.add(new periodeDto("0","APBN"));
		period.add(new periodeDto("1","Januari"));
		period.add(new periodeDto("2","Pebruari"));
		period.add(new periodeDto("3","Maret"));
		period.add(new periodeDto("4","April"));
		period.add(new periodeDto("5","Mei"));
		period.add(new periodeDto("6","Juni"));
		period.add(new periodeDto("7","Juli"));
		period.add(new periodeDto("8","Agustus"));
		period.add(new periodeDto("9","September"));
		period.add(new periodeDto("10","Oktober"));
		period.add(new periodeDto("11","Nopember"));
		period.add(new periodeDto("12","Desember"));
		period.add(new periodeDto("13","Unaudited"));
		period.add(new periodeDto("14","Audited"));
		period.add(new periodeDto("15","Pertanggung Jawaban"));
		
	}

	public List<periodeDto> getPeriod() {
		return period;
	}

	public void setPeriod(List<periodeDto> period) {
		this.period = period;
	}

	
	
}
