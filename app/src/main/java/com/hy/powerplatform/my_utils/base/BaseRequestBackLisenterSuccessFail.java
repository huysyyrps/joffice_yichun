package com.hy.powerplatform.my_utils.base;

/**
 * Created by dell on 2017/4/20.
 */

public interface BaseRequestBackLisenterSuccessFail<T>{
    void success(T t);
    void fail(T t);
    void fail(String message);
}


