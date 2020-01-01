package com.coroutine.bod.localkotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import test.FmOne;

public class OtherActivity extends FocusBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_other, new FmOne())
                .commit();
    }
}
