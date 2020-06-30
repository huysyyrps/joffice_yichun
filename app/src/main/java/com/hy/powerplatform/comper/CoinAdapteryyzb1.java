package com.hy.powerplatform.comper;

import android.content.Context;

import com.hy.powerplatform.R;
import com.hy.powerplatform.comper.bean.RZDA;
import com.hy.powerplatform.comper.view.CommonAdapter;
import com.hy.powerplatform.comper.view.CommonViewHolder;

import java.util.List;

/**
 * Created by chawei on 2018/4/29.
 */

public class CoinAdapteryyzb1 extends CommonAdapter<RZDA> {


    public CoinAdapteryyzb1(Context context, List<RZDA> dataList, int layoutId, CommonViewHolder.onItemCommonClickListener listener) {
        super(context, dataList, layoutId);
    }

    @Override
    public void bindData(CommonViewHolder holder, RZDA data, int position) {

        holder.setColorWhite(R.id.tvTitle)
                .setColorWhite(R.id.tvNow)
                .setColorWhite(R.id.tvYear)
                .setColorWhite(R.id.tvAddd);

//        if (data.getTag().equals("2")) {
//            holder.setColor(R.id.tvTitle)
//                    .setColor(R.id.tvNow)
//                    .setColor(R.id.tvYear)
//                    .setColor(R.id.tvAddd);
//        }
//        if (data.getTag().equals("3")) {
//            holder.setColorTag(R.id.tvTitle)
//                    .setColorTag(R.id.tvNow)
//                    .setColorTag(R.id.tvYear)
//                    .setColorTag(R.id.tvAddd);
//        }
        holder.setText(R.id.tvTitle, data.getName())
                .setText(R.id.tvNow, data.getNow())
                .setText(R.id.tvYear, data.getYear())
                .setText(R.id.tvAddd, data.getAddd());
    }
}
