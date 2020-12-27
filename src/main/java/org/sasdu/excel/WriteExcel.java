package org.sasdu.excel;


import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.sasdu.model.ItemRow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WriteExcel {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    private static HSSFCellStyle createStyleForCk11(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();

        style.setFillForegroundColor(
        HSSFColor.HSSFColorPredefined.GOLD.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);



        style.setFont(font);
        return style;
    }

    public static void wEx (LinkedList<ItemRow> list, List<Integer> ck11out ) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Общий список");
        HSSFSheet sheet1 = workbook.createSheet("Отсутствуют в СК11");
        HSSFSheet sheet2 = workbook.createSheet("Есть в СК11. НЕТ в СК2007");
        int rownum =3;
        int count=0;
        int count1=0;
        Cell cell,cell1;
        Row row,row1;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);
        HSSFCellStyle style1 = createStyleForCk11(workbook);


        row = sheet.createRow(rownum);

        // EmpNo
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("ID Ck2007 ");
        cell.setCellStyle(style);
        // EmpName
        sheet.setColumnWidth(1, 8000);
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Наименование");
        cell.setCellStyle(style);
        // Salary
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Тип");
        cell.setCellStyle(style);
        // Grade
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Время");
        cell.setCellStyle(style);
        // Bonus
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Значение");
        cell.setCellStyle(style);

        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Код качества");
        cell.setCellStyle(style);

        cell = row.createCell(9, CellType.STRING);
        cell.setCellValue("ОИ");
        cell.setCellStyle(style);

        cell = row.createCell(10, CellType.STRING);
        cell.setCellValue("ID Ck11");
        cell.setCellStyle(style);

        // Data
        for (ItemRow emp : list) {
            count++;
            if (emp.id_ck11==0){
                count1++;
            }
            rownum++;
            row = sheet.createRow(rownum);

            // ID Ck2007
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(emp.id);
            if (emp.id_ck11==0){cell.setCellStyle(style1);}

            // Наименование
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(emp.name);
            if (emp.id_ck11==0){cell.setCellStyle(style1);}
            // Тип
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(emp.type);
            if (emp.id_ck11==0){cell.setCellStyle(style1);}
            // Время
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(emp.time);
            if (emp.id_ck11==0){cell.setCellStyle(style1);}

            // Значение
            cell = row.createCell(4, CellType.NUMERIC);
            cell.setCellValue(emp.value);
            if (emp.id_ck11==0){cell.setCellStyle(style1);}

            // Код качества
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(emp.code);
            if (emp.id_ck11==0){cell.setCellStyle(style1);}




            if (emp.id_ck11==0){
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(" ");
                cell.setCellStyle(style1);}
            else{
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue("------");
            }


            if (emp.id_ck11==0){
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(" ");
                cell.setCellStyle(style1);}
            else{
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue("------");
            }



            if (emp.id_ck11==0){
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(" ");
                cell.setCellStyle(style1);}
            else{
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue("------");
            }


            // Класс ОИ

            cell = row.createCell(9, CellType.STRING);
            try{
                if (emp.id_ck11==0){cell.setCellValue(" ");}
                else{
                cell.setCellValue(emp.par);}
            }
            catch (Exception e){
                cell.setCellValue("!!!!");
            }
            if (emp.id_ck11==0){cell.setCellStyle(style1);}

            // ID Ck11
            cell = row.createCell(10, CellType.NUMERIC);
            try{
                if (emp.id_ck11==0){cell.setCellValue("нет ");}
                else{
                cell.setCellValue(emp.id_ck11);}
            }
            catch (Exception e){
                cell.setCellValue(999999);
            }
            if (emp.id_ck11==0){cell.setCellStyle(style1);}
        }

        row = sheet.createRow(0);
        cell = row.createCell(1, CellType.NUMERIC);
        cell.setCellValue("Всего ");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.NUMERIC);
        cell.setCellValue(count);
        cell.setCellStyle(style);

        row = sheet.createRow(1);
        cell = row.createCell(1, CellType.NUMERIC);
        cell.setCellValue("Отсутствуют в Ск11 : ");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.NUMERIC);
        cell.setCellValue(count1);
        cell.setCellStyle(style);

        row = sheet.createRow(2);
        cell = row.createCell(1, CellType.NUMERIC);

        cell.setCellValue("Есть в Ск11 но НЕТ в Ск2007: ");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.NUMERIC);
        cell.setCellValue(ck11out.size());
        cell.setCellStyle(style);


        ///// 2 /////// Отсутствуют в СК11 ///////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        rownum=1;
        row = sheet1.createRow(rownum);


        // EmpNo
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("ID Ck2007 ");
        cell.setCellStyle(style);
        // EmpName
        sheet1.setColumnWidth(1, 5000);
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Наименование");
        cell.setCellStyle(style);
        // Salary
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Тип");
        cell.setCellStyle(style);
        // Grade
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Время");
        cell.setCellStyle(style);
        // Bonus
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Значение");
        cell.setCellStyle(style);

        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Код качества");
        cell.setCellStyle(style);

        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Класс ОИ");
        cell.setCellStyle(style);

        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("ID Ck11");
        cell.setCellStyle(style);

        // Data
     count=0;
        for (ItemRow emp : list) {
            if (emp.id_ck11==0) {
                rownum++;
                count++;
                row = sheet1.createRow(rownum);


                // ID Ck2007

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(emp.id);


                // Наименование

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(emp.name);

                // Тип
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(emp.type);

                // Время

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(emp.time);


                // Значение

                cell = row.createCell(4, CellType.NUMERIC);
                cell.setCellValue(emp.value);


                // Код качества

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(emp.code);


                // Класс ОИ

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue("ТС");


                // ID Ck11

                cell = row.createCell(7, CellType.NUMERIC);
                cell.setCellValue("нет");

            }
        }

        ///// 3 ///  Есть в СК11. НЕТ в СК2007  ////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////////////////////////////////////
        rownum=1;
        row = sheet2.createRow(rownum);


        // EmpNo
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("ID Ck2007 ");
        cell.setCellStyle(style);
        // EmpName
       // sheet1.setColumnWidth(2, 5000);
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("ID Ck11");
        cell.setCellStyle(style);


        // Data
        count=0;
        for (Integer e : ck11out) {

                rownum++;
                count++;
                row = sheet2.createRow(rownum);


                // ID Ck2007

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue("нет");


                // Наименование

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(e);




        }
        row = sheet2.createRow(0);
        cell = row.createCell(0, CellType.NUMERIC);
        cell.setCellValue("    Всего :");

        cell = row.createCell(1, CellType.NUMERIC);
        cell.setCellValue(count);







        File file = new File("C:\\project\\_Excel\\WriteExcel.xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);

        workbook.write(outFile);

        System.out.println("Created file: " + file.getAbsolutePath());
    }
}
