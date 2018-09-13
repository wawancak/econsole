package com.sh.djpk.econsole.rest.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LraReportDao {

//			   1 => 'LRA Nasional',
//             2 => 'LRA Wilayah',               
//             3 => 'LRA Regional Provinsi',
//             4 => 'LRA Pemda',
//             5 => 'Rekapitulasi Akun Eliminasi',
//             6 => 'Monitoring Data Per Periode',   
//             7 => 'Monitoring Akun Eliminasi',        
	List<HashMap> getLraReportData(@Param("tahunAnggaran") int tahunAnggaran,
			@Param("periodeId") int periodeId,
			@Param("kodeLaporan") int kodeLaporan, @Param("othersParam") HashMap othersParam);
	
	List<HashMap> getRefPemdaDua(@Param("tahunAnggaran") int tahunAnggaran,
			@Param("kodeLaporan") int kodeLaporan, @Param("othersParam") HashMap othersParam);

}
