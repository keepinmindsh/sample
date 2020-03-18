package designpattern.gof_visitor.sample02;

public abstract class Entry implements IElement {

    public Entry Add(Entry entry) throws Exception {
        throw new Exception("FileTreatmentException");
    }
}
