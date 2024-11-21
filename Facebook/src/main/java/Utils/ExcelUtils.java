package Utils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
	
	String filepath;
	String sheetName;

    /**
     * This method reads the Excel file (FacebookLoginDetails.xlsx) and returns the data as a 2D Object array.
     * @param filePath the path to the Excel file
     * @param sheetName the name of the sheet to read (e.g., "Sheet1")
     * @return a 2D Object array containing the test data
     * @throws IOException if there is an issue reading the file
     */
    public static Object[][] getTestData(String filePath, String sheetName) throws IOException {
        // Open the Excel file
    	
    	 filePath = "F:\\Dahnesh Sample files\\FacebookDetails.xlsx"; 
    	 // Provide the correct file path
    	 
    	 
         sheetName = "Sheet1"; // Provide the sheet name
        FileInputStream file = new FileInputStream(new File(filePath));

        // Create a workbook instance
        Workbook workbook = new XSSFWorkbook(file);
        
        // Get the sheet by name
        Sheet sheet = workbook.getSheet(sheetName);
        
        // Get the number of rows and columns
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        // Initialize an Object array to hold the data
        Object[][] data = new Object[rowCount - 1][colCount]; // Exclude header row

        // Loop through each row (skip header row)
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            // Loop through each column
            for (int j = 0; j < colCount; j++) {
                // Store the cell value in the data array
                Cell cell = row.getCell(j);
                if (cell != null) {
                    data[i - 1][j] = cell.toString();  // Convert cell to string
                } else {
                    data[i - 1][j] = "";  // Handle empty cells
                }
            }
        }

        // Close the workbook and file input stream
        workbook.close();
        file.close();

        // Return the 2D data array
        return data;
    }

//    public static void main(String[] args) throws IOException {
//        // Example to test if the data is read properly
//        String filePath = "F:\\Dahnesh Sample files\\FacebookDetails.xlsx"; // Provide the correct file path
//        String sheetName = "Sheet1"; // Provide the sheet name
//
//        Object[][] data = getTestData(filePath, sheetName);
//
//        // Print the data for verification
//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < data[i].length; j++) {
//                System.out.print(data[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
    
    
}
