package com.the.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.service.FileBoardService;
import com.the.service.FileBoardServiceImpl;

@WebServlet("/page/*")
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//필터에서 처리하는 걸 권장...
		String uri = request.getRequestURI();
		String[] uris = uri.split("[/]");
		String key = uris[uris.length-1];
		String path = null;
		
		if(key.equals("write")) {
			path = "/WEB-INF/fboard/write.jsp";
			
		} 
		
		
		if(path != null) {
			request.getRequestDispatcher(path).forward(request, response);
		}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
