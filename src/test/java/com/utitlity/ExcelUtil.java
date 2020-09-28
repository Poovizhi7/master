package com.utitlity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtil {
	static String key;

	public static Map<String, Map<String, String>> getMapData() throws IOException {

		File f = new File(System.getProperty("user.dir") + "\\TestData\\savings.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet("Sheet1");
		//int lastRow = sheet.getLastRowNum();
		Map<String, Map<String, String>> dataMap = new HashMap<String, Map<String, String>>();
		Row header = sheet.getRow(0);
		System.out.println(sheet.getPhysicalNumberOfRows());
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			Map<String, String> currentMap = new HashMap<String, String>();
			//int lastColumn = row.getPhysicalNumberOfCells();
			System.out.println( row.getPhysicalNumberOfCells());
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell1 = row.getCell(0);
				int cellType = cell1.getCellType();
				if (cellType == 1) {
					key = cell1.getStringCellValue();
				}
				else if (cellType == 0) {
	
						double numericCellValue = cell1.getNumericCellValue();
						int in = (int) numericCellValue;
						long l = (long) numericCellValue;
						key = String.valueOf(l);
					}
				Cell cell2 = row.getCell(j);
				//System.out.println(cell2);
				int cellType2 = cell2.getCellType();
				if (cellType2 == 1) {
					currentMap.put(header.getCell(j).getStringCellValue(), cell2.getStringCellValue());
				}

				else if (cellType2 == 0) {
						double numericCellValue2 = cell2.getNumericCellValue();
						int inn = (int) numericCellValue2;
						currentMap.put(header.getCell(j).getStringCellValue(), String.valueOf((long)numericCellValue2));

					}
				}

			dataMap.put(key, currentMap);

		}
		System.out.println(dataMap);
		return dataMap;

	}

}