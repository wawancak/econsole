package com.sh.djpk.econsole.rest.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.djpk.econsole.rest.dao.UserDao;
import com.sh.djpk.econsole.rest.service.UserSvc;
import com.sh.djpk.share.util.StringUtils;

@Service("userSvc")
@Transactional(readOnly = false)
public class UserSvcImpl implements UserSvc {

	public static final Logger LOGGER = LoggerFactory
			.getLogger(UserSvcImpl.class);

	@Autowired
	UserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public List<HashMap> getAllPaging(int pageSize, int pageSequence,
			String direction, String orderBy, Map<String, Object> params) {
		LOGGER.info(
				"try get All Paging pageSize={}, pageSequence={}, params={}",
				pageSize, pageSequence, params);
		orderBy = StringUtils.nevl(orderBy, "username");
		direction = StringUtils.nevl(direction, "ASC");
		List<HashMap> l = userDao.getAllPaging(pageSize, pageSequence,
				direction, orderBy, params);
		LOGGER.trace("data from db={}", l);
		return l;
	}

	@Override
	public int insert(Map<String, Object> params) {
		LOGGER.info("try insert params={}", params);
		int i = userDao.insertUser(params);
		LOGGER.info("result insert user>>data from db={}", i);
		LOGGER.info("params={}", params);
		if(i > 0){
			int n = userDao.insertAuthAssignment(params);
			LOGGER.info("result insert auth_assignmet>>data from db={}", n);
			int m = userDao.insertUserPemda(params);
			LOGGER.info("result insert user_pemda>>data from db={}", m);
		}
		return i;
	}

	@Override
	public int update(Map<String, Object> params) {
		LOGGER.info("try update params={}", params);
		int i = userDao.updateUser(params);
		LOGGER.info("result update user>>data from db={}", i);
		LOGGER.info("params={}", params);
		if(i > 0){
			int n = userDao.updateAuthAssignment(params);
			LOGGER.info("result update auth_assignmet>>data from db={}", n);
			int m = userDao.updateUserPemda(params);
			LOGGER.info("result update user_pemda>>data from db={}", m);
		}
		return i;
	}

	@Override
	public int delete(Map<String, Object> params) {
		LOGGER.info("try delete params={}", params);
		int i = userDao.deleteUser(params);
		LOGGER.info("result insert user>>data from db={}", i);
		int n = userDao.deleteAuthAssignment(params);
		LOGGER.info("result delete auth_assignmet>>data from db={}", n);
		int m = userDao.deleteUserPemda(params);
		LOGGER.info("result delete user_pemda>>data from db={}", m);
		return i;
	}

}
