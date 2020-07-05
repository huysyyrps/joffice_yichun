package com.hy.powerplatform.login.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/7/5.
 */

public class RWSend implements Serializable {

    /**
     * success : true
     * isCheck : 19
     * isImplement : 76
     */

    private boolean success;
    private String isCheck;
    private String isImplement;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }

    public String getIsImplement() {
        return isImplement;
    }

    public void setIsImplement(String isImplement) {
        this.isImplement = isImplement;
    }
}
