package com.hy.powerplatform.login.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/3/31.
 */

public class FlowId implements Serializable {

    /**
     * success : true
     * data : [{"defId":"20377","formDefId":"10122","name":"ERP系统各部门需求调整"},{"defId":"20239","formDefId":"10082","name":"安全服务部投诉转办单"},{"defId":"10092","formDefId":"86","name":"办公用品采购申请单"},{"defId":"20224","formDefId":"10084","name":"保险费借款单商业险"},{"defId":"20225","formDefId":"10083","name":"保险费借款单意外险"},{"defId":"20307","formDefId":"10105","name":"报修项目登记表"},{"defId":"20263","formDefId":"10123","name":"测试"},{"defId":"20311","formDefId":"10077","name":"测试不同路径流程"},{"defId":"20290","formDefId":"83","name":"测试多人2019"},{"defId":"20291","formDefId":"83","name":"测试会签2019"},{"defId":"20396","formDefId":"10077","name":"测试勿动2"},{"defId":"20401","formDefId":"10077","name":"测试勿动4"},{"defId":"20292","formDefId":"10077","name":"测试一对多流程"},{"defId":"10150","formDefId":"60","name":"车辆保险费审批单"},{"defId":"20324","formDefId":"10125","name":"车载监控视频调阅审批"},{"defId":"20314","formDefId":"","name":"呈送文稿"},{"defId":"10149","formDefId":"67","name":"出差申请审批表"},{"defId":"10151","formDefId":"10078","name":"付款程序审批单"},{"defId":"20460","formDefId":"10128","name":"工会付款程序审批单"},{"defId":"20461","formDefId":"10129","name":"工会合同签订审批单"},{"defId":"20459","formDefId":"10127","name":"工会物品采购计划表"},{"defId":"20520","formDefId":"10134","name":"公司请示上报流程"},{"defId":"10094","formDefId":"10110","name":"公司信息发布审批单"},{"defId":"10106","formDefId":"73","name":"公司员工加班申请单"},{"defId":"10093","formDefId":"85","name":"合同付款审批单"},{"defId":"10165","formDefId":"66","name":"合同签订审批流程"},{"defId":"20264","formDefId":"10077","name":"会签测试流程"},{"defId":"20382","formDefId":"10124","name":"会签流程"},{"defId":"20302","formDefId":"10118","name":"驾驶员考核表"},{"defId":"20373","formDefId":"10121","name":"驾驶员考核评分表"},{"defId":"10105","formDefId":"10117","name":"驾驶员入职流程表"},{"defId":"20244","formDefId":"10109","name":"建设工程变更审批单"},{"defId":"20249","formDefId":"10108","name":"建设工程量增加审批单"},{"defId":"20226","formDefId":"10098","name":"交通事故费用借款审批单"},{"defId":"10152","formDefId":"62","name":"接待用餐审批表"},{"defId":"10135","formDefId":"83","name":"请假流程"},{"defId":"20321","formDefId":"10077","name":"请示上报流程"},{"defId":"10091","formDefId":"","name":"实习期驾驶员培训考核表"},{"defId":"10183","formDefId":"84","name":"物品采购计划表"},{"defId":"20271","formDefId":"10103","name":"物品采购计划表3000元以上"},{"defId":"20233","formDefId":"10107","name":"新建工程启动审批流程"},{"defId":"20411","formDefId":"10111","name":"信息技术部电子设备故障维修"},{"defId":"20316","formDefId":"10111","name":"信息技术部电子设备故障维修登记表"},{"defId":"20200","formDefId":"10076","name":"宜春公交集团发文"},{"defId":"10119","formDefId":"58","name":"宜春公交集团公司请假单（副总）"},{"defId":"20232","formDefId":"10087","name":"宜春公交集团项目申办表"},{"defId":"20533","formDefId":"10135","name":"员工入职流程"},{"defId":"20308","formDefId":"10104","name":"员工宿舍申请表"},{"defId":"10117","formDefId":"57","name":"中层领导请假单"},{"defId":"20504","formDefId":"10132","name":"子公司付款流程"},{"defId":"20274","formDefId":"10100","name":"子公司物品采购计划表"}]
     */

    public String success;
    public List<DataBean> data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
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
         * defId : 20377
         * formDefId : 10122
         * name : ERP系统各部门需求调整
         */

        public String defId;
        public String formDefId;
        public String name;

        public String getDefId() {
            return defId;
        }

        public void setDefId(String defId) {
            this.defId = defId;
        }

        public String getFormDefId() {
            return formDefId;
        }

        public void setFormDefId(String formDefId) {
            this.formDefId = formDefId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
