package com.sh.djpk.econsole.rest.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface UserDao {

	@Select("select * from ref_user")
	List<HashMap> getAll();
}
