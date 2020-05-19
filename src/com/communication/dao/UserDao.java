package com.communication.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;
import com.communication.entity.User;

@Repository
public class UserDao extends BaseDao<User> {

	public void loginIP(long id, String ip, Date date) {
		String sql = "UPDATE t_user SET last_login_ip=?,last_login_time=? WHERE id=?";
	    getSession().createSQLQuery(sql).setString(0,ip).setDate(1,date).setLong(2, id).executeUpdate();
	}

	public void updatePassword(long id, String password) {
		String sql = "UPDATE t_user SET password=? WHERE id=?";
		getSession().createSQLQuery(sql).setString(0,password).setLong(1, id).executeUpdate();	
	}

}