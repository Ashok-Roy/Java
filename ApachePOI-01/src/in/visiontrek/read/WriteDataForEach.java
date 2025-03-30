package in.visiontrek.read;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataForEach
{
	public static void main(String[] args) throws IOException
	{
		// workbook-->sheet-->row-->col
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("employee info");
				
				Object empdata[][]={
									{"EID", "EName", "ESalary"},
									{1, "Sachin", "1000"},
									{2, "Dhoni", "2000"},
									{3, "Kholi", "3000"},
								};
				int rownum = 0;
				for(Object[] data : empdata )
				{
					XSSFRow row = sheet.createRow(rownum++);
					int colnum = 0;
					for(Object value : data)
					{
						XSSFCell cell = row.createCell(colnum++);
						if(value instanceof String)
							cell.setCellValue((String)value);
						if(value instanceof Integer)
							cell.setCellValue((Integer)value);
						if(value instanceof Boolean)
							cell.setCellValue((Boolean)value);
					}
				}
				String path = ".\\datafile\\employee.xlsx";
				FileOutputStream fos = new FileOutputStream(path);
				workbook.write(fos);
				fos.close();
				System.out.println("Data Writing Successful");
	}

}
