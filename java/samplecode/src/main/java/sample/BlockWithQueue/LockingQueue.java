package sample.BlockWithQueue;

import java.util.concurrent.ConcurrentHashMap;

public class LockingQueue {
    public final static ConcurrentHashMap<String, Boolean> lockedMap = new ConcurrentHashMap<>();

    public static synchronized void insertToQueue(String insertFlag) {
        lockedMap.putIfAbsent(insertFlag, true);
    }

    public static synchronized boolean checkIfabsent(String insertFlag) {
        if(lockedMap.containsKey(insertFlag)){
            return false;
        }else {
            return true;
        }
    }

    public static synchronized void removeQueue(String insertFlag) {
        lockedMap.remove(insertFlag);
    }
}
