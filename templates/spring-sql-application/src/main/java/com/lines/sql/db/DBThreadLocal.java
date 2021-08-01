package com.lines.sql.db;

public class DBThreadLocal {
	 private static final ThreadLocal<String> threadLocal;

    static {
        threadLocal = new ThreadLocal<>();
    }

    public static void set(String systemId) {
        threadLocal.set(systemId);
    }

    public static void unset() {
        threadLocal.remove();
    }

    public static String get() {
        return threadLocal.get();
    }
}
