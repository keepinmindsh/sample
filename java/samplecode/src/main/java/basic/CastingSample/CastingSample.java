package basic.CastingSample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CastingSample {
    public static void main(String[] args) {

        float value1 = 100.0f;
        int value2 = (int)value1;

        log.info("Float Value : {}", value2);
    }
}
