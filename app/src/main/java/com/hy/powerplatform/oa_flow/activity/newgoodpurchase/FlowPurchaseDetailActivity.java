package com.hy.powerplatform.oa_flow.activity.newgoodpurchase;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.activity.newgoodpurchase.bean.NewGoodOurchaseWillDetail;
import com.hy.powerplatform.oa_flow.adapter.FlowMessageAdapter;
import com.hy.powerplatform.oa_flow.bean.Filed;
import com.hy.powerplatform.oa_flow.bean.FlowMessage1;
import com.hy.powerplatform.oa_flow.util.AlertDialogEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FIVE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_NINE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_SIX;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class FlowPurchaseDetailActivity extends BaseActivity {


    @BindView(R.id.header)
    Header header;
    @BindView(R.id.etClass)
    EditText etClass;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.etPerson)
    EditText etPerson;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.spinnerzc)
    Spinner spinnerzc;
    @BindView(R.id.tvZc)
    TextView tvZc;
    @BindView(R.id.spinnertype)
    Spinner spinnertype;
    @BindView(R.id.tvtype)
    TextView tvtype;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.etName1)
    EditText etName1;
    @BindView(R.id.tvName1)
    TextView tvName1;
    @BindView(R.id.etGG1)
    EditText etGG1;
    @BindView(R.id.tvGG1)
    TextView tvGG1;
    @BindView(R.id.etYS1)
    EditText etYS1;
    @BindView(R.id.tvYS1)
    TextView tvYS1;
    @BindView(R.id.etNum1)
    EditText etNum1;
    @BindView(R.id.tvNum1)
    TextView tvNum1;
    @BindView(R.id.etMoney1)
    EditText etMoney1;
    @BindView(R.id.tvMoney1)
    TextView tvMoney1;
    @BindView(R.id.etAllMoney1)
    EditText etAllMoney1;
    @BindView(R.id.tvAllMoney1)
    TextView tvAllMoney1;
    @BindView(R.id.tvAdd1)
    TextView tvAdd1;
    @BindView(R.id.tvCut1)
    TextView tvCut1;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.etName2)
    EditText etName2;
    @BindView(R.id.tvName2)
    TextView tvName2;
    @BindView(R.id.etGG2)
    EditText etGG2;
    @BindView(R.id.tvGG2)
    TextView tvGG2;
    @BindView(R.id.etYS2)
    EditText etYS2;
    @BindView(R.id.tvYS2)
    TextView tvYS2;
    @BindView(R.id.etNum2)
    EditText etNum2;
    @BindView(R.id.tvNum2)
    TextView tvNum2;
    @BindView(R.id.etMoney2)
    EditText etMoney2;
    @BindView(R.id.tvMoney2)
    TextView tvMoney2;
    @BindView(R.id.etAllMoney2)
    EditText etAllMoney2;
    @BindView(R.id.tvAllMoney2)
    TextView tvAllMoney2;
    @BindView(R.id.tvAdd2)
    TextView tvAdd2;
    @BindView(R.id.tvCut2)
    TextView tvCut2;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.etName3)
    EditText etName3;
    @BindView(R.id.tvName3)
    TextView tvName3;
    @BindView(R.id.etGG3)
    EditText etGG3;
    @BindView(R.id.tvGG3)
    TextView tvGG3;
    @BindView(R.id.etYS3)
    EditText etYS3;
    @BindView(R.id.tvYS3)
    TextView tvYS3;
    @BindView(R.id.etNum3)
    EditText etNum3;
    @BindView(R.id.tvNum3)
    TextView tvNum3;
    @BindView(R.id.etMoney3)
    EditText etMoney3;
    @BindView(R.id.tvMoney3)
    TextView tvMoney3;
    @BindView(R.id.etAllMoney3)
    EditText etAllMoney3;
    @BindView(R.id.tvAllMoney3)
    TextView tvAllMoney3;
    @BindView(R.id.tvAdd3)
    TextView tvAdd3;
    @BindView(R.id.tvCut3)
    TextView tvCut3;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.etName4)
    EditText etName4;
    @BindView(R.id.tvName4)
    TextView tvName4;
    @BindView(R.id.etGG4)
    EditText etGG4;
    @BindView(R.id.tvGG4)
    TextView tvGG4;
    @BindView(R.id.etYS4)
    EditText etYS4;
    @BindView(R.id.tvYS4)
    TextView tvYS4;
    @BindView(R.id.etNum4)
    EditText etNum4;
    @BindView(R.id.tvNum4)
    TextView tvNum4;
    @BindView(R.id.etMoney4)
    EditText etMoney4;
    @BindView(R.id.tvMoney4)
    TextView tvMoney4;
    @BindView(R.id.etAllMoney4)
    EditText etAllMoney4;
    @BindView(R.id.tvAllMoney4)
    TextView tvAllMoney4;
    @BindView(R.id.tvAdd4)
    TextView tvAdd4;
    @BindView(R.id.tvCut4)
    TextView tvCut4;
    @BindView(R.id.ll4)
    LinearLayout ll4;
    @BindView(R.id.etName5)
    EditText etName5;
    @BindView(R.id.tvName5)
    TextView tvName5;
    @BindView(R.id.etGG5)
    EditText etGG5;
    @BindView(R.id.tvGG5)
    TextView tvGG5;
    @BindView(R.id.etYS5)
    EditText etYS5;
    @BindView(R.id.tvYS5)
    TextView tvYS5;
    @BindView(R.id.etNum5)
    EditText etNum5;
    @BindView(R.id.tvNum5)
    TextView tvNum5;
    @BindView(R.id.etMoney5)
    EditText etMoney5;
    @BindView(R.id.tvMoney5)
    TextView tvMoney5;
    @BindView(R.id.etAllMoney5)
    EditText etAllMoney5;
    @BindView(R.id.tvAllMoney5)
    TextView tvAllMoney5;
    @BindView(R.id.tvAdd5)
    TextView tvAdd5;
    @BindView(R.id.tvCut5)
    TextView tvCut5;
    @BindView(R.id.ll5)
    LinearLayout ll5;
    @BindView(R.id.etName6)
    EditText etName6;
    @BindView(R.id.tvName6)
    TextView tvName6;
    @BindView(R.id.etGG6)
    EditText etGG6;
    @BindView(R.id.tvGG6)
    TextView tvGG6;
    @BindView(R.id.etYS6)
    EditText etYS6;
    @BindView(R.id.tvYS6)
    TextView tvYS6;
    @BindView(R.id.etNum6)
    EditText etNum6;
    @BindView(R.id.tvNum6)
    TextView tvNum6;
    @BindView(R.id.etMoney6)
    EditText etMoney6;
    @BindView(R.id.tvMoney6)
    TextView tvMoney6;
    @BindView(R.id.etAllMoney6)
    EditText etAllMoney6;
    @BindView(R.id.tvAllMoney6)
    TextView tvAllMoney6;
    @BindView(R.id.tvAdd6)
    TextView tvAdd6;
    @BindView(R.id.tvCut6)
    TextView tvCut6;
    @BindView(R.id.ll6)
    LinearLayout ll6;
    @BindView(R.id.etName7)
    EditText etName7;
    @BindView(R.id.tvName7)
    TextView tvName7;
    @BindView(R.id.etGG7)
    EditText etGG7;
    @BindView(R.id.tvGG7)
    TextView tvGG7;
    @BindView(R.id.etYS7)
    EditText etYS7;
    @BindView(R.id.tvYS7)
    TextView tvYS7;
    @BindView(R.id.etNum7)
    EditText etNum7;
    @BindView(R.id.tvNum7)
    TextView tvNum7;
    @BindView(R.id.etMoney7)
    EditText etMoney7;
    @BindView(R.id.tvMoney7)
    TextView tvMoney7;
    @BindView(R.id.etAllMoney7)
    EditText etAllMoney7;
    @BindView(R.id.tvAllMoney7)
    TextView tvAllMoney7;
    @BindView(R.id.tvAdd7)
    TextView tvAdd7;
    @BindView(R.id.tvCut7)
    TextView tvCut7;
    @BindView(R.id.ll7)
    LinearLayout ll7;
    @BindView(R.id.etName8)
    EditText etName8;
    @BindView(R.id.tvName8)
    TextView tvName8;
    @BindView(R.id.etGG8)
    EditText etGG8;
    @BindView(R.id.tvGG8)
    TextView tvGG8;
    @BindView(R.id.etYS8)
    EditText etYS8;
    @BindView(R.id.tvYS8)
    TextView tvYS8;
    @BindView(R.id.etNum8)
    EditText etNum8;
    @BindView(R.id.tvNum8)
    TextView tvNum8;
    @BindView(R.id.etMoney8)
    EditText etMoney8;
    @BindView(R.id.tvMoney8)
    TextView tvMoney8;
    @BindView(R.id.etAllMoney8)
    EditText etAllMoney8;
    @BindView(R.id.tvAllMoney8)
    TextView tvAllMoney8;
    @BindView(R.id.tvAdd8)
    TextView tvAdd8;
    @BindView(R.id.tvCut8)
    TextView tvCut8;
    @BindView(R.id.ll8)
    LinearLayout ll8;
    @BindView(R.id.etName9)
    EditText etName9;
    @BindView(R.id.tvName9)
    TextView tvName9;
    @BindView(R.id.etGG9)
    EditText etGG9;
    @BindView(R.id.tvGG9)
    TextView tvGG9;
    @BindView(R.id.etYS9)
    EditText etYS9;
    @BindView(R.id.tvYS9)
    TextView tvYS9;
    @BindView(R.id.etNum9)
    EditText etNum9;
    @BindView(R.id.tvNum9)
    TextView tvNum9;
    @BindView(R.id.etMoney9)
    EditText etMoney9;
    @BindView(R.id.tvMoney9)
    TextView tvMoney9;
    @BindView(R.id.etAllMoney9)
    EditText etAllMoney9;
    @BindView(R.id.tvAllMoney9)
    TextView tvAllMoney9;
    @BindView(R.id.tvAdd9)
    TextView tvAdd9;
    @BindView(R.id.tvCut9)
    TextView tvCut9;
    @BindView(R.id.ll9)
    LinearLayout ll9;
    @BindView(R.id.etName10)
    EditText etName10;
    @BindView(R.id.tvName10)
    TextView tvName10;
    @BindView(R.id.etGG10)
    EditText etGG10;
    @BindView(R.id.tvGG10)
    TextView tvGG10;
    @BindView(R.id.etYS10)
    EditText etYS10;
    @BindView(R.id.tvYS10)
    TextView tvYS10;
    @BindView(R.id.etNum10)
    EditText etNum10;
    @BindView(R.id.tvNum10)
    TextView tvNum10;
    @BindView(R.id.etMoney10)
    EditText etMoney10;
    @BindView(R.id.tvMoney10)
    TextView tvMoney10;
    @BindView(R.id.etAllMoney10)
    EditText etAllMoney10;
    @BindView(R.id.tvAllMoney10)
    TextView tvAllMoney10;
    @BindView(R.id.tvAdd10)
    TextView tvAdd10;
    @BindView(R.id.tvCut10)
    TextView tvCut10;
    @BindView(R.id.ll10)
    LinearLayout ll10;
    @BindView(R.id.tvAllNum)
    TextView tvAllNum;
    @BindView(R.id.tvHeJi)
    TextView tvHeJi;
    @BindView(R.id.etPFName1)
    EditText etPFName1;
    @BindView(R.id.tvPFName1)
    TextView tvPFName1;
    @BindView(R.id.etPFNum1)
    EditText etPFNum1;
    @BindView(R.id.tvPFNum1)
    TextView tvPFNum1;
    @BindView(R.id.etPFMoney1)
    EditText etPFMoney1;
    @BindView(R.id.tvPFMoney1)
    TextView tvPFMoney1;
    @BindView(R.id.etPFAllMoney1)
    EditText etPFAllMoney1;
    @BindView(R.id.tvPFAllMoney1)
    TextView tvPFAllMoney1;
    @BindView(R.id.ll11)
    LinearLayout ll11;
    @BindView(R.id.etPFName2)
    EditText etPFName2;
    @BindView(R.id.tvPFName2)
    TextView tvPFName2;
    @BindView(R.id.etPFNum2)
    EditText etPFNum2;
    @BindView(R.id.tvPFNum2)
    TextView tvPFNum2;
    @BindView(R.id.etPFMoney2)
    EditText etPFMoney2;
    @BindView(R.id.tvPFMoney2)
    TextView tvPFMoney2;
    @BindView(R.id.etPFAllMoney2)
    EditText etPFAllMoney2;
    @BindView(R.id.tvPFAllMoney2)
    TextView tvPFAllMoney2;
    @BindView(R.id.ll122)
    LinearLayout ll122;
    @BindView(R.id.etPFName3)
    EditText etPFName3;
    @BindView(R.id.tvPFName3)
    TextView tvPFName3;
    @BindView(R.id.etPFNum3)
    EditText etPFNum3;
    @BindView(R.id.tvPFNum3)
    TextView tvPFNum3;
    @BindView(R.id.etPFMoney3)
    EditText etPFMoney3;
    @BindView(R.id.tvPFMoney3)
    TextView tvPFMoney3;
    @BindView(R.id.etPFAllMoney3)
    EditText etPFAllMoney3;
    @BindView(R.id.tvPFAllMoney3)
    TextView tvPFAllMoney3;
    @BindView(R.id.ll33)
    LinearLayout ll33;
    @BindView(R.id.etPFName4)
    EditText etPFName4;
    @BindView(R.id.tvPFName4)
    TextView tvPFName4;
    @BindView(R.id.etPFNum4)
    EditText etPFNum4;
    @BindView(R.id.tvPFNum4)
    TextView tvPFNum4;
    @BindView(R.id.etPFMoney4)
    EditText etPFMoney4;
    @BindView(R.id.tvPFMoney4)
    TextView tvPFMoney4;
    @BindView(R.id.etPFAllMoney4)
    EditText etPFAllMoney4;
    @BindView(R.id.tvPFAllMoney4)
    TextView tvPFAllMoney4;
    @BindView(R.id.ll144)
    LinearLayout ll144;
    @BindView(R.id.etPFName5)
    EditText etPFName5;
    @BindView(R.id.tvPFName5)
    TextView tvPFName5;
    @BindView(R.id.etPFNum5)
    EditText etPFNum5;
    @BindView(R.id.tvPFNum5)
    TextView tvPFNum5;
    @BindView(R.id.etPFMoney5)
    EditText etPFMoney5;
    @BindView(R.id.tvPFMoney5)
    TextView tvPFMoney5;
    @BindView(R.id.etPFAllMoney5)
    EditText etPFAllMoney5;
    @BindView(R.id.tvPFAllMoney5)
    TextView tvPFAllMoney5;
    @BindView(R.id.ll55)
    LinearLayout ll55;
    @BindView(R.id.etPFName6)
    EditText etPFName6;
    @BindView(R.id.tvPFName6)
    TextView tvPFName6;
    @BindView(R.id.etPFNum6)
    EditText etPFNum6;
    @BindView(R.id.tvPFNum6)
    TextView tvPFNum6;
    @BindView(R.id.etPFMoney6)
    EditText etPFMoney6;
    @BindView(R.id.tvPFMoney6)
    TextView tvPFMoney6;
    @BindView(R.id.etPFAllMoney6)
    EditText etPFAllMoney6;
    @BindView(R.id.tvPFAllMoney6)
    TextView tvPFAllMoney6;
    @BindView(R.id.ll66)
    LinearLayout ll66;
    @BindView(R.id.etPFName7)
    EditText etPFName7;
    @BindView(R.id.tvPFName7)
    TextView tvPFName7;
    @BindView(R.id.etPFNum7)
    EditText etPFNum7;
    @BindView(R.id.tvPFNum7)
    TextView tvPFNum7;
    @BindView(R.id.etPFMoney7)
    EditText etPFMoney7;
    @BindView(R.id.tvPFMoney7)
    TextView tvPFMoney7;
    @BindView(R.id.etPFAllMoney7)
    EditText etPFAllMoney7;
    @BindView(R.id.tvPFAllMoney7)
    TextView tvPFAllMoney7;
    @BindView(R.id.ll77)
    LinearLayout ll77;
    @BindView(R.id.etPFName8)
    EditText etPFName8;
    @BindView(R.id.tvPFName8)
    TextView tvPFName8;
    @BindView(R.id.etPFNum8)
    EditText etPFNum8;
    @BindView(R.id.tvPFNum8)
    TextView tvPFNum8;
    @BindView(R.id.etPFMoney8)
    EditText etPFMoney8;
    @BindView(R.id.tvPFMoney8)
    TextView tvPFMoney8;
    @BindView(R.id.etPFAllMoney8)
    EditText etPFAllMoney8;
    @BindView(R.id.tvPFAllMoney8)
    TextView tvPFAllMoney8;
    @BindView(R.id.ll88)
    LinearLayout ll88;
    @BindView(R.id.etPFName9)
    EditText etPFName9;
    @BindView(R.id.tvPFName9)
    TextView tvPFName9;
    @BindView(R.id.etPFNum9)
    EditText etPFNum9;
    @BindView(R.id.tvPFNum9)
    TextView tvPFNum9;
    @BindView(R.id.etPFMoney9)
    EditText etPFMoney9;
    @BindView(R.id.tvPFMoney9)
    TextView tvPFMoney9;
    @BindView(R.id.etPFAllMoney9)
    EditText etPFAllMoney9;
    @BindView(R.id.tvPFAllMoney9)
    TextView tvPFAllMoney9;
    @BindView(R.id.ll99)
    LinearLayout ll99;
    @BindView(R.id.etPFName10)
    EditText etPFName10;
    @BindView(R.id.tvPFName10)
    TextView tvPFName10;
    @BindView(R.id.etPFNum10)
    EditText etPFNum10;
    @BindView(R.id.tvPFNum10)
    TextView tvPFNum10;
    @BindView(R.id.etPFMoney10)
    EditText etPFMoney10;
    @BindView(R.id.tvPFMoney10)
    TextView tvPFMoney10;
    @BindView(R.id.etPFAllMoney10)
    EditText etPFAllMoney10;
    @BindView(R.id.tvPFAllMoney10)
    TextView tvPFAllMoney10;
    @BindView(R.id.ll1010)
    LinearLayout ll1010;
    @BindView(R.id.HSView)
    HorizontalScrollView HSView;
    @BindView(R.id.tvPFAllNum)
    TextView tvPFAllNum;
    @BindView(R.id.llPFNum)
    LinearLayout llPFNum;
    @BindView(R.id.tvPFAllMoney)
    TextView tvPFAllMoney;
    @BindView(R.id.llPFMoney)
    LinearLayout llPFMoney;
    @BindView(R.id.etUse)
    EditText etUse;
    @BindView(R.id.tvspr)
    TextView tvspr;
    @BindView(R.id.llShenPiRen)
    LinearLayout llShenPiRen;
    @BindView(R.id.cb1)
    CheckBox cb1;
    @BindView(R.id.cb2)
    CheckBox cb2;
    @BindView(R.id.cb3)
    CheckBox cb3;
    @BindView(R.id.llspr1)
    LinearLayout llspr1;
    @BindView(R.id.cb4)
    CheckBox cb4;
    @BindView(R.id.cb5)
    CheckBox cb5;
    @BindView(R.id.cb6)
    CheckBox cb6;
    @BindView(R.id.llspr2)
    LinearLayout llspr2;
    @BindView(R.id.cb7)
    CheckBox cb7;
    @BindView(R.id.cb8)
    CheckBox cb8;
    @BindView(R.id.cb9)
    CheckBox cb9;
    @BindView(R.id.llspr5)
    LinearLayout llspr5;
    @BindView(R.id.cb10)
    CheckBox cb10;
    @BindView(R.id.cb11)
    CheckBox cb11;
    @BindView(R.id.cb12)
    CheckBox cb12;
    @BindView(R.id.llspr6)
    LinearLayout llspr6;
    @BindView(R.id.rb1)
    CheckBox rb1;
    @BindView(R.id.rb2)
    CheckBox rb2;
    @BindView(R.id.rb3)
    CheckBox rb3;
    @BindView(R.id.llspr3)
    LinearLayout llspr3;
    @BindView(R.id.rb4)
    CheckBox rb4;
    @BindView(R.id.rb5)
    CheckBox rb5;
    @BindView(R.id.rb6)
    CheckBox rb6;
    @BindView(R.id.llspr4)
    LinearLayout llspr4;
    @BindView(R.id.llShenPiRenList)
    LinearLayout llShenPiRenList;
    @BindView(R.id.etLeader)
    EditText etLeader;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.llLeader)
    LinearLayout llLeader;
    @BindView(R.id.etLeader1)
    EditText etLeader1;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.llLeader1)
    LinearLayout llLeader1;
    @BindView(R.id.etLeader2)
    EditText etLeader2;
    @BindView(R.id.tvLeader2)
    TextView tvLeader2;
    @BindView(R.id.llLeader2)
    LinearLayout llLeader2;
    @BindView(R.id.etLeader3)
    EditText etLeader3;
    @BindView(R.id.tvLeader3)
    TextView tvLeader3;
    @BindView(R.id.llLeader3)
    LinearLayout llLeader3;
    @BindView(R.id.etLeader4)
    EditText etLeader4;
    @BindView(R.id.tvLeader4)
    TextView tvLeader4;
    @BindView(R.id.llLeader4)
    LinearLayout llLeader4;
    @BindView(R.id.etLeader5)
    EditText etLeader5;
    @BindView(R.id.tvLeader5)
    TextView tvLeader5;
    @BindView(R.id.llLeader5)
    LinearLayout llLeader5;
    @BindView(R.id.etLeader6)
    EditText etLeader6;
    @BindView(R.id.tvLeader6)
    TextView tvLeader6;
    @BindView(R.id.llLeader6)
    LinearLayout llLeader6;
    @BindView(R.id.etLeader7)
    EditText etLeader7;
    @BindView(R.id.tvLeader7)
    TextView tvLeader7;
    @BindView(R.id.llLeader7)
    LinearLayout llLeader7;
    @BindView(R.id.btnT)
    FloatingActionButton btnT;
    @BindView(R.id.tvText)
    TextView tvText;
    @BindView(R.id.llDown)
    LinearLayout llDown;
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.btnHistory)
    Button btnHistory;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private String res;
    String flowMessage = "";

    String xiangguanfujian = "";
    String runID = "";
    String downloadData = "";
    FlowMessageAdapter adapter;
    List<FlowMessage1.DataBean> flowList = new ArrayList<>();
    //签字意见
    String bmyj = "", cwbyj = "", zcgkbmyj = "", cgbyj = "", bmfgldyj = "", cgfgldyj = "", cwzjyj = "", zjl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        header.setTvRight("追回");
        header.setVisibility(View.VISIBLE);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        btnT.setVisibility(View.GONE);
        tvText.setVisibility(View.GONE);
        btnUp.setVisibility(View.GONE);
        Intent intent = getIntent();
        final String runId = intent.getStringExtra("bean");
        ProgressDialogUtil.startLoad(this, "获取数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.MYLISTDETAIL + runId;
                DBHandler dbA = new DBHandler();
                res = dbA.OAQingJiaMyDetail(url);
                if (res.equals("获取数据失败") || res.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_ONE);
                }
            }
        }).start();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_goodpurchnew_data;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        new AlertDialogEditText().showDialog(this, runID, new BaseRequestBackLisenter() {
            @Override
            public void success(Object o) {
                Message message = new Message();
                message.what = TAG_FIVE;
                Bundle bundle = new Bundle();
                bundle.putString("msg", o.toString());
                message.setData(bundle);
                handler.sendMessage(message);
                finish();
            }

            @Override
            public void fail(String message) {
                Message message1 = new Message();
                message1.what = TAG_SIX;
                handler.sendMessage(message1);
            }
        });
    }

    @OnClick({ R.id.btnHistory})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHistory:
                recyclerView.setVisibility(View.VISIBLE);
                ProgressDialogUtil.startLoad(FlowPurchaseDetailActivity.this, "获取数据中");
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
//            case R.id.tvData:
//                List<String> dataList = new ArrayList<>();
//                if (!xiangguanfujian.equals("")) {
//                    dataList = new MyStringSpilt().stringSpiltList(xiangguanfujian);
//                    if (dataList.size() == 1) {
//                        String id = new MyStringSpilt().stringSpilt(dataList.get(0));
//                        final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                DBHandler dbA = new DBHandler();
//                                downloadData = dbA.OAQingJiaMyDetail(url);
//                                if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
//                                    handler.sendEmptyMessage(TAG_TWO);
//                                } else {
//                                    handler.sendEmptyMessage(TAG_NINE);
//                                }
//                            }
//                        }).start();
//                    } else if (dataList.size() > 1) {
//                        MyAlertDialog.MyListAlertDialog(this, dataList, new AlertDialogCallBackP() {
//                            @Override
//                            public void oneselect(final String data1) {
//                                String id = new MyStringSpilt().stringSpilt(data1);
//                                final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
//                                new Thread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        DBHandler dbA = new DBHandler();
//                                        downloadData = dbA.OAQingJiaMyDetail(url);
//                                        if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
//                                            handler.sendEmptyMessage(TAG_TWO);
//                                        } else {
//                                            handler.sendEmptyMessage(TAG_NINE);
//                                        }
//                                    }
//                                }).start();
//                            }
//
//                            @Override
//                            public void select(List<String> list) {
//
//                            }
//
//                            @Override
//                            public void confirm() {
//
//                            }
//
//                            @Override
//                            public void cancel() {
//
//                            }
//                        });
//                    }
//                }
//                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 111:
                    Gson gsonF = new Gson();
                    FlowMessage1 beanF = gsonF.fromJson(flowMessage, FlowMessage1.class);
                    for (int i = 0; i < beanF.getData().size(); i++) {
                        flowList.add(beanF.getData().get(i));
                    }
                    adapter = new FlowMessageAdapter(FlowPurchaseDetailActivity.this, flowList);
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(FlowPurchaseDetailActivity.this, "查询成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_ONE:
                    Gson gson = new Gson();
                    NewGoodOurchaseWillDetail bean = gson.fromJson(res, NewGoodOurchaseWillDetail.class);
                    etClass.setText(bean.getMainform().get(0).getBm());
                    etPerson.setText(bean.getMainform().get(0).getSqr());
                    tvTime.setText(bean.getMainform().get(0).getSqrq());
                    tvZc.setText(bean.getMainform().get(0).getIszc());
                    tvtype.setText(bean.getMainform().get(0).getGoodsType());
                    etUse.setText(bean.getMainform().get(0).getYongtu());
                    tvAllNum.setText(bean.getMainform().get(0).getShuliangheji1());
                    tvHeJi.setText(bean.getMainform().get(0).getJineheji1());
                    etName1.setText(bean.getMainform().get(0).getMingcheng1());
                    etGG1.setText(bean.getMainform().get(0).getGuige1());
                    etYS1.setText(bean.getMainform().get(0).getYusuan1());
                    etNum1.setText(bean.getMainform().get(0).getShuliang1());
                    etMoney1.setText(bean.getMainform().get(0).getDanjia1());
                    etAllMoney1.setText(bean.getMainform().get(0).getJine1());

                    etPFName1.setText(bean.getMainform().get(0).getPifumingcheng1());
                    etPFNum1.setText(bean.getMainform().get(0).getPifushuliang1());
                    etPFMoney1.setText(bean.getMainform().get(0).getPifudanjia1());
                    etPFAllMoney1.setText(bean.getMainform().get(0).getPifujine1());
                    if (res.indexOf("mingcheng2") != -1) {
                        HSView.setVisibility(View.VISIBLE);
                        ll122.setVisibility(View.VISIBLE);
                        etName2.setText(bean.getMainform().get(0).getMingcheng2());
                        etGG2.setText(bean.getMainform().get(0).getGuige2());
                        etYS2.setText(bean.getMainform().get(0).getYusuan2());
                        etNum2.setText(bean.getMainform().get(0).getShuliang2());
                        etMoney2.setText(bean.getMainform().get(0).getDanjia2());
                        etAllMoney2.setText(bean.getMainform().get(0).getJine2());

                        etPFName2.setText(bean.getMainform().get(0).getPifumingcheng2());
                        etPFNum2.setText(bean.getMainform().get(0).getPifushuliang2());
                        etPFMoney2.setText(bean.getMainform().get(0).getPifudanjia2());
                        etPFAllMoney2.setText(bean.getMainform().get(0).getPifujine2());
                    }
                    if (res.indexOf("mingcheng3") != -1) {
                        HSView.setVisibility(View.VISIBLE);
                        ll33.setVisibility(View.VISIBLE);
                        ll3.setVisibility(View.VISIBLE);
                        etName3.setText(bean.getMainform().get(0).getMingcheng3());
                        etGG3.setText(bean.getMainform().get(0).getGuige3());
                        etYS3.setText(bean.getMainform().get(0).getYusuan3());
                        etNum3.setText(bean.getMainform().get(0).getShuliang3());
                        etMoney3.setText(bean.getMainform().get(0).getDanjia3());
                        etAllMoney3.setText(bean.getMainform().get(0).getJine3());

                        etPFName3.setText(bean.getMainform().get(0).getPifumingcheng3());
                        etPFNum3.setText(bean.getMainform().get(0).getPifushuliang3());
                        etPFMoney3.setText(bean.getMainform().get(0).getPifudanjia3());
                        etPFAllMoney3.setText(bean.getMainform().get(0).getPifujine3());
                    }
                    if (res.indexOf("mingcheng4") != -1) {
                        HSView.setVisibility(View.VISIBLE);
                        ll144.setVisibility(View.VISIBLE);
                        ll4.setVisibility(View.VISIBLE);
                        etName4.setText(bean.getMainform().get(0).getMingcheng4());
                        etGG4.setText(bean.getMainform().get(0).getGuige4());
                        etYS4.setText(bean.getMainform().get(0).getYusuan4());
                        etNum4.setText(bean.getMainform().get(0).getShuliang4());
                        etMoney4.setText(bean.getMainform().get(0).getDanjia4());
                        etAllMoney4.setText(bean.getMainform().get(0).getJine4());

                        etPFName4.setText(bean.getMainform().get(0).getPifumingcheng4());
                        etPFNum4.setText(bean.getMainform().get(0).getPifushuliang4());
                        etPFMoney4.setText(bean.getMainform().get(0).getPifudanjia4());
                        etPFAllMoney4.setText(bean.getMainform().get(0).getPifujine4());
                    }
                    if (res.indexOf("mingcheng5") != -1) {
                        HSView.setVisibility(View.VISIBLE);
                        ll55.setVisibility(View.VISIBLE);
                        ll5.setVisibility(View.VISIBLE);
                        etGG5.setText(bean.getMainform().get(0).getGuige5());
                        etYS5.setText(bean.getMainform().get(0).getYusuan5());
                        etNum5.setText(bean.getMainform().get(0).getShuliang5());
                        etMoney5.setText(bean.getMainform().get(0).getDanjia5());
                        etAllMoney5.setText(bean.getMainform().get(0).getJine5());

                        etPFName5.setText(bean.getMainform().get(0).getPifumingcheng5());
                        etPFNum5.setText(bean.getMainform().get(0).getPifushuliang5());
                        etPFMoney5.setText(bean.getMainform().get(0).getPifudanjia5());
                        etPFAllMoney5.setText(bean.getMainform().get(0).getPifujine5());
                    }
                    if (res.indexOf("mingcheng6") != -1) {
                        HSView.setVisibility(View.VISIBLE);
                        ll66.setVisibility(View.VISIBLE);
                        ll6.setVisibility(View.VISIBLE);
                        etName6.setText(bean.getMainform().get(0).getMingcheng6());
                        etGG6.setText(bean.getMainform().get(0).getGuige6());
                        etYS6.setText(bean.getMainform().get(0).getYusuan6());
                        etNum6.setText(bean.getMainform().get(0).getShuliang6());
                        etMoney6.setText(bean.getMainform().get(0).getDanjia6());
                        etAllMoney6.setText(bean.getMainform().get(0).getJine6());

                        etPFName6.setText(bean.getMainform().get(0).getPifumingcheng6());
                        etPFNum6.setText(bean.getMainform().get(0).getPifushuliang6());
                        etPFMoney6.setText(bean.getMainform().get(0).getPifudanjia6());
                        etPFAllMoney6.setText(bean.getMainform().get(0).getPifujine6());
                    }
                    if (res.indexOf("mingcheng7") != -1) {
                        HSView.setVisibility(View.VISIBLE);
                        ll77.setVisibility(View.VISIBLE);
                        ll7.setVisibility(View.VISIBLE);
                        etName7.setText(bean.getMainform().get(0).getMingcheng7());
                        etGG7.setText(bean.getMainform().get(0).getGuige7());
                        etYS7.setText(bean.getMainform().get(0).getYusuan7());
                        etNum7.setText(bean.getMainform().get(0).getShuliang7());
                        etMoney7.setText(bean.getMainform().get(0).getDanjia7());
                        etAllMoney7.setText(bean.getMainform().get(0).getJine7());

                        etPFName7.setText(bean.getMainform().get(0).getPifumingcheng7());
                        etPFNum7.setText(bean.getMainform().get(0).getPifushuliang7());
                        etPFMoney7.setText(bean.getMainform().get(0).getPifudanjia7());
                        etPFAllMoney7.setText(bean.getMainform().get(0).getPifujine7());
                    }
                    if (res.indexOf("mingcheng8") != -1) {
                        HSView.setVisibility(View.VISIBLE);
                        ll88.setVisibility(View.VISIBLE);
                        ll8.setVisibility(View.VISIBLE);
                        etName8.setText(bean.getMainform().get(0).getMingcheng8());
                        etGG8.setText(bean.getMainform().get(0).getGuige8());
                        etYS8.setText(bean.getMainform().get(0).getYusuan8());
                        etNum8.setText(bean.getMainform().get(0).getShuliang8());
                        etMoney8.setText(bean.getMainform().get(0).getDanjia8());
                        etAllMoney8.setText(bean.getMainform().get(0).getJine8());

                        etPFName8.setText(bean.getMainform().get(0).getPifumingcheng8());
                        etPFNum8.setText(bean.getMainform().get(0).getPifushuliang8());
                        etPFMoney8.setText(bean.getMainform().get(0).getPifudanjia8());
                        etPFAllMoney8.setText(bean.getMainform().get(0).getPifujine8());
                    }
                    if (res.indexOf("mingcheng9") != -1) {
                        HSView.setVisibility(View.VISIBLE);
                        ll99.setVisibility(View.VISIBLE);
                        ll9.setVisibility(View.VISIBLE);
                        etName9.setText(bean.getMainform().get(0).getMingcheng9());
                        etGG9.setText(bean.getMainform().get(0).getGuige9());
                        etYS9.setText(bean.getMainform().get(0).getYusuan9());
                        etNum9.setText(bean.getMainform().get(0).getShuliang9());
                        etMoney9.setText(bean.getMainform().get(0).getDanjia9());
                        etAllMoney9.setText(bean.getMainform().get(0).getJine9());

                        etPFName9.setText(bean.getMainform().get(0).getPifumingcheng9());
                        etPFNum9.setText(bean.getMainform().get(0).getPifushuliang9());
                        etPFMoney9.setText(bean.getMainform().get(0).getPifudanjia9());
                        etPFAllMoney9.setText(bean.getMainform().get(0).getPifujine9());
                    }
                    if (res.indexOf("mingcheng10") != -1) {
                        HSView.setVisibility(View.VISIBLE);
                        ll1010.setVisibility(View.VISIBLE);
                        ll10.setVisibility(View.VISIBLE);
                        etName10.setText(bean.getMainform().get(0).getMingcheng10());
                        etGG10.setText(bean.getMainform().get(0).getGuige10());
                        etYS10.setText(bean.getMainform().get(0).getYusuan10());
                        etNum10.setText(bean.getMainform().get(0).getShuliang10());
                        etMoney10.setText(bean.getMainform().get(0).getDanjia10());
                        etAllMoney10.setText(bean.getMainform().get(0).getJine10());

                        etPFName10.setText(bean.getMainform().get(0).getPifumingcheng10());
                        etPFNum10.setText(bean.getMainform().get(0).getPifushuliang10());
                        etPFMoney10.setText(bean.getMainform().get(0).getPifudanjia10());
                        etPFAllMoney10.setText(bean.getMainform().get(0).getPifujine10());
                    }
                    runID = bean.getMainform().get(0).getRunId();
                    tvAllNum.setText(bean.getMainform().get(0).getShuliangheji1());
                    tvHeJi.setText(bean.getMainform().get(0).getJineheji1());
                    tvPFAllNum.setText(bean.getMainform().get(0).getShuliangheji2());
                    tvPFAllMoney.setText(bean.getMainform().get(0).getJineheji2());

                    bmyj = bean.getMainform().get(0).getBmyj();
                    cwbyj = bean.getMainform().get(0).getCwbyj();
                    zcgkbmyj = bean.getMainform().get(0).getZcgkbmyj();
                    cgbyj = bean.getMainform().get(0).getCgbyj();
                    bmfgldyj = bean.getMainform().get(0).getBmfgldyj();
                    cgfgldyj = bean.getMainform().get(0).getCgfgldyj();
                    cwzjyj = bean.getMainform().get(0).getCwzjyj();
                    zjl = bean.getMainform().get(0).getZjlyj();

                    String word7 = "";
                    if (zjl != null && !zjl.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(zjl);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word7 = word7 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader7.getVisibility() == View.VISIBLE) {
                            tvLeader7.setText(word7);
                            etLeader7.setHint(word7);
                        } else {
                            etLeader7.setHint(word7);
                        }
                    }

                    String word6 = "";
                    if (cwzjyj != null && !cwzjyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(cwzjyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word6 = word6 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader6.getVisibility() == View.VISIBLE) {
                            tvLeader6.setText(word6);
                        } else {
                            etLeader6.setHint(word6);
                        }
                    }

                    String word5 = "";
                    if (cgfgldyj != null && !cgfgldyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(cgfgldyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word5 = word5 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader5.getVisibility() == View.VISIBLE) {
                            tvLeader5.setText(word5);
                        } else {
                            etLeader5.setHint(word5);
                        }
                    }

                    String word4 = "";
                    if (bmfgldyj != null && !bmfgldyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(bmfgldyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word4 = word4 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader4.getVisibility() == View.VISIBLE) {
                            tvLeader4.setText(word4);
                        } else {
                            etLeader4.setHint(word4);
                        }
                    }

                    String word3 = "";
                    if (cgbyj != null && !cgbyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(cgbyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word3 = word3 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader3.getVisibility() == View.VISIBLE) {
                            tvLeader3.setText(word3);
                        } else {
                            etLeader3.setHint(word3);
                        }
                    }

                    String word2 = "";
                    if (zcgkbmyj != null && !zcgkbmyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(zcgkbmyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word2 = word2 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader2.getVisibility() == View.VISIBLE) {
                            tvLeader2.setText(word2);
                        } else {
                            etLeader2.setHint(word2);
                        }
                    }

                    String word1 = "";
                    if (cwbyj != null && !cwbyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(cwbyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word1 = word1 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader1.getVisibility() == View.VISIBLE) {
                            tvLeader1.setText(word1);
                        } else {
                            etLeader1.setHint(word1);
                        }
                    }

                    String word = "";
                    if (bmyj != null && !bmyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(bmyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word = word + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader.getVisibility() == View.VISIBLE) {
                            tvLeader.setText(word);
                        } else {
                            etLeader.setHint(word);
                        }
                    }

