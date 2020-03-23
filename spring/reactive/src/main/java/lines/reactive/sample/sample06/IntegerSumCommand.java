package lines.reactive.sample.sample06;

import java.util.List;
import java.util.Optional;

public class IntegerSumCommand implements Command {

    private final List<Integer> integerList;

    public IntegerSumCommand(List<Integer> integerList){
        this.integerList = integerList;
    }

    @Override
    public void work() {
        Optional<Integer> optionalInteger =
                integerList.stream().reduce(Integer::sum);

        System.out.println( Thread.currentThread().getName() + " " + optionalInteger.get());
        System.out.println( Thread.currentThread().getName() + " " + Counter.addAndGet());
    }
}
