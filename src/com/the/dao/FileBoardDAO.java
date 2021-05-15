package com.the.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.the.config.MybatisConfig;
import com.the.domain.dto.FileBoard;

public class FileBoardDAO {
	//sqlsessionfactory를 싱글톤 객체로 만들어 놓은 것을 사용하여(ServletContext에 저장된 객체) db에 접근...
	private SqlSessionFactory sqlSessionFactory;

	public FileBoardDAO() {
		sqlSessionFactory = MybatisConfig.getInstance();
	}

	public void fileBoardInsert(FileBoard fileBoard) {
		System.out.println("DB 실행 전 no : " + fileBoard.getNo());
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//FileBoard 테이블에 입력...
		sqlSession.insert("boardMapper.insert", fileBoard);
		//파일이 존재하면, fileTable에도 들어가야함... (BNO)
		//mapper에서 no 지정. bno에 활용하기 위해
		
		System.out.println("DB 실행 후 no : " + fileBoard.getNo());
		
		sqlSession.commit();
		sqlSession.close();
		
	}

}
