package com.zach.flicky.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.widget.Toolbar
import com.zach.flicky.R
import com.zach.flicky.databinding.ActivitySplashBinding
import com.zach.flicky.domain.core.BaseActivity

/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override val layoutResId: Int
        get() = R.layout.activity_splash

    override fun getToolBar(binding: ActivitySplashBinding): Toolbar? {
           return null
    }


    override fun onActivityReady(instance: Bundle?, binding: ActivitySplashBinding) {
          Handler().postDelayed({
              startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
              finish()
          },500)

    }


}
