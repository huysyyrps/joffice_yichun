package com.hy.powerplatform.comper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.comper.bean.ShengChangYYSmall;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerMonth;

import java.io.IOException;
import java.math.BigDecimal;
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

public class ShengChanYYEXListActivity1 extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.ll4)
    LinearLayout ll4;
    @BindView(R.id.ll5)
    LinearLayout ll5;
    @BindView(R.id.ll6)
    LinearLayout ll6;
    @BindView(R.id.ll7)
    LinearLayout ll7;
    @BindView(R.id.ll8)
    LinearLayout ll8;
    @BindView(R.id.ll9)
    LinearLayout ll9;
    @BindView(R.id.ll10)
    LinearLayout ll10;
    Intent intent;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.tvBQ1)
    TextView tvBQ1;
    @BindView(R.id.tvTQ1)
    TextView tvTQ1;
    @BindView(R.id.tvZJ1)
    TextView tvZJ1;
    @BindView(R.id.tvBQ2)
    TextView tvBQ2;
    @BindView(R.id.tvTQ2)
    TextView tvTQ2;
    @BindView(R.id.tvZJ2)
    TextView tvZJ2;
    @BindView(R.id.tvBQ3)
    TextView tvBQ3;
    @BindView(R.id.tvTQ3)
    TextView tvTQ3;
    @BindView(R.id.tvZJ3)
    TextView tvZJ3;
    @BindView(R.id.tvBQ4)
    TextView tvBQ4;
    @BindView(R.id.tvTQ4)
    TextView tvTQ4;
    @BindView(R.id.tvZJ4)
    TextView tvZJ4;
    @BindView(R.id.tvBQ5)
    TextView tvBQ5;
    @BindView(R.id.tvTQ5)
    TextView tvTQ5;
    @BindView(R.id.tvZJ5)
    TextView tvZJ5;
    @BindView(R.id.tvBQ6)
    TextView tvBQ6;
    @BindView(R.id.tvTQ6)
    TextView tvTQ6;
    @BindView(R.id.tvZJ6)
    TextView tvZJ6;
    @BindView(R.id.tvBQ7)
    TextView tvBQ7;
    @BindView(R.id.tvTQ7)
    TextView tvTQ7;
    @BindView(R.id.tvZJ7)
    TextView tvZJ7;
    @BindView(R.id.tvBQ8)
    TextView tvBQ8;
    @BindView(R.id.tvTQ8)
    TextView tvTQ8;
    @BindView(R.id.tvZJ8)
    TextView tvZJ8;
    @BindView(R.id.ivUp1)
    ImageView ivUp1;
    @BindView(R.id.ivDown1)
    ImageView ivDown1;
    @BindView(R.id.ivUp2)
    ImageView ivUp2;
    @BindView(R.id.ivDown2)
    ImageView ivDown2;
    @BindView(R.id.ivUp3)
    ImageView ivUp3;
    @BindView(R.id.ivDown3)
    ImageView ivDown3;
    @BindView(R.id.ivUp4)
    ImageView ivUp4;
    @BindView(R.id.ivDown4)
    ImageView ivDown4;
    @BindView(R.id.ivUp5)
    ImageView ivUp5;
    @BindView(R.id.ivDown5)
    ImageView ivDown5;
    @BindView(R.id.ivUp6)
    ImageView ivUp6;
    @BindView(R.id.ivDown6)
    ImageView ivDown6;
    @BindView(R.id.ivUp7)
    ImageView ivUp7;
    @BindView(R.id.ivDown7)
    ImageView ivDown7;
    @BindView(R.id.ivUp8)
    ImageView ivUp8;
    @BindView(R.id.ivDown8)
    ImageView ivDown8;
    private String res;
    int num = 1;
    double bq1 = 0.0, tq1 = 0.0, zj1 = 0.0,
            bq2 = 0.0, tq2 = 0.0, zj2 = 0.0,
            bq3 = 0.0, tq3 = 0.0, zj3 = 0.0, bq4 = 0.0, tq4 = 0.0, zj4 = 0.0, bq5 = 0.0, tq5 = 0.0, zj5 = 0.0, bq6 = 0.0, tq6 = 0.0, zj6 = 0.0, bq7 = 0.0, tq7 = 0.0, zj7 = 0.0, bq8 = 0.0, tq8 = 0.0, zj8 = 0.0;
    private OkHttpUtil httpUtil;
    private CustomDatePickerMonth customDatePicker1;
    List<ShengChangYYSmall.ResultBean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();
        header.setRightTv(false);
        httpUtil = OkHttpUtil.getInstance(this);
        getData(tvDate.getText().toString(), "0");
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
        return R.layout.activity_sheng_chan_yyexlist1;
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
                num = 0;
                getData(date1, "0");
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动
        customDatePicker1.showSpecificDay(false); // 不允许循环滚动
    }


    @OnClick({R.id.tvDate, R.id.ll1, R.id.ll2, R.id.ll3, R.id.ll4, R.id.ll5, R.id.ll6, R.id.ll7, R.id.ll8, R.id.ll9, R.id.ll10})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvDate:
                customDatePicker1.show(tvDate.getText().toString());
                break;
            case R.id.ll1:
                intent = new Intent(this, ShengChanYYDetailActivity.class);
                intent.putExtra("date", tvDate.getText().toString());
                intent.putExtra("tag", "职工人数");
                startActivity(intent);
                break;
            case R.id.ll2:
                intent = new Intent(this, ShengChanYYDetailActivity.class);
                intent.putExtra("date", tvDate.getText().toString());
                intent.putExtra("tag", "营运车辆");
                startActivity(intent);
                break;
            case R.id.ll3:
                intent = new Intent(this, ShengChanYYDetailActivity.class);
                intent.putExtra("date", tvDate.getText().toString());
                intent.putExtra("tag", "车辆车龄");
                startActivity(intent);
                break;
            case R.id.ll4:
                intent = new Intent(this, ShengChanYYDetailActivity.class);
                intent.putExtra("date", tvDate.getText().toString());
                intent.putExtra("tag", "公务车");
                startActivity(intent);
                break;
            case R.id.ll5:
                intent = new Intent(this, ShengChanYYDetailActivity.class);
                intent.putExtra("date", tvDate.getText().toString());
                intent.putExtra("tag", "线路情况");
                startActivity(intent);
                break;
            case R.id.ll6:
                intent = new Intent(this, ShengChanYYDetailActivity.class);
                intent.putExtra("date", tvDate.getText().toString());
                intent.putExtra("tag", "交通事故");
                startActivity(intent);
                break;
            case R.id.ll7:
                intent = new Intent(this, ShengChanYYDetailActivity.class);
                intent.putExtra("date", tvDate.getText().toString());
                intent.putExtra("tag", "服务指标");
                startActivity(intent);
                break;
            case R.id.ll8:
                intent = new Intent(this, ShengChanYYDetailActivity.class);
                intent.putExtra("date", tvDate.getText().toString());
                intent.putExtra("tag", "党员情况");
                startActivity(intent);
                break;
            case R.id.ll9:
                intent = new Intent(this, ShengChanYYDetailActivity1.class);
                intent.putExtra("date", tvDate.getText().toString());
                intent.putExtra("tag", "经营情况");
                startActivity(intent);
                break;
            case R.id.ll10:
                intent = new Intent(this, ShengChanYYDetailActivity1.class);
                intent.putExtra("date", tvDate.getText().toString());
                intent.putExtra("tag", "资产");
                startActivity(intent);
                break;

        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    Gson gson = new Gson();
                    ShengChangYYSmall bean = gson.fromJson(res, ShengChangYYSmall.class);
                    beanList.clear();
                    bq1 = 0.0;
                    tq1 = 0.0;
                    zj1 = 0.0;
                    bq2 = 0.0;
                    tq2 = 0.0;
                    zj2 = 0.0;
                    bq3 = 0.0;
                    tq3 = 0.0;
                    zj3 = 0.0
                    ;
                    bq4 = 0.0;
                    tq4 = 0.0;
                    zj4 = 0.0
                    ;
                    bq5 = 0.0;
                    tq5 = 0.0;
                    zj5 = 0.0
                    ;
                    bq6 = 0.0;
                    tq6 = 0.0;
                    zj6 = 0.0
                    ;
                    bq7 = 0.0;
                    tq7 = 0.0;
                    zj7 = 0.0
                    ;
                    bq8 = 0.0;
                    tq8 = 0.0;
                    zj8 = 0.0;
                    beanList.clear();
                    for (int i = 0; i < bean.getResult().size(); i++) {
                        beanList.add(bean.getResult().get(i));
                    }
                    for (int i = 0; i < beanList.size(); i++) {
                        if (beanList.get(i).getType().equals("01职工人数")) {
                            bq1 = bq1 + Double.parseDouble(beanList.get(i).getBqnum());
                            tq1 = tq1 + Double.parseDouble(beanList.get(i).getTqnum());
                            zj1 = zj1 + Double.parseDouble(beanList.get(i).getBhnum());
                            tvBQ1.setText(bq1 + "");
                            tvTQ1.setText(tq1 + "");
                            tvZJ1.setText(zj1 + "");
                            if (zj1>0){
                                ivUp1.setVisibility(View.GONE);
                                ivDown1.setVisibility(View.GONE);
                                tvZJ1.setTextColor(getResources().getColor(R.color.red));
                                ivUp1.setVisibility(View.VISIBLE);
                            }else if (zj1<0){
                                ivUp1.setVisibility(View.GONE);
                                ivDown1.setVisibility(View.GONE);
                                tvZJ1.setTextColor(getResources().getColor(R.color.color_bg_selected));
                                ivDown1.setVisibility(View.VISIBLE);
                            }else {
                                ivUp1.setVisibility(View.GONE);
                                ivDown1.setVisibility(View.GONE);
                                tvZJ1.setTextColor(getResources().getColor(R.color.graytext));
                            }
                        }
                        if (beanList.get(i).getType().equals("02营运车辆")) {
                            if (beanList.get(i).getName().equals("车辆数")){
                                bq2 = bq2 + Double.parseDouble(beanList.get(i).getBqnum());
                                tq2 = tq2 + Double.parseDouble(beanList.get(i).getTqnum());
                                zj2 = zj2 + Double.parseDouble(beanList.get(i).getBhnum());
                                tvBQ2.setText(bq2 + "");
                                tvTQ2.setText(tq2 + "");
                                tvZJ2.setText(zj2 + "");
                                if (zj2>0){
                                    ivUp2.setVisibility(View.GONE);
                                    ivDown2.setVisibility(View.GONE);
                                    tvZJ2.setTextColor(getResources().getColor(R.color.red));
                                    ivUp2.setVisibility(View.VISIBLE);
                                }else if (zj2<0){
                                    ivUp2.setVisibility(View.GONE);
                                    ivDown2.setVisibility(View.GONE);
                                    tvZJ2.setTextColor(getResources().getColor(R.color.color_bg_selected));
                                    ivDown2.setVisibility(View.VISIBLE);
                                }else {
                                    ivUp2.setVisibility(View.GONE);
                                    ivDown2.setVisibility(View.GONE);
                                    tvZJ2.setTextColor(getResources().getColor(R.color.graytext));
                                }
                            }
                        }
                        if (beanList.get(i).getType().equals("03车辆车龄")) {
                            num +=1;
                            bq3 = bq3 + Double.parseDouble(beanList.get(i).getBqnum());
                            tq3 = tq3 + Double.parseDouble(beanList.get(i).getTqnum());
                            zj3 = zj3 + Double.parseDouble(beanList.get(i).getBhnum());

                            double f1 = bq3/num;
                            BigDecimal bg1 = new BigDecimal(f1);
                            double f11 = bg1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

                            double f2 = tq3/num;
                            BigDecimal bg2 = new BigDecimal(f2);
                            double f22 = bg2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

                            double f3 = zj3/num;
                            BigDecimal bg3 = new BigDecimal(f3);
                            double f33 = bg3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

                            tvBQ3.setText(f11 + "");
                            tvTQ3.setText(f22 + "");
                            tvZJ3.setText(f33 + "");
                            if (zj3>0){
                                ivUp3.setVisibility(View.GONE);
                                ivDown3.setVisibility(View.GONE);
                                tvZJ3.setTextColor(getResources().getColor(R.color.red));
                                ivUp3.setVisibility(View.VISIBLE);
                            }else if (zj3<0){
                                ivUp3.setVisibility(View.GONE);
                                ivDown3.setVisibility(View.GONE);
                                tvZJ3.setTextColor(getResources().getColor(R.color.color_bg_selected));
                                ivDown3.setVisibility(View.VISIBLE);
                            }else {
                                ivUp3.setVisibility(View.GONE);
                                ivDown3.setVisibility(View.GONE);
                                tvZJ3.setTextColor(getResources().getColor(R.color.graytext));
                            }
                        }
                        if (beanList.get(i).getType().equals("04公务车")) {
                            bq4 = bq4 + Double.parseDouble(beanList.get(i).getBqnum());
                            tq4 = tq4 + Double.parseDouble(beanList.get(i).getTqnum());
                            zj4 = zj4 + Double.parseDouble(beanList.get(i).getBhnum());
                            tvBQ4.setText(bq4 + "");
                            tvTQ4.setText(tq4 + "");
                            tvZJ4.setText(zj4 + "");
                            if (zj4>0){
                                ivUp4.setVisibility(View.GONE);
                                ivDown4.setVisibility(View.GONE);
                                tvZJ4.setTextColor(getResources().getColor(R.color.red));
                                ivUp4.setVisibility(View.VISIBLE);
                            }else if (zj4<0){
                                ivUp4.setVisibility(View.GONE);
                                ivDown4.setVisibility(View.GONE);
                                tvZJ4.setTextColor(getResources().getColor(R.color.color_bg_selected));
                                ivDown4.setVisibility(View.VISIBLE);
                            }else {
                                ivUp4.setVisibility(View.GONE);
                                ivDown4.setVisibility(View.GONE);
                                tvZJ4.setTextColor(getResources().getColor(R.color.graytext));
                            }
                        }
                        if (beanList.get(i).getType().equals("05线路情况")) {
                            if (beanList.get(i).getName().equals("线路条数")){
                                bq5 = bq5 + Double.parseDouble(beanList.get(i).getBqnum());
                                tq5 = tq5 + Double.parseDouble(beanList.get(i).getTqnum());
                                zj5 = zj5 + Double.parseDouble(beanList.get(i).getBhnum());
                                tvBQ5.setText(bq5 + "");
                                tvTQ5.setText(tq5 + "");
                                tvZJ5.setText(zj5 + "");
                                if (zj5>0){
                                    ivUp5.setVisibility(View.GONE);
                                    ivDown5.setVisibility(View.GONE);
                                    tvZJ5.setTextColor(getResources().getColor(R.color.red));
                                    ivUp5.setVisibility(View.VISIBLE);
                                }else if (zj5<0){
                                    ivUp5.setVisibility(View.GONE);
                                    ivDown5.setVisibility(View.GONE);
                                    tvZJ5.setTextColor(getResources().getColor(R.color.color_bg_selected));
                                    ivDown5.setVisibility(View.VISIBLE);
                                }else {
                                    ivUp5.setVisibility(View.GONE);
                                    ivDown5.setVisibility(View.GONE);
                                    tvZJ5.setTextColor(getResources().getColor(R.color.graytext));
                                }
                            }
                        }
                        if (beanList.get(i).getType().equals("06交通事故")) {
                            bq6 = bq6 + Double.parseDouble(beanList.get(i).getBqnum());
                            tq6 = tq6 + Double.parseDouble(beanList.get(i).getTqnum());
                            zj6 = zj6 + Double.parseDouble(beanList.get(i).getBhnum());
                            tvBQ6.setText(bq6 + "");
                            tvTQ6.setText(tq6 + "");
                            tvZJ6.setText(zj6 + "");
                            if (zj6>0){
                                ivUp6.setVisibility(View.GONE);
                                ivDown6.setVisibility(View.GONE);
                                tvZJ6.setTextColor(getResources().getColor(R.color.red));
                                ivUp6.setVisibility(View.VISIBLE);
                            }else if (zj6<0){
                                ivUp6.setVisibility(View.GONE);
                                ivDown6.setVisibility(View.GONE);
                                tvZJ6.setTextColor(getResources().getColor(R.color.color_bg_selected));
                                ivDown6.setVisibility(View.VISIBLE);
                            }else {
                                ivUp6.setVisibility(View.GONE);
                                ivDown6.setVisibility(View.GONE);
                                tvZJ6.setTextColor(getResources().getColor(R.color.graytext));
                            }
                        }
                        if (beanList.get(i).getType().equals("07服务指标")) {
                            bq7 = bq7 + Double.parseDouble(beanList.get(i).getBqnum());
                            tq7 = tq7 + Double.parseDouble(beanList.get(i).getTqnum());
                            zj7 = zj7 + Double.parseDouble(beanList.get(i).getBhnum());
                            tvBQ7.setText(bq7 + "");
                            tvTQ7.setText(tq7 + "");
                            tvZJ7.setText(zj7 + "");
                            if (zj7>0){
                                ivUp7.setVisibility(View.GONE);
                                ivDown7.setVisibility(View.GONE);
                                tvZJ7.setTextColor(getResources().getColor(R.color.red));
                                ivUp7.setVisibility(View.VISIBLE);
                            }else if (zj7<0){
                                ivUp7.setVisibility(View.GONE);
                                ivDown7.setVisibility(View.GONE);
                                tvZJ7.setTextColor(getResources().getColor(R.color.color_bg_selected));
                                ivDown7.setVisibility(View.VISIBLE);
                            }else {
                                ivUp7.setVisibility(View.GONE);
                                ivDown7.setVisibility(View.GONE);
                                tvZJ7.setTextColor(getResources().getColor(R.color.graytext));
                            }
                        }
                        if (beanList.get(i).getType().equals("08党员情况")) {
                            bq8 = bq8 + Double.parseDouble(beanList.get(i).getBqnum());
                            tq8 = tq8 + Double.parseDouble(beanList.get(i).getTqnum());
                            zj8 = zj8 + Double.parseDouble(beanList.get(i).getBhnum());
                            tvBQ8.setText(bq8 + "");
                            tvTQ8.setText(tq8 + "");
                            tvZJ8.setText(zj8 + "");
                            if (zj8>0){
                                ivUp8.setVisibility(View.GONE);
                                ivDown8.setVisibility(View.GONE);
                                tvZJ8.setTextColor(getResources().getColor(R.color.red));
                                ivUp8.setVisibility(View.VISIBLE);
                            }else if (zj8<0){
                                ivUp8.setVisibility(View.GONE);
                                ivDown8.setVisibility(View.GONE);
                                tvZJ8.setTextColor(getResources().getColor(R.color.color_bg_selected));
                                ivDown8.setVisibility(View.VISIBLE);
                            }else {
                                ivUp8.setVisibility(View.GONE);
                                ivDown8.setVisibility(View.GONE);
                                tvZJ8.setTextColor(getResources().getColor(R.color.graytext));
                            }
                        }
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(ShengChanYYEXListActivity1.this, "操作失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
