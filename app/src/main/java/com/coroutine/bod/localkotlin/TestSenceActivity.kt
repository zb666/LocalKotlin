package com.coroutine.bod.localkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.ToastUtils
import com.coroutine.bod.localkotlin.db.AppDataBase
import com.coroutine.bod.localkotlin.db.User
import com.coroutine.bod.localkotlin.db.UserAppViewModel
import com.coroutine.bod.localkotlin.db.UserRepository
import kotlinx.android.synthetic.main.activity_testsence.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 *
 * @ClassName: TestSenceActivity
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-11-29
 */
class TestSenceActivity:AppCompatActivity() {

    private val userAppViewModel by lazy {
        ViewModelProvider(this).get(UserAppViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testsence)


//        Glide.with(this).load("")
//            .error(R.drawable.asia)
//            .into(iv_error)

//        iv_error.setImageResource(R.drawable.focus_earth)

        iv_error.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
            val userDao = AppDataBase.getDataBase(this@TestSenceActivity.applicationContext).userBean()
            val repository = UserRepository(userDao)
                repository.insert(User(name = "Bob",sex = "man"))
                val allUser = repository.allUser
                val size = allUser.size
                launch(Dispatchers.Main) {
                    ToastUtils.showLong("$size ${allUser.get(0).name}")
                }

            }
//           GlobalScope.launch {
//               val selectAll = userAppViewModel.selectAll()
//                selectAll.observe(this@TestSenceActivity, Observer {
//                    it.map {
//                        print(it)
//                    }
//                })
//               userAppViewModel.insert(User(name = "Bob",sex = "man"))
//               userAppViewModel.insert(User(name = "Bob2",sex = "woman"))
//
//           }
        }

    }
}