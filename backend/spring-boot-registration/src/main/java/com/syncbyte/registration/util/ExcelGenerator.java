package com.syncbyte.registration.util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.syncbyte.registration.entity.Employee;
 

public class ExcelGenerator {
	public static ByteArrayInputStream employeeToExcel(List<Employee> employees) throws IOException {
    String[] COLUMNs = {"Id","EmployeeCode", "Name", "DOB", "Password","FingerPrint","Attendance"};
    try(
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
    ){
      CreationHelper createHelper = workbook.getCreationHelper();
   
      Sheet sheet = workbook.createSheet("Employees");
   
      Font headerFont = workbook.createFont();
      headerFont.setBold(true);
      headerFont.setColor(IndexedColors.BLUE.getIndex());
   
      CellStyle headerCellStyle = workbook.createCellStyle();
      headerCellStyle.setFont(headerFont);
   
      // Row for Header
      Row headerRow = sheet.createRow(0);
   
      // Header
      for (int col = 0; col < COLUMNs.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(COLUMNs[col]);
        cell.setCellStyle(headerCellStyle);
      }
   
      // CellStyle for Dob
      CellStyle dobCellStyle = workbook.createCellStyle();
      dobCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
   
      int rowIdx = 1;
      for (Employee employee : employees) {
        Row row = sheet.createRow(rowIdx++);
   
        row.createCell(0).setCellValue(employee.getId());
        row.createCell(1).setCellValue(employee.getEmployeecode());
        row.createCell(2).setCellValue(employee.getName());
   
        Cell dobCell = row.createCell(3);
        dobCell.setCellValue(employee.getDob());
        dobCell.setCellStyle(dobCellStyle);
        row.createCell(4).setCellValue(employee.getPassword());
        row.createCell(5).setCellValue(employee.isFingerprint());

        row.createCell(6).setCellValue(employee.getAttendenceCount());
        
      }
   
      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    }
  }
}

