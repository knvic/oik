package org.sasdu.util;

import javafx.util.Pair;
import org.sasdu.model.ItemRow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public  class Compliance {
    public  static Pair<LinkedList<ItemRow>,List<Integer>> mapping(LinkedList<ItemRow> list, List<Integer> listCk){
        boolean gud=false;

        List<Integer> lost = new ArrayList<>();
        for (ItemRow element : list) {
            element.id_ck11=0;
        }




        for (ItemRow el : list) {
            System.out.print("Элемент ID = " +  el.id);
           if(listCk.contains(el.id)) {
               el.id_ck11=el.id;
               System.out.print("; Элемент " +  el.id+" найден в массиве СК "+ "размер до удаления "+ listCk.size());
               listCk.remove(el.id);
               System.out.println("; размер после удаления "+ listCk.size());
           }else
           {
               System.out.println("; Элемент " +  el.id+" Не найден в массиве СК размер  "+ listCk.size());
           }




               }


        for (Integer ck : listCk) {
            System.out.println(ck);}
        System.out.println("Количество оставшихся элемнтов =" +  listCk.size());
       //return list;
        return  new Pair<LinkedList<ItemRow>,List<Integer>>(list, listCk);
    }
}
