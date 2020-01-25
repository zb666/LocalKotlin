package com.coroutine.bod.localkotlin

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.text.format.Time
import android.util.SparseArray
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.core.content.ContextCompat
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.TimeUtils
import com.coroutine.bod.localkotlin.handle.BobHandler
import com.coroutine.bod.localkotlin.handle.BobLooper
import com.coroutine.bod.localkotlin.handle.BobMessage
import com.coroutine.bod.localkotlin.view.CircleDrawable
import com.coroutine.bod.localkotlin.viewmodel.HomeViewModel
import io.flutter.facade.Flutter
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_model.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import test.BackFmActivity
import timber.log.Timber
import java.io.File
import java.util.*
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class ModelObsViewActivity : AppCompatActivity(),CoroutineScope by MainScope(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fm_one)
    }


}



