package com.the.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.dao.FileBoardDAO;

public interface FileBoardService {
	//인터페이스의 모든 멤버 필드는 final static
	FileBoardDAO fileBoardDAO = new FileBoardDAO();
	
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}
