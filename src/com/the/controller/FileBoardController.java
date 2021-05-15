package com.the.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.service.FileBoardService;
import com.the.service.FileBoardServiceImpl;

@MultipartConfig(
		fileSizeThreshold = 1024*1024*1,
		location = "/", 
				// ' / '로 처리 or C:\\Users\\ysurk\\eclipse-workspace\\day0515\\WebContent\\upload 
				//즉 임시폴더
				// 아래 명시한 파일보다 큰 것이 들어올 경우 저장할 공간 (지정안하면 수시로 변경됨)
		maxFileSize = 1024*1024*10,
		maxRequestSize = 1024*1024*10
)

@WebServlet("/fboard/*")
public class FileBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    FileBoardService fileBoardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//필터에서 처리하는 걸 권장...
		String uri = request.getRequestURI();
		String[] uris = uri.split("[/]");
		String key = uris[uris.length-1];
		String path = null;
		
		if(key.equals("write")) {
			//로직 처리는 서비스가 진행한다.
			fileBoardService = new FileBoardServiceImpl();
			path = fileBoardService.execute(request, response);
			
		}
		if(path != null) {
			request.getRequestDispatcher(path).forward(request, response);
		}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
