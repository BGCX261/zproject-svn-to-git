package com.zmis.model.paging.service;

import com.zmis.core.QueryResult;
import com.zmis.model.user.User;

public interface PagingService {
	
	
	public QueryResult<User> getUser();
}
