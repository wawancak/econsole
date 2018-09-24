package com.sh.djpk.econsole.rest.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.djpk.econsole.rest.dao.AkunEliminasiDao;
import com.sh.djpk.econsole.rest.service.AkunEliminasiSvc;


@Service("akunEliminasiSvc")
@Transactional(readOnly = false)
public class AkunEliminasiSvcImpl implements AkunEliminasiSvc{

	public static final Logger LOGGER = LoggerFactory
			.getLogger(AkunEliminasiSvcImpl.class);
	
	@Autowired AkunEliminasiDao akunDao;

	@Override
	@Transactional(readOnly = true)
	public List<HashMap> getOnTahun(String tahunAnggaran) {
		LOGGER.info(
				"try get data per Pemda");
		List<HashMap> lst = akunDao.getEliminasi(tahunAnggaran);
		
		LOGGER.trace("data from db={}", lst);
		
		return lst;
	}

	@Override
	@Transactional(readOnly = true)
	public List<HashMap> getOnTahunPemda(String kodePemda, String tahunAnggaran) {
		LOGGER.info(
				"try get data per Pemda");
		List<HashMap> lst = akunDao.getEliminasiPemda(kodePemda, tahunAnggaran);
		
		LOGGER.trace("data from db={}", lst);
		
		return lst;
	}
	
	
	

}
