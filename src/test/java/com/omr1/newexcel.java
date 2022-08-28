package com.omr1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class newexcel {
       public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\user\\eclipse-workspace\\OMRDetails1\\libexcel\\Test.xlsx");
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Test");
		Row row = sheet.createRow(9);
		Cell cell = row.createCell(0);
		cell.setCellValue("JAVA");
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		
		
		
	}
}
