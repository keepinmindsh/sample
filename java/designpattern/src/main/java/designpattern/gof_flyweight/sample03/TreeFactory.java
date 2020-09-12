package designpattern.gof_flyweight.sample03;

import designpattern.gof_flyweight.sample03.model.Position;

public class TreeFactory {

    private static final TreeModel sharedTreeModel = new TreeModel();

    static public Tree create(Position position, double height, double thickness){
        return Tree.builder()
                .position(position)
                .height(height)
                .treeModel(sharedTreeModel)
                .thickness(thickness).build();
    }
}
