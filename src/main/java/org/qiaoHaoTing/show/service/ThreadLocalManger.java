package org.qiaoHaoTing.show.service;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalManger<T> extends ThreadLocal<T> {

    private static ThreadLocalManger<Map<String, Object>> MANGER = new ThreadLocalManger<>();

    private static HashMap<String, Object> MANGER_MAP = new HashMap<>();

    public static void setValue(String key, Object value) {
        Map<String, Object> context = MANGER.get();
        if(context == null) {
            synchronized (MANGER_MAP) {
                if(context == null) {
                    context = new HashMap<>();
                    MANGER.set(context);
                }
            }
        }
        context.put(key, value);
    }

    public static Object getValue(String key) {
        Map<String, Object> context = MANGER.get();
        if(context != null) {
            return context.get(key);
        }
        return null;
    }

    public static void remove(String key) {
        Map<String, Object> context = MANGER.get();
        if(context != null) {
            context.remove(key);
        }
    }

    public static void clear() {
        Map<String, Object> context = MANGER.get();
        if(context != null) {
            context.clear();
        }
    }
}
