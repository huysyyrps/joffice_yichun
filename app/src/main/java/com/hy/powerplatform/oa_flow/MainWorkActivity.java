package com.hy.powerplatform.oa_flow;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainWorkActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.webView)
    WebView webView;
    String cookiess="";
    SharedPreferencesHelper sharedPreferencesHelper;
    private String userId;
    private String id;
    private String depId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        String tag = getIntent().getStringExtra("tag");
        id = getIntent().getStringExtra("workId");
        sharedPreferencesHelper = new SharedPreferencesHelper(this,"login");
        cookiess = sharedPreferencesHelper.getData(this, "cookiess", "");
        userId = sharedPreferencesHelper.getData(this, "userId", "");
        depId = sharedPreferencesHelper.getData(this, "depId", "");
        WebSettings webSettings = webView.getSettings();
        webSettings.setDomStorageEnabled(true);//主要是这句
//        webSettings.setDomStorageEnabled(true);//打开本地缓存提供JS调用
//        webSettings.setAppCacheMaxSize(1024 * 1024 * 8);// 实现8倍缓存
        webSettings.setJavaScriptEnabled(true);//启用js
        webSettings.setBlockNetworkImage(false);//解决图片不显示
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setLoadsImagesAutomatically(true);
        String appCachePath = this.getApplication().getCacheDir().getAbsolutePath();
        webSettings.setAppCachePath(appCachePath);
        webSettings.setDatabaseEnabled(true);



//        webSettings.setAppCacheEnabled(true);
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
        String mUrl = "";
        if (tag.equals("1")){
            mUrl = "http://192.168.3.130:8080/erph5/#/pages/cooperative-office/task-distribution/task-list/task-list?userId=" + userId + "&depId="+depId;
        }else if (tag.equals("2")){
            mUrl = "http://192.168.3.130:8080/erph5/#/pages/cooperative-office/task-distribution/task-list/oper-list?userId=" + userId + "&depId="+depId;
        }else if (tag.equals("3")){
            mUrl = "http://192.168.3.130:8080/erph5/#/pages/cooperative-office/task-distribution/task-add/task-add?superviseWorkId=" + id + "&depId="+depId;
        }
        Log.e("mUrl", mUrl);
        syncCookie(Constant. BASE_URL2);
        setWebChromeClient();
        webView.loadUrl(mUrl);
        webView.addJavascriptInterface(new Object(){
            @JavascriptInterface
            public  void pageback(){
               finish();
            }
        },"app");
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main_work;
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
        Log.e("onDestroy", "onDestroy: " );
    }

    /**
     * 注入cookie
     */
    public void syncCookie( String url){
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
        Log.i("cookie",  cookiess+"ss");
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
        });

    }
}
