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
	
		long filesize = filePart.getSize();
		String fileName = filePart.getSubmittedFileName();
		String root = "C:/Users/ysurk/eclipse-workspace/day0515/WebContent"; //업로드할 경로 (물리주소)
		String path = "/upload/";
		
		//파일 업로드는 선택사항
		//파일이 존재할 때...
		String filePath = root + path;
		if(filesize > 0) {
			filePart.write(filePath + fileName); //업로드하는 부분
			System.out.println("파일 업로드 완료!");
		}
		String fileurl = path + fileName;
		
		//db 에 제목, 내용, 파일(파일 이름, 경로, 사이즈)가 넘어가야합니다...
		FileTable fileTable = new FileTable();
		fileTable.setFilename(fileName);
		fileTable.setFilesize(filesize);
		fileTable.setFileurl(fileurl);
		
		FileBoard fileBoard = new FileBoard();
		fileBoard.setSubject(subject);
		fileBoard.setContent(content);
		fileBoard.setFile(fileTable);
		
		
		fileBoardDAO.fileBoardInsert(fileBoard); //fileBoard만 넘겨줘도 연결이 되어있어서 처리 가능.
	
		
		return null;
	}

}
