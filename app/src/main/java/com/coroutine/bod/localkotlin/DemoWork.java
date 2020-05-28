//package com.coroutine.bod.localkotlin;
//
//import android.content.Context;
//
//import androidx.annotation.MainThread;
//import androidx.annotation.NonNull;
//import androidx.annotation.WorkerThread;
//import androidx.work.WorkManager;
//import androidx.work.Worker;
//import androidx.work.WorkerParameters;
//
///**
// * @ClassName: DemoWork
// * @Description:
// * @Author: zb666
// * @CreateDate: 2020-04-09
// */
//public class DemoWork extends Worker {
//
//    public DemoWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
//        super(context, workerParams);
//    }
//
//    @NonNull
//    @Override
//    public Result doWork() {
//        myCompress();
//        //return value
//        return Worker.Result.success();
//    }
//
//    @WorkerThread
//    private void myCompress() {
//
//    }
//
//}
