package com.hy.powerplatform.comper.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/7/3.
 */

public class ShengChangYYSmall implements Serializable {

    /**
     * success : true
     * totalCounts : 21
     * result : [{"type":"01职工人数","name":"管理员","bqnum":147,"tqnum":137,"bhnum":10,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"驾驶员","bqnum":746,"tqnum":750,"bhnum":-4,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"修理工","bqnum":36,"tqnum":38,"bhnum":-2,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"12328人员","bqnum":9,"tqnum":9,"bhnum":0,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"洗车员","bqnum":0,"tqnum":0,"bhnum":0,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"站务员","bqnum":11,"tqnum":6,"bhnum":5,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"核算员","bqnum":0,"tqnum":0,"bhnum":0,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"充电员","bqnum":18,"tqnum":9,"bhnum":9,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"加油员","bqnum":1,"tqnum":1,"bhnum":0,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"质检员","bqnum":4,"tqnum":4,"bhnum":0,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"采购员","bqnum":1,"tqnum":1,"bhnum":0,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"调度员","bqnum":6,"tqnum":5,"bhnum":1,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"仓管员","bqnum":7,"tqnum":6,"bhnum":1,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"督导员","bqnum":13,"tqnum":9,"bhnum":4,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"结算员","bqnum":7,"tqnum":7,"bhnum":0,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"接箱员","bqnum":9,"tqnum":8,"bhnum":1,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"充值员","bqnum":7,"tqnum":7,"bhnum":0,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"安保员","bqnum":3,"tqnum":3,"bhnum":0,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"精品保洁员","bqnum":0,"tqnum":0,"bhnum":0,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"退休人员","bqnum":0,"tqnum":0,"bhnum":0,"mbnum":"0","wcb":0},{"type":"01职工人数","name":"其他","bqnum":10,"tqnum":7,"bhnum":3,"mbnum":"0","wcb":0}]
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

    public static class ResultBean  implements Serializable {
        /**
         * type : 01职工人数
         * name : 管理员
         * bqnum : 147.0
         * tqnum : 137.0
         * bhnum : 10.0
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
