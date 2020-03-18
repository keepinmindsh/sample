package designpattern.gof_templateMethod.sample02;

import designpattern.gof_templateMethod.sample02.dbtemplate.DBTemplate;
import designpattern.gof_templateMethod.sample02.dbtemplate.OracleDB;

import java.util.List;
import java.util.Map;

public class Caller {

    public static void main(String[] args) {
        DBTemplate dbTemplate = new OracleDB();

        List<Map> resutList = (List<Map>)dbTemplate.execute("SELECT * FROM TB_ZZ_USER");

        resutList.forEach(value -> {
            System.out.println(value.get("USER_ID"));
        });
    }
}
