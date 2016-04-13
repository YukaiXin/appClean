package com.ykx.appclean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/4/12.
 */
public class AppManagerAdapter extends BaseAdapter {


    private Context context;

    //布局加载器

    private LayoutInflater mInflater;
    private List<AppInfo> appInfos;

    //动态改变appInfos
    public void setAppInfos(List<AppInfo> appInfos){

        this.appInfos = appInfos;
    }

    public  AppManagerAdapter(Context context,List<AppInfo> appInfos){

        this.context = context;
        this.appInfos =appInfos;
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return appInfos.size();
    }

    @Override
    public Object getItem(int i) {
        return appInfos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        View view = null;
        if(convertView != null)
        {
            view = convertView;
        }else{
            view = mInflater.inflate(R.layout.applationinstall_item,null);
        }

        ImageView iv_appicon = (ImageView)view.findViewById(R.id.imageView);
        TextView  tv_appname = (TextView)view.findViewById(R.id.textView);
        TextView  tv_appversion = (TextView) view.findViewById(R.id.textView2);

        AppInfo appInfo = appInfos.get(i);

        iv_appicon.setImageDrawable(appInfo.getAppIcon());
        tv_appname.setText(appInfo.getAppName());
        tv_appversion.setText(appInfo.getAppVersion());

        return view;
    }
}
