package com.ykx.appclean;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    protected static final int SUCCESS_GET_APPLICATION = 0;

    private Button mBtn;
    private ListView mLv;
    ArrayAdapter<String> mAdapter;

    //包管理器
    private PackageManager pm;

    //获取手机应用信息的业务类
    private AppInfoService mAppInfoService;

    //手机App信息
    private List<AppInfo> appInfos;

    //用户应用程序信息集合
    private List<AppInfo> userAppInfos;

    //是否是所有的app程序，默认为true
    private boolean isAllApp = true;

    //AppManagerAdapter mAdapter
    private AppManagerAdapter adapter;

    private PopupWindow popupWindow;

    //mHandler方法
    private Handler mHandler = new Handler() {

        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {

                case SUCCESS_GET_APPLICATION:

                    adapter = new AppManagerAdapter(getApplicationContext(),appInfos);

                    mLv.setAdapter(adapter);

                    break;

                default:
                    break;
            }
        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLv = (ListView) findViewById(R.id.listView);
        //实例化AppInfoService对象
        mAppInfoService = new AppInfoService(this);
        //包管理器
        pm = getPackageManager();

        new Thread(){

            public void run(){

                try {
                    appInfos = mAppInfoService.getAppInfos();
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }

                userAppInfos = new ArrayList<AppInfo>();

                for(AppInfo appInfo:appInfos){
                    if(appInfo.getIsApp())
                    {
                        Log.i("ykx","appInfo");
                        userAppInfos.add(appInfo);
                    }

                }
                Message msg = new Message();
                msg.what = SUCCESS_GET_APPLICATION;
                mHandler.sendMessage(msg);
            };

        }.start();
    }
}
