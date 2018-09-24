package com.sh.djpk.econsole.rest.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.djpk.econsole.rest.dao.TransferDao;
import com.sh.djpk.econsole.rest.service.TransferSvc;

@Service("transferSvc")
@Transactional(readOnly = false)
public class TrasnferSvcImpl implements TransferSvc {

	public static final Logger LOGGER = LoggerFactory
			.getLogger(TrasnferSvcImpl.class);
	
	@Autowired TransferDao transferDao;
	
	@Override
	public List<HashMap> getAllPemda() {
		LOGGER.info(
				"try get data ref pemda");
		List<HashMap> lst = transferDao.getAllTransfer();
		LOGGER.trace("data from db={}", lst);
		return lst;
	}

}
