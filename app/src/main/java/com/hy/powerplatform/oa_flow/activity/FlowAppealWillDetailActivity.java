package com.hy.powerplatform.oa_flow.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.adapter.FlowMessageAdapter;
import com.hy.powerplatform.oa_flow.bean.Filed;
import com.hy.powerplatform.oa_flow.bean.FlowAppealWillDetail;
import com.hy.powerplatform.oa_flow.bean.FlowContractPerson;
import com.hy.powerplatform.oa_flow.bean.FlowMessage1;
import com.hy.powerplatform.oa_flow.util.MyStringSpilt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_EIGHT;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_FIVE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_NINE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_SEVEN;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_SIX;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class FlowAppealWillDetailActivity extends BaseActivity {


    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvDpartment)
    TextView tvDpartment;
    @BindView(R.id.tvShiXiang)
    TextView tvShiXiang;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.cb1)
    CheckBox cb1;
    @BindView(R.id.cb2)
    CheckBox cb2;
    @BindView(R.id.cb3)
    CheckBox cb3;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.cb4)
    CheckBox cb4;
    @BindView(R.id.cb5)
    CheckBox cb5;
    @BindView(R.id.cb6)
    CheckBox cb6;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.cb7)
    CheckBox cb7;
    @BindView(R.id.cb8)
    CheckBox cb8;
    @BindView(R.id.cb9)
    CheckBox cb9;
    @BindView(R.id.ll5)
    LinearLayout ll5;
    @BindView(R.id.rb1)
    CheckBox rb1;
    @BindView(R.id.rb2)
    CheckBox rb2;
    @BindView(R.id.rb3)
    CheckBox rb3;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.rb4)
    CheckBox rb4;
    @BindView(R.id.rb5)
    CheckBox rb5;
    @BindView(R.id.rb6)
    CheckBox rb6;
    @BindView(R.id.ll4)
    LinearLayout ll4;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.etLeader)
    EditText etLeader;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.etLeader1)
    EditText etLeader1;
    @BindView(R.id.tvLeader2)
    TextView tvLeader2;
    @BindView(R.id.etLeader2)
    EditText etLeader2;
    @BindView(R.id.tvLeader3)
    TextView tvLeader3;
    @BindView(R.id.etLeader3)
    EditText etLeader3;
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.btnT)
    FloatingActionButton btnT;
    @BindView(R.id.tvText)
    TextView tvText;
    @BindView(R.id.btnHistory)
    Button btnHistory;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tvBM)
    TextView tvBM;
    @BindView(R.id.etBM)
    EditText etBM;
    @BindView(R.id.llData)
    LinearLayout llData;
    @BindView(R.id.tvLeaderW)
    TextView tvLeaderW;
    @BindView(R.id.tvLeader1W)
    TextView tvLeader1W;
    @BindView(R.id.tvLeader2W)
    TextView tvLeader2W;
    @BindView(R.id.tvLeader3W)
    TextView tvLeader3W;
    @BindView(R.id.tvspr)
    TextView tvspr;
    @BindView(R.id.llShenPiRen)
    LinearLayout llShenPiRen;
    @BindView(R.id.llShenPiRenList)
    LinearLayout llShenPiRenList;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.cb10)
    CheckBox cb10;
    @BindView(R.id.cb11)
    CheckBox cb11;
    @BindView(R.id.cb12)
    CheckBox cb12;
    @BindView(R.id.ll6)
    LinearLayout ll6;
    @BindView(R.id.cb13)
    CheckBox cb13;
    @BindView(R.id.cb14)
    CheckBox cb14;
    @BindView(R.id.cb15)
    CheckBox cb15;
    @BindView(R.id.ll7)
    LinearLayout ll7;
    @BindView(R.id.cb16)
    CheckBox cb16;
    @BindView(R.id.cb17)
    CheckBox cb17;
    @BindView(R.id.cb18)
    CheckBox cb18;
    @BindView(R.id.ll8)
    LinearLayout ll8;
    @BindView(R.id.cb19)
    CheckBox cb19;
    @BindView(R.id.cb20)
    CheckBox cb20;
    @BindView(R.id.cb21)
    CheckBox cb21;
    @BindView(R.id.ll9)
    LinearLayout ll9;
    @BindView(R.id.llLeaderBM)
    LinearLayout llLeaderBM;
    @BindView(R.id.llLeader)
    LinearLayout llLeader;
    @BindView(R.id.llLeader3)
    LinearLayout llLeader3;
    @BindView(R.id.llLeader1)
    LinearLayout llLeader1;
    @BindView(R.id.llLeader2)
    LinearLayout llLeader2;
    private String name, taskId, executionId, res, bmfzryj, xqbmyj, xqbmldyj, jsbmyj, jsbmldyj, zjlyj = "";
    private String mainId, signaName, destName, destType, checkTask, qianzhiData = "";
    String leader = "";
    String leaderCode = "";
    String leaderName = "";
    boolean assigned;
    String tag = "noEnd";
    String comment = "";
    String downloadData = "";
    String bmreout, xqreout, xqldreout, jsreout, jsldreout, csreout, jcreout, zjlreout, flowAssignld, serialNumber = "";

    String[] bigNametemp = null;
    String[] bigCodetemp = null;
    List<String> resultList = new ArrayList<>();
    List<String> resultList1 = new ArrayList<>();
    List<String> bigResultList = new ArrayList<>();
    List<String> bigResultList1 = new ArrayList<>();
    List<String> bigResultList2 = new ArrayList<>();
    String tag1;

    String role = "";
    String url;
    String userCode = "";
    String userName = "";
    String liushuihao = "";
    String[] nametemp = null;
    String[] codetemp = null;
    List<String> namelist = new ArrayList<>();
    List<FlowAppealWillDetail.TransBean> beanList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();

    Gson gson = new Gson();
    FlowAppealWillDetail bean;
    JSONArray jsonArray;
    JSONObject jsonObject;
    SimpleDateFormat formatter;
    Date curDate;
    String str;

    String xiangguanfujian = "";
    String btnTTag = "N";
    String runID = "";
    String upData = "";
    String piId = "";
    String flowMessage = "";
    FlowMessageAdapter adapter;
    List<FlowMessage1.DataBean> flowList = new ArrayList<>();
