package com.hy.powerplatform.my_utils.utils;

import android.util.ArrayMap;

import com.hy.powerplatform.my_utils.base.RxActionManager;

import java.util.Set;

import rx.Subscription;

/**
 * 单例模式管理RXJava请求
 *
 */

public class RxApiManager implements RxActionManager<Object> {

    private static RxApiManager sInstance = null;

    private ArrayMap<Object, Subscription> maps;

    public static RxApiManager get() {

        if (sInstance == null) {
            synchronized (RxApiManager.class) {
                if (sInstance == null) {
                    sInstance = new RxApiManager();
                }
            }
        }
        return sInstance;
    }
    private RxApiManager() {
        maps = new ArrayMap<>();
    }
    @Override
    public void add(Object tag, Subscription subscription) {
        maps.put(tag, subscription);
    }

    @Override
    public void remove(Object tag) {
        if (!maps.isEmpty()) {
            maps.remove(tag);
        }
    }
    public void removeAll() {
        if (!maps.isEmpty()) {
            maps.clear();
        }
    }
    @Override
    public void cancel(Object tag) {
        if (maps.isEmpty()) {
            return;
        }
        if (maps.get(tag) == null) {
            return;
        }
        if (!maps.get(tag).isUnsubscribed()) {
            maps.get(tag).isUnsubscribed();
            maps.remove(tag);
        }
    }
    @Override public void cancelAll() {
        if (maps.isEmpty()) {
            return;
        }
        Set<Object> keys = maps.keySet();
        for (Object apiKey : keys) {
            cancel(apiKey);
        }
    }
}
