package com.coroutine.bod.localkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.coroutine.bod.localkotlin.adapter.MyAdapter
import kotlinx.android.synthetic.main.test_fm.*

/**
 * @ClassName: TestFM
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-11-19
 */
class TestFM : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.test_fm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_inner.layoutManager = GridLayoutManager(context,3)
        val myAdapter = MyAdapter()
        rv_inner.adapter = myAdapter
        listOf("1","2","3","4","5","6","7","8","9","10").let {
            myAdapter.setNewData(it)
        }

        lifecycle.currentState
    }
}

