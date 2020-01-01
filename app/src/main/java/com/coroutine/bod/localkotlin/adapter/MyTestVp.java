package com.coroutine.bod.localkotlin.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.coroutine.bod.localkotlin.TestFM;

/**
 * @ClassName: MyTestVp
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-11-19
 */
public class MyTestVp extends FragmentPagerAdapter {

    public MyTestVp(@NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new TestFM();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