//                    String formRights = bean.getFormRights();
//                    try {
//                        JSONObject jsonObject = new JSONObject(formRights);
//                        bmyjreout = jsonObject.getString("bmfzryj");
//                        cwbyjreout = jsonObject.getString("cwbyij");
//                        zcgkbmyjreout = jsonObject.getString("czgkbmyj");
//                        cgbyjreout = jsonObject.getString("cgbyj");
//                        bmfgldyjreout = jsonObject.getString("bmfgldyj");
//                        cgfgldyjreout = jsonObject.getString("cgfgldyj");
//                        cwzjyjreout = jsonObject.getString("cwzjyj");
//                        zjlreout = jsonObject.getString("zjlyj");
//                        String pfreout = jsonObject.getString("pifumingcheng1");
//                        if (pfreout.equals("2")){
//                            etPFName1.setVisibility(View.VISIBLE);
//                            tvPFName1.setVisibility(View.GONE);
//                            etPFNum1.setVisibility(View.VISIBLE);
//                            tvPFNum1.setVisibility(View.GONE);
//                            etPFMoney1.setVisibility(View.VISIBLE);
//                            tvPFMoney1.setVisibility(View.GONE);
//                            etPFAllMoney1.setVisibility(View.VISIBLE);
//                            tvPFAllMoney1.setVisibility(View.GONE);
//                            if (ll122.getVisibility()==View.VISIBLE){
//                                etPFName2.setVisibility(View.VISIBLE);
//                                tvPFName2.setVisibility(View.GONE);
//                                etPFNum2.setVisibility(View.VISIBLE);
//                                tvPFNum2.setVisibility(View.GONE);
//                                etPFMoney2.setVisibility(View.VISIBLE);
//                                tvPFMoney2.setVisibility(View.GONE);
//                                etPFAllMoney2.setVisibility(View.VISIBLE);
//                                tvPFAllMoney2.setVisibility(View.GONE);
//                            }
//                            if (ll33.getVisibility()==View.VISIBLE){
//                                etPFName3.setVisibility(View.VISIBLE);
//                                tvPFName3.setVisibility(View.GONE);
//                                etPFNum3.setVisibility(View.VISIBLE);
//                                tvPFNum3.setVisibility(View.GONE);
//                                etPFMoney3.setVisibility(View.VISIBLE);
//                                tvPFMoney3.setVisibility(View.GONE);
//                                etPFAllMoney3.setVisibility(View.VISIBLE);
//                                tvPFAllMoney3.setVisibility(View.GONE);
//                            }
//                            if (ll144.getVisibility()==View.VISIBLE){
//                                etPFName4.setVisibility(View.VISIBLE);
//                                tvPFName4.setVisibility(View.GONE);
//                                etPFNum4.setVisibility(View.VISIBLE);
//                                tvPFNum4.setVisibility(View.GONE);
//                                etPFMoney4.setVisibility(View.VISIBLE);
//                                tvPFMoney4.setVisibility(View.GONE);
//                                etPFAllMoney4.setVisibility(View.VISIBLE);
//                                tvPFAllMoney4.setVisibility(View.GONE);
//                            }
//                            if (ll55.getVisibility()==View.VISIBLE){
//                                etPFName5.setVisibility(View.VISIBLE);
//                                tvPFName5.setVisibility(View.GONE);
//                                etPFNum5.setVisibility(View.VISIBLE);
//                                tvPFNum5.setVisibility(View.GONE);
//                                etPFMoney5.setVisibility(View.VISIBLE);
//                                tvPFMoney5.setVisibility(View.GONE);
//                                etPFAllMoney5.setVisibility(View.VISIBLE);
//                                tvPFAllMoney5.setVisibility(View.GONE);
//                            }
//                            if (ll66.getVisibility()==View.VISIBLE){
//                                etPFName6.setVisibility(View.VISIBLE);
//                                tvPFName6.setVisibility(View.GONE);
//                                etPFNum6.setVisibility(View.VISIBLE);
//                                tvPFNum6.setVisibility(View.GONE);
//                                etPFMoney6.setVisibility(View.VISIBLE);
//                                tvPFMoney6.setVisibility(View.GONE);
//                                etPFAllMoney6.setVisibility(View.VISIBLE);
//                                tvPFAllMoney6.setVisibility(View.GONE);
//                            }
//                            if (ll77.getVisibility()==View.VISIBLE) {
//                                etPFName7.setVisibility(View.VISIBLE);
//                                tvPFName7.setVisibility(View.GONE);
//                                etPFNum7.setVisibility(View.VISIBLE);
//                                tvPFNum7.setVisibility(View.GONE);
//                                etPFMoney7.setVisibility(View.VISIBLE);
//                                tvPFMoney7.setVisibility(View.GONE);
//                                etPFAllMoney7.setVisibility(View.VISIBLE);
//                                tvPFAllMoney7.setVisibility(View.GONE);
//                            }
//                            if (ll88.getVisibility()==View.VISIBLE) {
//                                etPFName8.setVisibility(View.VISIBLE);
//                                tvPFName8.setVisibility(View.GONE);
//                                etPFNum8.setVisibility(View.VISIBLE);
//                                tvPFNum8.setVisibility(View.GONE);
//                                etPFMoney8.setVisibility(View.VISIBLE);
//                                tvPFMoney8.setVisibility(View.GONE);
//                                etPFAllMoney8.setVisibility(View.VISIBLE);
//                                tvPFAllMoney8.setVisibility(View.GONE);
//                            }
//                            if (ll99.getVisibility()==View.VISIBLE) {
//                                etPFName9.setVisibility(View.VISIBLE);
//                                tvPFName9.setVisibility(View.GONE);
//                                etPFNum9.setVisibility(View.VISIBLE);
//                                tvPFNum9.setVisibility(View.GONE);
//                                etPFMoney9.setVisibility(View.VISIBLE);
//                                tvPFMoney9.setVisibility(View.GONE);
//                                etPFAllMoney9.setVisibility(View.VISIBLE);
//                                tvPFAllMoney9.setVisibility(View.GONE);
//                            }
//                            if (ll1010.getVisibility()==View.VISIBLE) {
//                                etPFName10.setVisibility(View.VISIBLE);
//                                tvPFName10.setVisibility(View.GONE);
//                                etPFNum10.setVisibility(View.VISIBLE);
//                                tvPFNum10.setVisibility(View.GONE);
//                                etPFMoney10.setVisibility(View.VISIBLE);
//                                tvPFMoney10.setVisibility(View.GONE);
//                                etPFAllMoney10.setVisibility(View.VISIBLE);
//                                tvPFAllMoney10.setVisibility(View.GONE);
//                            }
//                        }
//                        if (bmyjreout.equals("2")) {
//                            tvLeader.setVisibility(View.GONE);
//                            etLeader.setVisibility(View.VISIBLE);
//                            llLeader.setVisibility(View.VISIBLE);
//                        } else {
//                            tvLeader.setVisibility(View.VISIBLE);
//                            etLeader.setVisibility(View.GONE);
//                        }
//                        if (cwbyjreout.equals("2")) {
//                            tvLeader1.setVisibility(View.GONE);
//                            etLeader1.setVisibility(View.VISIBLE);
//                            llLeader1.setVisibility(View.VISIBLE);
//                        } else {
//                            tvLeader1.setVisibility(View.VISIBLE);
//                            etLeader1.setVisibility(View.GONE);
//                        }
//                        if (zcgkbmyjreout.equals("2")) {
//                            tvLeader2.setVisibility(View.GONE);
//                            etLeader2.setVisibility(View.VISIBLE);
//                            llLeader2.setVisibility(View.VISIBLE);
//                        } else {
//                            tvLeader2.setVisibility(View.VISIBLE);
//                            etLeader2.setVisibility(View.GONE);
//                        }
//                        if (cgbyjreout.equals("2")) {
//                            tvLeader3.setVisibility(View.GONE);
//                            etLeader3.setVisibility(View.VISIBLE);
//                            llLeader3.setVisibility(View.VISIBLE);
//                        } else {
//                            tvLeader3.setVisibility(View.VISIBLE);
//                            etLeader3.setVisibility(View.GONE);
//                        }
//                        if (bmfgldyjreout.equals("2")) {
//                            tvLeader4.setVisibility(View.GONE);
//                            etLeader4.setVisibility(View.VISIBLE);
//                            llLeader4.setVisibility(View.VISIBLE);
//                        } else {
//                            tvLeader4.setVisibility(View.VISIBLE);
//                            etLeader4.setVisibility(View.GONE);
//                        }
//                        if (cgfgldyjreout.equals("2")) {
//                            tvLeader5.setVisibility(View.GONE);
//                            etLeader5.setVisibility(View.VISIBLE);
//                            llLeader5.setVisibility(View.VISIBLE);
//                        } else {
//                            tvLeader5.setVisibility(View.VISIBLE);
//                            etLeader5.setVisibility(View.GONE);
//                        }
//                        if (cwzjyjreout.equals("2")) {
//                            tvLeader6.setVisibility(View.GONE);
//                            etLeader6.setVisibility(View.VISIBLE);
//                            llLeader6.setVisibility(View.VISIBLE);
//                        } else {
//                            tvLeader6.setVisibility(View.VISIBLE);
//                            etLeader6.setVisibility(View.GONE);
//                        }
//                        if (zjlreout.equals("2")) {
//                            tvLeader7.setVisibility(View.GONE);
//                            etLeader7.setVisibility(View.VISIBLE);
//                            llLeader7.setVisibility(View.VISIBLE);
//                        } else {
//                            tvLeader7.setVisibility(View.VISIBLE);
//                            etLeader7.setVisibility(View.GONE);
//                        }
//                        if (bmyjreout.equals("1") && cwbyjreout.equals("1") && zcgkbmyjreout.equals("1")
//                                && cgbyjreout.equals("1") && bmfgldyjreout.equals("1") && cgfgldyjreout.equals("1")
//                                && cwzjyjreout.equals("1") && zjlreout.equals("1")) {
//                            Toast.makeText(NewGoodPurchaseWillDetailActivity.this, "您对当前流程只有读取权限", Toast.LENGTH_SHORT).show();
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
////
//                    if (bean.isRevoke()) {
//                        Toast.makeText(NewGoodPurchaseWillDetailActivity.this, "当前流程已被追回", Toast.LENGTH_SHORT).show();
//                    }
//                    ProgressDialogUtil.stopLoad();
//                    if (beanList.size() == 1) {
//                        btnT.setVisibility(View.GONE);
//                        tvText.setVisibility(View.GONE);
//                        ProgressDialogUtil.startLoad(NewGoodPurchaseWillDetailActivity.this, "获取审核人");
//                        getAppRovePerson();
//                    } else {
//                        tvspr.setText("请点击“+”选择路径");
//                    }
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(FlowPurchaseDetailActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
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
                case TAG_FIVE:
                    Toast.makeText(FlowPurchaseDetailActivity.this, msg.getData().getString("msg"), Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case TAG_SIX:
                    Toast.makeText(FlowPurchaseDetailActivity.this, "提交数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

    private String getJSONData(String data) {
        String yijian = "";
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (!jsonObject.getString("v").toString().equals("")) {
                    yijian = yijian + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return yijian;
    }

}
