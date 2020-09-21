package com.hfrad.kotlinlesson.ui.splash

import android.os.Handler
import androidx.lifecycle.ViewModelProvider

import com.hfrad.kotlinlesson.ui.base.BaseActivity
import com.hfrad.kotlinlesson.ui.main.MainActivity
import com.hfrad.kotlinlesson.ui.main.MainViewModel

private const val START_DELAY = 1000L

class SplashActivity : BaseActivity<Boolean?, SplashViewState>() {

    override val viewModel: SplashViewModel by lazy {
        ViewModelProvider(this).get(SplashViewModel::class.java)

    }

    override val layoutRes: Int = com.hfrad.kotlinlesson.R.layout.activity_splash

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({ viewModel.requestUser() }, START_DELAY)
    }

    override fun renderData(data: Boolean?) {
        data?.takeIf{ it }?.let {
            startMainActivity()
        }
    }


    private fun startMainActivity() {
        startActivity(MainActivity.getStartIntent(this))
        finish()
    }
}