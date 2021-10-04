package com.readExcel.read.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.readExcel.file.exception.ApBusinessException;
import com.readExcel.read.bean.FospEifMccDo;
import com.readExcel.read.code.COLUMNS;
import com.readExcel.read.dto.FileDTO;

public class ReadServiceImpl implements ReadService {

	@Override
	public void proFile(FileDTO dto) {
		this.load(dto);
	}
	
	private void load(FileDTO dto) {
		List<FospEifMccDo> list = this.loadExcelData(dto);
		System.out.println("-----Finish-----");
	}
	
	private List<FospEifMccDo> loadExcelData(FileDTO dto) {
		try {
			final FileInputStream inp = new FileInputStream(dto.getFile());
			final HSSFWorkbook wb = new HSSFWorkbook(inp);
			final HSSFSheet sheet = wb.getSheetAt(0);
			List<COLUMNS> columns = this.localColums(sheet);
			List<FospEifMccDo> list = new ArrayList<FospEifMccDo>();
			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				HSSFRow hssfrow = sheet.getRow(i);
				int cellNo = 0;
				FospEifMccDo fospEifMccDo = new FospEifMccDo();
				for (COLUMNS column : columns) {
					HSSFCell hssfcell = hssfrow.getCell((short) cellNo++);
					final String lable = toString(hssfcell);
					column.set(fospEifMccDo, lable);
				}
				list.add(fospEifMccDo);
			}
			return list;
		} catch (Exception e) {
			throw new ApBusinessException("解析錯誤", e);
		}
	}
	
	private String toString(HSSFCell hssfcell) {
		switch (hssfcell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			return String.valueOf(hssfcell.getNumericCellValue());
		case HSSFCell.CELL_TYPE_STRING:
			return hssfcell.getStringCellValue();
		default:
			return "";
		}
	}
	
	private List<COLUMNS> localColums(HSSFSheet sheet) {
		List<COLUMNS> colums = new ArrayList<COLUMNS>();
		HSSFRow hssfrow = sheet.getRow(0);
		int index = 0;
		while (true) {
			HSSFCell hssfcell = hssfrow.getCell((short) index++);
			if (hssfcell == null || StringUtils.isBlank(hssfcell.getStringCellValue())) {
				break;
			} else {
				final String lable = hssfcell.getStringCellValue();
				COLUMNS column = COLUMNS.lookup(lable);
				if (column != null) {
					colums.add(column);
				} else {
					colums.add(COLUMNS.NOFILE);
				}
			}
		}
		return colums;
	}

}
