package com.pk.view.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelView extends AbstractExcelView {

	@Override
	//model이 넘겨준 데이터입니다.
	//workbook이 하나의 엑셀 파일입니다.
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//Controller에서 넘겨준 데이터 가져오기
		List<String> list = (List<String>)model.get("list");

		//출력할 sheet 만들기
		Sheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "뉴스기사");
		//시트의 첫번쨰 컬럼 너비 설정
		sheet.setColumnWidth(1, 256*30);
		
		//첫번째 셀에 타이틀을 설정
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("뉴스 기사");
		
		int rowNum = 1;
		while(rowNum <= list.size()) {
			Row r = sheet.createRow(rowNum);
			Cell c = r.createCell(0);
			c.setCellValue(list.get(rowNum-1));
			rowNum = rowNum +1;
		}
		
	}
}
