package com.coroutine.bod.localkotlin.test

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.AssetManager
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coroutine.bod.localkotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_testb_fm.*
import test.BackFmActivity

/**
 *
 * @ClassName: TestAFmActivity
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-11-03
 */
class TestBFmActivity:AppCompatActivity() {

    val pkm:PackageManager
    get() = application.packageManager

    val mDefault:ComponentName
    get() = componentName

    var component:ComponentName? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testb_fm)

//        loadApkRes()
        //com.coroutine.bod.localkotlin.test

        loadIcon()
        changeIcon11()
    }

    private fun loadIcon(){
        component = ComponentName(baseContext, "com.coroutine.bod.localkotlin.Test11")
    }

    private fun changeIcon11(){

        pkm.setComponentEnabledSetting(mDefault,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP)

        component?.run {
            pkm.setComponentEnabledSetting(this,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP)
        }

    }


    private fun loadApkRes() {
        val resources = loadApkResources()
        val color =
            resources.getColor(resources.getIdentifier("night_color", "color", "com.tzx.skin"))

        //获取到插件中的资源
        val drawable =
            resources.getDrawable(resources.getIdentifier("night_color", "color", "com.tzx.skin"))

        iv_res_load.setImageDrawable(drawable)

    }

    internal fun loadApkResources(): Resources {
        val apkPath = "xxx.apk"
        var assetManager: AssetManager? = null
        try {
            assetManager = AssetManager::class.java.newInstance()
            AssetManager::class.java.getDeclaredMethod("addAssetPath", String::class.java)
                .invoke(assetManager, apkPath)
            //加载到了外部的资源
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return Resources(
            assetManager,
            getResources().getDisplayMetrics(),
            getResources().getConfiguration()
        )
    }
}