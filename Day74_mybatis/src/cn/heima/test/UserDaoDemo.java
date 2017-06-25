package cn.heima.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.mybatis.dao.UserDao;
import cn.mybatis.dao.UserDaoImpl;
import cn.mybatis.pojo.User;

public class UserDaoDemo {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws Exception {
		// 创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 加载SqlMapConfig.xml配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 创建SqlsessionFactory
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}
	
	@Test
	public void demo1() throws IOException
	{
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.findUserById(28);
		System.out.println(user);
	}
	
	
	
	
	
	
	
	
}
