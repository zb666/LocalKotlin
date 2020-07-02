package com.coroutine.bod.localkotlin.arouter;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.coroutine.bod.localkotlin.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

import static com.coroutine.bod.localkotlin.CommonKt.IMAGE_URL;

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

        Glide.with(this).load(IMAGE_URL)
                .thumbnail(0.2f)
                .into((ImageView) findViewById(R.id.iv_load));



    }

    void testAtomic(){
        AtomicReference atomicReference = new AtomicReference();
//        atomicReference.compareAndSet()
        //对于多个值的更新操作
        int[] array = {1,2,3};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);

    }
}
