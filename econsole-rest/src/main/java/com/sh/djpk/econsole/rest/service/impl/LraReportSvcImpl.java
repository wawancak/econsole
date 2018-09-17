package com.sh.djpk.econsole.rest.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.djpk.econsole.rest.dao.LraReportDao;
import com.sh.djpk.econsole.rest.service.LraReportSvc;

@Service("lraReportSvc")
@Transactional(readOnly = false)
public class LraReportSvcImpl implements LraReportSvc {

	public static final Logger LOGGER = LoggerFactory
			.getLogger(LraReportSvcImpl.class);

	@Autowired
	LraReportDao lraReportDao;

	@Override
	@Transactional(readOnly = true)
	public List<HashMap> getLraReportData(int tahunAnggaran, int periodeId,
			int kodeLaporan, HashMap othersParam) {
		LOGGER.info(
				"try get data lra report tahunAnggaran={}, periodeId={}, kodeLaporan={}, othersParam={}",
				tahunAnggaran, periodeId, kodeLaporan, othersParam);
		String thnAng = String.valueOf(tahunAnggaran);
		List<HashMap> l = lraReportDao.getLraReportData(thnAng,
				periodeId, kodeLaporan, othersParam);
		LOGGER.trace("data from db={}", l);
		return l;
	}

	@Override
	public List<HashMap> getRefPemdaDua(int tahunAnggaran, int kodeLaporan,
			HashMap othersParam) {
		LOGGER.info(
				"try get data ref_pemda2 tahunAnggaran={}, kodeLaporan={}, othersParam={}",
				tahunAnggaran, kodeLaporan, othersParam);
		String thnAng = String.valueOf(tahunAnggaran);
		List<HashMap> l = lraReportDao.getRefPemdaDua(thnAng, kodeLaporan, othersParam);
		LOGGER.trace("data from db={}", l);
		return l;
	}

	@Override
	public List<HashMap> getPeriodeCb() {
		LOGGER.info(
				"try get data periode to combobox");
		List<HashMap> l = lraReportDao.getPeriodeCb();
		return l;
	}

}
