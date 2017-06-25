package cn.heima.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.mybatis.pojo.User;

public class MybatisDemo {

//	根据用户id查询一个用户
	@Test
	public void findUserById() throws IOException
	{
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 2. 加载SqlMapConfig.xml配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 3. 创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
		//4.创建session对象
		SqlSession session = sqlSessionFactory.openSession();
		// 5. 执行SqlSession对象执行查询，获取结果User
		// 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		User user = session.selectOne("test.findUserById", 26);
		System.out.println(user);
		session.close();
	}
//	根据用户名称模糊查询用户列表
	@Test
	public void findUserByName() throws IOException
	{
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 2. 加载SqlMapConfig.xml配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 3. 创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
		//4.创建session对象
		SqlSession session = sqlSessionFactory.openSession();
		
		List<User> list = session.selectList("test.findUserByName", "明");
		for (User user : list) {
			System.out.println(user);
		}
		session.close();
	}
	
//	添加用户
	@Test
	public void addUser() throws IOException
	{
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 2. 加载SqlMapConfig.xml配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 3. 创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
		//4.创建session对象
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("高圆圆");
		user.setSex("0");
		user.setBirthday(new Date());
		user.setAddress("中国劳动关系学院");
		session.insert("test.addUser", user);
		session.commit();
		System.out.println(user.getId());
	}
//	更新用户
	@Test
	public void updateUserById() throws IOException
	{
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 2. 加载SqlMapConfig.xml配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 3. 创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
		//4.创建session对象
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(26);
		user.setUsername("陈嘉伟");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("福建泉州");
		session.update("test.updateUserById", user);
		session.commit();
	}
//	删除用户
	@Test
	public void deleteUserById() throws IOException
	{
		//1.创建sqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 2. 加载SqlMapConfig.xml配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 3. 创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
		//4.创建session对象
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("test.deleteUserById", 26);
		session.commit();
		System.out.println("删除成功");
		
	}
}
