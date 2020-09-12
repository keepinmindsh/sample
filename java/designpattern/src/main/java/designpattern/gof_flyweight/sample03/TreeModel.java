package designpattern.gof_flyweight.sample03;

import designpattern.gof_flyweight.sample03.model.Mesh;
import designpattern.gof_flyweight.sample03.model.Texture;

public class TreeModel {
    Mesh mesh;
    Texture bark;
    Texture leaves;

    public TreeModel() {
        mesh = new Mesh();
        bark = new Texture("bark");
        leaves = new Texture("leaves");
    }

}
