package com.hy.powerplatform.oa_flow.activity.newgoodpurchase.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/7/2.
 */

public class NewGoodOurchaseWillDetail implements Serializable {

    /**
     * success : true
     * taskId : 10780045
     * pkValue : 49
     * formRights : {'pifudanjia1':'1','iszc':'1','danjia1':'1','shuliang1':'1','cwzjyj':'1','fgldyj':'1','jineheji1':'1','bm':'1','bmfzryj':'2','caigoufenguanlingdao':'1','bumenyijian':'1','caigoubuyijian':'1','sqr':'1','jine1':'1','LiuShuiHao':'1','czgkbmyj':'1','mingcheng1':'1','pifudanjia2':'1','pifushuliang2':'1','caiwuzongjian':'1','yusuan_text':'1','pifu_text':'1','mingcheng2':'1','goodsType':'1','caiwubuyijian':'1','yusuan1':'1','danjia2':'1','zcgkbmyj':'1','pifujine1':'1','xgfj':'1','cwbyj':'1','jcbmyj':'1','cgbyj':'1','jine2':'1','guige1':'1','jineheji2':'1','pifumingcheng1':'1','yusuan2':'1','shuliangheji2':'1','yt':'1','zichanguikoubumenyijian':'1','pifushuliang1':'1','shuliangheji1':'1','bmfgldyj':'1','cgfgldyj':'1','pifujine4':'1','guige2':'1','shuliang2':'1','danjiaheji1':'1','zjlyj':'1','bumenfenguanlingdao':'1','yongtu':'1','sqrq':'1','zichanguikou':'1','cwbyij':'1','zongjingliyijian':'1','pifumingcheng2':'1'}
     * mainform : [{"jcbmyj":"","cwbyij":"","jineheji2":"","bumenyijian":"","danjiaheji1":"","mingcheng1":"测试","mingcheng2":"","cwbyj":"","zichanguikoubumenyijian":"","bumenfenguanlingdao":"","bm":"宜春公交集团有限公司","zongjingliyijian":"","iszc":"资产类","cgbyj":"","zcgkbmyj":"","caiwuzongjian":"","jine2":"","cwzjyj":"","jine1":"6.00","shuliangheji2":"","zichanguikou":"","shuliangheji1":"2.00","yusuan2":"","yusuan1":"1","bmfzryj":"","caiwubuyijian":"","LiuShuiHao":"","shuliang1":"2","xgfj":"","shuliang2":"","runId":53024,"caigoubuyijian":"","caigoufenguanlingdao":"","yongtu":"测试","pifudanjia2":"","pifudanjia1":"","mainId":49,"sqrq":"2020-07-02","pifujine1":"","pifu_text":"","pifujine4":"","goodsType":"房屋及建筑物","bmfgldyj":"","guige2":"","guige1":"个","sqr":"超级管理员","$type$":"WF_wupincaigoujihuaxin","pifumingcheng1":"","danjia2":"","pifumingcheng2":"","danjia1":"3","fgldyj":"","yusuan_text":"","yt":"","bmyj":"","czgkbmyj":"","zjlyj":"","cgfgldyj":"","pifushuliang1":"","pifushuliang2":"","jineheji1":"6.0","zcDepName":""}]
     * formDefId : 10137
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"财务部意见","name":"to 财务部意见","source":"部门负责人"}]
     * runId : 53024
     * revoke : false
     */

    private boolean success;
    private String taskId;
    private String pkValue;
    private String formRights;
    private String formDefId;
    private String preTaskName;
    private boolean isSignTask;
    private int runId;
    private boolean revoke;
    private List<MainformBean> mainform;
    private List<TransBean> trans;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getPkValue() {
        return pkValue;
    }

    public void setPkValue(String pkValue) {
        this.pkValue = pkValue;
    }

    public String getFormRights() {
        return formRights;
    }

    public void setFormRights(String formRights) {
        this.formRights = formRights;
    }

    public String getFormDefId() {
        return formDefId;
    }

    public void setFormDefId(String formDefId) {
        this.formDefId = formDefId;
    }

    public String getPreTaskName() {
        return preTaskName;
    }

    public void setPreTaskName(String preTaskName) {
        this.preTaskName = preTaskName;
    }

