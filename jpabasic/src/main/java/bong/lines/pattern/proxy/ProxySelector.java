package bong.lines.pattern.proxy;

public class ProxySelector implements Selector {

    private final QuerySelector querySelector;
    private final Code code;

    public ProxySelector(QuerySelector querySelector, Code code) {
        this.querySelector = querySelector;
        this.code = code;
    }


    @Override
    public Object select() {

        // Transaction - Begin

        if(Code.LAZY == code){
            System.out.println("Loading 만 되었어!");
        }else{
            this.querySelector.select();
        }

        // Transaction - Commit

        // Transaction - Rollback

        // Transaction - Close

        return null;
    }
}
