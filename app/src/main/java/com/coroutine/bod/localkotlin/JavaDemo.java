package com.coroutine.bod.localkotlin;

import android.view.View;

import androidx.core.view.ViewKt;

import com.blankj.utilcode.util.ViewUtils;

import java.util.concurrent.locks.Lock;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/**
 * @ClassName: JavaDemo
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-06-07
 */
public class JavaDemo {

    synchronized void test(){

    }

    void insert(){
        synchronized (JavaDemo.class){

        }
    }

    public static void main(String[] args){
        //静态方法用Utils的形势调用
        int length = StringUtilsKt.customLength(new StringUtil());

        View view = null;

        ViewUtilsKt.limitClick(view, new Function0<Unit>() {
            @Override
            public Unit invoke() {
                return null;
            }
        });

        ViewUtilsKt.registerLifeCycle(view);

    }
}
