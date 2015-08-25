package com.zmis.model.user.service;

import java.util.LinkedHashMap;

import com.zmis.core.QueryResult;
import com.zmis.model.user.User;

public interface UserService {

	public abstract void saveUser(User user);

	public abstract void updateUser(User user);

	public abstract void deleteUser(Class<User> userClass, Object entityId);

	public abstract User findUser(Class<User> userClass, Object entityId);
	
	public abstract QueryResult<User> findUserByPage(Class<User> userClass, int starIndex,int recordMax,
			String where, Object[] whereValue, LinkedHashMap<String, String> orderBy);
	
	public abstract QueryResult<User> findUserByPage(Class<User> userClass, int starIndex,int recordMax,
			String where, Object[] whereValue);
	
	public abstract QueryResult<User> findUserByPage(Class<User> userClass, int starIndex,int recordMax,
			LinkedHashMap<String, String> orderBy);
	
	public abstract QueryResult<User> findUserByPage(Class<User> userClass, int starIndex,int recordMax
			);
	
}