package com.zyl.alhotfixdemo;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;

import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;
import com.zyl.alhotfixdemo.util.CommonConsts;
import com.zyl.tool.other.OtherTools;

/**
 * Created by zhaoyongliang on 2017/10/13.
 */

public class MApplication extends Application {

    private static final String TAG = "MApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        initHotfix();
        loadNewPatch();
    }

    private void loadNewPatch() {
        SophixManager.getInstance().queryAndLoadNewPatch();
    }

    private void initHotfix() {
        try {
            SophixManager.getInstance().setContext(this)
            .setAppVersion(OtherTools.getInstance().getVersionInfo(this).versionName)
            .setAesKey(null)
            .setEnableDebug(true)
            .setSecretMetaData(CommonConsts.APP_ID, CommonConsts.APP_SECRET, CommonConsts.RSA_SECRET)
            .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                @Override
                public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
                    Log.d(TAG, String.format("mode:%d,code:%d,info:%s,handlePatchVersion:%d", mode, code, info, handlePatchVersion));
                }
            }).initialize();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
