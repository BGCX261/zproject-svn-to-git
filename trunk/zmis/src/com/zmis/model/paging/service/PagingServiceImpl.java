package com.zmis.model.paging.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zmis.core.QueryResult;
import com.zmis.model.paging.dao.PagingDao;
import com.zmis.model.user.User;

@Service
@Transactional
public class PagingServiceImpl implements PagingService {
	@Resource(name="pagingDaoImpl")
	private PagingDao dao;
	
	public QueryResult<User> getUser() {
		return dao.getData(User.class, 1 ,21);
	}
	
}
