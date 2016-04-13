package com.ykx.appclean;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 201a6/4/12.
 */
public class AppInfo {

    private Drawable appIcon;
    private String appName;
    private String appVersion;
    private String appPackageName;
    private Boolean isUserApp;


    public AppInfo()
    {
        super();
    }

    public AppInfo(Drawable icon,String appName,String appVersion,String appPackageName,Boolean isUserApp)
    {
        super();
        this.appIcon = icon;
        this.appName = appName;
        this.appPackageName = appPackageName;
        this.appVersion = appVersion;
        this.isUserApp = isUserApp;
    }

    public AppInfo(Drawable icon,String appName,String appVersion,String appPackageName)
    {
        super();
        this.appIcon = icon;
        this.appName = appName;
        this.appPackageName = appPackageName;
        this.appVersion = appVersion;
    }

    public Drawable getAppIcon()
    {
        return this.appIcon;
    }

    public void setAppIcon( Drawable icon)
    {
        this.appIcon = icon;
    }


    public String getAppName()
    {
        return this.appName;
    }

    public void setAppName( String str)
    {
        this.appName = str;
    }


    public String getAppVersion()
    {
        return this.appVersion;
    }

    public void setAppVersion( String str)
    {
        this.appVersion = str;
    }

    public String getPackageName(){return appPackageName;}
    public void  setAppPackageName(String packageName){this.appPackageName = packageName;}

    public Boolean getIsApp()
    {
        return this.isUserApp;
    }

    public void  setIsUserApp(boolean isUserApp)
    {
        this.isUserApp = isUserApp;
    }
  public String toString(){

      return "No";
  }
}
