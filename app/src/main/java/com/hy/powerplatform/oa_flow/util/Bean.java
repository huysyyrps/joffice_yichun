package com.hy.powerplatform.oa_flow.util;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/3/18.
 */

public class Bean implements Serializable {
    public int i;
    public boolean bool;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
}
