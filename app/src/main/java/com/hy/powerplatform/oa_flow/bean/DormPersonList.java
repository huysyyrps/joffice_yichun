package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/3/10.
 */

public class DormPersonList implements Serializable {

    /**
     * success : true
     * totalCounts : 1209
     * result : [{"profileId":"41769","userCode":"3088","profileNo":"PN20200114113422-0649","isWork":"0","fullname":"李红兵","mnemonicCard":"LGB","idCard":"362201197002020615","position":"驾驶员","depName":"枢纽分公司","depId":"507","eCard":"","sex":"男","mobile":"13707957668","party":"群众","leaveDate":"","retirementDate":"","birthday":"1970-02-02 00:00:00.0","nowWorkDate":"2020-01-09 00:00:00.0","education":"","age":"50","address":"袁州区环城南路518号20栋405室"},{"profileId":"41770","userCode":"2607","profileNo":"PN20200114114522-0751","isWork":"0","fullname":"周建国","mnemonicCard":"ZJG","idCard":"362201199312162431","position":"驾驶员","depName":"营运一分公司","depId":"505","eCard":"","sex":"男","mobile":"18470517336","party":"群众","leaveDate":"","retirementDate":"","birthday":"1993-12-16 00:00:00.0","nowWorkDate":"2020-01-09 00:00:00.0","education":"","age":"27","address":"江西省宜春市袁州区柏木乡石井村官山组27号"},{"profileId":"41771","userCode":"2532","profileNo":"PN20200117170929-0611","isWork":"0","fullname":"唐荣","mnemonicCard":"TR","idCard":"362201198508100430","position":"驾驶员","depName":"营运二分公司","depId":"506","eCard":"","sex":"男","mobile":"18070559001","party":"群众","leaveDate":"","retirementDate":"","birthday":"1985-08-10 00:00:00.0","nowWorkDate":"2020-01-09 00:00:00.0","education":"","age":"35","address":"袁州区灵泉毛街东城社区店南路15号"},{"profileId":"41766","userCode":"3068","profileNo":"PN20200107150424-0654","isWork":"0","fullname":"易昕","mnemonicCard":"YX","idCard":"362201198708220453","position":"充电员","depName":"充电公司","depId":"522","eCard":"","sex":"男","mobile":"18070552224","party":"群众","leaveDate":"","retirementDate":"","birthday":"1987-08-22 00:00:00.0","nowWorkDate":"2019-12-20 00:00:00.0","education":"","age":"33","address":"江西省宜春市轴承厂宿舍"},{"profileId":"41767","userCode":"000001","profileNo":"PN20200107150644-0536","isWork":"0","fullname":"陈新芳","mnemonicCard":"CXF","idCard":"362201197601310817","position":"站台秩序维护员","depName":"安全运营部","depId":"523","eCard":"","sex":"男","mobile":"13437052118","party":"群众","leaveDate":"","retirementDate":"","birthday":"1976-01-31 00:00:00.0","nowWorkDate":"2019-12-20 00:00:00.0","education":"","age":"44","address":""},{"profileId":"41768","userCode":"3070","profileNo":"PN20200107150726-0624","isWork":"0","fullname":"王雨涛","mnemonicCard":"WYT","idCard":"362201198708283219","position":"站台秩序维护员","depName":"安全运营部","depId":"523","eCard":"","sex":"男","mobile":"15727588839","party":"群众","leaveDate":"","retirementDate":"","birthday":"1987-08-28 00:00:00.0","nowWorkDate":"2019-12-20 00:00:00.0","education":"","age":"33","address":"江西省宜春市袁州区洪塘镇庄溪村屯里组"},{"profileId":"41758","userCode":"3035","profileNo":"PN20191206164145-0215","isWork":"0","fullname":"洪焱","mnemonicCard":"HY","idCard":"362204199510076170","position":"驾驶员","depName":"枢纽分公司","depId":"507","eCard":"3035","sex":"男","mobile":"18162230572","party":"群众","leaveDate":"","retirementDate":"","birthday":"1995-10-07 00:00:00.0","nowWorkDate":"2019-12-06 00:00:00.0","education":"","age":"25","address":"江西省高安市龙潭镇洛城村洪阮自然村25号"},{"profileId":"41759","userCode":"3080","profileNo":"PN20191206164431-0746","isWork":"0","fullname":"李连生","mnemonicCard":"LLS","idCard":"360902197411132418","position":"驾驶员","depName":"营运一分公司","depId":"505","eCard":"3080","sex":"男","mobile":"15180527386","party":"群众","leaveDate":"","retirementDate":"","birthday":"1974-11-13 00:00:00.0","nowWorkDate":"2019-12-06 00:00:00.0","education":"","age":"46","address":"袁州区柏木乡双园村茶树下组1号"},{"profileId":"41760","userCode":"3078","profileNo":"PN20191206164625-0218","isWork":"0","fullname":"施坚洲","mnemonicCard":"SJZ","idCard":"362201198608200236","position":"驾驶员","depName":"营运一分公司","depId":"505","eCard":"3078","sex":"男","mobile":"18720608789","party":"群众","leaveDate":"","retirementDate":"","birthday":"1986-08-20 00:00:00.0","nowWorkDate":"2019-12-06 00:00:00.0","education":"","age":"34","address":"袁州区中山西路201号"},{"profileId":"41761","userCode":"3079","profileNo":"PN20191206165109-0254","isWork":"0","fullname":"刘安华","mnemonicCard":"LAH","idCard":"362201196810142210","position":"驾驶员","depName":"营运一分公司","depId":"505","eCard":"3079","sex":"男","mobile":"18907954989","party":"群众","leaveDate":"","retirementDate":"","birthday":"1968-10-14 00:00:00.0","nowWorkDate":"2019-12-06 00:00:00.0","education":"","age":"52","address":"袁州区芦村乡老立村冲口二组23号"},{"profileId":"41762","userCode":"3081","profileNo":"PN20191206165236-0636","isWork":"0","fullname":"张永红","mnemonicCard":"ZYG","idCard":"362201197703195418","position":"驾驶员","depName":"营运二分公司","depId":"506","eCard":"3081","sex":"男","mobile":"15179503218","party":"群众","leaveDate":"","retirementDate":"","birthday":"1977-03-19 00:00:00.0","nowWorkDate":"2019-12-06 00:00:00.0","education":"","age":"43","address":"江西省高安市新街镇新西路107号"},{"profileId":"41763","userCode":"3075","profileNo":"PN20191206165827-0480","isWork":"0","fullname":"曾新球","mnemonicCard":"ZXQ","idCard":"362201197009025814","position":"驾驶员","depName":"营运二分公司","depId":"506","eCard":"3075","sex":"男","mobile":"15770527565","party":"群众","leaveDate":"","retirementDate":"","birthday":"1970-09-02 00:00:00.0","nowWorkDate":"2019-12-06 00:00:00.0","education":"","age":"50","address":"江西省宜春市塔下路10号"},{"profileId":"41765","userCode":"3076","profileNo":"PN20200107150229-0629","isWork":"0","fullname":"张斌","mnemonicCard":"ZB","idCard":"362201197605140018","position":"充电员","depName":"充电公司","depId":"522","eCard":"","sex":"男","mobile":"198079566869","party":"群众","leaveDate":"","retirementDate":"","birthday":"1976-05-14 00:00:00.0","nowWorkDate":"2019-12-04 00:00:00.0","education":"","age":"44","address":"江西省宜春市袁州区重桂路75号"},{"profileId":"41754","userCode":"3072","profileNo":"PN20191206162136-0019","isWork":"0","fullname":"柳连辉","mnemonicCard":"LLH","idCard":"36220119780725403X","position":"驾驶员","depName":"枢纽分公司","depId":"507","eCard":"3072","sex":"男","mobile":"13755845119","party":"群众","leaveDate":"","retirementDate":"","birthday":"1978-07-25 00:00:00.0","nowWorkDate":"2019-12-03 00:00:00.0","education":"","age":"42","address":"袁州区天台镇流田村柳家冲组28号"},{"profileId":"41755","userCode":"3073","profileNo":"PN20191206162629-0875","isWork":"0","fullname":"袁六林","mnemonicCard":"YLL","idCard":"362201197307185015","position":"驾驶员","depName":"枢纽分公司","depId":"507","eCard":"3073","sex":"男","mobile":"13979570065","party":"群众","leaveDate":"","retirementDate":"","birthday":"1973-07-18 00:00:00.0","nowWorkDate":"2019-12-03 00:00:00.0","education":"","age":"47","address":"袁州区湖田乡林田村山塘尾村民小组17号"},{"profileId":"41756","userCode":"3052","profileNo":"PN20191206162813-0278","isWork":"0","fullname":"黄洋","mnemonicCard":"HY","idCard":"36220119790929303X","position":"驾驶员","depName":"枢纽分公司","depId":"507","eCard":"3052","sex":"男","mobile":"13755842059","party":"群众","leaveDate":"","retirementDate":"","birthday":"1979-09-29 00:00:00.0","nowWorkDate":"2019-12-03 00:00:00.0","education":"","age":"41","address":"江西省宜春市中山东路化肥厂"},{"profileId":"41757","userCode":"3074","profileNo":"PN20191206162941-0226","isWork":"0","fullname":"郭纯奎","mnemonicCard":"GCK","idCard":"362201197712060435","position":"驾驶员","depName":"枢纽分公司","depId":"507","eCard":"3074","sex":"男","mobile":"13979531845","party":"群众","leaveDate":"","retirementDate":"","birthday":"1977-12-06 00:00:00.0","nowWorkDate":"2019-12-03 00:00:00.0","education":"","age":"43","address":"宜春市锦绣大道1019号东升花园"},{"profileId":"41749","userCode":"3056","profileNo":"PN20191203101753-0234","isWork":"0","fullname":"兰明庚","mnemonicCard":"LMG","idCard":"362227198101102913","position":"站务员","depName":"营运二分公司","depId":"506","eCard":"3056","sex":"男","mobile":"15207056082","party":"群众","leaveDate":"","retirementDate":"","birthday":"1981-01-10 00:00:00.0","nowWorkDate":"2019-11-25 00:00:00.0","education":"","age":"39","address":"宜春市万载县黄茅镇新泉村丰树组29号"},{"profileId":"41750","userCode":"3055","profileNo":"PN20191203102102-0593","isWork":"0","fullname":"刘艳","mnemonicCard":"LY","idCard":"36220119851116382X","position":"调度员","depName":"安全运营部","depId":"523","eCard":"3055","sex":"女","mobile":"13407056485","party":"群众","leaveDate":"","retirementDate":"","birthday":"1985-11-16 00:00:00.0","nowWorkDate":"2019-11-25 00:00:00.0","education":"","age":"35","address":"袁州区竹亭乡社江村二字塘组"},{"profileId":"41751","userCode":"3058","profileNo":"PN20191203102316-0949","isWork":"0","fullname":"胡早桂","mnemonicCard":"HZG","idCard":"362201197211046010","position":"接箱员","depName":"财务部","depId":"501","eCard":"3058","sex":"男","mobile":"13767558205","party":"群众","leaveDate":"","retirementDate":"","birthday":"1972-11-04 00:00:00.0","nowWorkDate":"2019-11-25 00:00:00.0","education":"","age":"48","address":"袁州区新坊乡路口村桥仔下组22号"},{"profileId":"41752","userCode":"3053","profileNo":"PN20191203103916-0955","isWork":"0","fullname":"田梅兰","mnemonicCard":"TML","idCard":"362201198406047704","position":"站务员","depName":"枢纽分公司","depId":"507","eCard":"3053","sex":"女","mobile":"13307950513","party":"群众","leaveDate":"","retirementDate":"","birthday":"1984-06-04 00:00:00.0","nowWorkDate":"2019-11-25 00:00:00.0","education":"","age":"36","address":"江西省宜春市袁州区飞剑潭乡南坑村梁家组18号"},{"profileId":"41753","userCode":"3063","profileNo":"PN20191203105537-0017","isWork":"0","fullname":"周俊","mnemonicCard":"ZJ","idCard":"362429199007120312","position":"督导员","depName":"营运二分公司","depId":"506","eCard":"3063","sex":"男","mobile":"13766404455","party":"群众","leaveDate":"","retirementDate":"","birthday":"1990-07-12 00:00:00.0","nowWorkDate":"2019-11-25 00:00:00.0","education":"","age":"30","address":"袁州区宜春南路609号6栋1单元102室"},{"profileId":"41764","userCode":"3064","profileNo":"PN20200106170906-0691","isWork":"0","fullname":"潘文欣","mnemonicCard":"PWX","idCard":"360902200110300267","position":"督导员","depName":"营运二分公司","depId":"506","eCard":"","sex":"女","mobile":"18170450890","party":"群众","leaveDate":"","retirementDate":"","birthday":"2001-10-30 00:00:00.0","nowWorkDate":"2019-11-09 00:00:00.0","education":"","age":"19","address":"江西省宜春市袁州区环城西路550号怡曦花园"},{"profileId":"41744","userCode":"3062","profileNo":"PN20191104091214-0783","isWork":"0","fullname":"肖琦","mnemonicCard":"XQ","idCard":"362201198506240632","position":"驾驶员","depName":"枢纽分公司","depId":"507","eCard":"3062","sex":"男","mobile":"13672287473","party":"群众","leaveDate":"","retirementDate":"","birthday":"1985-06-24 00:00:00.0","nowWorkDate":"2019-10-28 00:00:00.0","education":"中专","age":"35","address":"袁州区官园街道高士北路1155号书香名郡"},{"profileId":"41745","userCode":"3059","profileNo":"PN20191104093548-0526","isWork":"0","fullname":"江波洋","mnemonicCard":"JPY","idCard":"430681198207271439","position":"驾驶员","depName":"枢纽分公司","depId":"507","eCard":"3059","sex":"男","mobile":"13976896821","party":"群众","leaveDate":"","retirementDate":"","birthday":"1982-07-27 00:00:00.0","nowWorkDate":"2019-10-28 00:00:00.0","education":"本科","age":"38","address":"湖南省汩罗市新市镇 福兴村二组5号"}]
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

    public static class ResultBean implements Serializable {
        /**
         * profileId : 41769
         * userCode : 3088
         * profileNo : PN20200114113422-0649
         * isWork : 0
         * fullname : 李红兵
         * mnemonicCard : LGB
         * idCard : 362201197002020615
         * position : 驾驶员
         * depName : 枢纽分公司
         * depId : 507
         * eCard :
         * sex : 男
         * mobile : 13707957668
         * party : 群众
         * leaveDate :
         * retirementDate :
         * birthday : 1970-02-02 00:00:00.0
         * nowWorkDate : 2020-01-09 00:00:00.0
         * education :
         * age : 50
         * address : 袁州区环城南路518号20栋405室
         */

