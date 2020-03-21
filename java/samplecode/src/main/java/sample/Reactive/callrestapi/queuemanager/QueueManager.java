package sample.Reactive.callrestapi.queuemanager;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class QueueManager {

    private static final ConcurrentHashMap<String, BlockingQueue<HashMap<String, Object>>> blockingQueueConcurrentHashMap = new ConcurrentHashMap<>();

    public static void addQueue(String key, BlockingQueue<HashMap<String, Object>> queue){
        blockingQueueConcurrentHashMap.put(key, queue);
    }

    public static BlockingQueue<HashMap<String, Object>> getQueue(String key){
        return blockingQueueConcurrentHashMap.get(key);
    }
}
