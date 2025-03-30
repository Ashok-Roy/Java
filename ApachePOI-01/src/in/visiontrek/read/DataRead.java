package in.visiontrek.read;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;


public class DataRead {
	public static void main(String[] args) throws IOException 
	{
		String location ="D:\\Java Programs Jan 22\\Advanced Java\\ApachePOI-01\\datafile\\countries.xlsx";
		FileInputStream fis = new FileInputStream(location);
		XSSFWorkbook workBook = new XSSFWorkbook(fis); // to read or write excel data
		// XSSFSheet sheet = workBook.getSheet(".//datafile//countries.xlsx"); // get the sheet with name
		XSSFSheet sheet = workBook.getSheetAt(0); // get the sheet with index
		
		int rows = sheet.getLastRowNum(); // getting the numbers of row 
		//System.out.println(rows);
		int cols = sheet.getRow(0).getLastCellNum(); // getting the number of column using one row
		//System.out.println(cols);
		for(int r = 0; r<=rows; r++)
		{
			XSSFRow row = sheet.getRow(r); // getting row one by one 
			for(int c = 0; c<cols; c++)
			{
				XSSFCell cell = row.getCell(c);
				try
				{
					switch(cell.getCellType())
					{
					case STRING:
						System.out.print(cell.getStringCellValue()+"\t");
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue()+"\t");
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue()+"\t");
						break;
					default:
						System.out.println("Invalid");
						break;
						
					}
				}catch(NullPointerException n){
					System.out.println(" ");
				}
				
			}
			System.out.println();
		}
		
		
		
		
	}
}
