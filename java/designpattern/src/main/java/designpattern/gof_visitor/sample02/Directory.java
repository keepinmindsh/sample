package designpattern.gof_visitor.sample02;

public class Directory extends Entry {
    @Override
    public void Accept(IVisitor iVisitor) {
        iVisitor.Visit(this);
    }
}
