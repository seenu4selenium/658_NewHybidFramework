package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcelsheet {

	public static void main(String[] args) throws Exception {
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\testdata\\td.xlsx");
		Workbook wb = new XSSFWorkbook(fi);
		Sheet s = wb.getSheet("FacebookLogin");
		Row r  = s.getRow(1);
		Cell c = r.getCell(0);
		Cell c1 = r.getCell(1);
		
		System.out.println(c.getStringCellValue());
		System.out.println(c1.getStringCellValue());
		
		
	}

}
