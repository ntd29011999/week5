package com.example.android.firstweekchallenge.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.example.android.firstweekchallenge.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // hiring title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        // full screen activity
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
        // 5 seconds splash
        Handler().postDelayed({
            // start onboard one activity
            startActivity(Intent(this@SplashActivity, TestFramentActivity::class.java))
            finish()

        }, 5000)


    }
}