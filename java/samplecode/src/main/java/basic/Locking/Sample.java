package basic.Locking;

import javax.naming.InsufficientResourcesException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {

    public static ExecutorService executorService = Executors.newFixedThreadPool(1000);

    public static void main(String[] args) throws InsufficientResourcesException {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    new Sample().tranferMoney(new Account(), new Account(), "100000");
                } catch (InsufficientResourcesException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static final Object tieLock = new Object();

    public void tranferMoney(final Account fromAcct, final Account toAcct, final String amount) throws InsufficientResourcesException {

        class Helper {
            public void tranfer() throws InsufficientResourcesException {
                if (fromAcct.getBalance().compareTo(amount) < 0) {
                    throw new InsufficientResourcesException();
                } else {
                    fromAcct.debit(amount);
                    toAcct.credit(amount);
                }
            }
        }

        int fromHash = System.identityHashCode(fromAcct);
        int toHash = System.identityHashCode(toAcct);

        if(fromHash < toHash) {
            synchronized (fromAcct){
                synchronized (toAcct){
                    new Helper().tranfer();
                }
            }
        }else if(fromHash > toHash){
            synchronized (toAcct){
                synchronized (fromAcct){
                    new Helper().tranfer();
                }
            }
        }else {
            synchronized (tieLock){
                synchronized (fromAcct){
                    synchronized (toAcct){
                        new Helper().tranfer();
                    }
                }
            }
        }


    }

}

class Account {

    public String getBalance(){
        return "5000";
    }

    public void debit(String amount){

    }

    public void credit(String amount){

    }
}


class DollarAmount{

}