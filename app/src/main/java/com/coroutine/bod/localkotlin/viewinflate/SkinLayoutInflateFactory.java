package com.coroutine.bod.localkotlin.viewinflate;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @ClassName: SkinLayoutInflateFactory
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-07-05
 */
public class SkinLayoutInflateFactory implements LayoutInflater.Factory {

    Context mContext;

    public SkinLayoutInflateFactory(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        //hook Assetmanager->加载SD卡 Path下的资源
        //获取资源Id->替换属性的资源Id
        return null;
    }


}
