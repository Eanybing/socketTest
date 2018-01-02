package jh.test.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MybatisTest {

	@Test
	public void test() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			Configuration configuration = sqlSessionFactory.getConfiguration();
			SqlSession session = sqlSessionFactory.openSession();
			
			User user = session.selectOne("mybatis.User.selectUser", 1);
			System.out.println(user.getName());
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
