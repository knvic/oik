package org.sasdu;

import javafx.util.Pair;
import org.sasdu.excel.ExcelParser;
import org.sasdu.excel.WriteExcel;
import org.sasdu.model.ItemRow;
import org.sasdu.util.CkList;
import org.sasdu.util.Compliance;

import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

        System.out.println( "Hello World!" );


      //LinkedList<ItemRow> item=ExcelParser.parse("C:\\project\\_Excel\\test.xls");
        //LinkedList<ItemRow> item=ExcelParser.parse("C:\\project\\_Excel\\test01.xls");
        LinkedList<ItemRow> item=ExcelParser.parse("C:\\project\\_Excel\\test_origin.xls");
        System.out.println("Количество элементов Ск2007 = "+item.size());

       // WriteExcelAll.wEx(item);
       // ItemRow work= item.get(5);
       // System.out.println(work.id+" "+work.name);
        //for (ItemRow element : item) {
       ///     System.out.println(element.id+" "+element.name+" "+element.type+" "+element.value+" "+element.code+" "+element.par+" "+element.id_ck11);
           // System.out.println(element.id+" "+element.name+" "+element.type+" "+element.value+" "+element.code);
        //}

        List<Integer> listCk= CkList.cklist(item);
        for (Integer el : listCk) {
            //System.out.println(el);
            }
        System.out.println("Количество элементов Ск11 = "+listCk.size());



        Pair<LinkedList<ItemRow>,List<Integer>> p = Compliance.mapping(item,listCk);

        System.out.println(p.getKey() + " " + p.getValue());
        LinkedList<ItemRow> listEnd=p.getKey();
        List<Integer> ck11out = p.getValue();

        for (Integer ck : ck11out) {
            System.out.println(ck);}
        System.out.println("Количество оставшихся элемнтов =" +  ck11out.size());

       // for (ItemRow element : list_end) {
       //         System.out.println(element.id+" "+element.name+" "+element.type+" "+element.time+" "+element.value+" "+element.code+" "+element.par+" "+element.id_ck11);
            // System.out.println(element.id+" "+element.name+" "+element.type+" "+element.value+" "+element.code);
        //    }

       // WriteExcelAll.wEx(item);
        WriteExcel.wEx(listEnd,ck11out);


        }



    }

