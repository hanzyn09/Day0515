package com.the.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.domain.dto.FileBoard;

public class FileBoardDetailServiceImpl implements FileBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String _no = request.getParameter("no");
		long no = Long.parseLong(_no);
		
		//db처리
		FileBoard result = fileBoardDAO.getDetail(no);
		request.setAttribute("detail", result);
		
		return "/WEB-INF/fboard/detail.jsp";
	}

}