    public boolean isIsSignTask() {
        return isSignTask;
    }

    public void setIsSignTask(boolean isSignTask) {
        this.isSignTask = isSignTask;
    }

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }

    public boolean isRevoke() {
        return revoke;
    }

    public void setRevoke(boolean revoke) {
        this.revoke = revoke;
    }

    public List<MainformBean> getMainform() {
        return mainform;
    }

    public void setMainform(List<MainformBean> mainform) {
        this.mainform = mainform;
    }

    public List<TransBean> getTrans() {
        return trans;
    }

    public void setTrans(List<TransBean> trans) {
        this.trans = trans;
    }

    public static class MainformBean implements Serializable {
        /**
         * jcbmyj :
         * cwbyij :
         * jineheji2 :
         * bumenyijian :
         * danjiaheji1 :
         * mingcheng1 : 测试
         * mingcheng2 :
         * cwbyj :
         * zichanguikoubumenyijian :
         * bumenfenguanlingdao :
         * bm : 宜春公交集团有限公司
         * zongjingliyijian :
         * iszc : 资产类
         * cgbyj :
         * zcgkbmyj :
         * caiwuzongjian :
         * jine2 :
         * cwzjyj :
         * jine1 : 6.00
         * shuliangheji2 :
         * zichanguikou :
         * shuliangheji1 : 2.00
         * yusuan2 :
         * yusuan1 : 1
         * bmfzryj :
         * caiwubuyijian :
         * LiuShuiHao :
         * shuliang1 : 2
         * xgfj :
         * shuliang2 :
         * runId : 53024
         * caigoubuyijian :
         * caigoufenguanlingdao :
         * yongtu : 测试
         * pifudanjia2 :
         * pifudanjia1 :
         * mainId : 49
         * sqrq : 2020-07-02
         * pifujine1 :
         * pifu_text :
         * pifujine4 :
         * goodsType : 房屋及建筑物
         * bmfgldyj :
         * guige2 :
         * guige1 : 个
         * sqr : 超级管理员
         * $type$ : WF_wupincaigoujihuaxin
         * pifumingcheng1 :
         * danjia2 :
         * pifumingcheng2 :
         * danjia1 : 3
         * fgldyj :
         * yusuan_text :
         * yt :
         * bmyj :
         * czgkbmyj :
         * zjlyj :
         * cgfgldyj :
         * pifushuliang1 :
         * pifushuliang2 :
         * jineheji1 : 6.0
         * zcDepName :
         */

        private String jcbmyj;
        private String cwbyij;
        private String jineheji2;
        private String bumenyijian;
        private String danjiaheji1;
        private String mingcheng1;
        private String mingcheng2;
        private String mingcheng3;
        private String mingcheng4;
        private String mingcheng5;
        private String mingcheng6;
        private String mingcheng7;
        private String mingcheng8;
        private String mingcheng9;
        private String mingcheng10;
        private String cwbyj;
        private String zichanguikoubumenyijian;
        private String bumenfenguanlingdao;
        private String bm;
        private String zongjingliyijian;
        private String iszc;
        private String cgbyj;
        private String zcgkbmyj;
        private String caiwuzongjian;
        private String jine2;
        private String cwzjyj;
        private String jine1;
        private String jine3;
        private String jine4;
        private String jine5;
        private String jine6;
        private String jine7;
        private String jine8;
        private String jine9;
        private String jine10;
        private String shuliangheji2;
        private String zichanguikou;
        private String shuliangheji1;
        private String yusuan2;
        private String yusuan1;
        private String yusuan3;
        private String yusuan4;
        private String yusuan5;
        private String yusuan6;
        private String yusuan7;
        private String yusuan8;
        private String yusuan9;
        private String yusuan10;
        private String bmfzryj;
        private String caiwubuyijian;
        private String LiuShuiHao;
        private String shuliang1;
        private String shuliang3;
        private String shuliang4;
        private String shuliang5;
        private String shuliang6;
        private String shuliang7;
        private String shuliang8;
        private String shuliang9;
        private String shuliang10;
        private String xgfj;
        private String shuliang2;
        private String runId;
        private String caigoubuyijian;
        private String caigoufenguanlingdao;
        private String yongtu;
        private String pifudanjia2;
        private String pifudanjia1;
        private String pifudanjia3;
        private String pifudanjia4;
        private String pifudanjia5;
        private String pifudanjia6;
        private String pifudanjia7;
        private String pifudanjia8;
        private String pifudanjia9;
        private String pifudanjia10;
        private int mainId;
        private String sqrq;
        private String pifujine1;
        private String pifujine2;
        private String pifujine3;
        private String pifujine4;
        private String pifujine5;
        private String pifujine6;
        private String pifujine7;
        private String pifujine8;
        private String pifujine9;
        private String pifujine10;
        private String pifu_text;
        private String goodsType;
        private String bmfgldyj;
        private String guige10;
        private String guige9;
        private String guige8;
        private String guige7;
        private String guige6;
        private String guige5;
        private String guige4;
        private String guige3;
        private String guige2;
        private String guige1;
        private String sqr;
        private String $type$;
        private String pifumingcheng1;
        private String pifumingcheng3;
        private String pifumingcheng4;
        private String pifumingcheng5;
        private String pifumingcheng6;
        private String pifumingcheng7;
        private String pifumingcheng8;
        private String pifumingcheng9;
        private String pifumingcheng10;
        private String danjia2;
        private String pifumingcheng2;
        private String danjia1;
        private String danjia10;
        private String danjia3;
        private String danjia4;
        private String danjia5;
        private String danjia6;
        private String danjia7;
        private String danjia8;
        private String danjia9;
        private String fgldyj;
        private String yusuan_text;
        private String yt;
        private String bmyj;
        private String czgkbmyj;
        private String zjlyj;
        private String cgfgldyj;
        private String pifushuliang1;
        private String pifushuliang2;
        private String pifushuliang3;

        public String getMingcheng3() {
            return mingcheng3;
        }

        public void setMingcheng3(String mingcheng3) {
            this.mingcheng3 = mingcheng3;
        }

        public String getMingcheng4() {
            return mingcheng4;
        }

        public void setMingcheng4(String mingcheng4) {
            this.mingcheng4 = mingcheng4;
        }

        public String getMingcheng5() {
            return mingcheng5;
        }

        public void setMingcheng5(String mingcheng5) {
            this.mingcheng5 = mingcheng5;
        }

        public String getMingcheng6() {
            return mingcheng6;
        }

        public void setMingcheng6(String mingcheng6) {
            this.mingcheng6 = mingcheng6;
        }

        public String getMingcheng7() {
            return mingcheng7;
        }

        public void setMingcheng7(String mingcheng7) {
            this.mingcheng7 = mingcheng7;
        }

        public String getMingcheng8() {
            return mingcheng8;
        }

        public void setMingcheng8(String mingcheng8) {
            this.mingcheng8 = mingcheng8;
        }

        public String getMingcheng9() {
            return mingcheng9;
        }

        public void setMingcheng9(String mingcheng9) {
            this.mingcheng9 = mingcheng9;
        }

        public String getMingcheng10() {
            return mingcheng10;
        }

        public void setMingcheng10(String mingcheng10) {
            this.mingcheng10 = mingcheng10;
        }

        public String getJine3() {
            return jine3;
        }

        public void setJine3(String jine3) {
            this.jine3 = jine3;
        }

        public String getJine4() {
            return jine4;
        }

        public void setJine4(String jine4) {
            this.jine4 = jine4;
        }

        public String getJine5() {
            return jine5;
        }

        public void setJine5(String jine5) {
            this.jine5 = jine5;
        }

        public String getJine6() {
            return jine6;
        }

        public void setJine6(String jine6) {
            this.jine6 = jine6;
        }

        public String getJine7() {
            return jine7;
        }

        public void setJine7(String jine7) {
            this.jine7 = jine7;
        }

        public String getJine8() {
            return jine8;
        }

        public void setJine8(String jine8) {
            this.jine8 = jine8;
        }

        public String getJine9() {
            return jine9;
        }

        public void setJine9(String jine9) {
            this.jine9 = jine9;
        }

        public String getJine10() {
            return jine10;
        }

        public void setJine10(String jine10) {
            this.jine10 = jine10;
        }

        public String getYusuan3() {
            return yusuan3;
        }

        public void setYusuan3(String yusuan3) {
            this.yusuan3 = yusuan3;
        }

        public String getYusuan4() {
            return yusuan4;
        }

        public void setYusuan4(String yusuan4) {
            this.yusuan4 = yusuan4;
        }

        public String getYusuan5() {
            return yusuan5;
        }

        public void setYusuan5(String yusuan5) {
            this.yusuan5 = yusuan5;
        }

        public String getYusuan6() {
            return yusuan6;
        }

        public void setYusuan6(String yusuan6) {
            this.yusuan6 = yusuan6;
        }

        public String getYusuan7() {
            return yusuan7;
        }

        public void setYusuan7(String yusuan7) {
            this.yusuan7 = yusuan7;
        }

        public String getYusuan8() {
            return yusuan8;
        }

        public void setYusuan8(String yusuan8) {
            this.yusuan8 = yusuan8;
        }

        public String getYusuan9() {
            return yusuan9;
        }

        public void setYusuan9(String yusuan9) {
            this.yusuan9 = yusuan9;
        }

        public String getYusuan10() {
            return yusuan10;
        }

        public void setYusuan10(String yusuan10) {
            this.yusuan10 = yusuan10;
        }

        public String getShuliang3() {
            return shuliang3;
        }

        public void setShuliang3(String shuliang3) {
            this.shuliang3 = shuliang3;
        }

        public String getShuliang4() {
            return shuliang4;
        }

        public void setShuliang4(String shuliang4) {
            this.shuliang4 = shuliang4;
        }

        public String getShuliang5() {
            return shuliang5;
        }

        public void setShuliang5(String shuliang5) {
            this.shuliang5 = shuliang5;
        }

        public String getShuliang6() {
            return shuliang6;
        }

        public void setShuliang6(String shuliang6) {
            this.shuliang6 = shuliang6;
        }

        public String getShuliang7() {
            return shuliang7;
        }

        public void setShuliang7(String shuliang7) {
            this.shuliang7 = shuliang7;
        }

        public String getShuliang8() {
            return shuliang8;
        }

        public void setShuliang8(String shuliang8) {
            this.shuliang8 = shuliang8;
        }

        public String getShuliang9() {
            return shuliang9;
        }

        public void setShuliang9(String shuliang9) {
            this.shuliang9 = shuliang9;
        }

        public String getShuliang10() {
            return shuliang10;
        }

        public void setShuliang10(String shuliang10) {
            this.shuliang10 = shuliang10;
        }

        public void setRunId(String runId) {
            this.runId = runId;
        }

        public String getPifudanjia3() {
            return pifudanjia3;
        }

        public void setPifudanjia3(String pifudanjia3) {
            this.pifudanjia3 = pifudanjia3;
        }

        public String getPifudanjia4() {
            return pifudanjia4;
        }

        public void setPifudanjia4(String pifudanjia4) {
            this.pifudanjia4 = pifudanjia4;
        }

        public String getPifudanjia5() {
            return pifudanjia5;
        }

        public void setPifudanjia5(String pifudanjia5) {
            this.pifudanjia5 = pifudanjia5;
        }

        public String getPifudanjia6() {
            return pifudanjia6;
        }

        public void setPifudanjia6(String pifudanjia6) {
            this.pifudanjia6 = pifudanjia6;
        }

        public String getPifudanjia7() {
            return pifudanjia7;
        }

        public void setPifudanjia7(String pifudanjia7) {
            this.pifudanjia7 = pifudanjia7;
        }

        public String getPifudanjia8() {
            return pifudanjia8;
        }

        public void setPifudanjia8(String pifudanjia8) {
            this.pifudanjia8 = pifudanjia8;
        }

        public String getPifudanjia9() {
            return pifudanjia9;
        }

        public void setPifudanjia9(String pifudanjia9) {
            this.pifudanjia9 = pifudanjia9;
        }

        public String getPifudanjia10() {
            return pifudanjia10;
        }

        public void setPifudanjia10(String pifudanjia10) {
            this.pifudanjia10 = pifudanjia10;
        }

        public String getPifujine2() {
            return pifujine2;
        }

        public void setPifujine2(String pifujine2) {
            this.pifujine2 = pifujine2;
        }

        public String getPifujine3() {
            return pifujine3;
        }

        public void setPifujine3(String pifujine3) {
            this.pifujine3 = pifujine3;
        }

        public String getPifujine5() {
            return pifujine5;
        }

        public void setPifujine5(String pifujine5) {
            this.pifujine5 = pifujine5;
        }

        public String getPifujine6() {
            return pifujine6;
        }

        public void setPifujine6(String pifujine6) {
            this.pifujine6 = pifujine6;
        }

        public String getPifujine7() {
            return pifujine7;
        }

        public void setPifujine7(String pifujine7) {
            this.pifujine7 = pifujine7;
        }

        public String getPifujine8() {
            return pifujine8;
        }

        public void setPifujine8(String pifujine8) {
            this.pifujine8 = pifujine8;
        }

        public String getPifujine9() {
            return pifujine9;
        }

        public void setPifujine9(String pifujine9) {
            this.pifujine9 = pifujine9;
        }

        public String getPifujine10() {
            return pifujine10;
        }

        public void setPifujine10(String pifujine10) {
            this.pifujine10 = pifujine10;
        }

        public String getGuige10() {
            return guige10;
        }

        public void setGuige10(String guige10) {
            this.guige10 = guige10;
        }

        public String getGuige9() {
            return guige9;
        }

        public void setGuige9(String guige9) {
            this.guige9 = guige9;
        }

        public String getGuige8() {
            return guige8;
        }

        public void setGuige8(String guige8) {
            this.guige8 = guige8;
        }

        public String getGuige7() {
            return guige7;
        }

        public void setGuige7(String guige7) {
            this.guige7 = guige7;
        }

        public String getGuige6() {
            return guige6;
        }

        public void setGuige6(String guige6) {
            this.guige6 = guige6;
        }

        public String getGuige5() {
            return guige5;
        }

        public void setGuige5(String guige5) {
            this.guige5 = guige5;
        }

        public String getGuige4() {
            return guige4;
        }

        public void setGuige4(String guige4) {
            this.guige4 = guige4;
        }

        public String getGuige3() {
            return guige3;
        }

        public void setGuige3(String guige3) {
            this.guige3 = guige3;
        }

        public String getPifumingcheng3() {
            return pifumingcheng3;
        }

        public void setPifumingcheng3(String pifumingcheng3) {
            this.pifumingcheng3 = pifumingcheng3;
        }

        public String getPifumingcheng4() {
            return pifumingcheng4;
        }

        public void setPifumingcheng4(String pifumingcheng4) {
            this.pifumingcheng4 = pifumingcheng4;
        }

        public String getPifumingcheng5() {
            return pifumingcheng5;
        }

        public void setPifumingcheng5(String pifumingcheng5) {
            this.pifumingcheng5 = pifumingcheng5;
        }

        public String getPifumingcheng6() {
            return pifumingcheng6;
        }

        public void setPifumingcheng6(String pifumingcheng6) {
            this.pifumingcheng6 = pifumingcheng6;
        }

        public String getPifumingcheng7() {
            return pifumingcheng7;
        }

        public void setPifumingcheng7(String pifumingcheng7) {
            this.pifumingcheng7 = pifumingcheng7;
        }

        public String getPifumingcheng8() {
            return pifumingcheng8;
        }

        public void setPifumingcheng8(String pifumingcheng8) {
            this.pifumingcheng8 = pifumingcheng8;
        }

        public String getPifumingcheng9() {
            return pifumingcheng9;
        }

        public void setPifumingcheng9(String pifumingcheng9) {
            this.pifumingcheng9 = pifumingcheng9;
        }

        public String getPifumingcheng10() {
            return pifumingcheng10;
        }

        public void setPifumingcheng10(String pifumingcheng10) {
            this.pifumingcheng10 = pifumingcheng10;
        }

        public String getDanjia10() {
            return danjia10;
        }

        public void setDanjia10(String danjia10) {
            this.danjia10 = danjia10;
        }

        public String getDanjia3() {
            return danjia3;
        }

        public void setDanjia3(String danjia3) {
            this.danjia3 = danjia3;
        }

        public String getDanjia4() {
            return danjia4;
        }

        public void setDanjia4(String danjia4) {
            this.danjia4 = danjia4;
        }

        public String getDanjia5() {
            return danjia5;
        }

        public void setDanjia5(String danjia5) {
            this.danjia5 = danjia5;
        }

        public String getDanjia6() {
            return danjia6;
        }

        public void setDanjia6(String danjia6) {
            this.danjia6 = danjia6;
        }

        public String getDanjia7() {
            return danjia7;
        }

        public void setDanjia7(String danjia7) {
            this.danjia7 = danjia7;
        }

        public String getDanjia8() {
            return danjia8;
        }

        public void setDanjia8(String danjia8) {
            this.danjia8 = danjia8;
        }

        public String getDanjia9() {
            return danjia9;
        }

        public void setDanjia9(String danjia9) {
            this.danjia9 = danjia9;
        }

        public String getPifushuliang3() {
            return pifushuliang3;
        }

        public void setPifushuliang3(String pifushuliang3) {
            this.pifushuliang3 = pifushuliang3;
        }

        public String getPifushuliang4() {
            return pifushuliang4;
        }

        public void setPifushuliang4(String pifushuliang4) {
            this.pifushuliang4 = pifushuliang4;
        }

        public String getPifushuliang5() {
            return pifushuliang5;
        }

        public void setPifushuliang5(String pifushuliang5) {
            this.pifushuliang5 = pifushuliang5;
        }

        public String getPifushuliang6() {
            return pifushuliang6;
        }

        public void setPifushuliang6(String pifushuliang6) {
            this.pifushuliang6 = pifushuliang6;
        }

        public String getPifushuliang7() {
            return pifushuliang7;
        }

        public void setPifushuliang7(String pifushuliang7) {
            this.pifushuliang7 = pifushuliang7;
        }

        public String getPifushuliang8() {
            return pifushuliang8;
        }

        public void setPifushuliang8(String pifushuliang8) {
            this.pifushuliang8 = pifushuliang8;
        }

        public String getPifushuliang9() {
            return pifushuliang9;
        }

        public void setPifushuliang9(String pifushuliang9) {
            this.pifushuliang9 = pifushuliang9;
        }

        public String getPifushuliang10() {
            return pifushuliang10;
        }

        public void setPifushuliang10(String pifushuliang10) {
            this.pifushuliang10 = pifushuliang10;
        }

        private String pifushuliang4;
        private String pifushuliang5;
        private String pifushuliang6;
        private String pifushuliang7;
        private String pifushuliang8;
        private String pifushuliang9;
        private String pifushuliang10;
        private String jineheji1;
        private String zcDepName;

        public String getJcbmyj() {
            return jcbmyj;
        }

        public void setJcbmyj(String jcbmyj) {
            this.jcbmyj = jcbmyj;
        }

        public String getCwbyij() {
            return cwbyij;
        }

        public void setCwbyij(String cwbyij) {
            this.cwbyij = cwbyij;
        }

        public String getJineheji2() {
            return jineheji2;
        }

        public void setJineheji2(String jineheji2) {
            this.jineheji2 = jineheji2;
        }

        public String getBumenyijian() {
            return bumenyijian;
        }

        public void setBumenyijian(String bumenyijian) {
            this.bumenyijian = bumenyijian;
        }

        public String getDanjiaheji1() {
            return danjiaheji1;
        }

        public void setDanjiaheji1(String danjiaheji1) {
            this.danjiaheji1 = danjiaheji1;
        }

        public String getMingcheng1() {
            return mingcheng1;
        }

        public void setMingcheng1(String mingcheng1) {
            this.mingcheng1 = mingcheng1;
        }

        public String getMingcheng2() {
            return mingcheng2;
        }

        public void setMingcheng2(String mingcheng2) {
            this.mingcheng2 = mingcheng2;
        }

        public String getCwbyj() {
            return cwbyj;
        }

        public void setCwbyj(String cwbyj) {
            this.cwbyj = cwbyj;
        }

        public String getZichanguikoubumenyijian() {
            return zichanguikoubumenyijian;
        }

        public void setZichanguikoubumenyijian(String zichanguikoubumenyijian) {
            this.zichanguikoubumenyijian = zichanguikoubumenyijian;
        }

        public String getBumenfenguanlingdao() {
            return bumenfenguanlingdao;
        }

        public void setBumenfenguanlingdao(String bumenfenguanlingdao) {
            this.bumenfenguanlingdao = bumenfenguanlingdao;
        }

        public String getBm() {
            return bm;
        }

        public void setBm(String bm) {
            this.bm = bm;
        }

        public String getZongjingliyijian() {
            return zongjingliyijian;
        }

        public void setZongjingliyijian(String zongjingliyijian) {
            this.zongjingliyijian = zongjingliyijian;
        }

        public String getIszc() {
            return iszc;
        }

        public void setIszc(String iszc) {
            this.iszc = iszc;
        }

        public String getCgbyj() {
            return cgbyj;
        }

        public void setCgbyj(String cgbyj) {
            this.cgbyj = cgbyj;
        }

        public String getZcgkbmyj() {
            return zcgkbmyj;
        }

        public void setZcgkbmyj(String zcgkbmyj) {
            this.zcgkbmyj = zcgkbmyj;
        }

        public String getCaiwuzongjian() {
            return caiwuzongjian;
        }

        public void setCaiwuzongjian(String caiwuzongjian) {
            this.caiwuzongjian = caiwuzongjian;
        }

        public String getJine2() {
            return jine2;
        }

        public void setJine2(String jine2) {
            this.jine2 = jine2;
        }

        public String getCwzjyj() {
            return cwzjyj;
        }

        public void setCwzjyj(String cwzjyj) {
            this.cwzjyj = cwzjyj;
        }

        public String getJine1() {
            return jine1;
        }

        public void setJine1(String jine1) {
            this.jine1 = jine1;
        }

        public String getShuliangheji2() {
            return shuliangheji2;
        }

        public void setShuliangheji2(String shuliangheji2) {
            this.shuliangheji2 = shuliangheji2;
        }

        public String getZichanguikou() {
            return zichanguikou;
        }

        public void setZichanguikou(String zichanguikou) {
            this.zichanguikou = zichanguikou;
        }

        public String getShuliangheji1() {
            return shuliangheji1;
        }

        public void setShuliangheji1(String shuliangheji1) {
            this.shuliangheji1 = shuliangheji1;
        }

        public String getYusuan2() {
            return yusuan2;
        }

        public void setYusuan2(String yusuan2) {
            this.yusuan2 = yusuan2;
        }

        public String getYusuan1() {
            return yusuan1;
        }

        public void setYusuan1(String yusuan1) {
            this.yusuan1 = yusuan1;
        }

        public String getBmfzryj() {
            return bmfzryj;
        }

        public void setBmfzryj(String bmfzryj) {
            this.bmfzryj = bmfzryj;
        }

        public String getCaiwubuyijian() {
            return caiwubuyijian;
        }

        public void setCaiwubuyijian(String caiwubuyijian) {
            this.caiwubuyijian = caiwubuyijian;
        }

        public String getLiuShuiHao() {
            return LiuShuiHao;
        }

        public void setLiuShuiHao(String LiuShuiHao) {
            this.LiuShuiHao = LiuShuiHao;
        }

        public String getShuliang1() {
            return shuliang1;
        }

        public void setShuliang1(String shuliang1) {
            this.shuliang1 = shuliang1;
        }

        public String getXgfj() {
            return xgfj;
        }

        public void setXgfj(String xgfj) {
            this.xgfj = xgfj;
        }

        public String getShuliang2() {
            return shuliang2;
        }

        public void setShuliang2(String shuliang2) {
            this.shuliang2 = shuliang2;
        }

        public String getRunId() {
            return runId;
        }

        public String getCaigoubuyijian() {
            return caigoubuyijian;
        }

        public void setCaigoubuyijian(String caigoubuyijian) {
            this.caigoubuyijian = caigoubuyijian;
        }

        public String getCaigoufenguanlingdao() {
            return caigoufenguanlingdao;
        }

        public void setCaigoufenguanlingdao(String caigoufenguanlingdao) {
            this.caigoufenguanlingdao = caigoufenguanlingdao;
        }

        public String getYongtu() {
            return yongtu;
        }

        public void setYongtu(String yongtu) {
            this.yongtu = yongtu;
        }

        public String getPifudanjia2() {
            return pifudanjia2;
        }

        public void setPifudanjia2(String pifudanjia2) {
            this.pifudanjia2 = pifudanjia2;
        }

        public String getPifudanjia1() {
            return pifudanjia1;
        }

        public void setPifudanjia1(String pifudanjia1) {
            this.pifudanjia1 = pifudanjia1;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getSqrq() {
            return sqrq;
        }

        public void setSqrq(String sqrq) {
            this.sqrq = sqrq;
        }

        public String getPifujine1() {
            return pifujine1;
        }

        public void setPifujine1(String pifujine1) {
            this.pifujine1 = pifujine1;
        }

        public String getPifu_text() {
            return pifu_text;
        }

        public void setPifu_text(String pifu_text) {
            this.pifu_text = pifu_text;
        }

        public String getPifujine4() {
            return pifujine4;
        }

        public void setPifujine4(String pifujine4) {
            this.pifujine4 = pifujine4;
        }

        public String getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(String goodsType) {
            this.goodsType = goodsType;
        }

        public String getBmfgldyj() {
            return bmfgldyj;
        }

        public void setBmfgldyj(String bmfgldyj) {
            this.bmfgldyj = bmfgldyj;
        }

        public String getGuige2() {
            return guige2;
        }

        public void setGuige2(String guige2) {
            this.guige2 = guige2;
        }

        public String getGuige1() {
            return guige1;
        }

        public void setGuige1(String guige1) {
            this.guige1 = guige1;
        }

        public String getSqr() {
            return sqr;
        }

        public void setSqr(String sqr) {
            this.sqr = sqr;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getPifumingcheng1() {
            return pifumingcheng1;
        }

        public void setPifumingcheng1(String pifumingcheng1) {
            this.pifumingcheng1 = pifumingcheng1;
        }

        public String getDanjia2() {
            return danjia2;
        }

        public void setDanjia2(String danjia2) {
            this.danjia2 = danjia2;
        }

        public String getPifumingcheng2() {
            return pifumingcheng2;
        }

        public void setPifumingcheng2(String pifumingcheng2) {
            this.pifumingcheng2 = pifumingcheng2;
        }

        public String getDanjia1() {
            return danjia1;
        }

        public void setDanjia1(String danjia1) {
            this.danjia1 = danjia1;
        }

        public String getFgldyj() {
            return fgldyj;
        }

        public void setFgldyj(String fgldyj) {
            this.fgldyj = fgldyj;
        }

        public String getYusuan_text() {
            return yusuan_text;
        }

        public void setYusuan_text(String yusuan_text) {
            this.yusuan_text = yusuan_text;
        }

        public String getYt() {
            return yt;
        }

        public void setYt(String yt) {
            this.yt = yt;
        }

        public String getBmyj() {
            return bmyj;
        }

        public void setBmyj(String bmyj) {
            this.bmyj = bmyj;
        }

        public String getCzgkbmyj() {
            return czgkbmyj;
        }

        public void setCzgkbmyj(String czgkbmyj) {
            this.czgkbmyj = czgkbmyj;
        }

        public String getZjlyj() {
            return zjlyj;
        }

        public void setZjlyj(String zjlyj) {
            this.zjlyj = zjlyj;
        }

        public String getCgfgldyj() {
            return cgfgldyj;
        }

        public void setCgfgldyj(String cgfgldyj) {
            this.cgfgldyj = cgfgldyj;
        }

        public String getPifushuliang1() {
            return pifushuliang1;
        }

        public void setPifushuliang1(String pifushuliang1) {
            this.pifushuliang1 = pifushuliang1;
        }

        public String getPifushuliang2() {
            return pifushuliang2;
        }

        public void setPifushuliang2(String pifushuliang2) {
            this.pifushuliang2 = pifushuliang2;
        }

        public String getJineheji1() {
            return jineheji1;
        }

        public void setJineheji1(String jineheji1) {
            this.jineheji1 = jineheji1;
        }

        public String getZcDepName() {
            return zcDepName;
        }

        public void setZcDepName(String zcDepName) {
            this.zcDepName = zcDepName;
        }
    }

    public static class TransBean implements Serializable {
        /**
         * destType : task
         * destination : 财务部意见
         * name : to 财务部意见
         * source : 部门负责人
         */

        private String destType;
        private String destination;
        private String name;
        private String source;

        public String getDestType() {
            return destType;
        }

        public void setDestType(String destType) {
            this.destType = destType;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }
}
