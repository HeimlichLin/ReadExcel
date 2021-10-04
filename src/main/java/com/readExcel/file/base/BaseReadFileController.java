package com.readExcel.file.base;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import com.readExcel.file.code.FilePathCode;

/**
 * 讀取檔案
 * 
 * @author 6284
 *
 */
public abstract class BaseReadFileController {

	private FilePathCode filePathCode;

	public BaseReadFileController(final FilePathCode filePathCode) {
		this.filePathCode = filePathCode;
	}

	/**
	 * 執行
	 */
	public void execute() {
		final List<File> files = this.getFile();
		for (final File file : files) {
			ProStatus proStatus = ProStatus.FAIL;
			try {
				proStatus = this.proFiles(file);
				proStatus.move(this.filePathCode, file);
			} catch (final Exception e) {
//				LOGGER.error(e);
				proStatus = ProStatus.FAIL;
				proStatus.move(this.filePathCode, file);
			}
		}
	}

	/**
	 * 檔案處理
	 * 
	 * @param file
	 * @return
	 */
	abstract protected ProStatus proFiles(File file);

	/**
	 * 取得檔案
	 * 
	 * @return
	 */
	private List<File> getFile() {
		final FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File file) {
				if (!file.isFile()) {
					return false;
				}
				return true;
			}
		};

		final File fileDIR = new File(this.filePathCode.getPath());
		final File[] listFiles = fileDIR.listFiles(fileFilter);
		final List<File> files = new ArrayList<File>();
		for (final File file : listFiles) {
			// final File pFile = new File(file.getParent(), file.getName().replace(".flg", ""));
			final File pFile = new File(file.getParent(), file.getName());
			if (pFile.exists()) {
				files.add(pFile);
			}
		}
		return files;
	}

}
