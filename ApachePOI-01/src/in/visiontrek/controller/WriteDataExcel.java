package in.visiontrek.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import in.visiontrek.util.JdbcConnection;

public class WriteDataExcel {

	private static Connection connection = null;
	private static PreparedStatement pstmt= null;
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		String selectQuery = "select id, country, capital, population from country";
		try {
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement(selectQuery);
			}
			ResultSet resultSet = pstmt.executeQuery();
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("employee info");
			// Creating one row and set the header or data into one one cell
			XSSFRow row = sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("Country");
			row.createCell(2).setCellValue("Ciry");
			row.createCell(3).setCellValue("Population");
			
			int r = 1;
			while(resultSet.next())
			{
				int id = resultSet.getInt(1);
				String country = resultSet.getString(2);
				String city = resultSet.getString(3);
				Double population = resultSet.getDouble(4);
				System.out.println(id+"\t"+country+"\t"+city+"\t"+population);
				
				// Creating one row and set the header or data into one one cell
				row = sheet.createRow(r++);
				row.createCell(0).setCellValue(id);
				row.createCell(1).setCellValue(country);
				row.createCell(2).setCellValue(city);
				row.createCell(3).setCellValue(population);
					
					
			}
			// create a excel file and write the workbook into the excel file 
			FileOutputStream fos = new FileOutputStream(".//datafile//employee.xlsx");
			workbook.write(fos);
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			
				try {
					if(connection != null)
						connection.close();
					if(pstmt != null)
						pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}

	}

}
