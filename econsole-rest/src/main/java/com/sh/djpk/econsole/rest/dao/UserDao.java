package com.sh.djpk.econsole.rest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sh.djpk.share.model.User;

public interface UserDao {

	@Select("select * from econsole.userman")
	List<User> getAll();
}
