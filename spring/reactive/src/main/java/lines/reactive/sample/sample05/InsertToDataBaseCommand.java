package lines.reactive.sample.sample05;

import java.util.List;
import java.util.Optional;

public class InsertToDataBaseCommand implements Command {

    private final List<Integer> integerList;

    public InsertToDataBaseCommand(List<Integer> listInteger){
        integerList = listInteger;
    }

    @Override
    public void work() {
        Optional<Integer> sum = integerList.stream().reduce(Integer::sum);

        System.out.println(Thread.currentThread().getName() +  " Final Result : " + sum);
        System.out.println(Thread.currentThread().getName()  + " " + Counter.incrementAndGet());

    }
}
