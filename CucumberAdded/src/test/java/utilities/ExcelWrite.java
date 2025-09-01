
package utilities;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class ExcelWrite {
 
    public static void writeMessage(String message, String fileName, String sheetName) {
        Workbook workbook;
        File file = new File(fileName);
 
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                workbook = new XSSFWorkbook(fis);
            } catch (IOException e) {
                System.err.println("Error opening existing Excel file: " + fileName);
                e.printStackTrace();
                return;
            }
        } else {
            workbook = new XSSFWorkbook();
        }
 
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            sheet = workbook.createSheet(sheetName);
        }
 
        int rowNum = sheet.getPhysicalNumberOfRows();
        
        if (rowNum == 0) {
            Row headerRow = sheet.createRow(0);
            Cell headerCell1 = headerRow.createCell(0);
            headerCell1.setCellValue("Scenario");
            Cell headerCell2 = headerRow.createCell(1);
            headerCell2.setCellValue("Status");
            rowNum++;
        }
        
        Row row = sheet.createRow(rowNum);
        
        String[] parts = message.split(" - ");
        String scenarioName = parts[0];
        String scenarioStatus = parts[1];
 
        Cell scenarioCell = row.createCell(0);
        scenarioCell.setCellValue(scenarioName);
 
        Cell statusCell = row.createCell(1);
        statusCell.setCellValue(scenarioStatus);
 
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            workbook.write(fos);
        } catch (IOException e) {
            System.err.println("Error writing to Excel file: " + fileName);
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
 