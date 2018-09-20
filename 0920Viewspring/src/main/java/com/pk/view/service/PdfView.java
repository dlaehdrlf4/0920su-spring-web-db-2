package com.pk.view.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class PdfView extends AbstractPdfView {

	//model은 Controller가 넘겨준 데이터
	//document 가 출력할 문서
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//데이터 가져오기
		List<String> list = (List<String>)model.get("unit");
		
		// 출력할 테이블 만들기 앞에께 행개수 뒤에께 열개수
		Table table = new Table(1, list.size()+1);
		//여백 설정
		table.setPadding(5);
		//폰트 설정 여기가 중요 // 앞에는 폰트설정
		BaseFont bf = BaseFont.createFont(
				"/Volumes/share/Spring/NanumBarunGothic.ttf", BaseFont.IDENTITY_H,	BaseFont.EMBEDDED);
		Font font = new Font(bf);
		
				
		//제목 셀 출력하기
		Cell cell = new Cell(new Paragraph("챔피언이름", font));
		cell.setHeader(true);
		table.addCell(cell);
		table.endHeaders();
				
				//데이터 출력
				for(String unit : list) {
					Cell temp = new Cell(
							new Paragraph(unit, font));
							table.addCell(temp);
				}
		//	테이블을 문서에 추가
			document.add(table);

	}

}
