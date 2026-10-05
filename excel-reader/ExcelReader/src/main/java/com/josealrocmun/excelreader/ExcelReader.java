package com.josealrocmun.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Reads the first sheet of {@code data.xlsx} (Apache POI) and prints each cell.
 *
 * Run from the project folder so {@code data.xlsx} is found next to the program:
 *   cd ExcelReader
 *   mvn -q exec:java
 *
 * Or compile with Maven and run the jar / classpath that includes POI.
 *
 * Change the file name below to read another .xlsx in this folder.
 *
 * @author José Alberto Rocha Munguía
 */
public class ExcelReader {

    // try: "data.xlsx" (must sit in the working directory when you run)
    private static final String EXCEL_FILE = "data.xlsx";

    public static void main(String[] args) {
        File file = new File(EXCEL_FILE);
        FileInputStream fis = null;
        XSSFWorkbook excelWorkbook = null;

        try {
            fis = new FileInputStream(file);
            excelWorkbook = new XSSFWorkbook(fis);

            // First sheet only — change 0 to open another sheet index
            XSSFSheet excelSheet = excelWorkbook.getSheetAt(0);

            int rows = excelSheet.getPhysicalNumberOfRows();
            int cols = excelSheet.getRow(0).getPhysicalNumberOfCells();

            String stringData[][] = new String[rows][cols];
            int numericData[][] = new int[rows][cols];

            XSSFCell cell;

            System.out.println("--- Reading Excel Content ---");

            for (int i = 0; i < rows; i++) {
                if (excelSheet.getRow(i) == null) {
                    continue;
                }

                for (int j = 0; j < cols; j++) {
                    cell = excelSheet.getRow(i).getCell(j);

                    if (cell == null) {
                        System.out.print("EMPTY\t");
                        continue;
                    }

                    if (cell.getCellType() == CellType.NUMERIC) {
                        int numberValue = (int) cell.getNumericCellValue();
                        numericData[i][j] = numberValue;
                        System.out.print(numberValue + "\t");
                    } else if (cell.getCellType() == CellType.STRING) {
                        String stringValue = cell.getStringCellValue();
                        stringData[i][j] = stringValue;
                        System.out.print(stringValue + "\t");
                    } else {
                        System.out.print("OTHER\t");
                    }
                }
                System.out.println();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, "File not found!", ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, "Error reading workbook!", ex);
        } finally {
            try {
                if (excelWorkbook != null) {
                    excelWorkbook.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
