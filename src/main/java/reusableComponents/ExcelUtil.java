package reusableComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;

import com.google.common.io.Files;

public class ExcelUtil {

	String filePath;
	Sheet sh;
	Workbook wb = null;
	FileInputStream fis = null;

	public ExcelUtil(String wbPath, String sheetName) {
		// open file - workbook
		File testDataFile = new File(wbPath);
		try {
			fis = new FileInputStream(testDataFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sh = wb.getSheet(sheetName);
	}

	// get test data from test data sheet in hashmap based on row number
	@SuppressWarnings("deprecation")
	public HashMap<String, String> getTestDataInMap(int rowNum) throws Exception {
		// read data row by row and put in map
		HashMap<String, String> hm = new HashMap<String, String>();

		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			String value;
			if (sh.getRow(rowNum).getCell(i) != null) {
				sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
				value = sh.getRow(rowNum).getCell(i).toString();
			} else {
				value = "";
			}
			hm.put(sh.getRow(0).getCell(i).toString(), value);
		}
		return hm;
	}

	// get row count
	public int getRowCount() {
		return sh.getLastRowNum();
	}

	// ger column count
	public int getColCount() {
		return sh.getRow(0).getLastCellNum();

	}

	public void getDataOFExcel() throws Exception {
		// read data row by row and put in map

		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			String value;
			if (sh.getRow(0).getCell(i) != null) {
				sh.getRow(0).getCell(i).setCellType(CellType.STRING);
				value = sh.getRow(0).getCell(i).toString();
				System.out.println(value);
			} else {
				value = "";
			}
		}
	}

	public void setCellData(HashMap<String, String> mapOfTestData, String filePath) throws IOException {

		Row row = null;
		Cell cell = null;
		for (int x = 1; x <= 1; x++) {
			for (int y = 0; y <= 100; y++) {

				row = sh.getRow(x);

				if (row == null) {
					row = sh.createRow(x);
				}
				cell = row.getCell(y);

				if (cell == null) {
					cell = row.createCell(y);
				}

				sh.getRow(x).getCell(y).setBlank();
			}
		}

		row = sh.getRow(0);

		int noOfCols = row.getLastCellNum();

		for (int i = 0; i < noOfCols; i++) {

			row = sh.getRow(0);
			String colInManRater = row.getCell(i).getStringCellValue();
			System.out.println("Column name in Man Rater is " + colInManRater);

			for (Entry<String, String> c : mapOfTestData.entrySet()) {

				row = sh.getRow(1);

				if (row == null) {
					row = sh.createRow(1);
				}

				cell = row.getCell(i);

				if (cell == null) {
					cell = row.createCell(i);
				}
				

				if (c.getKey().equalsIgnoreCase(sh.getRow(0).getCell(i).getStringCellValue())) {
					System.out.println("From Manual Rater " + sh.getRow(0).getCell(i));
					System.out.println("Value set is " + c.getValue());
					try {
						cell.setCellValue(Integer.parseInt(c.getValue()));
						XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
					}catch(Exception e) {
						cell.setCellValue(c.getValue());
						//XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
					}
					break;
				}
				XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
			}
		}
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		fis.close();
		fos.close();

	}

	public Map<String, Double> getPremiumFromExcel () {
		double locPremium =sh.getRow(4).getCell(0).getNumericCellValue();	
		double feesAndTaxesPremium = sh.getRow(5).getCell(0).getNumericCellValue();	
		double finalPremium = sh.getRow(6).getCell(0).getNumericCellValue();	
		
		Map<String,Double> mapOfPremium = new HashMap<String,Double>();
		mapOfPremium.put("LocationPremium", locPremium);
		mapOfPremium.put("FeesAndTaxesPremium", feesAndTaxesPremium);
		mapOfPremium.put("FinalPremium", finalPremium);
		
		return mapOfPremium;
		
	}
	
	public void copyExcelFile(String src,String dest) {
		
		File originalWb = new File(src); 
		File clonedWb = new File(dest);
		try {
			FileUtils.deleteQuietly(clonedWb);
			FileUtils.copyFile(originalWb, clonedWb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public double getPremiumFromExcelForCan () {
		double returnPremium =sh.getRow(3).getCell(0).getNumericCellValue();	
		return returnPremium;
		
	}
	
	public double getPremiumFromExcelForEnd () {
		double returnPremium =sh.getRow(3).getCell(0).getNumericCellValue();	
		return returnPremium;
		
	}
	
	public void setPolicyNumber(String subNo,String filePath,HashMap<String, String> mapOfTestData,int colIndex) throws IOException {
		sh.getRow(Integer.parseInt(mapOfTestData.get("Sr No"))).getCell(colIndex).setCellValue(subNo);
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		fis.close();
		fos.close();
		
	}
	
	public void setDetailsInCanSheet(String effDate,String expDate,String policyTerm, int premium, String filePath,HashMap<String, String> mapOfTestData) throws IOException {
		
		sh.getRow(Integer.parseInt(mapOfTestData.get("Sr No"))).getCell(5).setCellValue(premium);
		sh.getRow(Integer.parseInt(mapOfTestData.get("Sr No"))).getCell(6).setCellValue(effDate);
		sh.getRow(Integer.parseInt(mapOfTestData.get("Sr No"))).getCell(7).setCellValue(expDate);
		sh.getRow(Integer.parseInt(mapOfTestData.get("Sr No"))).getCell(9).setCellValue(policyTerm);
		
		
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		fis.close();
		fos.close();
		
	}
}
