package com.readExcel.read.dto;

import java.io.File;

public class FileDTO {
	
	private File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public String getFileName() {
		return this.file.getName();
	}

}
