package com.the.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.domain.dto.FileBoard;

public class FileBoardFileDeleteServiceImpl implements FileBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String _fno = request.getParameter("fno");
		long fno = Long.parseLong(_fno);
		
		//db처리
		//fileBoardDAO.fileDeleteByBno(fno);
		fileBoardDAO.fileDeleteByFno(fno);
		response.sendRedirect("detail?no="+request.getParameter("no"));
		//response.sendRedirect("list");
		
		return null;
	}

}
