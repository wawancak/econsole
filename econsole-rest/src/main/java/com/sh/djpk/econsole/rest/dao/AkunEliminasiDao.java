package com.sh.djpk.econsole.rest.dao;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface AkunEliminasiDao {
	
	
	List<HashMap> getEliminasi(
			@Param("tahunAnggaran") String tahunAnggaran
			);
	
	List<HashMap> getEliminasiPemda(
			@Param("kodePemda") String kdpemda,
			@Param("tahunAnggaran") String tahunAnggaran
			);
	
//	HashMap getSaldoAkun(
//			@Param("tahunAnggaran") String tahunAnggaran,
//			@Param("periodeId") int periodeId,
//			@Param("level3") String level3, 
//			@Param("kodePemda") String kdpemda 
//			);
	
	

}