        private String profileId;
        private String userCode;
        private String profileNo;
        private String isWork;
        private String fullname;
        private String mnemonicCard;
        private String idCard;
        private String position;
        private String depName;
        private String depId;
        private String eCard;
        private String sex;
        private String mobile;
        private String party;
        private String leaveDate;
        private String retirementDate;
        private String birthday;
        private String nowWorkDate;
        private String education;
        private String age;
        private String address;
        private String letters;

        public String geteCard() {
            return eCard;
        }

        public void seteCard(String eCard) {
            this.eCard = eCard;
        }

        public String getLetters() {
            return letters;
        }

        public void setLetters(String letters) {
            this.letters = letters;
        }

        public String getProfileId() {
            return profileId;
        }

        public void setProfileId(String profileId) {
            this.profileId = profileId;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getProfileNo() {
            return profileNo;
        }

        public void setProfileNo(String profileNo) {
            this.profileNo = profileNo;
        }

        public String getIsWork() {
            return isWork;
        }

        public void setIsWork(String isWork) {
            this.isWork = isWork;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getMnemonicCard() {
            return mnemonicCard;
        }

        public void setMnemonicCard(String mnemonicCard) {
            this.mnemonicCard = mnemonicCard;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public String getDepId() {
            return depId;
        }

        public void setDepId(String depId) {
            this.depId = depId;
        }

        public String getECard() {
            return eCard;
        }

        public void setECard(String eCard) {
            this.eCard = eCard;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getParty() {
            return party;
        }

        public void setParty(String party) {
            this.party = party;
        }

        public String getLeaveDate() {
            return leaveDate;
        }

        public void setLeaveDate(String leaveDate) {
            this.leaveDate = leaveDate;
        }

        public String getRetirementDate() {
            return retirementDate;
        }

        public void setRetirementDate(String retirementDate) {
            this.retirementDate = retirementDate;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getNowWorkDate() {
            return nowWorkDate;
        }

        public void setNowWorkDate(String nowWorkDate) {
            this.nowWorkDate = nowWorkDate;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
