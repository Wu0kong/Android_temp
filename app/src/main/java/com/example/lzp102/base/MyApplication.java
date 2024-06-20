package com.example.lzp102.base;


import android.app.Application;

import com.baidu.location.LocationClient;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

import cn.bmob.v3.Bmob;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "acff990e45303cfd771513784f69e391");
        LocationClient.setAgreePrivacy(true);
        SDKInitializer.setAgreePrivacy(this, true);
        SDKInitializer.initialize(this);

        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);

    }
}
