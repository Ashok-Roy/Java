package in.visiontrek.read;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWriteFromArrayList {
	public static void main(String[] args) throws IOException{
		// workbook-->sheet-->row--->cell
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("employee info");
		
		ArrayList<Object[]> list = new ArrayList<>();
		list.add(new Object[]{"EId", "EName", "ESalary"});
		list.add(new Object[]{1, "Sachin", 10000});
		list.add(new Object[]{2, "Dhoni", 20000});
		list.add(new Object[]{3, "Kholi", 30000});
		
		int rownum = 0;
		for(Object[] data : list)
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
