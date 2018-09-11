package com.sh.djpk.econsole.rest.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.djpk.econsole.rest.dao.UserDao;
import com.sh.djpk.econsole.rest.service.UserSvc;
import com.sh.djpk.share.model.User;

@Service("userSvc")
@Transactional(readOnly = false)
public class UserSvcImpl implements UserSvc{

	public static final Logger LOGGER = LoggerFactory
			.getLogger(UserSvcImpl.class);
	
	@Autowired UserDao userDao;
	
	@Override
	public List<User> getAll() {
		List<User> list = userDao.getAll();
		LOGGER.info("data from db = {}", list);
		return list;
	}

}
