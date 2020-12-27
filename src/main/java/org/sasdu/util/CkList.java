package org.sasdu.util;

import org.sasdu.model.ItemRow;

import javax.management.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CkList {
    public static List<Integer> cklist(LinkedList<ItemRow>  list) {
        List<Integer> cklist=new ArrayList<>();

        for (ItemRow element : list) {

        if(element.id_ck11 != null ) {
            cklist.add(element.id_ck11);
        }

        }
        System.out.println("Количество потерянных элемнтов =" + cklist.size());
       return cklist;
    }
}
