package designpattern.gof_flyweight.sample03;

import designpattern.gof_flyweight.sample03.model.Position;
import lombok.Builder;

@Builder
public class Tree {
    TreeModel treeModel; //공유할 객체

    Position position;

    double height;

    double thickness;
}
