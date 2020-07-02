package com.coroutine.bod.localkotlin.adapter

import android.view.View
import androidx.viewpager.widget.PagerAdapter

/**
 *
 * @ClassName: PageViewAdapter
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-06-18
 */
 class PageViewAdapter(private val list: List<String>?): PagerAdapter() {

    override fun isViewFromObject(view: View, obj: Any) = view == obj

    override fun getCount(): Int {
        return  list?.size?:20
    }

}