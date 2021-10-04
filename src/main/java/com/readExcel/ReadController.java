package com.readExcel;

import java.io.File;

import com.readExcel.file.base.BaseReadFileController;
import com.readExcel.file.base.ProStatus;
import com.readExcel.file.code.FilePathCode;
import com.readExcel.read.dto.FileDTO;
import com.readExcel.read.service.ReadService;
import com.readExcel.read.service.ReadServiceImpl;

public class ReadController extends BaseReadFileController {

	public ReadController() {
		super(FilePathCode.EXCEL);
	}

	@Override
	protected ProStatus proFiles(File file) {
		try {
			ReadService service = new ReadServiceImpl();		
			FileDTO dto = new FileDTO();
			dto.setFile(file);
			service.proFile(dto);
			return ProStatus.FINISH;
		} catch (Exception e) {
			return ProStatus.FAIL;
		}
	}

}
