package in.visiontrek.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReadUsingIterator {
	public static void main(String[] args) throws IOException 
	{
		String location ="D:\\Java Programs Jan 22\\Advanced Java\\ApachePOI-01\\datafile\\countries.xlsx";
		FileInputStream fis = new FileInputStream(location);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheetAt(0);
		//XSSFSheet sheet = workBook.getSheet("in.visiontrek.read.countries.xlsx");
		
		Iterator itr = sheet.iterator();
		while(itr.hasNext())
		{
			XSSFRow row = (XSSFRow)itr.next();
			Iterator cellItr = row.cellIterator();
			while(cellItr.hasNext())
			{
				XSSFCell cell = (XSSFCell)cellItr.next();
				switch(cell.getCellType())
				{
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				}
			}
		}
	}
}
