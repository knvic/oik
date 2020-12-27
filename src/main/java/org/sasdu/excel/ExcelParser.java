package org.sasdu.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.sasdu.model.ItemRow;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;




public class ExcelParser {

    public static LinkedList<ItemRow> parse(String fileName) throws Exception {
        LinkedList<ItemRow> itemRows=new LinkedList<>();

        //вспомогательное для кол-ва ошибок
        int err =0;
        //инициализируем потоки
        String result = "";
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            if (row.getRowNum()<2){continue;}

            try {
                itemRows.add(new ItemRow((int)row.getCell(0).getNumericCellValue(),row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue(),row.getCell(3).getStringCellValue(),(int)row.getCell(4).getNumericCellValue(),row.getCell(5).getStringCellValue(),row.getCell(9).getStringCellValue(),(int)row.getCell(10).getNumericCellValue()));
            }
            catch (Exception e) {

                err++;
                // itemRows.add(new ItemRow((int)row.getCell(0).getNumericCellValue(),row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue(),row.getCell(3).getStringCellValue(),(int)row.getCell(4).getNumericCellValue(),row.getCell(5).getStringCellValue(),row.getCell(9).getStringCellValue(),(int)row.getCell(10).getNumericCellValue()));
                itemRows.add(new ItemRow((int) row.getCell(0).getNumericCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue(), (int) row.getCell(4).getNumericCellValue(), row.getCell(5).getStringCellValue()));
            }
        }

        System.out.println("Количество ошибок = "+err);
        return itemRows;

    }

}
