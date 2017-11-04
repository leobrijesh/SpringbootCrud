package com.java.springboot.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.java.springboot.model.User;



@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	final static DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    static {
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
	private static List<User> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<User> findAllUsers() {
		return users;
	}
	
	public User findById(String id) {
		for(User user : users){
			if(user.getId().equals(id)){
				return user;
			}
		}
		return null;
	}
	
	public User findByEmail(String email) {
		for(User user : users){
			if(user.getEmail().equalsIgnoreCase(email)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(String id) {
		
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId().equals(id)) {
		    	user.setActive(false);
		    }
		}
	}

	public boolean isUserExist(User user) {
		return findByEmail(user.getEmail())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		try {
			users.add(new User("1231","Sam","Sharma","sam.sharma@gmail.com",123456,df.parse("30-Oct-1990"), true));
			users.add(new User("1232","Lisa","san","lisa.sharma@gmail.com",123456,df.parse("30-Oct-1990"), true));
			users.add(new User("1233","Brijesh","Gupta","brijesh.sharma@gmail.com",123456,df.parse("30-Oct-1990"), true));
			users.add(new User("1234","Karan","P","karan.sharma@gmail.com",123456,df.parse("30-Oct-1990"), true));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}

}
