package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteTestDataToExcelFile {

	public static void main(String[] args) throws Exception {
//		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\testdata\\td.xlsx");
//		Workbook wb = new XSSFWorkbook(fi);
//		Sheet s = wb.getSheet("Sheet3");
//		Row r  = s.getRow(1);
		//Row=1 coloum=5
		
		//How to write the test data to new excel
		//Create excel file
		FileOutputStream fo = new FileOutputStream(".\\src\\test\\resources\\testdata\\myExcel.xlsx");
		Workbook te = new XSSFWorkbook();
		Sheet sb = te.createSheet("hello");
		Row r1 = sb.createRow(9);
		Cell c1 = r1.createCell(8);		
		c1.setCellValue("akjdfgihsehrwen'ldgsn");
		
		//PUSH the create test data to excel file from RAM location
		te.write(fo);
		fo.close();
		
		
		
		
		
		

	}

}
