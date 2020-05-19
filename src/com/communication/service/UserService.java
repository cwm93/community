package com.communication.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.dao.UserDao;
import com.communication.entity.User;
import com.communication.util.Order;
import com.communication.util.Property;
import com.communication.util.Tool;

@Service
public class UserService extends BaseService<User> {

	@Autowired
	private UserDao userDao;

	@Resource
	private void setDao(UserDao dao) {
		super.setDao(dao);
	}

	public User getByUserName(String username) {
		List<User> users = getDao().findAll(Order.desc("id"), Property.eq("username", username));
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	public User login(String username, String password) {
		List<User> users = getDao().findAll(Order.desc("id"), Property.eq("username", username),
				Property.eq("password", Tool.getMD5(password)));
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	public void updateLoginIp(long id, String ip, Date date) {
		userDao.loginIP(id, ip, date);
	}

	public void updatePassword(long id, String passwrod) {
		userDao.updatePassword(id, Tool.getMD5(passwrod));
	}

	public boolean isMobileExisted(String mobile) {

		List<User> users = getDao().findAll(Order.desc("id"), Property.eq("username", mobile));

		if (users != null && users.size() > 0) {
			return true;
		}
		return false;
	}

	public boolean checkPassword(long id, String oldpassword) {
		List<User> users = getDao().findAll(Order.desc("id"), Property.eq("id", id),
				Property.eq("password", Tool.getMD5(oldpassword)));
		if (users != null && users.size() > 0) {
			return true;
		}
		return false;
	}

	public long countAll() {
		return getDao().countByProperty("id");
	}

	public long CountByStatus(String status) {
		return getDao().countByProperty("id", Property.eq("status", status));
	}
	
    public List<User> queryUsersByStatus(String status) {
		
		List<User> users = getDao().findAll(Order.desc("id"), Property.eq("status", status));
		if (users != null && users.size() > 0) {
			return users;
		}
		
		return null;
	}

	public List<User> findUsersByStatus(String status) {
		
		List<User> users = getDao().findAll(Order.desc("id"), Property.eq("status", status), Property.eq("role.id", 3));
		if (users != null && users.size() > 0) {
			return users;
		}
		
		return null;
	}
	
	public boolean checkUserLongin(HttpServletRequest request){
		HttpSession session  = request.getSession();
		User user = (User)session.getAttribute("curUser");
		if(user!=null){
			return true;
		}
		return false;
	}
	
	public User sessionUser(HttpServletRequest request){
		HttpSession session  = request.getSession();
		User user = null;
		if(session!=null){
			 user = (User)session.getAttribute("curUser");
		}
		return user;
	}

	public User loginBySmscode(String mobile, String smscode) {
		List<User> users = getDao().findAll(Order.desc("id"), Property.eq("mobile", mobile),Property.eq("smscode", smscode));
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	public User findByMobile(String mobile) {
		List<User> users = getDao().findAll(Order.desc("id"), Property.eq("mobile", mobile));
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(Tool.getMD5("abc@123"));
	}
}
