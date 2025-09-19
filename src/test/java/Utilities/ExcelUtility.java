package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtility {
    private Workbook workbook;
    private Sheet sheet;
    private String filePath;

    // Constructor to load Excel file
    public ExcelUtility(String filePath) {
        this.filePath = filePath;
        try (FileInputStream fis = new FileInputStream(filePath)) {
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get number of rows in a sheet
    public int getRowCount(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        return sheet.getLastRowNum();
    }

    // Get number of columns in a sheet
    public int getCellCount(String sheetName, int rowNum) {
        sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        return row.getLastCellNum();
    }

    // Get cell data (String/Number/Boolean handled automatically)
    public String getCellData(String sheetName, int rowNum, int colNum) {
        sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    // Close workbook
    public void closeWorkbook() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
