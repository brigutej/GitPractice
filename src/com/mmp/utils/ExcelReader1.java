package com.mmp.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReader {
 public static void main(String[] args) {
  try {
   FileInputStream fis = new FileInputStream("inputData.xls");

   HSSFWorkbook workbook = new HSSFWorkbook(fis);

   HSSFSheet worksheet = workbook.getSheetAt(0);

   System.out.println(worksheet.getRow(0).getCell(0).getStringCellValue());

   Iterator<Row> ite = worksheet.rowIterator();

   while(ite.hasNext())
   {
    Row row =  ite.next();

    Iterator<Cell> cellIterator = row.cellIterator();

    while (cellIterator.hasNext())
    {
     Cell cell = cellIterator.next();
     //Check the cell type and format accordingly
     switch (cell.getCellType())
     {
     case NUMERIC:
      System.out.print(cell.getNumericCellValue());
      break;
     case STRING:
      System.out.print(cell.getStringCellValue()+"--");
      break;
     }
    }
    System.out.println();
   }
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }
 }




}*/

public class ExcelReader1 {
	public static String projectpath;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static void main(String[] args) {
		//getRowCount();
		getCellDataString();
	}

	public static void getRowCount() {
		try {
			projectpath=	System.getProperty("user.dir");
			//System.out.println(projectpath);
			workbook = new XSSFWorkbook(projectpath+"\\excel\\symptoms.xlsx");
			sheet = workbook.getSheet("Sheet1");
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of Rows : "+rowCount);

		}catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			System.out.println(exp.getStackTrace());


		}

	}

	public static void getCellDataString() {

		try {
			projectpath=	System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectpath+"\\excel\\symptoms.xlsx");
			sheet = workbook.getSheet("Sheet1");
			String cellData = sheet.getRow(2).getCell(0).getStringCellValue();
			System.out.println(cellData);

		}catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			System.out.println(exp.getStackTrace());


		}
	}
	
	public static void getCellDataNumber() {

		try {
			projectpath=	System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectpath+"\\excel\\symptoms.xlsx");
			sheet = workbook.getSheet("Sheet1");
			double cellData = sheet.getRow(2).getCell(0).getNumericCellValue();
			System.out.println(cellData);

		}catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			System.out.println(exp.getStackTrace());


		}
	}
}
