package test

import android.os.Bundle
import android.view.View
import com.coroutine.bod.localkotlin.R
import com.coroutine.bod.localkotlin.test.BaseFragment
import kotlinx.android.synthetic.main.fm_two.*


/**
 *
 * @ClassName: FmOne
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-09-26
 */
class FmTwo : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fm_two
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTwo.setOnClickListener {
                        onBackPressedSupport()
//            popTo(FmTwo::class.java, true)
        }
    }


}