package in.visiontrek.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import in.visiontrek.util.JdbcConnection;

public class ReadData {
	private static Connection connection = null;
	private static PreparedStatement pstmt= null;
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("employee info");
		
		
		
		String selectQuery = "select id, country, capital, population from country";
		ArrayList<Object[]> list = new ArrayList<>();
		try {
			connection = JdbcConnection.getJdbcConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement(selectQuery);
			}
			ResultSet resultSet = null;
			if(pstmt != null)
				resultSet = pstmt.executeQuery();
			if(resultSet != null){
				System.out.println("ID\tCOUNTRY\tCITY\tPOPULATION");
				while(resultSet.next())
				{
					int id = resultSet.getInt(1);
					String country = resultSet.getString(2);
					String city = resultSet.getString(3);
					Double population = resultSet.getDouble(4);
					System.out.println(id+"\t"+country+"\t"+city+"\t"+population);
					
					
				}
			}
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
