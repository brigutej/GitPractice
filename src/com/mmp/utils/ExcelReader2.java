package com.mmp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReader2 {
	
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
		     case Cell.CELL_TYPE_NUMERIC:
		      System.out.print(cell.getNumericCellValue());
		      break;
		     case Cell.CELL_TYPE_STRING:
		      System.out.print(cell.getStringCellValue()+"--");
		      break;
		     }
		    }
		    System.out.println();
		   }
		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  } catch (IOException e1) {
		   e1.printStackTrace();
		  }
		 }

	}



