package designpattern.gof_visitor.sample02;

public class File extends Entry {

    @Override
    public void Accept(IVisitor iVisitor) {
        iVisitor.Visit(this);
    }
}
