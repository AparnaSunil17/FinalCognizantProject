package utilities;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	
	public static HashMap<String, String> storeValues = new HashMap<>();

	public static List<HashMap<String, String>> data(String filepath, String sheetName) {
		
		List<HashMap<String, String>> dataList = new ArrayList<>();
		
		try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row HeaderRow = sheet.getRow(0);
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) 
				{
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> currentHash = new HashMap<String, String>();
				for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) 
					{
					Cell currentCell = currentRow.getCell(j);
					String header=HeaderRow.getCell(j).getStringCellValue().trim();
					switch (currentCell.getCellType()) {
			        case STRING:
			            currentHash.put(header, currentCell.getStringCellValue());
			            break;

			        case NUMERIC:
			            if (DateUtil.isCellDateFormatted(currentCell)) {
			            	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			                Date date = currentCell.getDateCellValue();
			                currentHash.put(header, dateFormat.format(date));
			            } else {
			                currentHash.put(header, String.valueOf((long) currentCell.getNumericCellValue()));
			            }
			            break;

			        default:
			            currentHash.put(header, "");
						}
					}
				dataList.add(currentHash);
				}
			fs.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return dataList;
	}
}
