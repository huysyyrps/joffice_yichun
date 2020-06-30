package com.hy.powerplatform;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.hy.powerplatform.business_inspect.activity.ShiGuActivity;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends BaseActivity {
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.webView)
    WebView webView;
    SharedPreferencesHelper sharedPreferencesHelper;
    String cookiess;
    @BindView(R.id.header)
    Header header;
//    String loginName="",userPwd="",userName="",userId="",userCode="",superRoleName="",roleName="",rights="",depName="",depId="",cookiess="",positionStatus="";

    private ValueCallback<Uri> uploadMessage;
    private ValueCallback<Uri[]> uploadMessageAboveL;
    private final static int FILE_CHOOSER_RESULT_CODE = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        header.setTvTitle(Constant.EMAINTAINNAME);
        cookiess = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
        new StatusBarUtils().setWindowStatusBarColor(TestActivity.this, R.color.color_bg_selected);
//        //
//        sharedPreferencesHelper = new SharedPreferencesHelper(this,"login");
//        loginName = sharedPreferencesHelper.getData(this, "userName", "");
//        userPwd = sharedPreferencesHelper.getData(this, "userPwd", "");
//        userName = sharedPreferencesHelper.getData(this, "userStatus", "");
//        userId = sharedPreferencesHelper.getData(this, "userId", "");
//        userCode = sharedPreferencesHelper.getData(this, "userCode", "");
//        superRoleName = sharedPreferencesHelper.getData(this, "superRoleName", "");
//        roleName = sharedPreferencesHelper.getData(this, "roleName", "");
//        rights = sharedPreferencesHelper.getData(this, "rights", "");
//        depName = sharedPreferencesHelper.getData(this, "depName", "");
//        depId = sharedPreferencesHelper.getData(this, "depId", "");
//        cookiess = sharedPreferencesHelper.getData(this, "cookiess", "");
//        positionStatus = sharedPreferencesHelper.getData(this, "positionStatus", "");
//
        WebSettings webSettings = webView.getSettings();
        webSettings.setDomStorageEnabled(true);//主要是这句
        webSettings.setJavaScriptEnabled(true);//启用js
        webSettings.setBlockNetworkImage(false);//解决图片不显示
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setLoadsImagesAutomatically(true);
        String appCachePath = this.getApplication().getCacheDir().getAbsolutePath();
        webSettings.setAppCachePath(appCachePath);
        webSettings.setDatabaseEnabled(true);


        webView.setWebChromeClient(new WebChromeClient());//这行最好不要丢掉
        //该方法解决的问题是打开浏览器不调用系统浏览器，直接用webview打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {  //表示按返回键
                        webView.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
//        String mUrl = Constant. ERPH5BaseUrl + "/dispatch/#/pages/index/index?userName="+userName
//                +"&userId="+userId+"&userCode="+userCode+"&depName="+depName+"&depId="+depId +"&positionStatus="+positionStatus;
//
//        Log.e("mUrl", mUrl);
//        syncCookie(Constant. ERPH5Api);
        String mUrl = "http://192.168.3.185:8080/erph5/#/pages/cooperative-office/overFlow/constantSend/" +
                "constantSend?defId=" + Constant.EMAINTAINDIFID + "&title=" + Constant.EMAINTAINNAME;
        syncCookie("http://58.17.74.135:6775");
        setWebChromeClient();
        webView.loadUrl(mUrl);

        webView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void pushToAccidentReportingVC() {
                Log.e("Threadd", "Thread1 " + Thread.currentThread().getName());
                Intent intent = new Intent(TestActivity.this, ShiGuActivity.class);
                startActivity(intent);
//                handler.sendEmptyMessage(500);
            }

            @JavascriptInterface
            public void pushVehicleMaintenance() {
//                handler.sendEmptyMessage(501);
//                Intent intent1 = new Intent(TestActivity.this, RepairWebViewActivity.class);//
//                startActivity(intent1);
            }

            @JavascriptInterface
            public void pushMaterialScanning() {
//                Intent intent2 = new Intent(TestActivity.this, readyActivity.class);//
//                startActivity(intent2);
            }

            @JavascriptInterface
            public void loginoutClick() {
                finish();
            }
        }, "app");
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_test;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "onDestroy: ");
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 500:
                    Log.e("Threadd", "Thread2 " + Thread.currentThread());
                    Intent intent = new Intent(TestActivity.this, ShiGuActivity.class);
                    startActivity(intent);
                    break;
                case 501:
//                    Intent intent1 = new Intent(TestActivity.this, RepairWebViewActivity.class);//
//                    startActivity(intent1);
                    break;
            }

            finish();
        }
    };


    /**
     * 注入cookie
     */
    public void syncCookie(String url) {
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.setAcceptThirdPartyCookies(webView, true);//让项目接受第三方域名cookie的设置
        }
        cookieManager.setCookie(url, cookiess);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            CookieManager.getInstance().flush();
        } else {
            CookieSyncManager.getInstance().sync();
        }
//        String cookie1 = cookieManager.getCookie(url);
        Log.i("cookie", cookiess + "ss");
    }


    private void setWebChromeClient() {
        final Context context = this;
        //设置进度条
        //WebChromeClient与webViewClient的区别
        //webViewClient处理偏界面的操作：打开新界面，界面打开，界面打开结束
        //WebChromeClient处理偏js的操作
        webView.setWebChromeClient(new WebChromeClient() {
            /**
             * 进度改变的回调
             * WebView：就是本身
             * newProgress：即将要显示的进度
             */

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {

                    progressBar.setVisibility(View.GONE);

                } else {


                    progressBar.setProgress(newProgress);

                }


            }

            // For Android < 3.0
            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                uploadMessage = valueCallback;
//                openImageChooserActivity();
            }

            // For Android  >= 3.0
            public void openFileChooser(ValueCallback valueCallback, String acceptType) {
                uploadMessage = valueCallback;
//                openImageChooserActivity();
            }

            //For Android  >= 4.1
            public void openFileChooser(ValueCallback<Uri> valueCallback, String acceptType, String capture) {
                uploadMessage = valueCallback;
//                openImageChooserActivity();
            }

            // For Android >= 5.0
            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
                uploadMessageAboveL = filePathCallback;
//                openImageChooserActivity();
                return true;
            }

        });

    }

}