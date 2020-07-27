package lines.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class QueueStorage {
    private static final ConcurrentHashMap queueMap = new ConcurrentHashMap();

    public static <ParamKey, ParamValue> void addItem(ParamKey key, ParamValue paramValue ){
        log.info("Added Item : {}", paramValue);
        queueMap.put(key, paramValue);
    }

    public static List deQueue(){
        List<Object> queueList = new ArrayList<>();

        queueMap.keySet()
                .forEach(item -> {
                    queueList.add(queueMap.get(item));

                    queueMap.remove(item);
                });

        return queueList;
    }

    public static <ParamKey, ParamValue> ParamValue getItem(ParamKey paramKey){

        ParamValue paramValue = (ParamValue)queueMap.get(paramKey);

        log.info("Got Item : {}", paramValue);

        queueMap.remove(paramKey);

        return paramValue;
    }
}
