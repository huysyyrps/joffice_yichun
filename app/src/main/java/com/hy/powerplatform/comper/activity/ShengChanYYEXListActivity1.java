package com.hy.powerplatform.comper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerMonth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    private CustomDatePickerMonth customDatePicker1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();
        header.setRightTv(false);
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
                intent = new Intent(this,ShengChanYYDetailActivity.class);
                intent.putExtra("date",tvDate.getText().toString());
                intent.putExtra("tag","职工人数");
                startActivity(intent);
                break;
            case R.id.ll2:
                intent = new Intent(this,ShengChanYYDetailActivity.class);
                intent.putExtra("date",tvDate.getText().toString());
                intent.putExtra("tag","营运车辆");
                startActivity(intent);
                break;
            case R.id.ll3:
                intent = new Intent(this,ShengChanYYDetailActivity.class);
                intent.putExtra("date",tvDate.getText().toString());
                intent.putExtra("tag","车辆车龄");
                startActivity(intent);
                break;
            case R.id.ll4:
                intent = new Intent(this,ShengChanYYDetailActivity.class);
                intent.putExtra("date",tvDate.getText().toString());
                intent.putExtra("tag","公务车");
                startActivity(intent);
                break;
            case R.id.ll5:
                intent = new Intent(this,ShengChanYYDetailActivity.class);
                intent.putExtra("date",tvDate.getText().toString());
                intent.putExtra("tag","线路情况");
                startActivity(intent);
                break;
            case R.id.ll6:
                intent = new Intent(this,ShengChanYYDetailActivity.class);
                intent.putExtra("date",tvDate.getText().toString());
                intent.putExtra("tag","交通事故");
                startActivity(intent);
                break;
            case R.id.ll7:
                intent = new Intent(this,ShengChanYYDetailActivity.class);
                intent.putExtra("date",tvDate.getText().toString());
                intent.putExtra("tag","服务指标");
                startActivity(intent);
                break;
            case R.id.ll8:
                intent = new Intent(this,ShengChanYYDetailActivity.class);
                intent.putExtra("date",tvDate.getText().toString());
                intent.putExtra("tag","党员情况");
                startActivity(intent);
                break;
            case R.id.ll9:
                intent = new Intent(this,ShengChanYYDetailActivity1.class);
                intent.putExtra("date",tvDate.getText().toString());
                intent.putExtra("tag","经营情况");
                startActivity(intent);
                break;
            case R.id.ll10:
                intent = new Intent(this,ShengChanYYDetailActivity1.class);
                intent.putExtra("date",tvDate.getText().toString());
                intent.putExtra("tag","资产");
                startActivity(intent);
                break;

        }
    }
}
