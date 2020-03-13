package com.hy.powerplatform.my_utils.utils.azlistview;

import com.hy.powerplatform.oa_flow.bean.DormPersonList;

import java.util.Comparator;

/**
 * 用来对ListView中的数据根据A-Z进行排序，前面两个if判断主要是将不是以汉字开头的数据放在后面
 */
public class PinyinComparatorDormP implements Comparator<DormPersonList.ResultBean> {

    public int compare(DormPersonList.ResultBean o1, DormPersonList.ResultBean o2) {
        //这里主要是用来对ListView里面的数据根据ABCDEFG...来排序
        if (o1.getLetters().equals("@")
                || o2.getLetters().equals("#")) {
            return -1;
        } else if (o1.getLetters().equals("#")
                || o2.getLetters().equals("@")) {
            return 1;
        } else {
            return o1.getLetters().compareTo(o2.getLetters());
        }
    }
}