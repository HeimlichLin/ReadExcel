package com.readExcel.file.base;

import java.io.File;

import com.readExcel.file.code.FilePathCode;

/**
 * 檔案處理狀況
 * @author 6284
 *
 */
public enum ProStatus {
	
	FINISH {
		@Override
		void move(final FilePathCode filePathCode, final File file) {
//		final File flgFile = new File(file.getParent(), file.getName() + ".flg");
			final File moveFile = ProStatus.createFile(FilePathCode.TXT_SUCCESS.getPath(), file.getName());
			file.renameTo(moveFile);
//			flgFile.delete();
		}
	}, //
	
	FAIL {
		@Override
		void move(final FilePathCode filePathCode, final File file) {
//		final File flgFile = new File(file.getParent(), file.getName() + ".flg");
			final File moveFile = ProStatus.createFile(FilePathCode.TXT_FAIL.getPath(), file.getName());
			file.renameTo(moveFile);
//			flgFile.delete();
		}
	} //
	
	;
	
	void move(final FilePathCode filePathCode, final File f) {
		
	}
	
	private static File createFile(String filepath, String fileName) {
		final File moveFile = new File(filepath, fileName);
		ProStatus.createFileParentFolder(moveFile);
		return moveFile;
	}
	
	private static void createFileParentFolder(File file) {
		if (!file.exists()) {
			file.getParentFile().mkdirs();
//		} else if (file.exists()) {
//			file.delete();
		}
	}

}
