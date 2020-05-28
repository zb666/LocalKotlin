package com.coroutine.bod.localkotlin.arouter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.coroutine.bod.localkotlin.R;

/**
 * @ClassName: YourActivity
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-05-28
 */
@Route(path = "/app/activity")
public class YourActivity extends AppCompatActivity {

    @Autowired(name = "Key")
    String value;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your);
        ARouter.getInstance().inject(this);
        HelloService navigation = ARouter.getInstance().navigation(HelloService.class);
        String result = navigation.sayHello("Greet From Bob" + value);

        ToastUtils.showShort(result);
    }
}
