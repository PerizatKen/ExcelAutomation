package homework;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utilities.ExcelUtils;

public class CalculatorTest {
	public static void main(String[] args) throws IOException {

		String excelPath = "C:\\Users\\Perizat\\Desktop\\calculator.xlsx";

		FileInputStream in = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(in);
		XSSFSheet worksheet = workbook.getSheet("Sheet1");

		// int rowsCount = worksheet.getPhysicalNumberOfRows();
		ExcelUtils.openExcelFile(excelPath, "Sheet1");
		int rowsCount = ExcelUtils.getUsedRowsCount();
		System.out.println(rowsCount);

		for (int rownum = 1; rownum < rowsCount; rownum++) {

			String cellOperator = ExcelUtils.getCellData(rownum, 1);
			// System.out.println(oper);

			double num1 = Double.parseDouble(ExcelUtils.getCellData(rownum, 2));
			String strNum1 = String.valueOf(num1);
			System.out.println(strNum1);

			double num2 = Double.parseDouble(ExcelUtils.getCellData(rownum, 3));
			String strNum2 = String.valueOf(num2);
			System.out.println(strNum2);

			// double result = Calculator.Operation(oper, num1, num2);
			// String expResult = String.valueOf(result);
			// System.out.println(expResult);

			// if (execute.equals("Y")) {
			// String operation =
			// worksheet.getRow(rownum).getCell(1).toString();
			// System.out.println("Operation : " + operation);
			//
			// } else {
			// // System.out.println("No need to operate...");
			// }
			//
			// for (int rownum2 = 1; rownum2 < rowsCount; rownum2++) {
			// String operation =
			// worksheet.getRow(rownum2).getCell(1).toString();
			//
			// if (operation.equals("addition")) {
			// System.out.println(worksheet.getRow(rownum2).getCell(2));
			// // XSSFCell = worksheet.getRow(rownum2).getCell(4);
			// // int result = ;
			// } else {
			// System.out.println();
			// }
		}

	}
}
