package com.sh.djpk.econsole.rest.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.djpk.econsole.rest.dao.PeriodeDao;
import com.sh.djpk.econsole.rest.dao.UserDao;
import com.sh.djpk.econsole.rest.service.PeriodeSvc;
import com.sh.djpk.econsole.rest.service.UserSvc;
import com.sh.djpk.share.model.User;

@Service("periodeSvc")
@Transactional(readOnly = false)
public class PeriodeSvcImpl implements PeriodeSvc{

	public static final Logger LOGGER = LoggerFactory
			.getLogger(PeriodeSvcImpl.class);
	
	@Autowired PeriodeDao periodeDao;

	@Override
	@Transactional(readOnly = true)
	public List<HashMap> getAll() {
		LOGGER.info(
				"try get data Periode");
		List<HashMap> l = periodeDao.getPeriode();
		LOGGER.trace("data from db={}", l);
		return l;
	}
	
	
	

}
