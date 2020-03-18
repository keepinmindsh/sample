package designpattern.gof_composite.sample002;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    public List<Component> children = new ArrayList<>();

    public void Operation() {
        for (Component component : children) {
            component.Operation();
        }
    }

    public void Add(Component component) {
        children.add(component);
    }

    public void Remove(Component component) {
        children.remove(component);
    }

    public void GetChild(int index) {
        children.get(index);
    }
}