// app:header_title_right="@string/nullify"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        jsonArray = new JSONArray();
        jsonObject = new JSONObject();
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        curDate = new Date(System.currentTimeMillis());
        str = formatter.format(curDate);

        String superRoleName = new SharedPreferencesHelper(this, "login").getData(this, "roleName", "");
        btnUp.setVisibility(View.VISIBLE);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        Intent intent = getIntent();
        name = intent.getStringExtra("activityName");
        taskId = intent.getStringExtra("taskId");
        tag1 = intent.getStringExtra("tag");
        piId = intent.getStringExtra("piId");
        executionId = intent.getStringExtra("executionId");
        getData(name, taskId);
    }

    /**
     * 获取数据
     *
     * @param Name
     * @param taskId
     */
    private void getData(final String Name, final String taskId) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        new Thread(new Runnable() {
            @Override
            public void run() {
                //String name =URLDecoder.decode(待转值,"utf-8");
                String url = Constant.BASE_URL2 + Constant.DETAILWILL + Name + "&taskId=" + taskId + "&piId=" + piId;
                //                DBHandler dbA = new DBHandler();
//                res = dbA.OAQingJiaWillDoDex(url);
                OkHttpClient okHttpClient = new OkHttpClient();
                String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
                final Request request = new Request.Builder()
                        .url(url)
                        .addHeader("Cookie", Session)
                        .get()//默认就是GET请求，可以不写
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        handler.sendEmptyMessage(TAG_TWO);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        res = response.body().string();
                        handler.sendEmptyMessage(TAG_ONE);
                    }
                });
            }
        }).start();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_appeal_data;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setView(LayoutInflater.from(this).inflate(R.layout.dialog_with_edittext, null));
        dialog.show();
        dialog.getWindow().setContentView(R.layout.dialog_with_edittext);
        final EditText etContent = (EditText) dialog.findViewById(R.id.etContent);
        TextView tv_yes = (TextView) dialog.findViewById(R.id.yes);
        TextView tv_no = (TextView) dialog.findViewById(R.id.no);
        tv_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final String str = etContent.getText().toString();
                if (str.equals("")) {
                    Toast.makeText(FlowAppealWillDetailActivity.this, getResources().getString(R.string.nullify_reason), Toast.LENGTH_SHORT).show();
                } else {
                    dialog.dismiss();
                    ProgressDialogUtil.startLoad(FlowAppealWillDetailActivity.this, getResources().getString(R.string.get_data));
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            DBHandler dbHandler = new DBHandler();
                            String url = Constant.BASE_URL2 + Constant.NULLIFY;
                            boolean nullifyData = dbHandler.OAFlowNullify(url, taskId, str, executionId);
                            if (nullifyData) {
                                handler.sendEmptyMessage(333);
                            } else {
                                handler.sendEmptyMessage(444);
                            }
                        }
                    }).start();
                }
            }
        });
        tv_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
            }
        });
    }

    /**
     * 请求第一个处理人  之后不再让别人处理
     */
    private void getLastPerson() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.LASTPERSON;
                DBHandler dbA = new DBHandler();
                checkTask = dbA.OAQingJiaLast(url, taskId);
                if (checkTask.equals("保存失败") || checkTask.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_EIGHT);
                }
            }
        }).start();
    }

    /**
     * 获取destType  最后不是end的下一级审核人
     */
    private void getNoEndPerson() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.NOENDPERSON;
                DBHandler dbA = new DBHandler();
                qianzhiData = dbA.OAQingJiaFornt1(url, taskId, destName);
                if (qianzhiData.equals("保存失败") || qianzhiData.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_SEVEN);
                }
            }
        }).start();
    }

    //
    private void getNextPerson() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.NESTPERSON;
                DBHandler dbA = new DBHandler();
                qianzhiData = dbA.OAQingJiaFornt1(url, taskId, destName);
                if (qianzhiData.equals("保存失败") || qianzhiData.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_SEVEN);
                }
            }
        }).start();
    }

    /**
     * 设置多选框显示
     */
    private void setCbRbVer() {
        resultList.clear();
        bigResultList.clear();
        ll1.setVisibility(View.GONE);
        ll2.setVisibility(View.GONE);
        ll3.setVisibility(View.GONE);
        ll4.setVisibility(View.GONE);
        ll5.setVisibility(View.GONE);
        rb1.setChecked(false);
        rb2.setChecked(false);
        rb3.setChecked(false);
        rb4.setChecked(false);
        rb5.setChecked(false);
        rb6.setChecked(false);
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);
        cb5.setChecked(false);
        cb6.setChecked(false);
        cb7.setChecked(false);
        cb8.setChecked(false);
        cb9.setChecked(false);
        cb10.setChecked(false);
        cb11.setChecked(false);
        cb12.setChecked(false);
        cb13.setChecked(false);
        cb14.setChecked(false);
        cb15.setChecked(false);
        cb16.setChecked(false);
        cb17.setChecked(false);
        cb18.setChecked(false);
        cb19.setChecked(false);
        cb20.setChecked(false);
        cb21.setChecked(false);

        if (nametemp != null) {
            if (nametemp.length == 1) {
                rb1.setText(nametemp[0]);
                rb1.setChecked(true);
                ll3.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.INVISIBLE);
                rb3.setVisibility(View.INVISIBLE);
            }
            if (nametemp.length == 2) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                ll3.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.INVISIBLE);
            }
            if (nametemp.length == 3) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                rb3.setText(nametemp[2]);
                ll3.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.VISIBLE);
            }
            if (nametemp.length == 4) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                rb3.setText(nametemp[2]);
                rb4.setText(nametemp[3]);
                ll3.setVisibility(View.VISIBLE);
                ll4.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.VISIBLE);
                rb4.setVisibility(View.VISIBLE);
                rb5.setVisibility(View.INVISIBLE);
                rb6.setVisibility(View.INVISIBLE);
            }
            if (nametemp.length == 5) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                rb3.setText(nametemp[2]);
                rb4.setText(nametemp[3]);
                rb5.setText(nametemp[4]);
                ll3.setVisibility(View.VISIBLE);
                ll4.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.VISIBLE);
                rb4.setVisibility(View.VISIBLE);
                rb5.setVisibility(View.VISIBLE);
                rb6.setVisibility(View.INVISIBLE);
            }
            if (nametemp.length >= 6) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                rb3.setText(nametemp[2]);
                rb4.setText(nametemp[3]);
                rb5.setText(nametemp[4]);
                rb6.setText(nametemp[5]);
                ll3.setVisibility(View.VISIBLE);
                ll4.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.VISIBLE);
                rb4.setVisibility(View.VISIBLE);
                rb5.setVisibility(View.VISIBLE);
                rb6.setVisibility(View.VISIBLE);
            }
        }


        if (bigNametemp != null) {
            if (bigNametemp.length == 1) {
                cb1.setText(bigNametemp[0]);
                cb1.setChecked(true);
                ll1.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.INVISIBLE);
                cb3.setVisibility(View.INVISIBLE);
            }
            if (bigNametemp.length == 2) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                ll1.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.INVISIBLE);
            }
            if (bigNametemp.length == 3) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                ll1.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 4) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.INVISIBLE);
                cb6.setVisibility(View.INVISIBLE);
            }
            if (bigNametemp.length == 5) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.INVISIBLE);
            }
            if (bigNametemp.length == 6) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 7) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 8) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 9) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 10) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                cb10.setText(bigNametemp[9]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
                cb10.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 11) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                cb10.setText(bigNametemp[9]);
                cb11.setText(bigNametemp[10]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
                cb10.setVisibility(View.VISIBLE);
                cb11.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 12) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                cb10.setText(bigNametemp[9]);
                cb11.setText(bigNametemp[10]);
                cb12.setText(bigNametemp[11]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
                cb10.setVisibility(View.VISIBLE);
                cb11.setVisibility(View.VISIBLE);
                cb12.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 13) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                cb10.setText(bigNametemp[9]);
                cb11.setText(bigNametemp[10]);
                cb12.setText(bigNametemp[11]);
                cb13.setText(bigNametemp[12]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.VISIBLE);
                ll7.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
                cb10.setVisibility(View.VISIBLE);
                cb11.setVisibility(View.VISIBLE);
                cb12.setVisibility(View.VISIBLE);
                cb13.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 14) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                cb10.setText(bigNametemp[9]);
                cb11.setText(bigNametemp[10]);
                cb12.setText(bigNametemp[11]);
                cb13.setText(bigNametemp[12]);
                cb14.setText(bigNametemp[13]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.VISIBLE);
                ll7.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
                cb10.setVisibility(View.VISIBLE);
                cb11.setVisibility(View.VISIBLE);
                cb12.setVisibility(View.VISIBLE);
                cb13.setVisibility(View.VISIBLE);
                cb14.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 15) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                cb10.setText(bigNametemp[9]);
                cb11.setText(bigNametemp[10]);
                cb12.setText(bigNametemp[11]);
                cb13.setText(bigNametemp[12]);
                cb14.setText(bigNametemp[13]);
                cb15.setText(bigNametemp[14]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.VISIBLE);
                ll7.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
                cb10.setVisibility(View.VISIBLE);
                cb11.setVisibility(View.VISIBLE);
                cb12.setVisibility(View.VISIBLE);
                cb13.setVisibility(View.VISIBLE);
                cb14.setVisibility(View.VISIBLE);
                cb15.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 16) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                cb10.setText(bigNametemp[9]);
                cb11.setText(bigNametemp[10]);
                cb12.setText(bigNametemp[11]);
                cb13.setText(bigNametemp[12]);
                cb14.setText(bigNametemp[13]);
                cb15.setText(bigNametemp[14]);
                cb16.setText(bigNametemp[15]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.VISIBLE);
                ll7.setVisibility(View.VISIBLE);
                ll8.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
                cb10.setVisibility(View.VISIBLE);
                cb11.setVisibility(View.VISIBLE);
                cb12.setVisibility(View.VISIBLE);
                cb13.setVisibility(View.VISIBLE);
                cb14.setVisibility(View.VISIBLE);
                cb15.setVisibility(View.VISIBLE);
                cb16.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 17) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                cb10.setText(bigNametemp[9]);
                cb11.setText(bigNametemp[10]);
                cb12.setText(bigNametemp[11]);
                cb13.setText(bigNametemp[12]);
                cb14.setText(bigNametemp[13]);
                cb15.setText(bigNametemp[14]);
                cb16.setText(bigNametemp[15]);
                cb17.setText(bigNametemp[16]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.VISIBLE);
                ll7.setVisibility(View.VISIBLE);
                ll8.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
                cb10.setVisibility(View.VISIBLE);
                cb11.setVisibility(View.VISIBLE);
                cb12.setVisibility(View.VISIBLE);
                cb13.setVisibility(View.VISIBLE);
                cb14.setVisibility(View.VISIBLE);
                cb15.setVisibility(View.VISIBLE);
                cb16.setVisibility(View.VISIBLE);
                cb17.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 18) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                cb10.setText(bigNametemp[9]);
                cb11.setText(bigNametemp[10]);
                cb12.setText(bigNametemp[11]);
                cb13.setText(bigNametemp[12]);
                cb14.setText(bigNametemp[13]);
                cb15.setText(bigNametemp[14]);
                cb16.setText(bigNametemp[15]);
                cb17.setText(bigNametemp[16]);
                cb18.setText(bigNametemp[17]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.VISIBLE);
                ll7.setVisibility(View.VISIBLE);
                ll8.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
                cb10.setVisibility(View.VISIBLE);
                cb11.setVisibility(View.VISIBLE);
                cb12.setVisibility(View.VISIBLE);
                cb13.setVisibility(View.VISIBLE);
                cb14.setVisibility(View.VISIBLE);
                cb15.setVisibility(View.VISIBLE);
                cb16.setVisibility(View.VISIBLE);
                cb17.setVisibility(View.VISIBLE);
                cb18.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 19) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                cb10.setText(bigNametemp[9]);
                cb11.setText(bigNametemp[10]);
                cb12.setText(bigNametemp[11]);
                cb13.setText(bigNametemp[12]);
                cb14.setText(bigNametemp[13]);
                cb15.setText(bigNametemp[14]);
                cb16.setText(bigNametemp[15]);
                cb17.setText(bigNametemp[16]);
                cb18.setText(bigNametemp[17]);
                cb19.setText(bigNametemp[18]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.VISIBLE);
                ll7.setVisibility(View.VISIBLE);
                ll8.setVisibility(View.VISIBLE);
                ll9.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
                cb10.setVisibility(View.VISIBLE);
                cb11.setVisibility(View.VISIBLE);
                cb12.setVisibility(View.VISIBLE);
                cb13.setVisibility(View.VISIBLE);
                cb14.setVisibility(View.VISIBLE);
                cb15.setVisibility(View.VISIBLE);
                cb16.setVisibility(View.VISIBLE);
                cb17.setVisibility(View.VISIBLE);
                cb18.setVisibility(View.VISIBLE);
                cb19.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 20) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                cb10.setText(bigNametemp[9]);
                cb11.setText(bigNametemp[10]);
                cb12.setText(bigNametemp[11]);
                cb13.setText(bigNametemp[12]);
                cb14.setText(bigNametemp[13]);
                cb15.setText(bigNametemp[14]);
                cb16.setText(bigNametemp[15]);
                cb17.setText(bigNametemp[16]);
                cb18.setText(bigNametemp[17]);
                cb19.setText(bigNametemp[18]);
                cb20.setText(bigNametemp[19]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.VISIBLE);
                ll7.setVisibility(View.VISIBLE);
                ll8.setVisibility(View.VISIBLE);
                ll9.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
                cb10.setVisibility(View.VISIBLE);
                cb11.setVisibility(View.VISIBLE);
                cb12.setVisibility(View.VISIBLE);
                cb13.setVisibility(View.VISIBLE);
                cb14.setVisibility(View.VISIBLE);
                cb15.setVisibility(View.VISIBLE);
                cb16.setVisibility(View.VISIBLE);
                cb17.setVisibility(View.VISIBLE);
                cb18.setVisibility(View.VISIBLE);
                cb19.setVisibility(View.VISIBLE);
                cb20.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 21) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                cb10.setText(bigNametemp[9]);
                cb11.setText(bigNametemp[10]);
                cb12.setText(bigNametemp[11]);
                cb13.setText(bigNametemp[12]);
                cb14.setText(bigNametemp[13]);
                cb15.setText(bigNametemp[14]);
                cb16.setText(bigNametemp[15]);
                cb17.setText(bigNametemp[16]);
                cb18.setText(bigNametemp[17]);
                cb19.setText(bigNametemp[18]);
                cb20.setText(bigNametemp[19]);
                cb21.setText(bigNametemp[20]);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.VISIBLE);
                ll7.setVisibility(View.VISIBLE);
                ll8.setVisibility(View.VISIBLE);
                ll9.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
                cb10.setVisibility(View.VISIBLE);
                cb11.setVisibility(View.VISIBLE);
                cb12.setVisibility(View.VISIBLE);
                cb13.setVisibility(View.VISIBLE);
                cb14.setVisibility(View.VISIBLE);
                cb15.setVisibility(View.VISIBLE);
                cb16.setVisibility(View.VISIBLE);
                cb17.setVisibility(View.VISIBLE);
                cb18.setVisibility(View.VISIBLE);
                cb19.setVisibility(View.VISIBLE);
                cb20.setVisibility(View.VISIBLE);
                cb21.setVisibility(View.VISIBLE);
            }
        }
        ProgressDialogUtil.stopLoad();
    }

    public void getAppRovePerson() {
        ProgressDialogUtil.startLoad(FlowAppealWillDetailActivity.this, "获取数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBHandler dbA = new DBHandler();
                destType = beanList.get(0).getDestType();
                if (destType.equals("decision") || destType.equals("fork") || destType.equals("join")) {
                    handler.sendEmptyMessage(TAG_SIX);
                } else if (destType.indexOf("end") == -1) {
                    handler.sendEmptyMessage(TAG_FIVE);
                } else {
                    getLastPerson();
                }
                signaName = beanList.get(0).getName();
                destName = beanList.get(0).getDestination();
            }
        }).start();
        ProgressDialogUtil.stopLoad();
    }

    @OnClick({R.id.btnUp, R.id.tvData, R.id.btnT, R.id.btnHistory, R.id.llShenPiRen, R.id.llShenPiRenList})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llShenPiRen:
                if (btnT.getVisibility() == View.VISIBLE) {
                    if (btnTTag.equals("N")) {
                        Toast.makeText(this, "请点击加号选择路径", Toast.LENGTH_SHORT).show();
                    } else {
                        if (llShenPiRenList.getVisibility() == View.VISIBLE) {
                            llShenPiRenList.setVisibility(View.GONE);
                        } else {
                            llShenPiRenList.setVisibility(View.VISIBLE);
                        }
                    }
                } else {
                    if (llShenPiRenList.getVisibility() == View.VISIBLE) {
                        llShenPiRenList.setVisibility(View.GONE);
                    } else {
                        llShenPiRenList.setVisibility(View.VISIBLE);
                    }
                }

                break;
            case R.id.llShenPiRenList:
                break;
            case R.id.btnHistory:
                recyclerView.setVisibility(View.VISIBLE);
                ProgressDialogUtil.startLoad(FlowAppealWillDetailActivity.this, "获取数据中");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //String name =URLDecoder.decode(待转值,"utf-8");
                        String url = Constant.BASE_URL2 + Constant.FLOWMESSAGE;
                        DBHandler dbA = new DBHandler();
                        flowMessage = dbA.OAFlowMessage(url, runID);
                        if (flowMessage.equals("获取数据失败") || flowMessage.equals("")) {
                            handler.sendEmptyMessage(TAG_TWO);
                        } else {
                            handler.sendEmptyMessage(111);
                        }
                    }
                }).start();
                btnHistory.setEnabled(false);
                break;
            case R.id.btnT:
                btnTTag = "Y";
                llShenPiRenList.setVisibility(View.VISIBLE);
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        int[] location = new int[2];
                        llShenPiRen.getLocationOnScreen(location);
                        int offset = location[1] - scrollView.getMeasuredHeight();
                        scrollView.smoothScrollTo(0, Math.abs(offset));
                    }
                });
                if (beanList.size() != 0) {
                    if (beanList.size() == 1) {
                        ProgressDialogUtil.startLoad(FlowAppealWillDetailActivity.this, "获取数据中");
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                DBHandler dbA = new DBHandler();
                                destType = beanList.get(0).getDestType();
                                if (destType.equals("decision") || destType.equals("fork") || destType.equals("join")) {
                                    handler.sendEmptyMessage(TAG_SIX);
                                } else if (destType.indexOf("end") == -1) {
                                    handler.sendEmptyMessage(TAG_FIVE);
                                } else {
                                    getLastPerson();
                                }
                                signaName = beanList.get(0).getName();
                                destName = beanList.get(0).getDestination();
                            }
                        }).start();
                    } else {
                        namelist.clear();
                        for (int i = 0; i < beanList.size(); i++) {
                            namelist.add(beanList.get(i).getDestination());
                        }
                        MyAlertDialog.MyListAlertDialog(FlowAppealWillDetailActivity.this, namelist, new AlertDialogCallBackP() {
                            @Override
                            public void oneselect(final String data) {
                                ProgressDialogUtil.startLoad(FlowAppealWillDetailActivity.this, "获取数据中");
                                destName = data;
                                tvspr.setText(destName);
                                for (int i = 0; i < beanList.size(); i++) {
                                    if (destName.equals(beanList.get(i).getDestination())) {
                                        signaName = beanList.get(i).getName();
                                        destType = beanList.get(i).getDestType();
                                    }
                                }
                                if (destType.equals("decision") || destType.equals("fork") || destType.equals("join")) {
                                    handler.sendEmptyMessage(TAG_SIX);
                                } else if (destType.indexOf("end") == -1) {
                                    handler.sendEmptyMessage(TAG_FIVE);
                                } else {
                                    getLastPerson();
                                }

                            }

                            @Override
                            public void select(List<String> list) {

                            }

                            @Override
                            public void confirm() {

                            }

                            @Override
                            public void cancel() {

                            }
                        });
                        break;
                    }
                } else {
                    Toast.makeText(FlowAppealWillDetailActivity.this, "审批人为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvData:
                List<String> dataList = new ArrayList<>();
                if (!xiangguanfujian.equals("")) {
                    dataList = new MyStringSpilt().stringSpiltList(xiangguanfujian);
                    if (dataList.size() == 1) {
                        String id = new MyStringSpilt().stringSpilt(dataList.get(0));
                        final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                DBHandler dbA = new DBHandler();
                                downloadData = dbA.OAQingJiaMyDetail(url);
                                if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                                    handler.sendEmptyMessage(TAG_TWO);
                                } else {
                                    handler.sendEmptyMessage(TAG_NINE);
                                }
                            }
                        }).start();
                    } else if (dataList.size() > 1) {
                        MyAlertDialog.MyListAlertDialog(this, dataList, new AlertDialogCallBackP() {
                            @Override
                            public void oneselect(final String data1) {
                                String id = new MyStringSpilt().stringSpilt(data1);
                                final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        DBHandler dbA = new DBHandler();
                                        downloadData = dbA.OAQingJiaMyDetail(url);
                                        if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                                            handler.sendEmptyMessage(TAG_TWO);
                                        } else {
                                            handler.sendEmptyMessage(TAG_NINE);
                                        }
                                    }
                                }).start();
                            }

                            @Override
                            public void select(List<String> list) {

                            }

                            @Override
                            public void confirm() {

                            }

                            @Override
                            public void cancel() {

                            }
                        });
                    }
                }
                break;
            case R.id.btnUp:
                bean = gson.fromJson(res, FlowAppealWillDetail.class);
                bmfzryj = bean.getMainform().get(0).getBmfzryj();
                xqbmyj = bean.getMainform().get(0).getFgldyj();
                xqbmldyj = bean.getMainform().get(0).getJbfgldyj();
                jsbmyj = bean.getMainform().get(0).getBjap();
                jsbmldyj = bean.getMainform().get(0).getZjlyj();
                userName = new SharedPreferencesHelper(FlowAppealWillDetailActivity.this,
                        "login").getData(FlowAppealWillDetailActivity.this, "userStatus", "");
                userCode = new SharedPreferencesHelper(FlowAppealWillDetailActivity.this,
                        "login").getData(FlowAppealWillDetailActivity.this, "userId", "");
                jsonArray = new JSONArray();
                jsonObject = new JSONObject();
                formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                curDate = new Date(System.currentTimeMillis());
                str = formatter.format(curDate);
                if (etBM.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etBM.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etBM.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (bmfzryj.equals("")) {
                        bmfzryj = jsonArray.toString();
                    } else {
                        bmfzryj = bmfzryj + "," + jsonArray.toString();
                        bmfzryj = bmfzryj.toString().replace("],[", ",");
                    }
                }

                if (etLeader.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (xqbmyj.equals("")) {
                        xqbmyj = jsonArray.toString();
                    } else {
                        xqbmyj = xqbmyj + "," + jsonArray.toString();
                        xqbmyj = xqbmyj.toString().replace("],[", ",");
                    }
                }
                if (etLeader1.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader1.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader1.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (xqbmldyj.equals("")) {
                        xqbmldyj = jsonArray.toString();
                    } else {
                        xqbmldyj = xqbmldyj + "," + jsonArray.toString();
                        xqbmldyj = xqbmldyj.toString().replace("],[", ",");
                    }
                }
                if (etLeader2.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader2.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader2.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (jsbmyj.equals("")) {
                        jsbmyj = jsonArray.toString();
                    } else {
                        jsbmyj = jsbmyj + "," + jsonArray.toString();
                        jsbmyj = jsbmyj.toString().replace("],[", ",");
                    }
                }
                if (etLeader3.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader3.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader3.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (jsbmldyj.equals("")) {
                        jsbmldyj = jsonArray.toString();
                    } else {
                        jsbmldyj = jsbmldyj + "," + jsonArray.toString();
                        jsbmldyj = jsbmldyj.toString().replace("],[", ",");
                    }
                }

                if (comment.equals("")) {
                    if (!bmreout.equals("2") && !xqreout.equals("2") && !xqldreout.equals("2")
                            && !jsreout.equals("2") && !jsldreout.equals("2")) {
                        comment = "";
                        personSession();
                    } else if (!bmfzryj.equals("") && !jsbmldyj.equals("") && !jsbmyj.equals("")
                            && !xqbmldyj.equals("") && !jsbmyj.equals("")) {
                        comment = "";
                        personSession();
                    } else {
                        Toast.makeText(this, "请签字", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    personSession();
                }
                break;
        }
    }

    private void personSession() {
        Log.e("soso", "这里走了吗22");
        if (bigResultList.size() != 0) {
            sendData();
        } else {
            if (btnT.getVisibility() == View.VISIBLE) {
                if (btnTTag.equals("N")) {
                    Gson gson = new Gson();
                    FlowAppealWillDetail bean = gson.fromJson(res, FlowAppealWillDetail.class);
                    bmfzryj = bean.getMainform().get(0).getBmfzryj();
                    xqbmyj = bean.getMainform().get(0).getFgldyj();
                    xqbmldyj = bean.getMainform().get(0).getJbfgldyj();
                    jsbmyj = bean.getMainform().get(0).getBjap();
                    jsbmldyj = bean.getMainform().get(0).getZjlyj();
                    Toast.makeText(this, "请点击加号选择路径", Toast.LENGTH_SHORT).show();
                } else {
                    sendData();
                }
            } else {
                sendData();
            }
        }
    }

    private void sendData() {
        ProgressDialogUtil.startLoad(FlowAppealWillDetailActivity.this, "提交数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e("soso", "这里走了吗");
                String department = tvDpartment.getText().toString();
                String person = tvPerson.getText().toString();
                String time = tvTime.getText().toString();
                String data = tvShiXiang.getText().toString();
                final String userCode = new SharedPreferencesHelper(FlowAppealWillDetailActivity.this,
                        "login").getData(FlowAppealWillDetailActivity.this, "userCode", "");

                if (codetemp != null) {
                    for (String s : codetemp) {
                        resultList.add(s);
                        resultList1.add(s);
                    }
                }
                if (bigCodetemp != null) {
                    for (String s : bigCodetemp) {
                        bigResultList.add(s);
                        bigResultList1.add(s);
                    }
                }

                if (rb6.isChecked()) {
                    if (resultList.size() >= 6) {
                        resultList.remove(5);
                    }
                }
                if (!rb5.isChecked()) {
                    if (resultList.size() >= 5) {
                        resultList.remove(4);
                    }
                }
                if (!rb4.isChecked()) {
                    if (resultList.size() >= 4) {
                        resultList.remove(3);
                    }
                }
                if (!rb3.isChecked()) {
                    if (resultList.size() >= 3) {
                        resultList.remove(2);
                    }
                }
                if (!rb2.isChecked()) {
                    if (resultList.size() >= 2) {
                        resultList.remove(1);
                    }
                }
                if (!rb1.isChecked()) {
                    if (resultList.size() >= 1) {
                        resultList.remove(0);
                    }
                }

                if (cb21.isChecked()) {
                    if (bigResultList.size() >= 21) {
                        bigResultList2.add(bigResultList.get(20));
                    }
                }
                if (cb20.isChecked()) {
                    if (bigResultList.size() >= 20) {
                        bigResultList2.add(bigResultList.get(19));
                    }
                }
                if (cb19.isChecked()) {
                    if (bigResultList.size() >= 19) {
                        bigResultList2.add(bigResultList.get(18));
                    }
                }
                if (cb18.isChecked()) {
                    if (bigResultList.size() >= 18) {
                        bigResultList2.add(bigResultList.get(17));
                    }
                }
                if (cb17.isChecked()) {
                    if (bigResultList.size() >= 17) {
                        bigResultList2.add(bigResultList.get(16));
                    }
                }
                if (cb16.isChecked()) {
                    if (bigResultList.size() >= 16) {
                        bigResultList2.add(bigResultList.get(15));
                    }
                }
                if (cb15.isChecked()) {
                    if (bigResultList.size() >= 15) {
                        bigResultList2.add(bigResultList.get(14));
                    }
                }
                if (cb14.isChecked()) {
                    if (bigResultList.size() >= 14) {
                        bigResultList2.add(bigResultList.get(13));
                    }
                }
                if (cb13.isChecked()) {
                    if (bigResultList.size() >= 13) {
                        bigResultList2.add(bigResultList.get(12));
                    }
                }
                if (cb12.isChecked()) {
                    if (bigResultList.size() >= 11) {
                        bigResultList2.add(bigResultList.get(11));
                    }
                }
                if (cb11.isChecked()) {
                    if (bigResultList.size() >= 11) {
                        bigResultList2.add(bigResultList.get(10));
                    }
                }
                if (cb10.isChecked()) {
                    if (bigResultList.size() >= 10) {
                        bigResultList2.add(bigResultList.get(9));
                    }
                }
                if (cb9.isChecked()) {
                    if (bigResultList.size() >= 9) {
                        bigResultList2.add(bigResultList.get(8));
                    }
                }
                if (cb8.isChecked()) {
                    if (bigResultList.size() >= 8) {
                        bigResultList2.add(bigResultList.get(7));
                    }
                }
                if (cb7.isChecked()) {
                    if (bigResultList.size() >= 7) {
                        bigResultList2.add(bigResultList.get(6));
                    }
                }
                if (cb6.isChecked()) {
                    if (bigResultList.size() >= 6) {
                        bigResultList2.add(bigResultList.get(5));
                    }
                }
                if (cb5.isChecked()) {
                    if (bigResultList.size() >= 5) {
                        bigResultList2.add(bigResultList.get(4));
                    }
                }
                if (cb4.isChecked()) {
                    if (bigResultList.size() >= 4) {
                        bigResultList2.add(bigResultList.get(3));
                    }
                }
                if (cb3.isChecked()) {
                    if (bigResultList.size() >= 3) {
                        bigResultList2.add(bigResultList.get(2));
                    }
                }
                if (cb2.isChecked()) {
                    if (bigResultList.size() >= 2) {
                        bigResultList2.add(bigResultList.get(1));
                    }
                }
                if (cb1.isChecked()) {
                    if (bigResultList.size() >= 1) {
                        bigResultList2.add(bigResultList.get(0));
                    }
                }

                String userCodes = "";
                if (resultList.size() == 0) {
                    userCodes = resultList1.toString();
                    userCodes = userCodes.toString().replace("[", "");
                    userCodes = userCodes.toString().replace("]", "");
                } else {
                    userCodes = resultList.toString();
                    userCodes = userCodes.toString().replace("[", "");
                    userCodes = userCodes.toString().replace("]", "");
                }

                if (bigResultList2.size() == 0 && bigResultList1.size() != 0) {
                    Looper.prepare();
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(FlowAppealWillDetailActivity.this, "请选择审批人", Toast.LENGTH_SHORT).show();
                    Looper.loop();
                } else if (resultList.size() == 0 && resultList1.size() != 0) {
                    Looper.prepare();
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(FlowAppealWillDetailActivity.this, "请选择审批人", Toast.LENGTH_SHORT).show();
                    Looper.loop();
                } else {
                    String bigUserCodes = bigResultList2.toString();
                    bigUserCodes = bigUserCodes.toString().replace("[", "");
                    bigUserCodes = bigUserCodes.toString().replace("]", "");

                    if (!bigUserCodes.equals("") && !userCodes.equals("")) {
                        flowAssignld = leader + ":" + role + "|" + bigUserCodes + ":" + userCodes;
                        flowAssignld = flowAssignld.replace(" ", "");
                        flowAssignld = flowAssignld.replace(":|", "|");
                    } else if (!bigUserCodes.equals("") && userCodes.equals("")) {
                        flowAssignld = leader + ":" + role + "|" + bigUserCodes;
                        flowAssignld = flowAssignld.replace(" ", "");
                        flowAssignld = flowAssignld.replace(":|", "|");
                    } else {
                        flowAssignld = destName + "|" + userCodes;
                        flowAssignld = flowAssignld.replace(" ", "");
                        flowAssignld = flowAssignld.replace(":|", "|");
                        flowAssignld = flowAssignld.replace(":", "");
                    }
                }
                String url = Constant.BASE_URL2 + Constant.EXAMINEDATA;
                DBHandler dbA = new DBHandler();
                upData = dbA.OAAppealLeader(url, department, person, time, userCode, data,
                        destName, taskId, flowAssignld, mainId, xqbmyj, xqbmldyj, jsbmyj, jsbmldyj,
                        serialNumber, comment, liushuihao, bmfzryj, "", signaName);
                Log.e("soso", "这里走了吗" + upData);
                if (upData.equals("")) {
                    handler.sendEmptyMessage(TAG_THERE);
                } else {
                    handler.sendEmptyMessage(TAG_FOUR);
                }
            }
        }).start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 333:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(FlowAppealWillDetailActivity.this, getResources().getString(R.string.c_success), Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case 444:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(FlowAppealWillDetailActivity.this, getResources().getString(R.string.c_false), Toast.LENGTH_SHORT).show();
                    break;
                case 111:
                    Gson gsonF = new Gson();
                    FlowMessage1 beanF = gsonF.fromJson(flowMessage, FlowMessage1.class);
                    for (int i = 0; i < beanF.getData().size(); i++) {
                        flowList.add(beanF.getData().get(i));
                    }
                    adapter = new FlowMessageAdapter(FlowAppealWillDetailActivity.this, flowList);
                    recyclerView.setAdapter(adapter);
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_ONE:
                    Gson gson = new Gson();
                    FlowAppealWillDetail bean = gson.fromJson(res, FlowAppealWillDetail.class);
                    taskId = bean.getTaskId();
                    final String date = bean.getMainform().get(0).getShenQingShiJian();
                    final String person = bean.getMainform().get(0).getShenQingRen();
                    final String department = bean.getMainform().get(0).getSqbm();
                    final String data = bean.getMainform().get(0).getQingshishangbaoneirong().toString();
                    liushuihao = bean.getMainform().get(0).getLiuShuiHao();
                    xiangguanfujian = bean.getMainform().get(0).getXiangGuanFuJian().toString();
                    runID = bean.getMainform().get(0).getRunId();
                    if (xiangguanfujian.equals("")) {
                        llData.setVisibility(View.GONE);
                    } else {
                        tvData.setText(xiangguanfujian);
                    }

                    tvTime.setText(date);
                    tvPerson.setText(person);
                    tvShiXiang.setText(data);
                    tvDpartment.setText(department);

                    bmfzryj = bean.getMainform().get(0).getBmfzryj();
                    xqbmyj = bean.getMainform().get(0).getFgldyj();
                    xqbmldyj = bean.getMainform().get(0).getJbfgldyj();
                    jsbmyj = bean.getMainform().get(0).getBjap();
                    jsbmldyj = bean.getMainform().get(0).getZjlyj();
                    mainId = String.valueOf(bean.getMainform().get(0).getMainId());
                    for (int i = 0; i < bean.getTrans().size(); i++) {
                        beanList.add(bean.getTrans().get(i));
                    }

                    String wordbm = "";
                    if (bmfzryj != null && !bmfzryj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(bmfzryj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    wordbm = wordbm + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvBM.getVisibility() == View.VISIBLE) {
                            tvBM.setText(wordbm);
                            etBM.setHint(wordbm);
                        } else {
                            etBM.setHint(wordbm);
                        }
                    }else {
                        llLeaderBM.setVisibility(View.GONE);
                    }

                    String word4 = "";
                    if (jsbmldyj != null && !jsbmldyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(jsbmldyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word4 = word4 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader3.getVisibility() == View.VISIBLE) {
                            tvLeader3.setText(word4);
                            etLeader3.setHint(word4);
                        } else {
                            etLeader3.setHint(word4);
                        }
                    }else {
                        llLeader3.setVisibility(View.GONE);
                    }
                    String word3 = "";
                    if (jsbmyj != null && !jsbmyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(jsbmyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word3 = word3 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader2.getVisibility() == View.VISIBLE) {
                            tvLeader2.setText(word3);
                            etLeader2.setHint(word3);
                        } else {
                            etLeader2.setHint(word3);
                        }
                    }else {
                        llLeader2.setVisibility(View.GONE);
                    }
                    String word2 = "";
                    if (xqbmldyj != null && !xqbmldyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(xqbmldyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word2 = word2 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader1.getVisibility() == View.VISIBLE) {
                            tvLeader1.setText(word2);
                            etLeader1.setHint(word2);
                        } else {
                            etLeader1.setHint(word2);
                        }
                    }else {
                        llLeader1.setVisibility(View.GONE);
                    }
                    String word1 = "";
                    if (xqbmyj != null && !xqbmyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(xqbmyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word1 = word1 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader.getVisibility() == View.VISIBLE) {
                            tvLeader.setText(word1);
                            etLeader.setHint(word1);
                        } else {
                            etLeader.setHint(word1);
                        }
                    }else {
                        llLeader.setVisibility(View.GONE);
                    }

                    String formRights = bean.getFormRights();
                    try {
                        JSONObject jsonObject = new JSONObject(formRights);
                        xqreout = jsonObject.getString("fgldyj");
                        xqldreout = jsonObject.getString("jbfgldyj");
                        jsreout = jsonObject.getString("bjap");
                        jsldreout = jsonObject.getString("zjlyj");
                        bmreout = jsonObject.getString("bmfzryj");
                        if (bmreout.equals("2")) {
                            tvBM.setVisibility(View.GONE);
                            etBM.setVisibility(View.VISIBLE);
                            llLeaderBM.setVisibility(View.VISIBLE);
                        } else {
                            tvBM.setVisibility(View.VISIBLE);
                            etBM.setVisibility(View.GONE);
                            tvLeaderW.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }
                        if (xqreout.equals("2")) {
                            tvLeader.setVisibility(View.GONE);
                            etLeader.setVisibility(View.VISIBLE);
                            llLeader.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader.setVisibility(View.VISIBLE);
                            etLeader.setVisibility(View.GONE);
                            tvLeader1W.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }
                        if (xqldreout.equals("2")) {
                            tvLeader1.setVisibility(View.GONE);
                            etLeader1.setVisibility(View.VISIBLE);
                            llLeader1.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader1.setVisibility(View.VISIBLE);
                            etLeader1.setVisibility(View.GONE);
                            tvLeader2W.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }
                        if (jsreout.equals("2")) {
                            tvLeader2.setVisibility(View.GONE);
                            etLeader2.setVisibility(View.VISIBLE);
                            llLeader2.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader2.setVisibility(View.VISIBLE);
                            etLeader2.setVisibility(View.GONE);
                            tvLeader3W.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }
                        if (jsldreout.equals("2")) {
                            tvLeader3.setVisibility(View.GONE);
                            etLeader3.setVisibility(View.VISIBLE);
                            llLeader3.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader3.setVisibility(View.VISIBLE);
                            etLeader3.setVisibility(View.GONE);
                        }

                        if (bmreout.equals("1") && xqreout.equals("1") && xqldreout.equals("1") && jsreout.equals("1") && jsldreout.equals("1")) {
                            Toast.makeText(FlowAppealWillDetailActivity.this, "您对当前流程只有读取权限", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if (bean.isRevoke()) {
                        Toast.makeText(FlowAppealWillDetailActivity.this, "当前流程已被追回", Toast.LENGTH_SHORT).show();
                    }
                    ProgressDialogUtil.stopLoad();
                    if (beanList.size() == 1) {
                        btnT.setVisibility(View.GONE);
                        tvText.setVisibility(View.GONE);
                        ProgressDialogUtil.startLoad(FlowAppealWillDetailActivity.this, "获取审核人");
                        getAppRovePerson();
                    } else {
                        tvspr.setText("请点击“+”选择路径");
                    }
                    break;
                case TAG_TWO:
                    Toast.makeText(FlowAppealWillDetailActivity.this, "操作失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_THERE:
                    Toast.makeText(FlowAppealWillDetailActivity.this, "提交数据成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case TAG_FOUR:
                    Toast.makeText(FlowAppealWillDetailActivity.this, upData, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_FIVE:
                    getNoEndPerson();
                    break;
                case TAG_SIX:
                    getNextPerson();
                    break;
                case TAG_SEVEN:
                    bigNametemp = null;
                    bigCodetemp = null;
                    Gson gson1 = new Gson();
                    FlowContractPerson bean1 = gson1.fromJson(qianzhiData, FlowContractPerson.class);
                    if (bean1.getData() != null) {
                        if (bean1.getData().size() > 1) {
                            role = bean1.getData().get(1).getRole();
                            userCode = bean1.getData().get(1).getUserNames();
                            userName = bean1.getData().get(1).getUserCodes();
                            nametemp = userName.split(",");
                            codetemp = userCode.split(",");
                        }
                        leader = bean1.getData().get(0).getRole();
                        leaderCode = bean1.getData().get(0).getUserNames();
                        leaderName = bean1.getData().get(0).getUserCodes();
                        bigNametemp = leaderName.split(",");
                        bigCodetemp = leaderCode.split(",");
                    }
                    setCbRbVer();
                    break;
                case TAG_EIGHT:
                    Toast.makeText(FlowAppealWillDetailActivity.this, "流程已到最后一步，请提交", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_NINE:
                    Gson gson2 = new Gson();
                    Filed filed = gson2.fromJson(downloadData, Filed.class);
                    String filePath = filed.getData().getFilePath();
                    String url = Constant.FIELDETAIL + filePath;
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    break;
            }
        }
    };

}
