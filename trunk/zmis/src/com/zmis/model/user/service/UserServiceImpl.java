package com.zmis.model.user.service;

import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zmis.core.QueryResult;
import com.zmis.model.user.User;
import com.zmis.model.user.dao.UserDao;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
	//@Autowired
	@Resource(name="userDaoImpl")
	private UserDao userDao ;
	
	/* (non-Javadoc)
	 * @see com.zmis.user.service.UserService#saveUser(com.zmis.user.bean.User)
	 */
	public void saveUser(User user) {
		userDao.save(user);
	}
	
	/* (non-Javadoc)
	 * @see com.zmis.user.service.UserService#updateUser(com.zmis.user.bean.User)
	 */
	public void updateUser(User user) {
		userDao.update(user);
	}
	
	/* (non-Javadoc)
	 * @see com.zmis.user.service.UserService#deleteUser(java.lang.Class, java.lang.Object)
	 */
	public void deleteUser(Class<User> userClass, Object entityId) {
		userDao.delete(userClass, entityId);
	}
	
	/* (non-Javadoc)
	 * @see com.zmis.user.service.UserService#findUser(java.lang.Class, java.lang.Object)
	 */
	public User findUser(Class<User> userClass, Object entityId) {
		return userDao.find(userClass, entityId);
	}

	public QueryResult<User> findUserByPage(Class<User> userClass, int starIndex,int recordMax,
			String where, Object[] whereValue, LinkedHashMap<String, String> orderBy) {
		return userDao.getData(userClass, starIndex, recordMax,where, whereValue, orderBy);
	}

	public QueryResult<User> findUserByPage(Class<User> userClass,
			int starIndex, int recordMax, String where, Object[] whereValue) {
		
		return userDao.getData(userClass, starIndex, recordMax,where, whereValue);
	}

	public QueryResult<User> findUserByPage(Class<User> userClass,
			int starIndex, int recordMax, LinkedHashMap<String, String> orderBy) {
		
		return userDao.getData(userClass, starIndex, recordMax, orderBy);
	}

	public QueryResult<User> findUserByPage(Class<User> userClass,
			int starIndex, int recordMax) {
		
		return userDao.getData(userClass, starIndex, recordMax);
	}
	
}

