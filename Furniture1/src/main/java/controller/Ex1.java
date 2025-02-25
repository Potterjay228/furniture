package controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import util.DbConnection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class Ex1 {
    public static void main(String[] args) {
       
    	Connection connection=DbConnection.getDb();

        String excelFilePath = "c:/work/Furniture1.xlsx";
        String SQL="SELECT * FROM furniture.porder";

        try (
        	 PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery();
             Workbook workbook = new XSSFWorkbook()
            ) {

            // 新增 Excel 工作表
            Sheet sheet = workbook.createSheet("訂購單");

            // 建立標題行
            Row headerRow = sheet.createRow(0);
            String[] headers = {"ID", "姓名", "書桌", "電競椅", "衣櫃", "帳號"};

            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);

            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            // 將讀取資料庫的資料寫入excel檔
            int rowNum = 1;
            while (resultSet.next()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(resultSet.getInt("id"));
                row.createCell(1).setCellValue(resultSet.getString("name"));
                row.createCell(2).setCellValue(resultSet.getString("desk"));
                row.createCell(3).setCellValue(resultSet.getString("gamingChair"));
                row.createCell(4).setCellValue(resultSet.getString("wardrobe"));
                row.createCell(5).setCellValue(resultSet.getString("username"));
            }

            // 自動調整欄位寬度
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // 寫入 Excel 檔案
            try (FileOutputStream fileOut = new FileOutputStream(excelFilePath)) {
                workbook.write(fileOut);
                System.out.println("Excel 檔案已生成：" + excelFilePath);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

	public static void exportToExcel() {
		Connection connection = DbConnection.getDb(); // 假設這是你的資料庫連線方法

        String excelFilePath = "c:/work/Furniture1/Furniture1.xlsx";
        String SQL = "SELECT * FROM furniture.porder";

        try (
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Workbook workbook = new XSSFWorkbook()
        ) {

            // 新增 Excel 工作表
            Sheet sheet = workbook.createSheet("訂購單");

            // 建立標題行
            Row headerRow = sheet.createRow(0);
            String[] headers = {"ID", "姓名", "書桌", "電競椅", "衣櫃", "帳號"};

            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);

            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            // 將讀取資料庫的資料寫入excel檔
            int rowNum = 1;
            while (resultSet.next()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(resultSet.getInt("id"));
                row.createCell(1).setCellValue(resultSet.getString("name"));
                row.createCell(2).setCellValue(resultSet.getString("desk"));
                row.createCell(3).setCellValue(resultSet.getString("gamingChair"));
                row.createCell(4).setCellValue(resultSet.getString("wardrobe"));
                row.createCell(5).setCellValue(resultSet.getString("username"));
            }

            // 自動調整欄位寬度
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // 寫入 Excel 檔案
            try (FileOutputStream fileOut = new FileOutputStream(excelFilePath)) {
                workbook.write(fileOut);
                System.out.println("Excel 檔案已生成：" + excelFilePath);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
