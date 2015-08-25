package com.zmis.model.user.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zmis.core.base.dao.BaseDaoSupport;
import com.zmis.model.user.User;

/**
 * 用户Dao
 * 
 * 2012-8-25 下午08:15:36
 * @author zlj
 */
@Repository
@Service("userDaoImpl")
@Transactional
public class UserDaoImpl extends BaseDaoSupport<User> implements UserDao {
	
	@Override
	public void delete(Class<User> entityClass, Object[] entityIds) {
		if(entityIds != null && entityIds.length>0) {
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<entityIds.length; i++) {
				sb.append("?").append(i+2).append(",");
			}
			sb.deleteCharAt(sb.length()-1);
			Query query = em.createQuery("update sysUser u set u.delete=?1 where u.userId in("+sb.toString()+")");
//			Query query = em.createQuery("select u from SysUser u.isDelete=?1 where u.userId in("+sb.toString()+")");
			query.setParameter(1, true);
			System.out.println(">>"+entityIds[0]);
			for(int i=0; i<entityIds.length; i++) {
				query.setParameter(i+2, entityIds[i]);
			}
			query.executeUpdate();
		}
	}
	
}
