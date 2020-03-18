package designpattern.gof_chainofresponsibility.sample02;

public abstract class SystemChecker {

    private SystemChecker checker;

    public SystemChecker setNext(SystemChecker checker){
        this.checker = checker;
        return checker;
    }

    public final void validator(String type){
        if(resolve(type)){
            done();
        }else if(checker != null){
            checker.validator(type);
        }else{
            System.out.println(type + "은 해결할 수 없었습니다.");
        }
    }

    public abstract boolean resolve(String type);
    public abstract void done();
}
