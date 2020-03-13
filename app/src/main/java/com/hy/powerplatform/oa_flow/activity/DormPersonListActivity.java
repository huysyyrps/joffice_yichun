package com.hy.powerplatform.oa_flow.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.database.MyDatabaseHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.azlistview.EditTextWithDel;
import com.hy.powerplatform.my_utils.utils.azlistview.PinyinComparatorDormP;
import com.hy.powerplatform.my_utils.utils.azlistview.PinyinUtils;
import com.hy.powerplatform.my_utils.utils.azlistview.SideBar;
import com.hy.powerplatform.oa_flow.adapter.DormPersonAdapter;
import com.hy.powerplatform.oa_flow.adapter.PersonListAdapter;
import com.hy.powerplatform.oa_flow.bean.DormPersonList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DormPersonListActivity extends BaseActivity implements PersonListAdapter.OnGetAdapterPositionListener {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.et_search)
    EditTextWithDel etSearch;
    @BindView(R.id.lv_contact)
    ListView lvContact;
    @BindView(R.id.dialog)
    TextView dialog;
    @BindView(R.id.sidrbar)
    SideBar sidrbar;

    List<DormPersonList.ResultBean> dataList = new ArrayList<>();
    DormPersonAdapter adapter;
    SQLiteDatabase db;
    MyDatabaseHelper helper;
    Cursor cursor;
    List<String> selectList = new ArrayList<>();
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        getPerson();
    }

    private void initDatas() {
        sidrbar.setTextView(dialog);
    }

    private void initEvents() {
        //设置右侧触摸监听
        sidrbar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    lvContact.setSelection(position + 1);
                }
            }
        });

        //ListView的点击事件
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (ListView.CHOICE_MODE_MULTIPLE == lvContact.getChoiceMode()) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_city_name);
                    if (!selectList.contains(textView.getText().toString())) {
                        selectList.add(textView.getText().toString());
                    } else {
                        for (int i = 0; i < selectList.size(); i++) {
                            if (selectList.get(i).equals(textView.getText().toString())) {
                                selectList.remove(i);
                            }
                        }
                    }
                }
            }
        });

        //根据输入框输入值的改变来过滤搜索
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setAdapter() {
        Collections.sort(dataList, new PinyinComparatorDormP());
        adapter = new DormPersonAdapter(this, dataList);
        lvContact.setAdapter(adapter);
        adapter.setOnClientMyTextView(new DormPersonAdapter.CallBackPosition() {
            @Override
            public void myTextViewClient(String name, String profileId, String userCode, String sex, String eCode,
                                         String age, String idCard, String mobile, String adress) {
                Intent intent = new Intent();
//                intent.putExtra("userName", name+"");
//                intent.putExtra("eCode", eCode+"");
//                intent.putExtra("profileId", profileId+"");
//                intent.putExtra("userCode", userCode+"");//将计算的值回传回去

                if (name.equals("")) {
                    intent.putExtra("userName", "");
                } else {
                    intent.putExtra("userName", name);
                }

                if (eCode.equals("")) {
                    intent.putExtra("eCode", "");
                } else {
                    intent.putExtra("eCode", eCode);
                }
                if (profileId.equals("")) {
                    intent.putExtra("profileId", "");
                } else {
                    intent.putExtra("profileId", profileId);
                }

                if (userCode.equals("")) {
                    intent.putExtra("userCode", "");
                } else {
                    intent.putExtra("userCode", userCode);
                }

                if (userCode.equals("")) {
                    intent.putExtra("sex", "");
                } else {
                    intent.putExtra("sex", sex);
                }
                if (userCode.equals("")) {
                    intent.putExtra("age", "");
                } else {
                    intent.putExtra("age", age);
                }
                if (userCode.equals("")) {
                    intent.putExtra("idCard", "");
                } else {
                    intent.putExtra("idCard", idCard);
                }
                if (userCode.equals("")) {
                    intent.putExtra("mobile", "");
                } else {
                    intent.putExtra("mobile", mobile);
                }
                if (userCode.equals("")) {
                    intent.putExtra("adress", "");
                } else {
                    intent.putExtra("adress", adress);
                }
                setResult(Constant.TAG_TWO, intent);
                finish(); //结束当前的activity的生命周期
            }

        });
    }

    private void getPerson() {
        ProgressDialogUtil.startLoad(this, "获取数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String turl = Constant.BASE_URL2 + Constant.DORMPERSONLIST;
                DBHandler dbA = new DBHandler();
                String res = dbA.personList(turl);
                Bundle bundle = new Bundle();
                Message message = new Message();
                message.what = Constant.TAG_ONE;
                bundle.putString("data", res);
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }).start();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_personlist;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<DormPersonList.ResultBean> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(filterStr)) {
            mSortList = dataList;
        } else {
            mSortList.clear();
            for (DormPersonList.ResultBean sortModel : dataList) {
                String name = sortModel.getFullname();
                if (name.toUpperCase().indexOf(filterStr.toString().toUpperCase()) != -1 || PinyinUtils.getPingYin(name).toUpperCase().startsWith(filterStr.toString().toUpperCase())) {
                    mSortList.add(sortModel);
                }
            }
        }
        // 根据a-z进行排序
        Collections.sort(mSortList, new PinyinComparatorDormP());
        adapter.updateListView(mSortList);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String data = (String) msg.getData().get("data");
            try {
                JSONObject jsonObject1 = new JSONObject(data);
                JSONArray jsonArray = jsonObject1.getJSONArray("result");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    ContentValues values = new ContentValues();
                    values.put(com.hy.powerplatform.database.Constant.FULL_NAME, jsonObject.getString("fullname"));
                    values.put(com.hy.powerplatform.database.Constant.ECARD, jsonObject.getString("profileId"));
                    try {
                        values.put(com.hy.powerplatform.database.Constant.PROFILEID, jsonObject.getString("eCard"));
                    } catch (Exception e) {
                        Log.e("XXX", jsonObject.getString("fullname"));
                    }
                    values.put(com.hy.powerplatform.database.Constant.SEX, jsonObject.getString("sex"));
                    values.put(com.hy.powerplatform.database.Constant.USERCODE, jsonObject.getString("userCode"));
                    DormPersonList.ResultBean bean = new DormPersonList.ResultBean();
                    bean.setFullname(jsonObject.getString("fullname"));
                    bean.setProfileId(jsonObject.getString("profileId"));
                    try {
                        bean.setECard(jsonObject.getString("eCard"));
                    } catch (Exception e) {
                        Log.e("XXX", jsonObject.getString("fullname"));
                    }
                    bean.setSex(jsonObject.getString("sex"));
                    bean.setUserCode(jsonObject.getString("userCode"));
                    bean.setPosition(jsonObject.getString("position"));
                    bean.setDepName(jsonObject.getString("depName"));
                    bean.setMobile(jsonObject.getString("mobile"));
                    bean.setParty(jsonObject.getString("party"));
                    bean.setBirthday(jsonObject.getString("birthday"));
                    bean.setNowWorkDate(jsonObject.getString("nowWorkDate"));
                    bean.setAge(jsonObject.getString("age"));
                    bean.setAddress(jsonObject.getString("address"));
                    bean.setIdCard(jsonObject.getString("idCard"));
                    //汉字转换成拼音
                    String pinyin = PinyinUtils.getPingYin(jsonObject.getString("fullname"));
                    String sortString = pinyin.substring(0, 1).toUpperCase();

                    // 正则表达式，判断首字母是否是英文字母
                    if (sortString.matches("[A-Z]")) {
                        bean.setLetters(sortString);
                    } else {
                        bean.setLetters("#");
                    }
                    dataList.add(bean);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            initDatas();
            initEvents();
            setAdapter();
            ProgressDialogUtil.stopLoad();
        }
    };

    @Override
    public void getAdapterPosition(String userName, String userCode, String profileId) {
        Intent intent = new Intent();
        // 获取用户计算后的结果
        if (userName.equals("")) {
            intent.putExtra("userName", "");
        } else {
            intent.putExtra("userName", userName);
        }

        if (userCode.equals("")) {
            intent.putExtra("userCode", "");
        } else {
            intent.putExtra("userCode", userCode);
        }
        if (profileId.equals("")) {
            intent.putExtra("profileId", "");
        } else {
            intent.putExtra("profileId", profileId);
        }
        setResult(Constant.TAG_TWO, intent);
        finish(); //结束当前的activity的生命周期
    }
}
