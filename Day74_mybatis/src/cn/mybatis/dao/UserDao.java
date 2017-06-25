package cn.mybatis.dao;

import java.io.IOException;
import java.util.List;

import cn.mybatis.pojo.User;

public interface UserDao {

	public User findUserById(Integer id) throws IOException;
	
	public List<User> findUserByName(String username) throws IOException;
	
	public void addUser(User user) throws IOException;
	
}
