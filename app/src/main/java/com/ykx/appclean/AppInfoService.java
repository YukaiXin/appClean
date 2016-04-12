package com.ykx.appclean;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/12.
 */
@SuppressWarnings("WrongConstant")
public class AppInfoService {

    private Context mContext;
    private PackageManager pm;
    public List<AppInfo> getAppInfos(){

        List<AppInfo> appInfos = new ArrayList<AppInfo>();

        List<ApplicationInfo> applicationInfos = pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);

        for (ApplicationInfo info:applicationInfos){
            AppInfo appInfo = new AppInfo();

            //app图标
            Drawable app_icon = info.loadIcon(pm);
            appInfo.setAppIcon(app_icon);
            //app 名字
            String app_name =  info.loadLabel(pm).toString();
            appInfo.setAppName(app_name);
            //app 应用包名
            String app_pakeagename = info.packageName;

            boolean isUserApp = filterApp(info);
            appInfo.setIsUserApp(isUserApp);
            appInfos.add(appInfo);
        }
        return appInfos;
    }

    private boolean filterApp(ApplicationInfo info) {

        if((info.flags&ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0){
            return true;
        }else if((info.flags&ApplicationInfo.FLAG_SYSTEM) == 0){
            return true;
        }
        return false;
    }

    public AppInfoService(Context context){

        this.mContext = context;
        pm = context.getPackageManager();
    }

}
