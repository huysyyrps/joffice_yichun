package com.hy.powerplatform.comper.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/7/3.
 */

public class ShengChangYYBig implements Serializable {

    /**
     * success : true
     * totalCounts : 3
     * result : [{"type":"09经营情况","name":"总收入","bqnum":0,"tqnum":0,"bhnum":0,"mbnum":"0","wcb":0},{"type":"09经营情况","name":"总成本","bqnum":0,"tqnum":0,"bhnum":0,"mbnum":"0","wcb":0},{"type":"09经营情况","name":"客运量","bqnum":812194,"tqnum":3821400.48,"bhnum":-3009206.48,"mbnum":"0","wcb":0}]
     */

    private boolean success;
    private int totalCounts;
    private List<ResultBean> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable  {
        /**
         * type : 09经营情况
         * name : 总收入
         * bqnum : 0.0
         * tqnum : 0.0
         * bhnum : 0.0
         * mbnum : 0
         * wcb : 0.0
         */

        private String type;
        private String name;
        private String bqnum;
        private String tqnum;
        private String bhnum;
        private String mbnum;
        private String wcb;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBqnum() {
            return bqnum;
        }

        public void setBqnum(String bqnum) {
            this.bqnum = bqnum;
        }

        public String getTqnum() {
            return tqnum;
        }

        public void setTqnum(String tqnum) {
            this.tqnum = tqnum;
        }

        public String getBhnum() {
            return bhnum;
        }

        public void setBhnum(String bhnum) {
            this.bhnum = bhnum;
        }

        public String getMbnum() {
            return mbnum;
        }

        public void setMbnum(String mbnum) {
            this.mbnum = mbnum;
        }

        public String getWcb() {
            return wcb;
        }

        public void setWcb(String wcb) {
            this.wcb = wcb;
        }
    }
}
