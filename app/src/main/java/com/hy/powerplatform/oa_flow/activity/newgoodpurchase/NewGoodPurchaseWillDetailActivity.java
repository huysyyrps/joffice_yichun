package com.hy.powerplatform.oa_flow.activity.newgoodpurchase;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
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
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.activity.newgoodpurchase.bean.NewGoodOurchaseWillDetail;
import com.hy.powerplatform.oa_flow.adapter.FlowMessageAdapter;
import com.hy.powerplatform.oa_flow.bean.FlowContractPerson;
import com.hy.powerplatform.oa_flow.bean.FlowMessage1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_EIGHT;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_FIVE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_SEVEN;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_SIX;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class NewGoodPurchaseWillDetailActivity extends BaseActivity {

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
    //    @BindView(R.id.textView8)
//    TextView textView8;
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
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.etLeader7)
    EditText etLeader7;
    @BindView(R.id.tvLeader7)
    TextView tvLeader7;
    @BindView(R.id.llLeader7)
    LinearLayout llLeader7;

    private OkHttpUtil httpUtil;
    List<NewGoodOurchaseWillDetail.TransBean> beanList = new ArrayList<>();
    //签字意见
    String bmyj = "", cwbyj = "", zcgkbmyj = "", cgbyj = "", bmfgldyj = "", cgfgldyj = "", cwzjyj = "", zjl = "";
    String bmyjreout = "", cwbyjreout = "", zcgkbmyjreout = "", cgbyjreout = "", bmfgldyjreout = "", cgfgldyjreout = "", cwzjyjreout = "", zjlreout = "";
    String name = "", taskId = "", piId = "", executionId = "", res = "", runID = "", mainId = "", destType="",
            signaName="", destName="", checkTask ="", qianzhiData = "";
    double AllMoney1 = 0.0, AllMoney2 = 0.0, AllMoney3 = 0.0, AllMoney4 = 0.0, AllMoney5 = 0.0, AllMoney6 = 0.0, AllMoney7 = 0.0, AllMoney8 = 0.0, AllMoney9 = 0.0, AllMoney10 = 0.0;
    Double allNum1 = 0.0, allNum2 = 0.0, allNum3 = 0.00, allNum4 = 0.0, allNum5 = 0.0, allNum6 = 0.0, allNum7 = 0.0, allNum8 = 0.00, allNum9 = 0.0, allNum10 = 0.0;
    double moneyS1 = 0.0, moneyS2 = 0.0, moneyS3 = 0.0, moneyS4 = 0.0, moneyS5 = 0.0, moneyS6 = 0.0, moneyS7 = 0.0, moneyS8 = 0.0, moneyS9 = 0.0, moneyS10 = 0.0;
    String role = "", userCode = "", userName = "", leader = "", leaderCode = "", leaderName = "", btnTTag = "N", flowMessage = "";;
    String[] nametemp = null;
    String[] codetemp = null;
    String[] bigNametemp = null;
    String[] bigCodetemp = null;
    JSONArray jsonArray;
    JSONObject jsonObject;
    SimpleDateFormat formatter;
    Date curDate;
    String str;
    String comment = "", flowAssignld = "";
    FlowMessageAdapter adapter;
    List<FlowMessage1.DataBean> flowList = new ArrayList<>();
    List<String> namelist = new ArrayList<>();
    List<String> resultList = new ArrayList<>();
    List<String> resultList1 = new ArrayList<>();
    List<String> bigResultList = new ArrayList<>();
    List<String> bigResultList1 = new ArrayList<>();
    List<String> bigResultList2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        httpUtil = OkHttpUtil.getInstance(this);
        spinnertype.setVisibility(View.GONE);
        spinnerzc.setVisibility(View.GONE);
        tvtype.setVisibility(View.VISIBLE);
        tvZc.setVisibility(View.VISIBLE);
        llShenPiRenList.setVisibility(View.VISIBLE);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        Intent intent = getIntent();
        name = intent.getStringExtra("activityName");
        taskId = intent.getStringExtra("taskId");
        String taskName = intent.getStringExtra("taskName");
        piId = intent.getStringExtra("piId");
        executionId = intent.getStringExtra("executionId");
        header.setTvTitle(taskName);

        etPFAllMoney1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("")) {
                    AllMoney1 = (Double.valueOf(s.toString()));
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney1 = 0.0;
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etPFAllMoney2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("")) {
                    AllMoney2 = (Double.valueOf(s.toString()));
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney2 = 0.0;
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etPFAllMoney3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("")) {
                    AllMoney3 = (Double.valueOf(s.toString()));
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney3 = 0.0;
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etPFAllMoney4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("")) {
                    AllMoney4 = (Double.valueOf(s.toString()));
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney4 = 0.0;
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etPFAllMoney5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("")) {
                    AllMoney5 = (Double.valueOf(s.toString()));
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney5 = 0.0;
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etPFAllMoney6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("")) {
                    AllMoney6 = (Double.valueOf(s.toString()));
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney6 = 0.0;
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etPFAllMoney7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("")) {
                    AllMoney7 = (Double.valueOf(s.toString()));
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney7 = 0.0;
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etPFAllMoney8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("")) {
                    AllMoney8 = (Double.valueOf(s.toString()));
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney8 = 0.0;
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etPFAllMoney9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("")) {
                    AllMoney9 = (Double.valueOf(s.toString()));
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney9 = 0.0;
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etPFAllMoney10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("")) {
                    AllMoney10 = (Double.valueOf(s.toString()));
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney10 = 0.0;
                    tvPFAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });

        etPFNum1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    allNum1 = (Double.valueOf(s.toString()));
                    tvPFAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etPFMoney1.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum1));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFMoney1.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFMoney1.getText().toString().equals("")) {
                            etPFAllMoney1.setText(new BigDecimal(allNum1 * Double.valueOf(etPFMoney1.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney1.setText(String.valueOf(0 * allNum1));
                        }
                    }
                } else {
                    allNum1 = 0.0;
                    tvPFAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5 + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etPFAllMoney1.setText(String.valueOf(0 * moneyS1));
                }
            }
        });
        etPFNum2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    allNum2 = (Double.valueOf(s.toString()));
                    tvPFAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etPFMoney2.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum2));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFMoney2.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFMoney2.getText().toString().equals("")) {
                            etAllMoney2.setText(new BigDecimal(allNum2 * Double.valueOf(etPFMoney2.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney2.setText(String.valueOf(0 * allNum2));
                        }
                    }
                } else {
                    allNum2 = 0.0;
                    tvPFAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etPFAllMoney2.setText(String.valueOf(0 * moneyS2));
                }
            }
        });
        etPFNum3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    allNum3 = (Double.valueOf(s.toString()));
                    tvPFAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etPFMoney3.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum3));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFMoney3.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFMoney3.getText().toString().equals("")) {
                            etPFAllMoney3.setText(new BigDecimal(allNum3 * Double.valueOf(etPFMoney3.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney3.setText(String.valueOf(0 * allNum3));
                        }
                    }
                } else {
                    allNum3 = 0.0;
                    tvPFAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etPFAllMoney3.setText(String.valueOf(0 * moneyS3));
                }
            }
        });
        etPFNum4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    allNum4 = (Double.valueOf(s.toString()));
                    tvPFAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etPFMoney4.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum4));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFMoney4.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFMoney4.getText().toString().equals("")) {
                            etPFAllMoney4.setText(new BigDecimal(allNum4 * Double.valueOf(etPFMoney4.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney4.setText(String.valueOf(0 * allNum4));
                        }
                    }
                } else {
                    allNum4 = 0.0;
                    tvPFAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etPFAllMoney4.setText(String.valueOf(0 * moneyS4));
                }
            }
        });
        etPFNum5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    allNum5 = (Double.valueOf(s.toString()));
                    tvPFAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etPFMoney5.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum5));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFMoney5.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFMoney5.getText().toString().equals("")) {
                            etPFAllMoney5.setText(new BigDecimal(allNum5 * Double.valueOf(etPFMoney5.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney5.setText(String.valueOf(0 * allNum5));
                        }
                    }
                } else {
                    allNum5 = 0.0;
                    tvPFAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etPFAllMoney5.setText(String.valueOf(0 * moneyS5));
                }
            }
        });
        etPFNum6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    allNum6 = (Double.valueOf(s.toString()));
                    tvPFAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etPFMoney6.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum6));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFMoney6.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFMoney6.getText().toString().equals("")) {
                            etPFAllMoney6.setText(new BigDecimal(allNum6 * Double.valueOf(etPFMoney6.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney6.setText(String.valueOf(0 * allNum6));
                        }
                    }
                } else {
                    allNum6 = 0.0;
                    tvPFAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etPFAllMoney6.setText(String.valueOf(0));
                }
            }
        });
        etPFNum7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    allNum7 = (Double.valueOf(s.toString()));
                    tvPFAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etPFMoney7.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum7));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFMoney7.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFMoney7.getText().toString().equals("")) {
                            etPFAllMoney7.setText(new BigDecimal(allNum7 * Double.valueOf(etPFMoney7.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney7.setText(String.valueOf(0 * allNum7));
                        }
                    }
                } else {
                    allNum7 = 0.0;
                    tvPFAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etPFAllMoney7.setText(String.valueOf(0 * moneyS7));
                }
            }
        });
        etPFNum8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    allNum8 = (Double.valueOf(s.toString()));
                    tvPFAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etPFMoney8.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum8));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFMoney8.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFMoney8.getText().toString().equals("")) {
                            etPFAllMoney8.setText(new BigDecimal(allNum8 * Double.valueOf(etPFMoney8.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney8.setText(String.valueOf(0 * allNum8));
                        }
                    }
                } else {
                    allNum8 = 0.0;
                    tvPFAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etPFAllMoney8.setText(String.valueOf(0 * moneyS8));
                }
            }
        });
        etPFNum9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    allNum9 = (Double.valueOf(s.toString()));
                    tvPFAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etPFMoney9.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum9));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFMoney9.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFMoney9.getText().toString().equals("")) {
                            etPFAllMoney9.setText(new BigDecimal(allNum9 * Double.valueOf(etPFMoney9.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney9.setText(String.valueOf(0 * allNum9));
                        }
                    }
                } else {
                    allNum9 = 0.0;
                    tvPFAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etPFAllMoney9.setText(String.valueOf(0 * moneyS9));
                }
            }
        });
        etPFNum10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    allNum10 = (Double.valueOf(s.toString()));
                    tvPFAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etPFMoney10.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum10));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFMoney10.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFMoney10.getText().toString().equals("")) {
                            etPFAllMoney10.setText(new BigDecimal(allNum10 * Double.valueOf(etPFMoney10.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney10.setText(String.valueOf(0 * allNum10));
                        }
                    }
                } else {
                    allNum10 = 0.0;
                    tvPFAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etPFAllMoney10.setText(String.valueOf(0 * moneyS10));
                }
            }
        });

        etPFMoney1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }

                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS1 = (Double.valueOf(s.toString()));
                    if (!etPFNum1.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS1));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFNum1.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFNum1.getText().toString().equals("")) {
//                            etAllMoney1.setText(s1);
                            etPFAllMoney1.setText(new BigDecimal(moneyS1 * Double.valueOf(etPFNum1.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney1.setText(String.valueOf(0 * moneyS1));
                        }
                    }
                } else {
                    etPFAllMoney1.setText(String.valueOf(0 * moneyS1));
                }
            }
        });
        etPFMoney2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS2 = (Double.valueOf(s.toString()));
                    if (!etPFNum2.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS2));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFNum2.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFNum2.getText().toString().equals("")) {
                            etPFAllMoney2.setText(new BigDecimal(moneyS2 * Double.valueOf(etPFNum2.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney2.setText(String.valueOf(0 * moneyS2));
                        }
                    }
                } else {
                    etPFAllMoney2.setText(String.valueOf(0 * moneyS2));
                }
            }
        });
        etPFMoney3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS3 = (Double.valueOf(s.toString()));
                    if (!etPFNum3.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS3));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFNum3.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFNum3.getText().toString().equals("")) {
                            etPFAllMoney3.setText(new BigDecimal(moneyS3 * Double.valueOf(etPFNum3.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney3.setText(String.valueOf(0 * moneyS3));
                        }
                    }
                } else {
                    etPFAllMoney3.setText(String.valueOf(0 * moneyS3));
                }
            }
        });
        etPFMoney4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS4 = (Double.valueOf(s.toString()));
                    if (!etPFNum4.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS4));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFNum4.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFNum4.getText().toString().equals("")) {
                            etPFAllMoney4.setText(new BigDecimal(moneyS4 * Double.valueOf(etPFNum4.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney4.setText(String.valueOf(0 * moneyS4));
                        }
                    }
                } else {
                    etPFAllMoney4.setText(String.valueOf(0 * moneyS4));
                }
            }
        });
        etPFMoney5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS5 = (Double.valueOf(s.toString()));
                    if (!etPFNum5.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS5));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFNum5.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFNum5.getText().toString().equals("")) {
                            etPFAllMoney5.setText(new BigDecimal(moneyS5 * Double.valueOf(etPFNum5.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney5.setText(String.valueOf(0 * moneyS5));
                        }
                    }
                } else {
                    etPFAllMoney5.setText(String.valueOf(0 * moneyS5));
                }
            }
        });
        etPFMoney6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }

                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS6 = (Double.valueOf(s.toString()));
                    if (!etPFNum6.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS6));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFNum6.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFNum6.getText().toString().equals("")) {
//                            etAllMoney1.setText(s1);
                            etPFAllMoney6.setText(new BigDecimal(moneyS6 * Double.valueOf(etPFNum6.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney6.setText(String.valueOf(0 * moneyS6));
                        }
                    }
                } else {
                    etPFAllMoney6.setText(String.valueOf(0 * moneyS6));
                }
            }
        });
        etPFMoney7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS7 = (Double.valueOf(s.toString()));
                    if (!etPFNum7.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS7));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFNum7.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFNum7.getText().toString().equals("")) {
                            etPFAllMoney7.setText(new BigDecimal(moneyS7 * Double.valueOf(etPFNum7.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney7.setText(String.valueOf(0 * moneyS7));
                        }
                    }
                } else {
                    etPFAllMoney7.setText(String.valueOf(0 * moneyS7));
                }
            }
        });
        etPFMoney8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS8 = (Double.valueOf(s.toString()));
                    if (!etPFNum8.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS8));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFNum8.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFNum8.getText().toString().equals("")) {
                            etPFAllMoney8.setText(new BigDecimal(moneyS8 * Double.valueOf(etPFNum8.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney8.setText(String.valueOf(0 * moneyS8));
                        }
                    }
                } else {
                    etPFAllMoney8.setText(String.valueOf(0 * moneyS8));
                }
            }
        });
        etPFMoney9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS9 = (Double.valueOf(s.toString()));
                    if (!etPFNum9.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS9));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFNum9.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFNum9.getText().toString().equals("")) {
                            etPFAllMoney9.setText(new BigDecimal(moneyS9 * Double.valueOf(etPFNum9.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney9.setText(String.valueOf(0 * moneyS9));
                        }
                    }
                } else {
                    etPFAllMoney9.setText(String.valueOf(0 * moneyS9));
                }
            }
        });
        etPFMoney10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS10 = (Double.valueOf(s.toString()));
                    if (!etPFNum10.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS10));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etPFNum10.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etPFNum10.getText().toString().equals("")) {
                            etPFAllMoney10.setText(new BigDecimal(moneyS10 * Double.valueOf(etPFNum10.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etPFAllMoney10.setText(String.valueOf(0 * moneyS10));
                        }
                    }
                } else {
                    etPFAllMoney10.setText(String.valueOf(0 * moneyS10));
                }
            }
        });
        getData(name, taskId);
    }

    protected int provideContentViewId() {
        return R.layout.fragment_goodpurchnew_data;
    }

    protected boolean isHasHeader() {
        return true;
    }

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
                    Toast.makeText(NewGoodPurchaseWillDetailActivity.this, getResources().getString(R.string.nullify_reason), Toast.LENGTH_SHORT).show();
                } else {
                    dialog.dismiss();
                    ProgressDialogUtil.startLoad(NewGoodPurchaseWillDetailActivity.this, getResources().getString(R.string.get_data));
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

    private void getData(String name, String taskId) {
        String turl = Constant.BASE_URL2 + "htmobile/moblieGetTask.do";
        final HashMap<String, String> map = new HashMap();
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        map.clear();
        map.put("activityName", name);
        map.put("taskId", taskId);
        map.put("piId", piId);
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

    @OnClick({R.id.btnT, R.id.btnUp, R.id.btnHistory,R.id.llShenPiRen})
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
            case R.id.btnHistory:
                recyclerView.setVisibility(View.VISIBLE);
                ProgressDialogUtil.startLoad(NewGoodPurchaseWillDetailActivity.this, "获取数据中");
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
                if (beanList.size() != 0) {
                    if (beanList.size() == 1) {
                        ProgressDialogUtil.startLoad(NewGoodPurchaseWillDetailActivity.this, "获取数据中");
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
                        MyAlertDialog.MyListAlertDialog(NewGoodPurchaseWillDetailActivity.this, namelist, new AlertDialogCallBackP() {
                            @Override
                            public void oneselect(final String data) {
                                ProgressDialogUtil.startLoad(NewGoodPurchaseWillDetailActivity.this, "获取数据中");
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
                    Toast.makeText(NewGoodPurchaseWillDetailActivity.this, "审批人为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnUp:
                Gson gson = new Gson();
                NewGoodOurchaseWillDetail bean = gson.fromJson(res, NewGoodOurchaseWillDetail.class);
                bmyj = bean.getMainform().get(0).getBmyj();
                cwbyj = bean.getMainform().get(0).getCwbyj();
                zcgkbmyj = bean.getMainform().get(0).getZcgkbmyj();
                cgbyj = bean.getMainform().get(0).getCgbyj();
                bmfgldyj = bean.getMainform().get(0).getBmfgldyj();
                cgfgldyj = bean.getMainform().get(0).getCgfgldyj();
                cwzjyj = bean.getMainform().get(0).getCwzjyj();
                zjl = bean.getMainform().get(0).getZjlyj();
                userName = new SharedPreferencesHelper(NewGoodPurchaseWillDetailActivity.this,
                        "login").getData(NewGoodPurchaseWillDetailActivity.this, "userStatus", "");
                userCode = new SharedPreferencesHelper(NewGoodPurchaseWillDetailActivity.this,
                        "login").getData(NewGoodPurchaseWillDetailActivity.this, "userId", "");
                jsonArray = new JSONArray();
                jsonObject = new JSONObject();
                formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                curDate = new Date(System.currentTimeMillis());
                str = formatter.format(curDate);
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
                    if (bmyj.equals("")) {
                        bmyj = jsonArray.toString();
                    } else {
                        bmyj = bmyj + "," + jsonArray.toString();
                        bmyj = bmyj.toString().replace("],[", ",");
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
                    if (cwbyj.equals("")) {
                        cwbyj = jsonArray.toString();
                    } else {
                        cwbyj = cwbyj + "," + jsonArray.toString();
                        cwbyj = cwbyj.toString().replace("],[", ",");
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
                    if (zcgkbmyj.equals("")) {
                        zcgkbmyj = jsonArray.toString();
                    } else {
                        zcgkbmyj = zcgkbmyj + "," + jsonArray.toString();
                        zcgkbmyj = zcgkbmyj.toString().replace("],[", ",");
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
                    if (cgbyj.equals("")) {
                        cgbyj = jsonArray.toString();
                    } else {
                        cgbyj = cgbyj + "," + jsonArray.toString();
                        cgbyj = cgbyj.toString().replace("],[", ",");
                    }
                }
                if (etLeader4.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader4.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader4.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (bmfgldyj.equals("")) {
                        bmfgldyj = jsonArray.toString();
                    } else {
                        bmfgldyj = bmfgldyj + "," + jsonArray.toString();
                        bmfgldyj = bmfgldyj.toString().replace("],[", ",");
                    }
                }
                if (etLeader5.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader5.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader5.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (cgfgldyj.equals("")) {
                        cgfgldyj = jsonArray.toString();
                    } else {
                        cgfgldyj = cgfgldyj + "," + jsonArray.toString();
                        cgfgldyj = cgfgldyj.toString().replace("],[", ",");
                    }
                }

                if (etLeader6.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader6.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader6.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (cwzjyj.equals("")) {
                        cwzjyj = jsonArray.toString();
                    } else {
                        cwzjyj = cwzjyj + "," + jsonArray.toString();
                        cwzjyj = cwzjyj.toString().replace("],[", ",");
                    }
                }
                if (etLeader7.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader7.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader7.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (zjl.equals("")) {
                        zjl = jsonArray.toString();
                    } else {
                        zjl = zjl + "," + jsonArray.toString();
                        zjl = zjl.toString().replace("],[", ",");
                    }
                }

                if (comment.equals("")) {
                    if (!bmyjreout.equals("2") && !cwbyjreout.equals("2") && !zcgkbmyjreout.equals("2")
                            && !cgbyjreout.equals("2") && !bmfgldyjreout.equals("2")&& !cgfgldyjreout.equals("2")
                            && !cwzjyjreout.equals("2")&& !zjlreout.equals("2")) {
                        comment = "";
                        personSession();
                    } else if (!bmyj.equals("") && !cwbyj.equals("") && !zcgkbmyj.equals("")
                            && !cgbyj.equals("") && !bmfgldyj.equals("")&& !cgfgldyj.equals("")
                            && !cwzjyj.equals("")&& !zjlreout.equals("")) {
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
                    NewGoodOurchaseWillDetail bean = gson.fromJson(res, NewGoodOurchaseWillDetail.class);
                    bmyj = bean.getMainform().get(0).getBmyj();
                    cwbyj = bean.getMainform().get(0).getCwbyj();
                    zcgkbmyj = bean.getMainform().get(0).getZcgkbmyj();
                    cgbyj = bean.getMainform().get(0).getCgbyj();
                    bmfgldyj = bean.getMainform().get(0).getBmfgldyj();
                    cgfgldyj = bean.getMainform().get(0).getCgfgldyj();
                    cwzjyj = bean.getMainform().get(0).getCwzjyj();
                    zjl = bean.getMainform().get(0).getZjlyj();
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
        ProgressDialogUtil.startLoad(NewGoodPurchaseWillDetailActivity.this, "提交数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e("soso", "这里走了吗");
                String department = etClass.getText().toString();
                String person = etPerson.getText().toString();
                String time = tvTime.getText().toString();
                String zc = tvZc.getText().toString();
                String goodType = tvtype.getText().toString();
                final String userCode = new SharedPreferencesHelper(NewGoodPurchaseWillDetailActivity.this,
                        "login").getData(NewGoodPurchaseWillDetailActivity.this, "userCode", "");

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
                    Toast.makeText(NewGoodPurchaseWillDetailActivity.this, "请选择审批人", Toast.LENGTH_SHORT).show();
                    Looper.loop();
                } else if (resultList.size() == 0 && resultList1.size() != 0) {
                    Looper.prepare();
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(NewGoodPurchaseWillDetailActivity.this, "请选择审批人", Toast.LENGTH_SHORT).show();
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
                ProgressDialogUtil.startLoad(NewGoodPurchaseWillDetailActivity.this, "提交数据中");
                String url = Constant.BASE_URL2 + Constant.EXAMINEDATA;
                final HashMap<String, String> map = new HashMap();
                map.clear();
                map.put("flowAssignId", flowAssignld);
                map.put("taskId", taskId);
                map.put("signalName", signaName);
                map.put("destName", destName);
                map.put("sendMsg", "true");
                map.put("sendMail", "true");
                map.put("comments", comment);
                map.put("mainId", mainId);
                map.put("formDefId", Constant.NEWGOODPUECHASE);
                map.put("sqrq", tvTime.getText().toString());
                map.put("sqrq", time);
                map.put("bmDid", "378");
                map.put("bm", department);
                map.put("sqr", person);
                map.put("iszc", zc);
                map.put("goodsType", goodType);
                map.put("mingcheng1", etName1.getText().toString());
                map.put("guige1", etGG1.getText().toString());
                map.put("yusuan1", etYS1.getText().toString());
                map.put("shuliang1", etNum1.getText().toString());
                map.put("danjia1", etMoney1.getText().toString());
                map.put("jine1", etAllMoney1.getText().toString());

                if (etPFName1.getVisibility()==View.VISIBLE){
                    map.put("pifumingcheng1", etPFName1.getText().toString());
                }else {
                    map.put("pifumingcheng1", tvPFName1.getText().toString());
                }
                if (etPFNum1.getVisibility()==View.VISIBLE){
                    map.put("pifushuliang1", etPFNum1.getText().toString());
                }else {
                    map.put("pifushuliang1", tvPFNum1.getText().toString());
                }
                if (etPFMoney1.getVisibility()==View.VISIBLE){
                    map.put("pifudanjia1", etPFMoney1.getText().toString());
                }else {
                    map.put("pifudanjia1", etPFMoney1.getText().toString());
                }
                if (etPFAllMoney1.getVisibility()==View.VISIBLE){
                    map.put("pifujine1", etPFAllMoney1.getText().toString());
                }else {
                    map.put("pifujine1", etPFAllMoney1.getText().toString());
                }
                map.put("shuliangheji1", tvAllNum.getText().toString());
                map.put("jineheji1", tvHeJi.getText().toString());
                map.put("yongtu", etUse.getText().toString());

                if (ll2.getVisibility() == View.VISIBLE) {
                    map.put("mingcheng2", etName2.getText().toString());
                    map.put("guige2", etGG2.getText().toString());
                    map.put("yusuan2", etYS2.getText().toString());
                    map.put("shuliang2", etNum2.getText().toString());
                    map.put("danjia2", etMoney2.getText().toString());
                    map.put("jine2", etAllMoney2.getText().toString());

                    if (etPFName2.getVisibility()==View.VISIBLE){
                        map.put("pifumingcheng2", etPFName2.getText().toString());
                    }else {
                        map.put("pifumingcheng2", tvPFName2.getText().toString());
                    }
                    if (etPFNum2.getVisibility()==View.VISIBLE){
                        map.put("pifushuliang2", etPFNum2.getText().toString());
                    }else {
                        map.put("pifushuliang2", tvPFNum2.getText().toString());
                    }
                    if (etPFMoney2.getVisibility()==View.VISIBLE){
                        map.put("pifudanjia2", etPFMoney2.getText().toString());
                    }else {
                        map.put("pifudanjia2", etPFMoney2.getText().toString());
                    }
                    if (etPFAllMoney2.getVisibility()==View.VISIBLE){
                        map.put("pifujine2", etPFAllMoney2.getText().toString());
                    }else {
                        map.put("pifujine2", etPFAllMoney2.getText().toString());
                    }
                }
                if (ll3.getVisibility() == View.VISIBLE) {
                    map.put("mingcheng3", etName3.getText().toString());
                    map.put("guige3", etGG3.getText().toString());
                    map.put("yusuan3", etYS3.getText().toString());
                    map.put("shuliang3", etNum3.getText().toString());
                    map.put("danjia3", etMoney3.getText().toString());
                    map.put("jine3", etAllMoney3.getText().toString());

                    if (etPFName3.getVisibility()==View.VISIBLE){
                        map.put("pifumingcheng3", etPFName3.getText().toString());
                    }else {
                        map.put("pifumingcheng3", tvPFName3.getText().toString());
                    }
                    if (etPFNum3.getVisibility()==View.VISIBLE){
                        map.put("pifushuliang3", etPFNum3.getText().toString());
                    }else {
                        map.put("pifushuliang3", tvPFNum3.getText().toString());
                    }
                    if (etPFMoney3.getVisibility()==View.VISIBLE){
                        map.put("pifudanjia3", etPFMoney3.getText().toString());
                    }else {
                        map.put("pifudanjia3", etPFMoney3.getText().toString());
                    }
                    if (etPFAllMoney3.getVisibility()==View.VISIBLE){
                        map.put("pifujine3", etPFAllMoney3.getText().toString());
                    }else {
                        map.put("pifujine3", etPFAllMoney3.getText().toString());
                    }
                }
                if (ll4.getVisibility() == View.VISIBLE) {
                    map.put("mingcheng4", etName4.getText().toString());
                    map.put("guige4", etGG4.getText().toString());
                    map.put("yusuan4", etYS4.getText().toString());
                    map.put("shuliang4", etNum4.getText().toString());
                    map.put("danjia4", etMoney4.getText().toString());
                    map.put("jine4", etAllMoney4.getText().toString());

                    if (etPFName4.getVisibility()==View.VISIBLE){
                        map.put("pifumingcheng4", etPFName4.getText().toString());
                    }else {
                        map.put("pifumingcheng4", tvPFName4.getText().toString());
                    }
                    if (etPFNum4.getVisibility()==View.VISIBLE){
                        map.put("pifushuliang4", etPFNum4.getText().toString());
                    }else {
                        map.put("pifushuliang4", tvPFNum4.getText().toString());
                    }
                    if (etPFMoney4.getVisibility()==View.VISIBLE){
                        map.put("pifudanjia4", etPFMoney4.getText().toString());
                    }else {
                        map.put("pifudanjia4", etPFMoney4.getText().toString());
                    }
                    if (etPFAllMoney4.getVisibility()==View.VISIBLE){
                        map.put("pifujine4", etPFAllMoney4.getText().toString());
                    }else {
                        map.put("pifujine4", etPFAllMoney4.getText().toString());
                    }
                }
                if (ll5.getVisibility() == View.VISIBLE) {
                    map.put("mingcheng5", etName5.getText().toString());
                    map.put("guige5", etGG5.getText().toString());
                    map.put("yusuan5", etYS5.getText().toString());
                    map.put("shuliang5", etNum5.getText().toString());
                    map.put("danjia5", etMoney5.getText().toString());
                    map.put("jine5", etAllMoney5.getText().toString());

                    if (etPFName5.getVisibility()==View.VISIBLE){
                        map.put("pifumingcheng5", etPFName5.getText().toString());
                    }else {
                        map.put("pifumingcheng5", tvPFName5.getText().toString());
                    }
                    if (etPFNum5.getVisibility()==View.VISIBLE){
                        map.put("pifushuliang5", etPFNum5.getText().toString());
                    }else {
                        map.put("pifushuliang5", tvPFNum5.getText().toString());
                    }
                    if (etPFMoney5.getVisibility()==View.VISIBLE){
                        map.put("pifudanjia5", etPFMoney5.getText().toString());
                    }else {
                        map.put("pifudanjia5", etPFMoney5.getText().toString());
                    }
                    if (etPFAllMoney5.getVisibility()==View.VISIBLE){
                        map.put("pifujine5", etPFAllMoney5.getText().toString());
                    }else {
                        map.put("pifujine5", etPFAllMoney5.getText().toString());
                    }
                }
                if (ll6.getVisibility() == View.VISIBLE) {
                    map.put("mingcheng6", etName6.getText().toString());
                    map.put("guige6", etGG6.getText().toString());
                    map.put("yusuan6", etYS6.getText().toString());
                    map.put("shuliang6", etNum6.getText().toString());
                    map.put("danjia6", etMoney6.getText().toString());
                    map.put("jine6", etAllMoney6.getText().toString());

                    if (etPFName6.getVisibility()==View.VISIBLE){
                        map.put("pifumingcheng6", etPFName6.getText().toString());
                    }else {
                        map.put("pifumingcheng6", tvPFName6.getText().toString());
                    }
                    if (etPFNum6.getVisibility()==View.VISIBLE){
                        map.put("pifushuliang6", etPFNum6.getText().toString());
                    }else {
                        map.put("pifushuliang6", tvPFNum6.getText().toString());
                    }
                    if (etPFMoney6.getVisibility()==View.VISIBLE){
                        map.put("pifudanjia6", etPFMoney6.getText().toString());
                    }else {
                        map.put("pifudanjia6", etPFMoney6.getText().toString());
                    }
                    if (etPFAllMoney6.getVisibility()==View.VISIBLE){
                        map.put("pifujine6", etPFAllMoney6.getText().toString());
                    }else {
                        map.put("pifujine6", etPFAllMoney6.getText().toString());
                    }
                }
                if (ll7.getVisibility() == View.VISIBLE) {
                    map.put("mingcheng7", etName7.getText().toString());
                    map.put("guige7", etGG7.getText().toString());
                    map.put("yusuan7", etYS7.getText().toString());
                    map.put("shuliang7", etNum7.getText().toString());
                    map.put("danjia7", etMoney7.getText().toString());
                    map.put("jine7", etAllMoney7.getText().toString());

                    if (etPFName7.getVisibility()==View.VISIBLE){
                        map.put("pifumingcheng7", etPFName7.getText().toString());
                    }else {
                        map.put("pifumingcheng7", tvPFName7.getText().toString());
                    }
                    if (etPFNum7.getVisibility()==View.VISIBLE){
                        map.put("pifushuliang7", etPFNum7.getText().toString());
                    }else {
                        map.put("pifushuliang7", tvPFNum7.getText().toString());
                    }
                    if (etPFMoney7.getVisibility()==View.VISIBLE){
                        map.put("pifudanjia7", etPFMoney7.getText().toString());
                    }else {
                        map.put("pifudanjia7", etPFMoney7.getText().toString());
                    }
                    if (etPFAllMoney7.getVisibility()==View.VISIBLE){
                        map.put("pifujine7", etPFAllMoney7.getText().toString());
                    }else {
                        map.put("pifujine7", etPFAllMoney7.getText().toString());
                    }
                }
                if (ll8.getVisibility() == View.VISIBLE) {
                    map.put("mingcheng8", etName8.getText().toString());
                    map.put("guige8", etGG8.getText().toString());
                    map.put("yusuan8", etYS8.getText().toString());
                    map.put("shuliang8", etNum8.getText().toString());
                    map.put("danjia8", etMoney8.getText().toString());
                    map.put("jine8", etAllMoney8.getText().toString());

                    if (etPFName8.getVisibility()==View.VISIBLE){
                        map.put("pifumingcheng8", etPFName8.getText().toString());
                    }else {
                        map.put("pifumingcheng8", tvPFName8.getText().toString());
                    }
                    if (etPFNum8.getVisibility()==View.VISIBLE){
                        map.put("pifushuliang8", etPFNum8.getText().toString());
                    }else {
                        map.put("pifushuliang8", tvPFNum8.getText().toString());
                    }
                    if (etPFMoney8.getVisibility()==View.VISIBLE){
                        map.put("pifudanjia8", etPFMoney8.getText().toString());
                    }else {
                        map.put("pifudanjia8", etPFMoney8.getText().toString());
                    }
                    if (etPFAllMoney8.getVisibility()==View.VISIBLE){
                        map.put("pifujine8", etPFAllMoney8.getText().toString());
                    }else {
                        map.put("pifujine8", etPFAllMoney8.getText().toString());
                    }
                }
                if (ll9.getVisibility() == View.VISIBLE) {
                    map.put("mingcheng9", etName9.getText().toString());
                    map.put("guige9", etGG9.getText().toString());
                    map.put("yusuan9", etYS9.getText().toString());
                    map.put("shuliang9", etNum9.getText().toString());
                    map.put("danjia9", etMoney9.getText().toString());
                    map.put("jine9", etAllMoney9.getText().toString());

                    if (etPFName9.getVisibility()==View.VISIBLE){
                        map.put("pifumingcheng9", etPFName9.getText().toString());
                    }else {
                        map.put("pifumingcheng9", tvPFName9.getText().toString());
                    }
                    if (etPFNum9.getVisibility()==View.VISIBLE){
                        map.put("pifushuliang9", etPFNum9.getText().toString());
                    }else {
                        map.put("pifushuliang9", tvPFNum9.getText().toString());
                    }
                    if (etPFMoney9.getVisibility()==View.VISIBLE){
                        map.put("pifudanjia9", etPFMoney9.getText().toString());
                    }else {
                        map.put("pifudanjia9", etPFMoney9.getText().toString());
                    }
                    if (etPFAllMoney9.getVisibility()==View.VISIBLE){
                        map.put("pifujine9", etPFAllMoney9.getText().toString());
                    }else {
                        map.put("pifujine9", etPFAllMoney9.getText().toString());
                    }
                }
                if (ll10.getVisibility() == View.VISIBLE) {
                    map.put("mingcheng10", etName10.getText().toString());
                    map.put("guige10", etGG10.getText().toString());
                    map.put("yusuan10", etYS10.getText().toString());
                    map.put("shuliang10", etNum10.getText().toString());
                    map.put("danjia10", etMoney10.getText().toString());
                    map.put("jine10", etAllMoney10.getText().toString());

                    if (etPFName10.getVisibility()==View.VISIBLE){
                        map.put("pifumingcheng10", etPFName10.getText().toString());
                    }else {
                        map.put("pifumingcheng10", tvPFName10.getText().toString());
                    }
                    if (etPFNum10.getVisibility()==View.VISIBLE){
                        map.put("pifushuliang10", etPFNum10.getText().toString());
                    }else {
                        map.put("pifushuliang10", tvPFNum10.getText().toString());
                    }
                    if (etPFMoney10.getVisibility()==View.VISIBLE){
                        map.put("pifudanjia10", etPFMoney10.getText().toString());
                    }else {
                        map.put("pifudanjia10", etPFMoney10.getText().toString());
                    }
                    if (etPFAllMoney10.getVisibility()==View.VISIBLE){
                        map.put("pifujine10", etPFAllMoney10.getText().toString());
                    }else {
                        map.put("pifujine10", etPFAllMoney10.getText().toString());
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
                    if (bmyj.equals("")) {
                        bmyj = jsonArray.toString();
                    } else {
                        bmyj = bmyj + "," + jsonArray.toString();
                        bmyj = bmyj.toString().replace("],[", ",");
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
                    if (cwbyj.equals("")) {
                        cwbyj = jsonArray.toString();
                    } else {
                        cwbyj = cwbyj + "," + jsonArray.toString();
                        cwbyj = cwbyj.toString().replace("],[", ",");
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
                    if (zcgkbmyj.equals("")) {
                        zcgkbmyj = jsonArray.toString();
                    } else {
                        zcgkbmyj = zcgkbmyj + "," + jsonArray.toString();
                        zcgkbmyj = zcgkbmyj.toString().replace("],[", ",");
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
                    if (cgbyj.equals("")) {
                        cgbyj = jsonArray.toString();
                    } else {
                        cgbyj = cgbyj + "," + jsonArray.toString();
                        cgbyj = cgbyj.toString().replace("],[", ",");
                    }
                }
                if (etLeader4.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader4.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader4.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (bmfgldyj.equals("")) {
                        bmfgldyj = jsonArray.toString();
                    } else {
                        bmfgldyj = bmfgldyj + "," + jsonArray.toString();
                        bmfgldyj = bmfgldyj.toString().replace("],[", ",");
                    }
                }
                if (etLeader5.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader5.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader5.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (cgfgldyj.equals("")) {
                        cgfgldyj = jsonArray.toString();
                    } else {
                        cgfgldyj = cgfgldyj + "," + jsonArray.toString();
                        cgfgldyj = cgfgldyj.toString().replace("],[", ",");
                    }
                }
                if (etLeader6.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader6.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader6.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (cwzjyj.equals("")) {
                        cwzjyj = jsonArray.toString();
                    } else {
                        cwzjyj = cwzjyj + "," + jsonArray.toString();
                        cwzjyj = cwzjyj.toString().replace("],[", ",");
                    }
                }
                if (etLeader7.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader7.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader7.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (zjl.equals("")) {
                        zjl = jsonArray.toString();
                    } else {
                        zjl = zjl + "," + jsonArray.toString();
                        zjl = zjl.toString().replace("],[", ",");
                    }
                }
                map.put("bmyj",bmyj);
                map.put("cwbyj",cwbyj);
                map.put("zcgkbmyj",zcgkbmyj);
                map.put("cgbyj",cgbyj);
                map.put("bmfgldyj",bmfgldyj);
                map.put("cgfgldyj",cgfgldyj);
                map.put("cwzjyj",cwzjyj);
                map.put("zjlyj",zjl);
                httpUtil.postForm(url, map, new OkHttpUtil.ResultCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Message message = new Message();
                        Bundle b = new Bundle();
                        b.putString("error", e.toString());
                        message.setData(b);
                        message.what = TAG_FOUR;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        String data = response.body().string();
                        Message message = new Message();
                        Bundle b = new Bundle();
                        b.putString("data", data);
                        message.setData(b);
                        message.what = TAG_THERE;
                        handler.sendMessage(message);
                    }
                });
//                if (upData.equals("")) {
//                    handler.sendEmptyMessage(TAG_THERE);
//                } else {
//                    handler.sendEmptyMessage(TAG_FOUR);
//                }
            }
        }).start();
    }

    public void getAppRovePerson() {
        ProgressDialogUtil.startLoad(NewGoodPurchaseWillDetailActivity.this, "获取数据中");
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
     * 设置多选框显示
     */
    private void setCbRbVer() {
        resultList.clear();
        bigResultList.clear();
        llspr1.setVisibility(View.GONE);
        llspr2.setVisibility(View.GONE);
        llspr5.setVisibility(View.GONE);
        llspr6.setVisibility(View.GONE);
        llspr3.setVisibility(View.GONE);
        llspr4.setVisibility(View.GONE);
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

        if (nametemp != null) {
            if (nametemp.length == 1) {
                rb1.setText(nametemp[0]);
                rb1.setChecked(true);
                llspr3.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.INVISIBLE);
                rb3.setVisibility(View.INVISIBLE);
            }
            if (nametemp.length == 2) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                llspr3.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.INVISIBLE);
            }
            if (nametemp.length == 3) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                rb3.setText(nametemp[2]);
                llspr3.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.VISIBLE);
            }
            if (nametemp.length == 4) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                rb3.setText(nametemp[2]);
                rb4.setText(nametemp[3]);
                llspr3.setVisibility(View.VISIBLE);
                llspr4.setVisibility(View.VISIBLE);
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
                llspr3.setVisibility(View.VISIBLE);
                llspr4.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.VISIBLE);
                rb4.setVisibility(View.VISIBLE);
                rb5.setVisibility(View.VISIBLE);
                rb6.setVisibility(View.INVISIBLE);
            }
            if (nametemp.length == 6) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                rb3.setText(nametemp[2]);
                rb4.setText(nametemp[3]);
                rb5.setText(nametemp[4]);
                rb6.setText(nametemp[5]);
                llspr3.setVisibility(View.VISIBLE);
                llspr4.setVisibility(View.VISIBLE);
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
                llspr1.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.INVISIBLE);
                cb3.setVisibility(View.INVISIBLE);
            }
            if (bigNametemp.length == 2) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb1.setChecked(true);
                cb2.setChecked(true);
                llspr1.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.INVISIBLE);
            }
            if (bigNametemp.length == 3) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                llspr1.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 4) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                llspr1.setVisibility(View.VISIBLE);
                llspr2.setVisibility(View.VISIBLE);
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
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                cb5.setChecked(true);
                llspr1.setVisibility(View.VISIBLE);
                llspr2.setVisibility(View.VISIBLE);
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
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                cb5.setChecked(true);
                cb6.setChecked(true);
                llspr1.setVisibility(View.VISIBLE);
                llspr2.setVisibility(View.VISIBLE);
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
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                cb5.setChecked(true);
                cb6.setChecked(true);
                cb7.setChecked(true);
                llspr1.setVisibility(View.VISIBLE);
                llspr2.setVisibility(View.VISIBLE);
                llspr5.setVisibility(View.VISIBLE);
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
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                cb5.setChecked(true);
                cb6.setChecked(true);
                cb7.setChecked(true);
                cb8.setChecked(true);
                llspr1.setVisibility(View.VISIBLE);
                llspr2.setVisibility(View.VISIBLE);
                llspr5.setVisibility(View.VISIBLE);
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
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                cb5.setChecked(true);
                cb6.setChecked(true);
                cb7.setChecked(true);
                cb8.setChecked(true);
                cb9.setChecked(true);
                llspr1.setVisibility(View.VISIBLE);
                llspr2.setVisibility(View.VISIBLE);
                llspr5.setVisibility(View.VISIBLE);
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
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                cb5.setChecked(true);
                cb6.setChecked(true);
                cb7.setChecked(true);
                cb8.setChecked(true);
                cb9.setChecked(true);
                cb10.setChecked(true);
                llspr1.setVisibility(View.VISIBLE);
                llspr2.setVisibility(View.VISIBLE);
                llspr5.setVisibility(View.VISIBLE);
                llspr6.setVisibility(View.VISIBLE);
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
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                cb5.setChecked(true);
                cb6.setChecked(true);
                cb7.setChecked(true);
                cb8.setChecked(true);
                cb9.setChecked(true);
                cb10.setChecked(true);
                cb11.setChecked(true);
                llspr1.setVisibility(View.VISIBLE);
                llspr2.setVisibility(View.VISIBLE);
                llspr5.setVisibility(View.VISIBLE);
                llspr6.setVisibility(View.VISIBLE);
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
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                cb5.setChecked(true);
                cb6.setChecked(true);
                cb7.setChecked(true);
                cb8.setChecked(true);
                cb9.setChecked(true);
                cb10.setChecked(true);
                cb11.setChecked(true);
                cb12.setChecked(true);
                llspr1.setVisibility(View.VISIBLE);
                llspr2.setVisibility(View.VISIBLE);
                llspr5.setVisibility(View.VISIBLE);
                llspr6.setVisibility(View.VISIBLE);
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
        }
        ProgressDialogUtil.stopLoad();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
//                case 333:
//                    ProgressDialogUtil.stopLoad();
//                    Toast.makeText(FlowPuechaseWillDetailActivity.this, getResources().getString(R.string.c_success), Toast.LENGTH_SHORT).show();
//                    finish();
//                    break;
//                case 444:
//                    ProgressDialogUtil.stopLoad();
//                    Toast.makeText(FlowPuechaseWillDetailActivity.this, getResources().getString(R.string.c_false), Toast.LENGTH_SHORT).show();
//                    break;
//                case 111:
//                    Gson gsonF = new Gson();
//                    FlowMessage1 beanF = gsonF.fromJson(flowMessage, FlowMessage1.class);
//                    for (int i = 0; i < beanF.getData().size(); i++) {
//                        flowList.add(beanF.getData().get(i));
//                    }
//                    adapter = new FlowMessageAdapter(FlowPuechaseWillDetailActivity.this, flowList);
//                    recyclerView.setAdapter(adapter);
//                    ProgressDialogUtil.stopLoad();
//                    break;
                case 333:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(NewGoodPurchaseWillDetailActivity.this, getResources().getString(R.string.c_success), Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case 444:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(NewGoodPurchaseWillDetailActivity.this, getResources().getString(R.string.c_false), Toast.LENGTH_SHORT).show();
                    break;
                case 111:
                    Gson gsonF = new Gson();
                    FlowMessage1 beanF = gsonF.fromJson(flowMessage, FlowMessage1.class);
                    for (int i = 0; i < beanF.getData().size(); i++) {
                        flowList.add(beanF.getData().get(i));
                    }
                    adapter = new FlowMessageAdapter(NewGoodPurchaseWillDetailActivity.this, flowList);
                    recyclerView.setAdapter(adapter);
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_ONE:
                    Gson gson = new Gson();
                    NewGoodOurchaseWillDetail bean = gson.fromJson(res, NewGoodOurchaseWillDetail.class);
                    taskId = bean.getTaskId();
//                    String department = bean.getMainform().get(0).getBm();
//                    String person = bean.getMainform().get(0).getSqr();
//                    String time = bean.getMainform().get(0).getSqrq();
//                    String iszc = bean.getMainform().get(0).getIszc();
//                    String goodsType = bean.getMainform().get(0).getGoodsType();
//                    String use = bean.getMainform().get(0).getYt();
//                    String allNum = bean.getMainform().get(0).getShuliangheji1();
//                    String heji = bean.getMainform().get(0).getJineheji1();
//                    String name1 = bean.getMainform().get(0).getMingcheng1();
//                    String gg1 = bean.getMainform().get(0).getGuige1();
//                    String ys1 = bean.getMainform().get(0).getYusuan1();
//                    String num1 = bean.getMainform().get(0).getShuliang1();
//                    String money1 = bean.getMainform().get(0).getDanjia1();
//                    String allMoney1 = bean.getMainform().get(0).getJine1();
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
                    mainId = String.valueOf(bean.getMainform().get(0).getMainId());
                    for (int i = 0; i < bean.getTrans().size(); i++) {
                        beanList.add(bean.getTrans().get(i));
                    }

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

                    String formRights = bean.getFormRights();
                    try {
                        JSONObject jsonObject = new JSONObject(formRights);
                        bmyjreout = jsonObject.getString("bmfzryj");
                        cwbyjreout = jsonObject.getString("cwbyij");
                        zcgkbmyjreout = jsonObject.getString("czgkbmyj");
                        cgbyjreout = jsonObject.getString("cgbyj");
                        bmfgldyjreout = jsonObject.getString("bmfgldyj");
                        cgfgldyjreout = jsonObject.getString("cgfgldyj");
                        cwzjyjreout = jsonObject.getString("cwzjyj");
                        zjlreout = jsonObject.getString("zjlyj");
                        String pfreout = jsonObject.getString("pifumingcheng1");
                        if (pfreout.equals("2")){
                            etPFName1.setVisibility(View.VISIBLE);
                            tvPFName1.setVisibility(View.GONE);
                            etPFNum1.setVisibility(View.VISIBLE);
                            tvPFNum1.setVisibility(View.GONE);
                            etPFMoney1.setVisibility(View.VISIBLE);
                            tvPFMoney1.setVisibility(View.GONE);
                            etPFAllMoney1.setVisibility(View.VISIBLE);
                            tvPFAllMoney1.setVisibility(View.GONE);
                            if (ll122.getVisibility()==View.VISIBLE){
                                etPFName2.setVisibility(View.VISIBLE);
                                tvPFName2.setVisibility(View.GONE);
                                etPFNum2.setVisibility(View.VISIBLE);
                                tvPFNum2.setVisibility(View.GONE);
                                etPFMoney2.setVisibility(View.VISIBLE);
                                tvPFMoney2.setVisibility(View.GONE);
                                etPFAllMoney2.setVisibility(View.VISIBLE);
                                tvPFAllMoney2.setVisibility(View.GONE);
                            }
                            if (ll33.getVisibility()==View.VISIBLE){
                                etPFName3.setVisibility(View.VISIBLE);
                                tvPFName3.setVisibility(View.GONE);
                                etPFNum3.setVisibility(View.VISIBLE);
                                tvPFNum3.setVisibility(View.GONE);
                                etPFMoney3.setVisibility(View.VISIBLE);
                                tvPFMoney3.setVisibility(View.GONE);
                                etPFAllMoney3.setVisibility(View.VISIBLE);
                                tvPFAllMoney3.setVisibility(View.GONE);
                            }
                            if (ll144.getVisibility()==View.VISIBLE){
                                etPFName4.setVisibility(View.VISIBLE);
                                tvPFName4.setVisibility(View.GONE);
                                etPFNum4.setVisibility(View.VISIBLE);
                                tvPFNum4.setVisibility(View.GONE);
                                etPFMoney4.setVisibility(View.VISIBLE);
                                tvPFMoney4.setVisibility(View.GONE);
                                etPFAllMoney4.setVisibility(View.VISIBLE);
                                tvPFAllMoney4.setVisibility(View.GONE);
                            }
                            if (ll55.getVisibility()==View.VISIBLE){
                                etPFName5.setVisibility(View.VISIBLE);
                                tvPFName5.setVisibility(View.GONE);
                                etPFNum5.setVisibility(View.VISIBLE);
                                tvPFNum5.setVisibility(View.GONE);
                                etPFMoney5.setVisibility(View.VISIBLE);
                                tvPFMoney5.setVisibility(View.GONE);
                                etPFAllMoney5.setVisibility(View.VISIBLE);
                                tvPFAllMoney5.setVisibility(View.GONE);
                            }
                            if (ll66.getVisibility()==View.VISIBLE){
                                etPFName6.setVisibility(View.VISIBLE);
                                tvPFName6.setVisibility(View.GONE);
                                etPFNum6.setVisibility(View.VISIBLE);
                                tvPFNum6.setVisibility(View.GONE);
                                etPFMoney6.setVisibility(View.VISIBLE);
                                tvPFMoney6.setVisibility(View.GONE);
                                etPFAllMoney6.setVisibility(View.VISIBLE);
                                tvPFAllMoney6.setVisibility(View.GONE);
                            }
                            if (ll77.getVisibility()==View.VISIBLE) {
                                etPFName7.setVisibility(View.VISIBLE);
                                tvPFName7.setVisibility(View.GONE);
                                etPFNum7.setVisibility(View.VISIBLE);
                                tvPFNum7.setVisibility(View.GONE);
                                etPFMoney7.setVisibility(View.VISIBLE);
                                tvPFMoney7.setVisibility(View.GONE);
                                etPFAllMoney7.setVisibility(View.VISIBLE);
                                tvPFAllMoney7.setVisibility(View.GONE);
                            }
                            if (ll88.getVisibility()==View.VISIBLE) {
                                etPFName8.setVisibility(View.VISIBLE);
                                tvPFName8.setVisibility(View.GONE);
                                etPFNum8.setVisibility(View.VISIBLE);
                                tvPFNum8.setVisibility(View.GONE);
                                etPFMoney8.setVisibility(View.VISIBLE);
                                tvPFMoney8.setVisibility(View.GONE);
                                etPFAllMoney8.setVisibility(View.VISIBLE);
                                tvPFAllMoney8.setVisibility(View.GONE);
                            }
                            if (ll99.getVisibility()==View.VISIBLE) {
                                etPFName9.setVisibility(View.VISIBLE);
                                tvPFName9.setVisibility(View.GONE);
                                etPFNum9.setVisibility(View.VISIBLE);
                                tvPFNum9.setVisibility(View.GONE);
                                etPFMoney9.setVisibility(View.VISIBLE);
                                tvPFMoney9.setVisibility(View.GONE);
                                etPFAllMoney9.setVisibility(View.VISIBLE);
                                tvPFAllMoney9.setVisibility(View.GONE);
                            }
                            if (ll1010.getVisibility()==View.VISIBLE) {
                                etPFName10.setVisibility(View.VISIBLE);
                                tvPFName10.setVisibility(View.GONE);
                                etPFNum10.setVisibility(View.VISIBLE);
                                tvPFNum10.setVisibility(View.GONE);
                                etPFMoney10.setVisibility(View.VISIBLE);
                                tvPFMoney10.setVisibility(View.GONE);
                                etPFAllMoney10.setVisibility(View.VISIBLE);
                                tvPFAllMoney10.setVisibility(View.GONE);
                            }
                        }
                        if (bmyjreout.equals("2")) {
                            tvLeader.setVisibility(View.GONE);
                            etLeader.setVisibility(View.VISIBLE);
                            llLeader.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader.setVisibility(View.VISIBLE);
                            etLeader.setVisibility(View.GONE);
                        }
                        if (cwbyjreout.equals("2")) {
                            tvLeader1.setVisibility(View.GONE);
                            etLeader1.setVisibility(View.VISIBLE);
                            llLeader1.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader1.setVisibility(View.VISIBLE);
                            etLeader1.setVisibility(View.GONE);
                        }
                        if (zcgkbmyjreout.equals("2")) {
                            tvLeader2.setVisibility(View.GONE);
                            etLeader2.setVisibility(View.VISIBLE);
                            llLeader2.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader2.setVisibility(View.VISIBLE);
                            etLeader2.setVisibility(View.GONE);
                        }
                        if (cgbyjreout.equals("2")) {
                            tvLeader3.setVisibility(View.GONE);
                            etLeader3.setVisibility(View.VISIBLE);
                            llLeader3.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader3.setVisibility(View.VISIBLE);
                            etLeader3.setVisibility(View.GONE);
                        }
                        if (bmfgldyjreout.equals("2")) {
                            tvLeader4.setVisibility(View.GONE);
                            etLeader4.setVisibility(View.VISIBLE);
                            llLeader4.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader4.setVisibility(View.VISIBLE);
                            etLeader4.setVisibility(View.GONE);
                        }
                        if (cgfgldyjreout.equals("2")) {
                            tvLeader5.setVisibility(View.GONE);
                            etLeader5.setVisibility(View.VISIBLE);
                            llLeader5.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader5.setVisibility(View.VISIBLE);
                            etLeader5.setVisibility(View.GONE);
                        }
                        if (cwzjyjreout.equals("2")) {
                            tvLeader6.setVisibility(View.GONE);
                            etLeader6.setVisibility(View.VISIBLE);
                            llLeader6.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader6.setVisibility(View.VISIBLE);
                            etLeader6.setVisibility(View.GONE);
                        }
                        if (zjlreout.equals("2")) {
                            tvLeader7.setVisibility(View.GONE);
                            etLeader7.setVisibility(View.VISIBLE);
                            llLeader7.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader7.setVisibility(View.VISIBLE);
                            etLeader7.setVisibility(View.GONE);
                        }
                        if (bmyjreout.equals("1") && cwbyjreout.equals("1") && zcgkbmyjreout.equals("1")
                                && cgbyjreout.equals("1") && bmfgldyjreout.equals("1") && cgfgldyjreout.equals("1")
                                && cwzjyjreout.equals("1") && zjlreout.equals("1")) {
                            Toast.makeText(NewGoodPurchaseWillDetailActivity.this, "您对当前流程只有读取权限", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
//
                    if (bean.isRevoke()) {
                        Toast.makeText(NewGoodPurchaseWillDetailActivity.this, "当前流程已被追回", Toast.LENGTH_SHORT).show();
                    }
                    ProgressDialogUtil.stopLoad();
                    if (beanList.size() == 1) {
                        btnT.setVisibility(View.GONE);
                        tvText.setVisibility(View.GONE);
                        ProgressDialogUtil.startLoad(NewGoodPurchaseWillDetailActivity.this, "获取审核人");
                        getAppRovePerson();
                    } else {
                        tvspr.setText("请点击“+”选择路径");
                    }
                    break;
                case TAG_TWO:
                    Toast.makeText(NewGoodPurchaseWillDetailActivity.this, "操作失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_THERE:
                    Toast.makeText(NewGoodPurchaseWillDetailActivity.this, "提交数据成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case TAG_FOUR:
//                    Toast.makeText(NewGoodPurchaseWillDetailActivity.this, upData, Toast.LENGTH_SHORT).show();
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
                        } else if (bean1.getData().size() == 1) {
                            if (bean1.getData().get(0).getRole().equals("办结安排")) {
                                role = bean1.getData().get(0).getRole();
                                userCode = bean1.getData().get(0).getUserNames();
                                userName = bean1.getData().get(0).getUserCodes();
                                nametemp = userName.split(",");
                                codetemp = userCode.split(",");
                            } else {
                                leader = bean1.getData().get(0).getRole();
                                leaderCode = bean1.getData().get(0).getUserNames();
                                leaderName = bean1.getData().get(0).getUserCodes();
                                bigNametemp = leaderName.split(",");
                                bigCodetemp = leaderCode.split(",");
                            }
                        }
                    }
                    setCbRbVer();
                    break;
                case TAG_EIGHT:
                    Toast.makeText(NewGoodPurchaseWillDetailActivity.this, "流程已到最后一步，请提交", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

}
