package com.the.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.domain.dto.FileBoard;

public class FileBoardListServiceImpl implements FileBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<FileBoard> result = fileBoardDAO.getListAll();
		request.setAttribute("list", result);
		
		return "/WEB-INF/fboard/list.jsp"; //여기에서만 request.set 한 내용 확인 가능
	}

}
