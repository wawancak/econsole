package com.sh.djpk.econsole.rest.service;

import java.util.HashMap;
import java.util.List;

import com.sh.djpk.share.model.User;

public interface AkunEliminasiSvc {

	List<HashMap> getOnTahun(String tahunAnggaran);
	
	List<HashMap> getOnTahunPemda(String kodePemda, String tahunAnggaran);
	
}
