package in.visiontrek.read;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWriteDemo {

	public static void main(String[] args) throws IOException
	{
		// workbook-->sheet-->row-->col
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("employee info");
		
		Object data[][]={
							{"EID", "EName", "ESalary"},
							{1, "Sachin", "1000"},
							{2, "Dhoni", "2000"},
							{3, "Kholi", "3000"},
						};
		
		int rows = data.length; // getting the num of row
		int cols = data[0].length; // getting the num of col in one row
		
		for(int r = 0; r<rows; r++)
		{
			XSSFRow row = sheet.createRow(r); // creating row in sheet according to Object row
			for(int c = 0; c<cols; c++)
			{
				XSSFCell cell = row.createCell(c); // creating cell in sheet according to Object col
				Object value = data[r][c];        // Getting the data one by one
				if( value instanceof String)      // Setting the data as per type
				{
					cell.setCellValue((String)value);
				}
				if( value instanceof Integer)
				{
					cell.setCellValue((Integer)value);
				}
				if( value instanceof Boolean)
				{
					cell.setCellValue((Boolean)value);
				}
			}
			
		}
		
		// For Each loop
		
		
		String path = ".\\datafile\\employee.xlsx";
		FileOutputStream fos = new FileOutputStream(path);
		workbook.write(fos);
		fos.close();
		System.out.println("Data writing successful");
		
		
	}
}
