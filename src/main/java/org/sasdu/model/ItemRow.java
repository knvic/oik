package org.sasdu.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Cell;

@Getter
@Setter
public class ItemRow {
    public Integer id;
    public String name;
    public String type;
    public String time;
    public Integer value;
    public String code;
    public String par;
    public Integer id_ck11;

    public ItemRow() {
    }

    public ItemRow(Integer id, String name, String type, String time, Integer value, String code, String par, Integer id_ck11) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.time = time;
        this.value = value;
        this.code = code;
        this.par = par;
        this.id_ck11 = id_ck11;
    }
    public ItemRow(Integer id, String name, String type, String time, Integer value, String code) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.time = time;
        this.value = value;
        this.code = code;

    }

}
