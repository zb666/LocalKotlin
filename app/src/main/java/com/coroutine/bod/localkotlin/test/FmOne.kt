package test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.coroutine.bod.localkotlin.R
import com.coroutine.bod.localkotlin.adapter.MyAdapter
import com.coroutine.bod.localkotlin.test.BaseFragment
import kotlinx.android.synthetic.main.fm_one.*
import kotlinx.android.synthetic.main.item_one.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 *
 * @ClassName: FmOne
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-09-26
 */

class FmOne : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(activity).inflate(R.layout.fm_one,container,false)
    }

    var i = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val myAdapter = MyAdapter()
            .apply {
                setOnLoadMoreListener({
                    if (++i<20){
                        Timber.d("LoadMore: $i")
                        GlobalScope.launch(Dispatchers.IO){
                            delay(500)
                            launch(Dispatchers.Main) {
                                addData(listOf("1","2","3","4","5"))
                                if (i==20)loadMoreEnd(true)
                                else{
                                    loadMoreComplete()
                                }
                            }
                        }
                    }
                },rv_one)
            }
        myAdapter.addData(listOf("1","2","3","4","5"))

        rv_one.layoutManager = GridLayoutManager(activity, 2)
        rv_one.adapter = myAdapter




    }

}