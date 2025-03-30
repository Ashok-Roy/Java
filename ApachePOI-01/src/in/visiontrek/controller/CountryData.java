package in.visiontrek.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import in.visiontrek.util.JdbcConnection;

public class CountryData {
	// Read from excel and Write Data in DB
	static Connection connection = null;
	static PreparedStatement pstmt = null;
	public static void main(String[] args) 
	{
		String insertQuery = "insert into country(country,capital,population) values(?,?,?)";
		String path="D:\\Java Programs Jan 22\\Advanced Java\\ApachePOI-01\\datafile\\countries.xlsx";
		String country;
		String city;
		Double population;
		
		try {
			connection = JdbcConnection.getJdbcConnection();
			
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int rows = sheet.getLastRowNum();
			
			for(int r = 1; r<=rows; r++)
			{
				XSSFRow row = sheet.getRow(r);
				country = row.getCell(0).getStringCellValue();
				city = row.getCell(1).getStringCellValue();
				population = row.getCell(2).getNumericCellValue();
				
				if(connection != null)
				{
					pstmt = connection.prepareStatement(insertQuery);
				}
				if(pstmt != null)
				{
					pstmt.setString(1, country);
					pstmt.setString(2, city);
					pstmt.setDouble(3, population);
				}
				if(pstmt != null)
				{
					int rowAffect = pstmt.executeUpdate();
					if(rowAffect == 1)
					{
						System.out.println("Data Insertion Successful");
					}else{
						System.out.println("Data Insertion Failed");
					}
				}
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
