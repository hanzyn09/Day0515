package com.the.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {
	//sqlSessionFactory를 떠올리기...
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getInstance(){
		//null 일 때 한번만 실행
		if(sqlSessionFactory == null) new MybatisConfig();
		
		return sqlSessionFactory;
	}

	private MybatisConfig() {
		String resource = "mybatis/mybatis-config.xml"; //경로 지정해주기
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	


}
