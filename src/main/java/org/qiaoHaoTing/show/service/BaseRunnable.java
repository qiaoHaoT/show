package org.qiaoHaoTing.show.service;

public abstract class BaseRunnable implements Runnable {

    @Override
    public void run() {
        try {
            task();
        } finally {
            ThreadLocalManger.clear();
        }
    }

    public void setArg(String key, String value) {
        ThreadLocalManger.setValue(key, value);
    }

    public Object getArg(String key) {
        return ThreadLocalManger.getValue(key);
    }

    public abstract void task();
}
