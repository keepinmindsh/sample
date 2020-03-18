package designpattern.gof_composite.sample001;

import java.util.ArrayList;
import java.util.List;

public class RecordHandler extends RecorderType {

    private final List<RecorderType> children = new ArrayList<>();

    private final StringBuilder strBuilder = new StringBuilder();

    @Override
    public String speak(int level) {
        for (RecorderType record : children) {

            String tab = " ";

            for (int i = 0; i < level; i++) {
                tab += "<>";
            }

            strBuilder.append(tab + record.speak(level));
        }

        return strBuilder.toString();
    }

    @Override
    public void add(RecorderType record) {
        children.add(record);
    }

    @Override
    public void remove(RecorderType record) {
        children.remove(record);
    }

    @Override
    public RecorderType getRecord(int index) {
        return children.get(index);
    }

}
