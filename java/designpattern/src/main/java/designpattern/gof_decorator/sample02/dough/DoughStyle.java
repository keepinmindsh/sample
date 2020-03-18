package designpattern.gof_decorator.sample02.dough;

public class DoughStyle {
    private String doughName;

    public DoughStyle(String doughName){
        this.doughName = doughName;
    }

    @Override
    public String toString(){
        return doughName;
    }
}
