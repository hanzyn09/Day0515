package com.the.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.the.domain.dto.FileBoard;
import com.the.domain.dto.FileTable;

public class FileBoardServiceImpl implements FileBoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Part filePart = request.getPart("file"); //파일 데이터만 Part로 받는다.
		FileBoard fileBoard = new FileBoard();
		fileBoard.setSubject(subject);
		fileBoard.setContent(content);
	
		long filesize = filePart.getSize();
		

		if(filesize > 0) { //파일이 존재할 때...
			//파일 업로드는 선택사항
			String fileName = filePart.getSubmittedFileName();
			String root = "C:/Users/ysurk/eclipse-workspace/day0515/WebContent"; //업로드할 경로 (물리주소)
			String path = "/upload/";
			
			String filePath = root + path;
			String fileurl = path + fileName;
			
			filePart.write(filePath + fileName); //업로드하는 부분
			System.out.println("파일 업로드 완료!");

			//파일 정보 셋팅
			//db 에 제목, 내용, 파일(파일 이름, 경로, 사이즈)가 넘어가야합니다...
			FileTable fileTable = new FileTable();
			fileTable.setFilename(fileName);
			fileTable.setFilesize(filesize);
			fileTable.setFileurl(fileurl);
			
			fileBoard.setFile(fileTable); //파일 객체 == 선택적인 요소
		}
		
		fileBoardDAO.fileBoardInsert(fileBoard); //fileBoard만 넘겨줘도 연결이 되어있어서 처리 가능.
		
		//저장 후 db에서 저장된 정보를 가지고 list 페이지 이동... 
		//절대경로 이동방법
		//response.sendRedirect(request.getContextPath()+"/fboard/list");
		//상대경로 이동방법
		response.sendRedirect("list");
		return null;
	}

}
