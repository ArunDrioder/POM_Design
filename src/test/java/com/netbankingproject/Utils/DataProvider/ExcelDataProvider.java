package com.netbankingproject.Utils.DataProvider;

import com.netbankingproject.Utils.Readers.DataReader.DataReaderClass;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class ExcelDataProvider
{
    @DataProvider(name = "LoginTestData")
    public Object[][] getData() throws IOException {
        String pathToExcel = "C:\\Backup\\Selenium - Workspace\\POM_Design\\src\\test\\java\\com\\netbankingproject\\data\\excelData.xlsx";

        int rowCount = DataReaderClass.getRowCount(pathToExcel,"Login");
        System.out.println(rowCount);

        int colCount = DataReaderClass.getCellCount(pathToExcel,"Login",2);
        String loginData[][] = new String[rowCount][colCount];

        for (int i = 1; i<=rowCount; i++)
        {
            for (int j = 0; j<colCount;j++)
            {
                loginData[i-1][j] = DataReaderClass.getCellData(pathToExcel,"Login",i,j);
            }

        }
        return loginData;


    }

}
