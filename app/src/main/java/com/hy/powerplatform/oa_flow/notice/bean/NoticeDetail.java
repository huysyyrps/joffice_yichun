package com.hy.powerplatform.oa_flow.notice.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/3/5.
 */

public class NoticeDetail implements Serializable {

    /**
     * success : true
     * data : {"version":null,"orgId":null,"orgPath":null,"newsId":10286,"subjectIcon":"","subject":"测试何时发出","author":"超级管理员","createtime":"2020-02-28","expTime":null,"replyCounts":0,"viewCounts":1,"issuer":"超级管理员","content":"关于推荐2019年度宜春市五一巾帼标兵人选的通知集团各部门、生产单位：根据《关于评选2019年度宜春市五一巾帼标兵岗、标兵、女创业带头人的通知》文件要求，请各部门、生产单位根据五一巾帼标兵的推选范围和条件做好人选推荐工作，于3月12日前将推荐材料（推荐表和重点事迹）报送至党群部。附件：《关于评选2019年度宜春市五一巾帼标兵岗、标兵、女创业带头人的通知》宜春公交集团有限公司工会委员会2020年3月5日","updateTime":"2020-02-28","status":0,"isDeskImage":null,"isNotice":1,"sn":null,"orgIds":"495,496,499,500,501,502,503,504,505,506,507,508,509,510,512,514,518,519,520,521,522,523","orgNames":"党群工作部,综合管理部,人力资源部,信息技术部,财务部,大为物业公司,采购供应部,乐途公司,营运一分公司,营运二分公司,枢纽分公司,修理厂,广告公司,出租车公司,领导班子,宜春市春城通科技有限公司,顺通客运服务有限公司,监察审计部,企业发展部,宣传教育部,充电公司,安全运营部","userIds":"","userNames":"","depIds":"","section":{"version":null,"orgId":null,"orgPath":null,"sectionId":11,"sectionName":"公告","sectionDesc":"","createtime":"2016-07-15","sectionType":1,"username":"超级管理员","userId":1,"colNumber":1,"rowNumber":4,"status":1},"fileId":"0","fileName":"","readPersons":"9389,9354,","readCount":2,"filePath":"","depId":"378","depName":"宜春公交集团有限公司","readtimes":"9389,2020-02-29 14:06:10|9354,2020-03-03 14:00:33|","readUserids":"9389,1,9354,","sectionId":11}
     */

    private boolean success;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * newsId : 10286
         * subjectIcon :
         * subject : 测试何时发出
         * author : 超级管理员
         * createtime : 2020-02-28
         * expTime : null
         * replyCounts : 0
         * viewCounts : 1
         * issuer : 超级管理员
         * content : 关于推荐2019年度宜春市五一巾帼标兵人选的通知集团各部门、生产单位：根据《关于评选2019年度宜春市五一巾帼标兵岗、标兵、女创业带头人的通知》文件要求，请各部门、生产单位根据五一巾帼标兵的推选范围和条件做好人选推荐工作，于3月12日前将推荐材料（推荐表和重点事迹）报送至党群部。附件：《关于评选2019年度宜春市五一巾帼标兵岗、标兵、女创业带头人的通知》宜春公交集团有限公司工会委员会2020年3月5日
         * updateTime : 2020-02-28
         * status : 0
         * isDeskImage : null
         * isNotice : 1
         * sn : null
         * orgIds : 495,496,499,500,501,502,503,504,505,506,507,508,509,510,512,514,518,519,520,521,522,523
         * orgNames : 党群工作部,综合管理部,人力资源部,信息技术部,财务部,大为物业公司,采购供应部,乐途公司,营运一分公司,营运二分公司,枢纽分公司,修理厂,广告公司,出租车公司,领导班子,宜春市春城通科技有限公司,顺通客运服务有限公司,监察审计部,企业发展部,宣传教育部,充电公司,安全运营部
         * userIds :
         * userNames :
         * depIds :
         * section : {"version":null,"orgId":null,"orgPath":null,"sectionId":11,"sectionName":"公告","sectionDesc":"","createtime":"2016-07-15","sectionType":1,"username":"超级管理员","userId":1,"colNumber":1,"rowNumber":4,"status":1}
         * fileId : 0
         * fileName :
         * readPersons : 9389,9354,
         * readCount : 2
         * filePath :
         * depId : 378
         * depName : 宜春公交集团有限公司
         * readtimes : 9389,2020-02-29 14:06:10|9354,2020-03-03 14:00:33|
         * readUserids : 9389,1,9354,
         * sectionId : 11
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int newsId;
        private String subjectIcon;
        private String subject;
        private String author;
        private String createtime;
        private Object expTime;
        private int replyCounts;
        private int viewCounts;
        private String issuer;
        private String content;
        private String updateTime;
        private int status;
        private Object isDeskImage;
        private int isNotice;
        private Object sn;
        private String orgIds;
        private String orgNames;
        private String userIds;
        private String userNames;
        private String depIds;
        private SectionBean section;
        private String fileId;
        private String fileName;
        private String readPersons;
        private int readCount;
        private String filePath;
        private String depId;
        private String depName;
        private String readtimes;
        private String readUserids;
        private int sectionId;

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

