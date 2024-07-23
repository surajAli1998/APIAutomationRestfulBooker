package com.apiautomation.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    public static String EXCEL_PATH = "src/test/resources/TD.xlsx";
    public static Workbook workbook;
    public static Sheet sheet;

    public static Object[][] getTestData(String sheetName){
        FileInputStream fileInputStream;
        try{
            fileInputStream = new FileInputStream(EXCEL_PATH);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0; i<sheet.getLastRowNum(); i++){
            for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++){
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }

    @DataProvider
    public Object[][] getData(){
        /**
         * here i can write code for future requirement
         * in data.properties file we can store different sheet names of the excel for diff purpose
         * we can use particular sheet for fetching test data for particular job
         */
        return getTestData("Sheet1");
    }
}
