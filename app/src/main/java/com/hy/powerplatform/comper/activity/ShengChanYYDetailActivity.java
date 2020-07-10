package com.hy.powerplatform.comper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.comper.bean.ShengChangYYSmall;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapterPosition;
import com.hy.powerplatform.my_utils.utils.BaseViewHolderPosition;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class ShengChanYYDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private String res;
    private OkHttpUtil httpUtil;
    BaseRecyclerAdapterPosition mAdapter;
    List<ShengChangYYSmall.ResultBean>beanList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        String tag = intent.getStringExtra("tag");
        httpUtil = OkHttpUtil.getInstance(this);
        getData(date,tag);
    }

    private void getData(String date, String tag) {
        String turl = Constant.BASE_URL2 + "starkh/listOperationIndexDataAudit.do";
        final HashMap<String, String> map = new HashMap();
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        map.clear();
        map.put("month", date);
        map.put("typeName", tag);
        httpUtil.postForm(turl, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = TAG_TWO;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                res = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", res);
                message.setData(b);
                message.what = TAG_ONE;
                handler.sendMessage(message);
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_sheng_chan_yydetail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    Gson gson = new Gson();
                    ShengChangYYSmall bean = gson.fromJson(res, ShengChangYYSmall.class);
                    ShengChangYYSmall.ResultBean bean1 = new ShengChangYYSmall.ResultBean();
                    bean1.setName("名称");
                    bean1.setBqnum("本期");
                    bean1.setTqnum("同期");
                    bean1.setBhnum("增减");
                    beanList.add(bean1);
                    for (int i=0;i<bean.getResult().size();i++){
                        beanList.add(bean.getResult().get(i));
                    }
                    mAdapter = new BaseRecyclerAdapterPosition<ShengChangYYSmall.ResultBean>(ShengChanYYDetailActivity.this
                            , R.layout.adapter_yy_small_item, beanList) {
                        @Override
                        public void convert(BaseViewHolderPosition holder, ShengChangYYSmall.ResultBean resultBean, int i) {
                            holder.setText(R.id.tvName, resultBean.getName());
                            holder.setText(R.id.tvBq, resultBean.getBqnum());
                            holder.setText(R.id.tvTq, resultBean.getTqnum());
                            if (!resultBean.getBhnum().equals("增减")){
                                if (Double.parseDouble(resultBean.getBhnum())<0){
                                    holder.setColor1(R.id.tvZJ, "4");
                                    holder.setImageViewVisitiomGone(R.id.ivDown);
                                    holder.setImageViewVisitiomGone(R.id.ivUp);
                                    holder.setText(R.id.tvZJ, resultBean.getBhnum());
                                    holder.setImageViewVisitiom(R.id.ivDown);
                                }else if (Double.parseDouble(resultBean.getBhnum())>0){
                                    holder.setColor1(R.id.tvZJ, "1");
                                    holder.setImageViewVisitiomGone(R.id.ivDown);
                                    holder.setImageViewVisitiomGone(R.id.ivUp);
                                    holder.setText(R.id.tvZJ, resultBean.getBhnum());
                                    holder.setImageViewVisitiom(R.id.ivUp);
                                }else {
                                    holder.setText(R.id.tvZJ, resultBean.getBhnum());
                                }
                            }else {
                                holder.setText(R.id.tvZJ, resultBean.getBhnum());
                            }
                            if (i%2==0){
                                holder.setColor(R.id.llConstant);
                            }
                        }
                    };
                    recyclerView.setAdapter(mAdapter);
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(ShengChanYYDetailActivity.this, "操作失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
