package com.mmp.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;



public class TestUtil {
	static ExcelReader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
		try {
		
		reader = new ExcelReader(System.getProperty("user.dir")+"\\excel\\Login.xlsx");
		}catch(Exception e) {
			e.printStackTrace();
			String sheetName = "login";
			int rows = reader.getRowCount(sheetName);
			//int cols = reader.getColumnCount(sheetName);
			
			
	    	for (int rowNum =2;  rowNum <=rows; rowNum++) {
	    		
	    		String userName = reader.getCellData(sheetName,"username", rowNum);
	    		String passWord = reader.getCellData(sheetName,"password", rowNum);
	    		
	    		Object ob[]= {userName,passWord};
	    		myData.add(ob);
			
		}
			
		}
		return myData;
		
	}

   
		
		
    		
    		
    		
    		
    		/*for (int colNum=0; colNum < cols; colNum++) {
    			//data[0][0]
    			data[rowNum-2][colNum]= reader.getCellData(sheetName,colNum,rowNum);*/
    		
    }

