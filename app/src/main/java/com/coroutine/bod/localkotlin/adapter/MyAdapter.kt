package com.coroutine.bod.localkotlin.adapter

import android.widget.SeekBar
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.coroutine.bod.localkotlin.R
import timber.log.Timber

/**
 *
 * @ClassName: MyAdapter
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-09-28
 */
class MyAdapter:BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_one){

    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper?.itemView?.findViewById<SeekBar>(R.id.seekBarOne)
        ?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                helper.itemView.findViewById<SeekBar>(R.id.seekBarTwo).progress = progress
                Timber.d("Seekbar: OnChange:$progress")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Timber.d("Seekbar: StartTracking")

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Timber.d("Seekbar: StopTracking")

            }

        })
    }
}