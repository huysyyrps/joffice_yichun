package com.hy.powerplatform.car_maintain.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/22.
 */

public class WeiXiuChang implements Serializable {

    /**
     * success : true
     * data : [{"version":null,"orgId":null,"orgPath":null,"dicId":1197,"itemName":"维修厂","itemValue":"总站维修厂","descp":"","sn":1,"globalType":{"version":null,"orgId":null,"orgPath":null,"proTypeId":3537,"typeName":"维修厂","path":"0.3527.3537.","depth":2,"parentId":3527,"nodeKey":"weixiuchang","catKey":"DIC","sn":99,"userId":1,"code":null,"useTime":null,"usePrice":null,"wxfl":1},"proTypeId":null},{"version":null,"orgId":null,"orgPath":null,"dicId":1198,"itemName":"维修厂","itemValue":"枢纽站维修厂","descp":"","sn":2,"globalType":{"version":null,"orgId":null,"orgPath":null,"proTypeId":3537,"typeName":"维修厂","path":"0.3527.3537.","depth":2,"parentId":3527,"nodeKey":"weixiuchang","catKey":"DIC","sn":99,"userId":1,"code":null,"useTime":null,"usePrice":null,"wxfl":1},"proTypeId":null}]
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * dicId : 1197
         * itemName : 维修厂
         * itemValue : 总站维修厂
         * descp :
         * sn : 1
         * globalType : {"version":null,"orgId":null,"orgPath":null,"proTypeId":3537,"typeName":"维修厂","path":"0.3527.3537.","depth":2,"parentId":3527,"nodeKey":"weixiuchang","catKey":"DIC","sn":99,"userId":1,"code":null,"useTime":null,"usePrice":null,"wxfl":1}
         * proTypeId : null
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int dicId;
        private String itemName;
        private String itemValue;
        private String descp;
        private int sn;
        private GlobalTypeBean globalType;
        private Object proTypeId;

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }

        public Object getOrgId() {
            return orgId;
        }

        public void setOrgId(Object orgId) {
            this.orgId = orgId;
        }

        public Object getOrgPath() {
            return orgPath;
        }

        public void setOrgPath(Object orgPath) {
            this.orgPath = orgPath;
        }

        public int getDicId() {
            return dicId;
        }

        public void setDicId(int dicId) {
            this.dicId = dicId;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemValue() {
            return itemValue;
        }

        public void setItemValue(String itemValue) {
            this.itemValue = itemValue;
        }

        public String getDescp() {
            return descp;
        }

        public void setDescp(String descp) {
            this.descp = descp;
        }

        public int getSn() {
            return sn;
        }

        public void setSn(int sn) {
            this.sn = sn;
        }

        public GlobalTypeBean getGlobalType() {
            return globalType;
        }

        public void setGlobalType(GlobalTypeBean globalType) {
            this.globalType = globalType;
        }

        public Object getProTypeId() {
            return proTypeId;
        }

        public void setProTypeId(Object proTypeId) {
            this.proTypeId = proTypeId;
        }

        public static class GlobalTypeBean implements Serializable {
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * proTypeId : 3537
             * typeName : 维修厂
             * path : 0.3527.3537.
             * depth : 2
             * parentId : 3527
             * nodeKey : weixiuchang
             * catKey : DIC
             * sn : 99
             * userId : 1
             * code : null
             * useTime : null
             * usePrice : null
             * wxfl : 1
             */

            private Object version;
            private Object orgId;
            private Object orgPath;
            private int proTypeId;
            private String typeName;
            private String path;
            private int depth;
            private int parentId;
            private String nodeKey;
            private String catKey;
            private int sn;
            private int userId;
            private Object code;
            private Object useTime;
            private Object usePrice;
            private int wxfl;

            public Object getVersion() {
                return version;
            }

            public void setVersion(Object version) {
                this.version = version;
            }

            public Object getOrgId() {
                return orgId;
            }

            public void setOrgId(Object orgId) {
                this.orgId = orgId;
            }

            public Object getOrgPath() {
                return orgPath;
            }

            public void setOrgPath(Object orgPath) {
                this.orgPath = orgPath;
            }

            public int getProTypeId() {
                return proTypeId;
            }

            public void setProTypeId(int proTypeId) {
                this.proTypeId = proTypeId;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public int getDepth() {
                return depth;
            }

            public void setDepth(int depth) {
                this.depth = depth;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getNodeKey() {
                return nodeKey;
            }

            public void setNodeKey(String nodeKey) {
                this.nodeKey = nodeKey;
            }

            public String getCatKey() {
                return catKey;
            }

            public void setCatKey(String catKey) {
                this.catKey = catKey;
            }

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public Object getCode() {
                return code;
            }

            public void setCode(Object code) {
                this.code = code;
            }

            public Object getUseTime() {
                return useTime;
            }

            public void setUseTime(Object useTime) {
                this.useTime = useTime;
            }

            public Object getUsePrice() {
                return usePrice;
            }

            public void setUsePrice(Object usePrice) {
                this.usePrice = usePrice;
            }

            public int getWxfl() {
                return wxfl;
            }

            public void setWxfl(int wxfl) {
                this.wxfl = wxfl;
            }
        }
    }
}
