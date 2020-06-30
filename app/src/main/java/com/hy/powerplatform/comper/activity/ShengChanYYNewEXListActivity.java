package com.hy.powerplatform.comper.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.comper.CoinAdapteryyzb1;
import com.hy.powerplatform.comper.CoinAdapteryyzb2;
import com.hy.powerplatform.comper.CoinAdapteryyzb3;
import com.hy.powerplatform.comper.bean.CLQK;
import com.hy.powerplatform.comper.bean.JYQK;
import com.hy.powerplatform.comper.bean.RZDA;
import com.hy.powerplatform.comper.view.CommonViewHolder;
import com.hy.powerplatform.comper.view.HRecyclerView;
import com.hy.powerplatform.comper.view.HRecyclerView1;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerMonth;
import com.hy.powerplatform.oa_flow.metting.bean.MyOverOpenList;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class ShengChanYYNewEXListActivity extends BaseActivity {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.recyclerView1)
    HRecyclerView recyclerView1;
    @BindView(R.id.recyclerView2)
    HRecyclerView recyclerView2;
    @BindView(R.id.recyclerView3)
    HRecyclerView1 recyclerView3;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    private CustomDatePickerMonth customDatePicker1;
    CoinAdapteryyzb1 baseAdapter1;
    CoinAdapteryyzb2 baseAdapter2;
    CoinAdapteryyzb3 baseAdapter3;
    String[] beanListTitle1 = new String[3];
    String[] beanListTitle2 = new String[3];
    String[] beanListTitle3 = new String[5];
    List<RZDA> beanList1 = new ArrayList<>();
    List<CLQK> beanList2 = new ArrayList<>();
    List<JYQK> beanList3 = new ArrayList<>();
    private OkHttpUtil httpUtil;
    final HashMap<String, String> map = new HashMap();
    private String[] groups = {"01职工人数", "02营运车辆", "03车辆车龄", "04公务车", "05线路情况", "06交通事故", "07服务指标"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        httpUtil = OkHttpUtil.getInstance(this);
        initDatePicker();
        header.setRightTv(false);
        getData();
        for (int i = 0; i < 8; i++) {
            RZDA rzda = new RZDA();
            if (i==0){
                rzda.setName("管理员");
            }
            if (i==1){
                rzda.setName("驾驶员");
            }
            if (i==2){
                rzda.setName("修理工");
            }
            if (i>2){
                rzda.setName("采购员");
            }
            rzda.setAddd(i + "");
            rzda.setNow(i + 2 + "");
            rzda.setYear(i + 3 + "");
            beanList1.add(rzda);
        }
        beanListTitle1[0] = ("当前");
        beanListTitle1[1] = ("上年底");
        beanListTitle1[2] = ("增减");
        recyclerView1.setHeaderListData(beanListTitle1);
        baseAdapter1 = new CoinAdapteryyzb1(this, beanList1, R.layout.item_yy_layout, new CommonViewHolder.onItemCommonClickListener() {
            @Override
            public void onItemClickListener(int position) {
                Toast.makeText(ShengChanYYNewEXListActivity.this, "position--->" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClickListener(int position) {

            }
        });
        recyclerView1.setAdapter(baseAdapter1);

        for (int i = 0; i < 6; i++) {
            CLQK clqk = new CLQK();
            if (i==0){
                clqk.setName("车辆数");
            }
            if (i==1){
                clqk.setName("存电动车");
            }
            if (i==2){
                clqk.setName("报废车辆");
            }
            if (i==3){
                clqk.setName("新增车辆");
            }
            if (i==4){
                clqk.setName("一年车");
            }
            if (i==5){
                clqk.setName("二年车");
            }
            clqk.setAddd(i + "");
            clqk.setNow(i + 2 + "");
            clqk.setYear(i + 3 + "");
            beanList2.add(clqk);
        }
        beanListTitle2[0] = ("当前");
        beanListTitle2[1] = ("上年底");
        beanListTitle2[2] = ("增减");
        recyclerView2.setHeaderListData(beanListTitle2);
        baseAdapter2 = new CoinAdapteryyzb2(this, beanList2, R.layout.item_yy_layout, new CommonViewHolder.onItemCommonClickListener() {
            @Override
            public void onItemClickListener(int position) {
                Toast.makeText(ShengChanYYNewEXListActivity.this, "position--->" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClickListener(int position) {

            }
        });
        recyclerView2.setAdapter(baseAdapter2);


        for (int i = 0; i < 7; i++) {
            JYQK jyqk = new JYQK();
            if (i==0){
                jyqk.setName("总收入");
            }
            if (i==1){
                jyqk.setName("总成本");
            }
            if (i==2){
                jyqk.setName("资产定额");
            }
            if (i==3){
                jyqk.setName("驾驶员违章");
            }
            if (i==4){
                jyqk.setName("投诉数据");
            }
            if (i==5){
                jyqk.setName("正式党员");
            }
            if (i==6){
                jyqk.setName("发展对象");
            }
            jyqk.setMubiaoz(i + "");
            jyqk.setWanchengz(i + 2 + "");
            jyqk.setWanchengb(i + 3 + "");
            jyqk.setTongqiz(i + 2 + "");
            jyqk.setZengjian(i + 3 + "");
            beanList3.add(jyqk);
        }
        beanListTitle3[0] = ("目标值");
        beanListTitle3[1] = ("完成值");
        beanListTitle3[2] = ("完成比");
        beanListTitle3[3] = ("同期值");
        beanListTitle3[4] = ("增减");
        recyclerView3.setHeaderListData(beanListTitle3);
        baseAdapter3 = new CoinAdapteryyzb3(this, beanList3, R.layout.item_yyjy_layout, new CommonViewHolder.onItemCommonClickListener() {
            @Override
            public void onItemClickListener(int position) {
                Toast.makeText(ShengChanYYNewEXListActivity.this, "position--->" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClickListener(int position) {

            }
        });
        recyclerView3.setAdapter(baseAdapter3);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_sheng_chan_yynewexlist;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM", Locale.CHINA);
        String now = sdf.format(new Date());
        tvDate.setText(now);

        customDatePicker1 = new CustomDatePickerMonth(this, new CustomDatePickerMonth.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                String date = time.split(" ")[0];
                String date1 = date.split("-")[0] + "-" + date.split("-")[1];
                tvDate.setText(date1);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动
        customDatePicker1.showSpecificDay(false); // 不允许循环滚动
    }

    @OnClick({R.id.tvDate, R.id.ll1, R.id.ll2, R.id.ll3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvDate:
                customDatePicker1.show(tvDate.getText().toString());
                break;
            case R.id.ll1:
                if (recyclerView1.getVisibility() == View.VISIBLE) {
                    recyclerView1.setVisibility(View.GONE);
                } else {
                    recyclerView1.setVisibility(View.VISIBLE);
//                    recyclerView2.setVisibility(View.GONE);
//                    recyclerView3.setVisibility(View.GONE);
                }
                break;
            case R.id.ll2:
                if (recyclerView2.getVisibility() == View.VISIBLE) {
                    recyclerView2.setVisibility(View.GONE);
                } else {
                    recyclerView2.setVisibility(View.VISIBLE);
//                    recyclerView1.setVisibility(View.GONE);
//                    recyclerView3.setVisibility(View.GONE);
                }
                break;
            case R.id.ll3:
                if (recyclerView3.getVisibility() == View.VISIBLE) {
                    recyclerView3.setVisibility(View.GONE);
                } else {
                    recyclerView3.setVisibility(View.VISIBLE);
//                    recyclerView1.setVisibility(View.GONE);
//                    recyclerView2.setVisibility(View.GONE);
                }
                break;
        }
    }

    public void getData() {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.YYZB;
        map.clear();
        map.put("month", "2020-05");
        map.put("type", "0");
        httpUtil.postForm(path_url, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
//                Log.i("main", "response:" + response.body().string());
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = TAG_TWO;
                handler.sendMessage(message);
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    String message = msg.getData().getString("error");
                    Toast.makeText(ShengChanYYNewEXListActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    MyOverOpenList bean = new Gson().fromJson(data, MyOverOpenList.class);
                    if (bean.getTotalCounts() != 0) {
//                        for (int i = 0; i < bean.getResult().size(); i++) {
//                            beanList.add(bean.getResult().get(i));
//                        }
//                        if (bean.getResult().size() == 0 && beanList.size() == 0) {
//                            recyclerView.setVisibility(View.GONE);
//                            llNoContent.setVisibility(View.VISIBLE);
//                        } else if (bean.getResult().size() == 0 && beanList.size() != 0) {
//                            if (recyclerView != null) {
//                                recyclerView.complete();
//                                recyclerView.onNoMore();
//                                baseAdapter.notifyDataSetChanged();
//                            }
//                        } else if (bean.getResult().size() != 0 && beanList.size() != 0 && bean.getResult().size() < 20) {
//                            if (recyclerView != null) {
//                                recyclerView.complete();
//                                recyclerView.onNoMore();
//                                baseAdapter.notifyDataSetChanged();
//                            }
//                        } else {
//                            if (recyclerView != null) {
//                                recyclerView.complete();
//                                baseAdapter.notifyDataSetChanged();
//                            }
//                        }
//                        baseAdapter.notifyDataSetChanged();
//                    } else {
//                        if (bean.getResult().size() == 0 && beanList.size() == 0) {
//                            recyclerView.setVisibility(View.GONE);
//                            llNoContent.setVisibility(View.VISIBLE);
//                        } else {
//                            recyclerView.setVisibility(View.VISIBLE);
//                            llNoContent.setVisibility(View.GONE);
//                            recyclerView.complete();
//                            recyclerView.onNoMore();
//                            baseAdapter.notifyDataSetChanged();
//                        }
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
