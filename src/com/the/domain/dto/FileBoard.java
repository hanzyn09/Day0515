package com.the.domain.dto;

public class FileBoard {
	private long no;
	private String subject;
	private String content;
	private FileTable file;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public FileTable getFile() {
		return file;
	}
	public void setFile(FileTable file) {
		this.file = file;
	}
	
	
}
