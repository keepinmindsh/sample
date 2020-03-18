package designpattern.gof_visitor.sample02;


public interface IVisitor {

    void Visit(File file);
    void Visit(Directory directory);
}
