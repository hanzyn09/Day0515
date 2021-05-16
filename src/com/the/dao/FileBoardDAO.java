package com.the.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.the.config.MybatisConfig;
import com.the.domain.dto.FileBoard;
import com.the.domain.dto.FileTable;

public class FileBoardDAO {
	//sqlsessionfactory를 싱글톤 객체로 만들어 놓은 것을 사용하여(ServletContext에 저장된 객체) db에 접근...
	private SqlSessionFactory sqlSessionFactory;

	public FileBoardDAO() {
		sqlSessionFactory = MybatisConfig.getInstance();
	}

	public void fileBoardInsert(FileBoard fileBoard) {
		//System.out.println("DB 실행 전 no : " + fileBoard.getNo());
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//FileBoard 테이블에 입력...
		sqlSession.insert("boardMapper.insert", fileBoard);
		//파일이 존재하면, fileTable에도 들어가야함... (BNO)
		//mapper에서 no 지정. bno에 활용하기 위해
		
		//System.out.println("DB 실행 후 no : " + fileBoard.getNo());
		
		//파일 데이터를 저장한다.
		//mapper는 1:1을 권장하므로 하나 더 생성해서 fileTable에 넣어줄 것임.
		FileTable fileinfo = fileBoard.getFile();
		if(fileinfo != null) {// ==> 파일이 존재할 때만 실행한다.
			fileinfo.setBno(fileBoard.getNo());
			sqlSession.insert("fileMapper.insert", fileinfo);
		}
		
		
		sqlSession.commit();
		sqlSession.close();
		
	}

	public List<FileBoard> getListAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<FileBoard> result = sqlSession.selectList("boardMapper.listAll");
		
		for(FileBoard board : result) {
			//board.getNo() == fileTable의 BNO
			long bno = board.getNo();
			FileTable fileResult = sqlSession.selectOne("fileMapper.matchBno", bno); //list로 써도 상관 없다.
			System.out.println(fileResult);
			board.setFile(fileResult);
		}
		sqlSession.close();
		
		return result;
	}

	public FileBoard getDetail(long no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		FileBoard result = sqlSession.selectOne("boardMapper.detail",no);
		//파일테이블
		long bno = no; //매퍼에서 썼던 쿼리를 재사용하기 위해 파라미터 이름 변경
		FileTable fileResult = sqlSession.selectOne("fileMapper.matchBno", bno);
		//파일 결과 셋팅
		result.setFile(fileResult);
		
		sqlSession.close();
		
		return result;
	}



	public int fileDeleteByBno(long bno) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		int result = sqlSession.delete("fileMapper.deleteByBno", bno); //변경된 row 갯수
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}

	public void fboardDeleteById(long no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.delete("boardMapper.deleteById", no);
		sqlSession.commit();
		sqlSession.close();
		
	}

	public void fileDeleteByFno(long fno) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		int result = sqlSession.delete("fileMapper.deleteByFno", fno); //변경된 row 갯수
		sqlSession.commit();
		sqlSession.close();
		
		// result;
		
	}



}
