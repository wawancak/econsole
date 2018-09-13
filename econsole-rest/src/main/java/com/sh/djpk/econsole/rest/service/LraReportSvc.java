package com.sh.djpk.econsole.rest.service;

import java.util.HashMap;
import java.util.List;

public interface LraReportSvc {

	List<HashMap> getLraReportData(int tahunAnggaran, int periodeId,
			int kodeLaporan, HashMap othersParam);

	List<HashMap> getRefPemdaDua(int tahunAnggaran, int kodeLaporan,
			HashMap othersParam);
}
