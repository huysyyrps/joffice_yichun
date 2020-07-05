package com.hy.powerplatform.oa_flow.activity.newgoodpurchase.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.oa_flow.activity.PersonListActivity;
import com.hy.powerplatform.oa_flow.bean.Name;
import com.leon.lfilepickerlibrary.LFilePicker;
import com.leon.lfilepickerlibrary.utils.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
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
import butterknife.Unbinder;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FIVE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

/**
 * 物品采购(新)
 */
public class FragmentNewGoodsPurchaseData extends Fragment {

    Unbinder unbinder;
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
    @BindView(R.id.spinnertype)
    Spinner spinnertype;
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
    @BindView(R.id.tvPFAllMoney)
    TextView tvPFAllMoney;
    @BindView(R.id.etUse)
    EditText etUse;
    @BindView(R.id.etLeader1)
    EditText etLeader1;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.etLeader2)
    EditText etLeader2;
    @BindView(R.id.tvLeader2)
    TextView tvLeader2;
    @BindView(R.id.etLeader3)
    EditText etLeader3;
    @BindView(R.id.tvLeader3)
    TextView tvLeader3;
    @BindView(R.id.etLeader4)
    EditText etLeader4;
    @BindView(R.id.tvLeader4)
    TextView tvLeader4;
//    @BindView(R.id.llAll)
//    LinearLayout llAll;
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.llPFNum)
    LinearLayout llPFNum;
    @BindView(R.id.llPFMoney)
    LinearLayout llPFMoney;
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
    @BindView(R.id.llLeader1)
    LinearLayout llLeader1;
    @BindView(R.id.llLeader2)
    LinearLayout llLeader2;
    @BindView(R.id.llLeader3)
    LinearLayout llLeader3;
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
    @BindView(R.id.btnHistory)
    Button btnHistory;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private CustomDatePickerDay customDatePicker1;

    String userId = "";
    String userCode = "";
    String userName = "";
    String[] nametemp = null;
    String[] codetemp = null;
    List<String> codeList = new ArrayList<>();
    List<Name.DataBean> datalist = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();
    List<String> namelist = new ArrayList<>();
    List<String> namelist1 = new ArrayList<>();
    List<String> listZC = new ArrayList<String>();
    List<String> listType = new ArrayList<String>();
    String userDepart = "", aboutDep = "";
    String isShow = "true";
    private OkHttpUtil httpUtil;
    String aboutData = "", data1 = "", res = "", type = "", iszc = "";
    double AllMoney1 = 0.0, AllMoney2 = 0.0, AllMoney3 = 0.0, AllMoney4 = 0.0, AllMoney5 = 0.0, AllMoney6 = 0.0, AllMoney7 = 0.0, AllMoney8 = 0.0, AllMoney9 = 0.0, AllMoney10 = 0.0;
    Double allNum1 = 0.0, allNum2 = 0.0, allNum3 = 0.00, allNum4 = 0.0, allNum5 = 0.0, allNum6 = 0.0, allNum7 = 0.0, allNum8 = 0.00, allNum9 = 0.0, allNum10 = 0.0;
    double moneyS1 = 0.0, moneyS2 = 0.0, moneyS3 = 0.0, moneyS4 = 0.0, moneyS5 = 0.0, moneyS6 = 0.0, moneyS7 = 0.0, moneyS8 = 0.0, moneyS9 = 0.0, moneyS10 = 0.0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goodpurchnew_data, container, false);
        unbinder = ButterKnife.bind(this, view);
        btnHistory.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        llDown.setVisibility(View.GONE);
        httpUtil = OkHttpUtil.getInstance(getActivity());
        HSView.setVisibility(View.GONE);
        llPFNum.setVisibility(View.GONE);
        llPFMoney.setVisibility(View.GONE);
        tvCut1.setVisibility(View.GONE);
        tvCut2.setVisibility(View.GONE);
        tvCut3.setVisibility(View.GONE);
        tvCut4.setVisibility(View.GONE);
        tvCut5.setVisibility(View.GONE);
        tvCut6.setVisibility(View.GONE);
        tvCut7.setVisibility(View.GONE);
        tvCut8.setVisibility(View.GONE);
        tvCut9.setVisibility(View.GONE);
        tvCut10.setVisibility(View.GONE);
        initDatePicker();
        userId = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userCode", "");
        userName = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userStatus", "");
        String department = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "depName", "");
        etPerson.setText(userName);
        etClass.setText(department);
        etAllMoney1.addTextChangedListener(new TextWatcher() {
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
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney1 = 0.0;
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etAllMoney2.addTextChangedListener(new TextWatcher() {
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
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney2 = 0.0;
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etAllMoney3.addTextChangedListener(new TextWatcher() {
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
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney3 = 0.0;
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etAllMoney4.addTextChangedListener(new TextWatcher() {
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
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney4 = 0.0;
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etAllMoney5.addTextChangedListener(new TextWatcher() {
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
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney5 = 0.0;
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etAllMoney6.addTextChangedListener(new TextWatcher() {
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
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney6 = 0.0;
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etAllMoney7.addTextChangedListener(new TextWatcher() {
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
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney7 = 0.0;
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etAllMoney8.addTextChangedListener(new TextWatcher() {
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
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney8 = 0.0;
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etAllMoney9.addTextChangedListener(new TextWatcher() {
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
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney9 = 0.0;
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });
        etAllMoney10.addTextChangedListener(new TextWatcher() {
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
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                } else {
                    AllMoney10 = 0.0;
                    tvHeJi.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5
                            + AllMoney6 + AllMoney7 + AllMoney8 + AllMoney9 + AllMoney10));
                }
            }
        });

        etNum1.addTextChangedListener(new TextWatcher() {
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
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney1.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum1));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney1.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney1.getText().toString().equals("")) {
                            etAllMoney1.setText(new BigDecimal(allNum1 * Double.valueOf(etMoney1.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney1.setText(String.valueOf(0 * allNum1));
                        }
                    }
                } else {
                    allNum1 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5 + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etAllMoney1.setText(String.valueOf(0 * moneyS1));
                }
            }
        });
        etNum2.addTextChangedListener(new TextWatcher() {
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
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney2.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum2));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney2.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney2.getText().toString().equals("")) {
                            etAllMoney2.setText(new BigDecimal(allNum2 * Double.valueOf(etMoney2.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney2.setText(String.valueOf(0 * allNum2));
                        }
                    }
                } else {
                    allNum2 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etAllMoney2.setText(String.valueOf(0 * moneyS2));
                }
            }
        });
        etNum3.addTextChangedListener(new TextWatcher() {
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
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney3.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum3));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney3.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney3.getText().toString().equals("")) {
                            etAllMoney3.setText(new BigDecimal(allNum3 * Double.valueOf(etMoney3.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney3.setText(String.valueOf(0 * allNum3));
                        }
                    }
                } else {
                    allNum3 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etAllMoney3.setText(String.valueOf(0 * moneyS3));
                }
            }
        });
        etNum4.addTextChangedListener(new TextWatcher() {
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
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney4.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum4));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney4.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney4.getText().toString().equals("")) {
                            etAllMoney4.setText(new BigDecimal(allNum4 * Double.valueOf(etMoney4.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney4.setText(String.valueOf(0 * allNum4));
                        }
                    }
                } else {
                    allNum4 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etAllMoney4.setText(String.valueOf(0 * moneyS4));
                }
            }
        });
        etNum5.addTextChangedListener(new TextWatcher() {
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
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney5.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum5));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney5.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney5.getText().toString().equals("")) {
                            etAllMoney5.setText(new BigDecimal(allNum5 * Double.valueOf(etMoney5.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney5.setText(String.valueOf(0 * allNum5));
                        }
                    }
                } else {
                    allNum5 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etAllMoney5.setText(String.valueOf(0 * moneyS5));
                }
            }
        });
        etNum6.addTextChangedListener(new TextWatcher() {
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
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney6.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum6));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney6.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney6.getText().toString().equals("")) {
                            etAllMoney6.setText(new BigDecimal(allNum6 * Double.valueOf(etMoney6.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney6.setText(String.valueOf(0 * allNum6));
                        }
                    }
                } else {
                    allNum6 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etAllMoney6.setText(String.valueOf(0));
                }
            }
        });
        etNum7.addTextChangedListener(new TextWatcher() {
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
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney7.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum7));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney7.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney7.getText().toString().equals("")) {
                            etAllMoney7.setText(new BigDecimal(allNum7 * Double.valueOf(etMoney7.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney7.setText(String.valueOf(0 * allNum7));
                        }
                    }
                } else {
                    allNum7 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etAllMoney7.setText(String.valueOf(0 * moneyS7));
                }
            }
        });
        etNum8.addTextChangedListener(new TextWatcher() {
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
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney8.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum8));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney8.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney8.getText().toString().equals("")) {
                            etAllMoney8.setText(new BigDecimal(allNum8 * Double.valueOf(etMoney8.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney8.setText(String.valueOf(0 * allNum8));
                        }
                    }
                } else {
                    allNum8 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etAllMoney8.setText(String.valueOf(0 * moneyS8));
                }
            }
        });
        etNum9.addTextChangedListener(new TextWatcher() {
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
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney9.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum9));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney9.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney9.getText().toString().equals("")) {
                            etAllMoney9.setText(new BigDecimal(allNum9 * Double.valueOf(etMoney9.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney9.setText(String.valueOf(0 * allNum9));
                        }
                    }
                } else {
                    allNum9 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etAllMoney9.setText(String.valueOf(0 * moneyS9));
                }
            }
        });
        etNum10.addTextChangedListener(new TextWatcher() {
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
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney10.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum10));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney10.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney10.getText().toString().equals("")) {
                            etAllMoney10.setText(new BigDecimal(allNum10 * Double.valueOf(etMoney10.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney10.setText(String.valueOf(0 * allNum10));
                        }
                    }
                } else {
                    allNum10 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5
                            + allNum6 + allNum7 + allNum8 + allNum9 + allNum10));
                    etAllMoney10.setText(String.valueOf(0 * moneyS10));
                }
            }
        });

        etMoney1.addTextChangedListener(new TextWatcher() {
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
                    if (!etNum1.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS1));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum1.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum1.getText().toString().equals("")) {
//                            etAllMoney1.setText(s1);
                            etAllMoney1.setText(new BigDecimal(moneyS1 * Double.valueOf(etNum1.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney1.setText(String.valueOf(0 * moneyS1));
                        }
                    }
                } else {
                    etAllMoney1.setText(String.valueOf(0 * moneyS1));
                }
            }
        });
        etMoney2.addTextChangedListener(new TextWatcher() {
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
                    if (!etNum2.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS2));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum2.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum2.getText().toString().equals("")) {
                            etAllMoney2.setText(new BigDecimal(moneyS2 * Double.valueOf(etNum2.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney2.setText(String.valueOf(0 * moneyS2));
                        }
                    }
                } else {
                    etAllMoney2.setText(String.valueOf(0 * moneyS2));
                }
            }
        });
        etMoney3.addTextChangedListener(new TextWatcher() {
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
                    if (!etNum3.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS3));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum3.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum3.getText().toString().equals("")) {
                            etAllMoney3.setText(new BigDecimal(moneyS3 * Double.valueOf(etNum3.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney3.setText(String.valueOf(0 * moneyS3));
                        }
                    }
                } else {
                    etAllMoney3.setText(String.valueOf(0 * moneyS3));
                }
            }
        });
        etMoney4.addTextChangedListener(new TextWatcher() {
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
                    if (!etNum4.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS4));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum4.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum4.getText().toString().equals("")) {
                            etAllMoney4.setText(new BigDecimal(moneyS4 * Double.valueOf(etNum4.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney4.setText(String.valueOf(0 * moneyS4));
                        }
                    }
                } else {
                    etAllMoney4.setText(String.valueOf(0 * moneyS4));
                }
            }
        });
        etMoney5.addTextChangedListener(new TextWatcher() {
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
                    if (!etNum5.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS5));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum5.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum5.getText().toString().equals("")) {
                            etAllMoney5.setText(new BigDecimal(moneyS5 * Double.valueOf(etNum5.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney5.setText(String.valueOf(0 * moneyS5));
                        }
                    }
                } else {
                    etAllMoney5.setText(String.valueOf(0 * moneyS5));
                }
            }
        });
        etMoney6.addTextChangedListener(new TextWatcher() {
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
                    if (!etNum6.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS6));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum6.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum6.getText().toString().equals("")) {
//                            etAllMoney1.setText(s1);
                            etAllMoney6.setText(new BigDecimal(moneyS6 * Double.valueOf(etNum6.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney6.setText(String.valueOf(0 * moneyS6));
                        }
                    }
                } else {
                    etAllMoney6.setText(String.valueOf(0 * moneyS6));
                }
            }
        });
        etMoney7.addTextChangedListener(new TextWatcher() {
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
                    if (!etNum7.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS7));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum7.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum7.getText().toString().equals("")) {
                            etAllMoney7.setText(new BigDecimal(moneyS7 * Double.valueOf(etNum7.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney7.setText(String.valueOf(0 * moneyS7));
                        }
                    }
                } else {
                    etAllMoney7.setText(String.valueOf(0 * moneyS7));
                }
            }
        });
        etMoney8.addTextChangedListener(new TextWatcher() {
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
                    if (!etNum8.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS8));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum8.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum8.getText().toString().equals("")) {
                            etAllMoney8.setText(new BigDecimal(moneyS8 * Double.valueOf(etNum8.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney8.setText(String.valueOf(0 * moneyS8));
                        }
                    }
                } else {
                    etAllMoney8.setText(String.valueOf(0 * moneyS8));
                }
            }
        });
        etMoney9.addTextChangedListener(new TextWatcher() {
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
                    if (!etNum9.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS9));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum9.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum9.getText().toString().equals("")) {
                            etAllMoney9.setText(new BigDecimal(moneyS9 * Double.valueOf(etNum9.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney9.setText(String.valueOf(0 * moneyS9));
                        }
                    }
                } else {
                    etAllMoney9.setText(String.valueOf(0 * moneyS9));
                }
            }
        });
        etMoney10.addTextChangedListener(new TextWatcher() {
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
                    if (!etNum10.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS10));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum10.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum10.getText().toString().equals("")) {
                            etAllMoney10.setText(new BigDecimal(moneyS10 * Double.valueOf(etNum10.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney10.setText(String.valueOf(0 * moneyS10));
                        }
                    }
                } else {
                    etAllMoney10.setText(String.valueOf(0 * moneyS10));
                }
            }
        });

        listZC.add("资产类");
        listZC.add("非资产类");
        listType.add("");
        listType.add("办公家具");
        listType.add("电子设备");
        listType.add("交通设备");
        listType.add("房屋及建筑物");
        listType.add("修理设备");
        listType.add("材料配件");
        listType.add("投币机、零钞兑换机");
        listType.add("消防、安防设备");
        listType.add("充电桩");
        ArrayAdapter adapterZC = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listZC);
        adapterZC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerzc.setAdapter(adapterZC);
        spinnerzc.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (arg2 == 1) {
                    ll1.setVisibility(View.GONE);
                    listType.clear();
                    listType.add("");
                } else {
                    ll1.setVisibility(View.VISIBLE);
                    listType.clear();
                    listType.add("");
                    listType.add("办公家具");
                    listType.add("电子设备");
                    listType.add("交通设备");
                    listType.add("房屋及建筑物");
                    listType.add("修理设备");
                    listType.add("材料配件");
                    listType.add("投币机、零钞兑换机");
                    listType.add("消防、安防设备");
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ArrayAdapter adapterType = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listType);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertype.setAdapter(adapterType);
        spinnertype.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (arg2 != 0) {
                    final String data = (String) spinnertype.getItemAtPosition(arg2);//从spinner中获取被选择的数据
                    Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String url = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + "admin/getAssetsByTypeAssetsManage.do?type=" + data;
                            DBHandler dbA = new DBHandler();
                            aboutData = dbA.GoodsPurchaseAboutDep(url);
                            if (aboutData.equals("保存失败") || aboutData.equals("")) {
                                handler.sendEmptyMessage(111);
                            } else {
                                handler.sendEmptyMessage(222);
                            }
                        }
                    }).start();
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        return view;
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvTime.setText(now.split(" ")[0]);
        customDatePicker1 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvTime.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker1.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker1.setIsLoop(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tvTime, R.id.btnUp, R.id.tvPerson, R.id.tvAdd1, R.id.tvCut1, R.id.tvAdd2, R.id.tvCut2,
            R.id.tvAdd3, R.id.tvCut3, R.id.tvAdd4, R.id.tvCut4, R.id.tvAdd5, R.id.tvCut5, R.id.tvAdd6,
            R.id.tvCut6, R.id.tvAdd7, R.id.tvCut7, R.id.tvAdd8, R.id.tvCut8, R.id.tvAdd9, R.id.tvCut9, R.id.tvAdd10, R.id.tvCut10})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTime:
                customDatePicker1.show(tvTime.getText().toString());
                break;
            case R.id.tvPerson:
                Intent intent = new Intent(getActivity(), PersonListActivity.class);
                startActivityForResult(intent, TAG_TWO);
                break;
            case R.id.btnUp:
                final String department = etClass.getText().toString().trim();
                final String person = etPerson.getText().toString().trim();
                final String time = tvTime.getText().toString().trim();
                final String use = etUse.getText().toString().trim();
                if (department.equals("")) {
                    Toast.makeText(getActivity(), "部门不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (person.equals("")) {
                    Toast.makeText(getActivity(), "申请人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (time.equals("")) {
                    Toast.makeText(getActivity(), "填单日期不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etName1.getText().toString().equals("") || etNum1.getText().toString().equals("") || etAllMoney1.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "采购信息不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (spinnerzc.getSelectedItem().toString().equals("资产类")) {
                    if (spinnertype.getSelectedItem().toString().equals("")) {
                        Toast.makeText(getActivity(), "物品类型不能为空", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                if (use.equals("")) {
                    Toast.makeText(getActivity(), "用途不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etName1.getText().toString().trim().equals("") || etNum1.getText().toString().trim().equals("") || etAllMoney1.getText().toString().trim().equals("")) {
                    Toast.makeText(getActivity(), "采购信息不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                ProgressDialogUtil.startLoad(getActivity(), "数据上传中");
                getSenPiPersonOne();
                break;
            case R.id.tvAdd1:
                ll2.setVisibility(View.VISIBLE);
                break;
            case R.id.tvAdd2:
                ll3.setVisibility(View.VISIBLE);
                break;
            case R.id.tvCut2:
                ll2.setVisibility(View.GONE);
                break;
            case R.id.tvAdd3:
                ll4.setVisibility(View.VISIBLE);
                break;
            case R.id.tvCut3:
                ll3.setVisibility(View.GONE);
                break;
            case R.id.tvAdd4:
                ll5.setVisibility(View.VISIBLE);
                break;
            case R.id.tvCut4:
                ll4.setVisibility(View.GONE);
                break;
            case R.id.tvAdd5:
                ll6.setVisibility(View.VISIBLE);
                break;
            case R.id.tvCut5:
                ll5.setVisibility(View.GONE);
                break;
            case R.id.tvAdd6:
                ll7.setVisibility(View.VISIBLE);
                break;
            case R.id.tvCut6:
                ll6.setVisibility(View.GONE);
                break;
            case R.id.tvAdd7:
                ll8.setVisibility(View.VISIBLE);
                break;
            case R.id.tvCut7:
                ll7.setVisibility(View.GONE);
                break;
            case R.id.tvAdd8:
                ll9.setVisibility(View.VISIBLE);
                break;
            case R.id.tvCut8:
                ll8.setVisibility(View.GONE);
                break;
            case R.id.tvAdd9:
                ll10.setVisibility(View.VISIBLE);
                break;
            case R.id.tvCut9:
                ll9.setVisibility(View.GONE);
                break;
            case R.id.tvAdd10:
                Toast.makeText(getActivity(), "已到上限", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvCut10:
                ll10.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            List<String> list = data.getStringArrayListExtra("paths");
            for (String s : list) {
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
                File file = new File(s);
                Toast.makeText(getActivity(), file.getName(), Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == TAG_TWO) {
            if (data != null) {
                userCode = data.getStringExtra("userCode");
                userName = data.getStringExtra("userName");
                etPerson.setText(userName);
            }
        }
    }

    /**
     * 获取第一审批人
     */
    private void getSenPiPersonOne() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + "flow/startTransProcessActivity.do";
                DBHandler dbA = new DBHandler();
                data1 = dbA.OAQingJiaMor(url, com.hy.powerplatform.my_utils.base.Constant.NEWGOODPUECHASEDIFID);
                if (data1.equals("保存失败") || data1.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_ONE);
                }
            }
        }).start();
    }

    /**
     * 提交数据
     */
    private void UpContractData() {
        ProgressDialogUtil.startLoad(getActivity(), "提交数据中");
        String turl = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + com.hy.powerplatform.my_utils.base.Constant.UPDATAU;
        DBHandler dbA = new DBHandler();
        String uId = "";
        if (selectList.size() == 1) {
            uId = selectList.get(0);
        }
        if (selectList.size() > 1) {
            for (int i = 1; i < selectList.size(); i++) {
                if (i < selectList.size() - 1) {
                    uId = uId + selectList.get(i) + ",";
                } else {
                    uId = uId + selectList.get(i);
                }
            }
            uId = selectList.get(0) + "," + uId;
        }
        String department = etClass.getText().toString();
        String person = etPerson.getText().toString();
        String time = tvTime.getText().toString();
        String use = etUse.getText().toString();
        String name1 = etName1.getText().toString() + "";
        String name2 = etName2.getText().toString() + "";
        String name3 = etName3.getText().toString() + "";
        String name4 = etName4.getText().toString() + "";
        String name5 = etName5.getText().toString() + "";
        String name6 = etName6.getText().toString() + "";
        String name7 = etName7.getText().toString() + "";
        String name8 = etName8.getText().toString() + "";
        String name9 = etName9.getText().toString() + "";
        String name10 = etName10.getText().toString() + "";

        String gg1 = etGG1.getText().toString() + "";
        String gg2 = etGG2.getText().toString() + "";
        String gg3 = etGG3.getText().toString() + "";
        String gg4 = etGG4.getText().toString() + "";
        String gg5 = etGG5.getText().toString() + "";
        String gg6 = etGG6.getText().toString() + "";
        String gg7 = etGG7.getText().toString() + "";
        String gg8 = etGG8.getText().toString() + "";
        String gg9 = etGG9.getText().toString() + "";
        String gg10 = etGG10.getText().toString() + "";

        String ys1 = etYS1.getText().toString() + "";
        String ys2 = etYS2.getText().toString() + "";
        String ys3 = etYS3.getText().toString() + "";
        String ys4 = etYS4.getText().toString() + "";
        String ys5 = etYS5.getText().toString() + "";
        String ys6 = etYS6.getText().toString() + "";
        String ys7 = etYS7.getText().toString() + "";
        String ys8 = etYS8.getText().toString() + "";
        String ys9 = etYS9.getText().toString() + "";
        String ys10 = etYS10.getText().toString() + "";

        String num1 = etNum1.getText().toString() + "";
        String num2 = etNum2.getText().toString() + "";
        String num3 = etNum3.getText().toString() + "";
        String num4 = etNum4.getText().toString() + "";
        String num5 = etNum5.getText().toString() + "";
        String num6 = etNum6.getText().toString() + "";
        String num7 = etNum7.getText().toString() + "";
        String num8 = etNum8.getText().toString() + "";
        String num9 = etNum9.getText().toString() + "";
        String num10 = etNum10.getText().toString() + "";

        String money1 = etMoney1.getText().toString() + "";
        String money2 = etMoney2.getText().toString() + "";
        String money3 = etMoney3.getText().toString() + "";
        String money4 = etMoney4.getText().toString() + "";
        String money5 = etMoney5.getText().toString() + "";
        String money6 = etMoney6.getText().toString() + "";
        String money7 = etMoney7.getText().toString() + "";
        String money8 = etMoney8.getText().toString() + "";
        String money9 = etMoney9.getText().toString() + "";
        String money10 = etMoney10.getText().toString() + "";

        String allMoney1 = etAllMoney1.getText().toString() + "";
        String allMoney2 = etAllMoney2.getText().toString() + "";
        String allMoney3 = etAllMoney3.getText().toString() + "";
        String allMoney4 = etAllMoney4.getText().toString() + "";
        String allMoney5 = etAllMoney5.getText().toString() + "";
        String allMoney6 = etAllMoney6.getText().toString() + "";
        String allMoney7 = etAllMoney7.getText().toString() + "";
        String allMoney8 = etAllMoney8.getText().toString() + "";
        String allMoney9 = etAllMoney9.getText().toString() + "";
        String allMoney10 = etAllMoney10.getText().toString() + "";

        String numHg = tvAllNum.getText().toString();
        String moneyHj = tvHeJi.getText().toString();
        String yongtu = etUse.getText().toString();
        if (spinnertype.getSelectedItem() == null) {
            type = "";
        } else {
            type = spinnertype.getSelectedItem().toString();
        }
        iszc = spinnerzc.getSelectedItem().toString();
        final HashMap<String, String> map = new HashMap();
        ProgressDialogUtil.startLoad(getActivity(), getResources().getString(R.string.get_data));
        map.clear();
        map.put("useTemplate", "false");
        map.put("defId", com.hy.powerplatform.my_utils.base.Constant.NEWGOODPUECHASEDIFID);
        map.put("startFlow", "true");
        map.put("destName", userDepart);
        map.put("sendMsg", "true");
        map.put("sendMail", "true");
        map.put("flowAssignId", userDepart + "|" + uId);
        map.put("formDefId", com.hy.powerplatform.my_utils.base.Constant.NEWGOODPUECHASE);
        map.put("iszc", iszc);
        map.put("goodsType", type);
        map.put("sqrq", time);
        map.put("bmDid", "378");
        map.put("bm", department);
        map.put("sqrUId", userId);
        map.put("sqr", userName);
        map.put("mingcheng1", name1);
        map.put("guige1", gg1);
        map.put("yusuan1", ys1);
        map.put("shuliang1", num1);
        map.put("danjia1", money1);
        map.put("jine1", allMoney1);
        map.put("shuliangheji1", numHg);
        map.put("jineheji1", moneyHj);
        map.put("yongtu", yongtu);
        if (ll2.getVisibility() == View.VISIBLE) {
            map.put("mingcheng2", name2);
            map.put("guige2", gg2);
            map.put("yusuan2", ys2);
            map.put("shuliang2", num2);
            map.put("danjia2", money2);
            map.put("jine2", allMoney2);
        }
        if (ll3.getVisibility() == View.VISIBLE) {
            map.put("mingcheng3", name3);
            map.put("guige3", gg3);
            map.put("yusuan3", ys3);
            map.put("shuliang3", num3);
            map.put("danjia3", money3);
            map.put("jine3", allMoney3);
        }
        if (ll4.getVisibility() == View.VISIBLE) {
            map.put("mingcheng4", name4);
            map.put("guige4", gg4);
            map.put("yusuan4", ys4);
            map.put("shuliang4", num4);
            map.put("danjia4", money4);
            map.put("jine4", allMoney4);
        }
        if (ll5.getVisibility() == View.VISIBLE) {
            map.put("mingcheng5", name5);
            map.put("guige5", gg5);
            map.put("yusuan5", ys5);
            map.put("shuliang5", num5);
            map.put("danjia5", money5);
            map.put("jine5", allMoney5);
        }
        if (ll6.getVisibility() == View.VISIBLE) {
            map.put("mingcheng6", name6);
            map.put("guige6", gg6);
            map.put("yusuan6", ys6);
            map.put("shuliang6", num6);
            map.put("danjia6", money6);
            map.put("jine6", allMoney6);
        }
        if (ll7.getVisibility() == View.VISIBLE) {
            map.put("mingcheng7", name7);
            map.put("guige7", gg7);
            map.put("yusuan7", ys7);
            map.put("shuliang7", num7);
            map.put("danjia7", money7);
            map.put("jine7", allMoney7);
        }
        if (ll8.getVisibility() == View.VISIBLE) {
            map.put("mingcheng8", name8);
            map.put("guige8", gg8);
            map.put("yusuan8", ys8);
            map.put("shuliang8", num8);
            map.put("danjia8", money8);
            map.put("jine8", allMoney8);
        }
        if (ll9.getVisibility() == View.VISIBLE) {
            map.put("mingcheng9", name9);
            map.put("guige9", gg9);
            map.put("yusuan9", ys9);
            map.put("shuliang9", num9);
            map.put("danjia9", money9);
            map.put("jine9", allMoney9);
        }
        if (ll10.getVisibility() == View.VISIBLE) {
            map.put("mingcheng10", name10);
            map.put("guige10", gg10);
            map.put("yusuan10", ys10);
            map.put("shuliang10", num10);
            map.put("danjia10", money10);
            map.put("jine10", allMoney10);
        }
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
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = TAG_FIVE;
                handler.sendMessage(message);
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    new LFilePicker().withSupportFragment(this)
                            .withRequestCode(1)
                            .withIconStyle(Constant.ICON_STYLE_BLUE)
                            .withTitle("Open From Fragment")
                            .start();
                } else {
                    Toast.makeText(getActivity(), "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 111:
                    Toast.makeText(getActivity(), "关联部门失败", Toast.LENGTH_SHORT).show();
                    break;
                case 222:
                    try {
                        JSONObject jsonObject = new JSONObject(aboutData);
                        aboutDep = jsonObject.getString("msg");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case TAG_ONE:
                    try {
                        JSONObject jsonObject = new JSONObject(data1);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        namelist.clear();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObjectName = jsonArray.getJSONObject(i);
                            String name = jsonObjectName.getString("destination");
                            namelist.add(name);
                        }
                        if (namelist.size() != 0) {
                            if (namelist.size() == 1) {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        String url = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + com.hy.powerplatform.my_utils.base.Constant.NOENDPERSON;
                                        DBHandler dbA = new DBHandler();
                                        res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.NEWGOODPUECHASEDIFID, namelist.get(0));
                                        userDepart = namelist.get(0);
                                        if (res.equals("保存失败") || res.equals("")) {
                                            handler.sendEmptyMessage(TAG_TWO);
                                        } else {
                                            handler.sendEmptyMessage(TAG_FOUR);
                                        }
                                    }
                                }).start();
                            } else {
                                MyAlertDialog.MyListAlertDialog(getActivity(), namelist, new AlertDialogCallBackP() {
                                    @Override
                                    public void oneselect(final String data) {
                                        ProgressDialogUtil.startLoad(getActivity(), "获取数据中");
                                        new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                String url = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + com.hy.powerplatform.my_utils.base.Constant.NOENDPERSON;
                                                DBHandler dbA = new DBHandler();
                                                userDepart = data;
                                                res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.NEWGOODPUECHASEDIFID, data);
                                                if (res.equals("保存失败") || res.equals("")) {
                                                    handler.sendEmptyMessage(TAG_TWO);
                                                } else {
                                                    handler.sendEmptyMessage(TAG_FOUR);
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
                        } else {
                            Toast.makeText(getActivity(), "审批人为空", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case TAG_TWO:
                    Toast.makeText(getActivity(), "操作失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_FOUR:
                    ProgressDialogUtil.stopLoad();
                    try {
                        JSONObject jsonObject = new JSONObject(res);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        datalist.clear();
                        nameList.clear();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Name.DataBean name = new Name.DataBean();
                            JSONObject jsonObjectName = jsonArray.getJSONObject(i);
                            name.setActivityName(jsonObjectName.getString("userNames"));
                            name.setUName(jsonObjectName.getString("userCodes"));
                            datalist.add(name);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (datalist.size() == 1) {
                        Name.DataBean bean1 = datalist.get(0);
                        userCode = bean1.getActivityName();
                        String userName = bean1.getUName();
                        nametemp = userName.split(",");
                        codetemp = userCode.split(",");
                        if (codetemp != null) {
                            for (String s : codetemp) {
                                codeList.add(s);
                            }
                        }
                        if (nametemp != null) {
                            for (String s : nametemp) {
                                nameList.add(s);
                            }
                        }
                        if (codeList.size() == 1) {
                            selectList.add(codeList.get(0));
                            UpContractData();
                        } else {
                            MyAlertDialog.MyListAlertDialog(isShow, codeList, nameList, namelist1, getActivity(), new AlertDialogCallBackP() {

                                @Override
                                public void select(List<String> data) {
                                    selectList = data;
                                    UpContractData();
                                }

                                @Override
                                public void oneselect(String s) {

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
                case TAG_FIVE:
                    Toast.makeText(getActivity(), "发布成功", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                    break;
            }
        }
    };
}
