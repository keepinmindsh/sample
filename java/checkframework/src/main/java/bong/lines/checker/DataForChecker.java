package bong.lines.checker;

import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.NonNull;

@Builder
@Getter
public class DataForChecker {
    private final @NonNull String name1;
    private final @NonNull String name2;
    private final @NonNull String name3;

}
