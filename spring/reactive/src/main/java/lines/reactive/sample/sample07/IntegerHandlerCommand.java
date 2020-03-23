package lines.reactive.sample.sample07;

import java.util.List;
import java.util.Optional;

public class IntegerHandlerCommand implements Command {

    private Optional<Integer> optionalInteger;

    public IntegerHandlerCommand(List<Integer> integerList){

        Counter.addAndGet();

        this.optionalInteger = integerList.stream().reduce(Integer::sum);
    }

    @Override
    public int getTotal() {
        return this.optionalInteger.orElse(0);
    }

    @Override
    public boolean isMinus() {
        return this.optionalInteger.orElse(0) < 0;
    }
}
