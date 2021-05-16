package com.the.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileBoardDeleteServiceImpl implements FileBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String _no = request.getParameter("no");
		long no = Long.parseLong(_no);
		
		//외래키 걸려있는 파일테이블부터 삭제후, 보드테이블을 삭제해야한다. : 제약조건 때문...
		int result = fileBoardDAO.fileDeleteByBno(no); //파일 없다해도 0으로 처리하고 넘어가는데 검증 필요
		fileBoardDAO.fboardDeleteById(no);
		
		System.out.println("삭제된 갯수: " + result);
		
		response.sendRedirect("list");
		
		return null;
	}

}
