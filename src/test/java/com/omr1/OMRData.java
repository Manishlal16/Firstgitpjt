package com.omr1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OMRData {
       public static void main(String[] args) throws IOException {
       File file = new File("C:\\Users\\user\\eclipse-workspace\\OMRDetails1\\libexcel\\Book11.xlsx");
	   FileInputStream stream = new FileInputStream(file);
	   Workbook workbook = new XSSFWorkbook(stream);
	   Sheet sheet = workbook.getSheet("Datas");
	   Row row = sheet.createRow(4);
	   Cell cell = row.createCell(13);
	   cell.setCellValue("gegjhg");
	   FileOutputStream out = new FileOutputStream(file);
	   workbook.write(out);
	}
}
