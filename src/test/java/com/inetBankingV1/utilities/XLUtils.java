package com.inetBankingV1.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		
		fi= new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheet);
		int rowcount = sheet.getLastRowNum();
		wb.close();
		fi.close();
		
		return rowcount;
	}
	
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		
		fi= new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
		
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rownum, int column) throws IOException {
		fi= new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(column);
		String data;
		
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			
			return cellData;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			data ="";
			e.printStackTrace();
		}
		
		wb.close();
		fi.close();
		
		return data;
	}
	
	public static void setCellData(String xlfile, String xlsheet, int rownum, int column, String data ) throws IOException {
		
		fi= new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(column);
		cell.setCellValue(data);
		fo= new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

}
