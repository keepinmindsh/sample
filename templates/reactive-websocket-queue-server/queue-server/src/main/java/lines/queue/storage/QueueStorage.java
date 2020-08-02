package lines.queue.storage;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class QueueStorage {
    private static final ConcurrentHashMap queueMap = new ConcurrentHashMap();

    public static <ParamKey, ParamValue> void addItem(ParamKey key, ParamValue paramValue ){
        log.info("Added Item : {}", paramValue);
        queueMap.put(key, paramValue);
    }

    public static <ParamKey, ParamValue> ParamValue getItem(ParamKey paramKey){

        ParamValue paramValue = (ParamValue)queueMap.get(paramKey);

        log.info("Got Item : {}", paramValue);

        return paramValue;
    }
}
