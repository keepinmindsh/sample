package designpattern.gof_composite.sample001;

import java.util.ArrayList;
import java.util.List;

public class RecorderType {

    private final List<RecorderType> children = new ArrayList<>();

    private final StringBuilder strBuilder = new StringBuilder();

    public String speak(int level) {

        String tab = " ";

        int nextInt = children.size();
        int countInt = 0;

        ++level;

        for (int i = 0; i < level; i++) {
            tab += "<>";
        }

        for (RecorderType record : children) {

            ++countInt;

            // 폴더의 마지막 행
            if (nextInt == countInt) {
                tab = "";
            }

            // 폴더 내의 RecordHandler Array
            if (record instanceof RecordHandler) {
                tab = "";
            }

            strBuilder.append(tab + record.speak(level));


        }

        return strBuilder.toString();
    }

    public void add(RecorderType record) {
        children.add(record);
    }

    public void remove(RecorderType record) {
        children.remove(record);
    }

    public RecorderType getRecord(int index) {
        return children.get(index);
    }

}
