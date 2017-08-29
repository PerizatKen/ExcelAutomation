package excelreadwrite;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static void main(String[] args) throws IOException {
		String excelPath = "C:\\Users\\Perizat\\Desktop\\EmpData.xlsx";
		FileInputStream in = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(in);
		XSSFSheet worksheet = workbook.getSheet("TestData");

		int rowsCount = worksheet.getPhysicalNumberOfRows();
		System.out.println("Number of rows: " + rowsCount);

		in.close();

		XSSFCell cell = worksheet.getRow(1).getCell(2);
		if (cell == null) {
			cell = worksheet.getRow(1).createCell(2);
		}
		cell.setCellValue("Pass");

		XSSFCell cell2 = worksheet.getRow(6).getCell(2);
		if (cell2 == null) {
			cell2 = worksheet.getRow(6).createCell(2);
		}
		cell2.setCellValue("Pass");

		FileOutputStream out = new FileOutputStream(excelPath);
		workbook.write(out);
		in.close();
		out.close();
	}
}
