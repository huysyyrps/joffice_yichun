package com.hy.powerplatform.comper;

import android.content.Context;

import com.hy.powerplatform.R;
import com.hy.powerplatform.comper.bean.JYQK;
import com.hy.powerplatform.comper.view.CommonAdapter;
import com.hy.powerplatform.comper.view.CommonViewHolder;

import java.util.List;

/**
 * Created by chawei on 2018/4/29.
 */

public class CoinAdapteryyzb3 extends CommonAdapter<JYQK> {


    public CoinAdapteryyzb3(Context context, List<JYQK> dataList, int layoutId, CommonViewHolder.onItemCommonClickListener listener) {
        super(context, dataList, layoutId);
    }

    @Override
    public void bindData(CommonViewHolder holder, JYQK data, int position) {

        holder.setColorWhite(R.id.tvTitle)
                .setColorWhite(R.id.tvMBZ)
                .setColorWhite(R.id.tvWCZ)
                .setColorWhite(R.id.tvWCB)
                .setColorWhite(R.id.tvTQZ)
                .setColorWhite(R.id.tvZJ);

//        if (data.getTag().equals("2")) {
//            holder.setColor(R.id.tvTitle)
//                    .setColor(R.id.tvMBZ)
//                    .setColor(R.id.tvWCZ)
//                    .setColor(R.id.tvWCB)
//                    .setColor(R.id.tvTQZ)
//                    .setColor(R.id.tvZJ);
//        }
//        if (data.getTag().equals("3")) {
//            holder.setColorTag(R.id.tvTitle)
//                    .setColorTag(R.id.tvMBZ)
//                    .setColorTag(R.id.tvWCZ)
//                    .setColorTag(R.id.tvWCB)
//                    .setColorTag(R.id.tvTQZ)
//                    .setColorTag(R.id.tvZJ);
//        }
        holder.setText(R.id.tvTitle, data.getName())
                .setText(R.id.tvMBZ, data.getMubiaoz())
                .setText(R.id.tvWCZ, data.getWanchengz())
                .setText(R.id.tvWCB, data.getWanchengb())
                .setText(R.id.tvTQZ, data.getTongqiz())
                .setText(R.id.tvZJ, data.getZengjian());
    }
}