        public int getNewsId() {
            return newsId;
        }

        public void setNewsId(int newsId) {
            this.newsId = newsId;
        }

        public String getSubjectIcon() {
            return subjectIcon;
        }

        public void setSubjectIcon(String subjectIcon) {
            this.subjectIcon = subjectIcon;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getExpTime() {
            return expTime;
        }

        public void setExpTime(Object expTime) {
            this.expTime = expTime;
        }

        public int getReplyCounts() {
            return replyCounts;
        }

        public void setReplyCounts(int replyCounts) {
            this.replyCounts = replyCounts;
        }

        public int getViewCounts() {
            return viewCounts;
        }

        public void setViewCounts(int viewCounts) {
            this.viewCounts = viewCounts;
        }

        public String getIssuer() {
            return issuer;
        }

        public void setIssuer(String issuer) {
            this.issuer = issuer;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getIsDeskImage() {
            return isDeskImage;
        }

        public void setIsDeskImage(Object isDeskImage) {
            this.isDeskImage = isDeskImage;
        }

        public int getIsNotice() {
            return isNotice;
        }

        public void setIsNotice(int isNotice) {
            this.isNotice = isNotice;
        }

        public Object getSn() {
            return sn;
        }

        public void setSn(Object sn) {
            this.sn = sn;
        }

        public String getOrgIds() {
            return orgIds;
        }

        public void setOrgIds(String orgIds) {
            this.orgIds = orgIds;
        }

        public String getOrgNames() {
            return orgNames;
        }

        public void setOrgNames(String orgNames) {
            this.orgNames = orgNames;
        }

        public String getUserIds() {
            return userIds;
        }

        public void setUserIds(String userIds) {
            this.userIds = userIds;
        }

        public String getUserNames() {
            return userNames;
        }

        public void setUserNames(String userNames) {
            this.userNames = userNames;
        }

        public String getDepIds() {
            return depIds;
        }

        public void setDepIds(String depIds) {
            this.depIds = depIds;
        }

        public SectionBean getSection() {
            return section;
        }

        public void setSection(SectionBean section) {
            this.section = section;
        }

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getReadPersons() {
            return readPersons;
        }

        public void setReadPersons(String readPersons) {
            this.readPersons = readPersons;
        }

        public int getReadCount() {
            return readCount;
        }

        public void setReadCount(int readCount) {
            this.readCount = readCount;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getDepId() {
            return depId;
        }

        public void setDepId(String depId) {
            this.depId = depId;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public String getReadtimes() {
            return readtimes;
        }

        public void setReadtimes(String readtimes) {
            this.readtimes = readtimes;
        }

        public String getReadUserids() {
            return readUserids;
        }

        public void setReadUserids(String readUserids) {
            this.readUserids = readUserids;
        }

        public int getSectionId() {
            return sectionId;
        }

        public void setSectionId(int sectionId) {
            this.sectionId = sectionId;
        }

        public static class SectionBean implements Serializable {
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * sectionId : 11
             * sectionName : 公告
             * sectionDesc :
             * createtime : 2016-07-15
             * sectionType : 1
             * username : 超级管理员
             * userId : 1
             * colNumber : 1
             * rowNumber : 4
             * status : 1
             */

            private Object version;
            private Object orgId;
            private Object orgPath;
            private int sectionId;
            private String sectionName;
            private String sectionDesc;
            private String createtime;
            private int sectionType;
            private String username;
            private int userId;
            private int colNumber;
            private int rowNumber;
            private int status;

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

            public int getSectionId() {
                return sectionId;
            }

            public void setSectionId(int sectionId) {
                this.sectionId = sectionId;
            }

            public String getSectionName() {
                return sectionName;
            }

            public void setSectionName(String sectionName) {
                this.sectionName = sectionName;
            }

            public String getSectionDesc() {
                return sectionDesc;
            }

            public void setSectionDesc(String sectionDesc) {
                this.sectionDesc = sectionDesc;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public int getSectionType() {
                return sectionType;
            }

            public void setSectionType(int sectionType) {
                this.sectionType = sectionType;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getColNumber() {
                return colNumber;
            }

            public void setColNumber(int colNumber) {
                this.colNumber = colNumber;
            }

            public int getRowNumber() {
                return rowNumber;
            }

            public void setRowNumber(int rowNumber) {
                this.rowNumber = rowNumber;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
