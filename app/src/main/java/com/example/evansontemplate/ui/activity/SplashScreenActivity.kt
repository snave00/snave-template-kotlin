package com.example.evansontemplate.ui.activity

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import com.example.evansontemplate.R
import com.example.evansontemplate.ui.base.BaseActivity
import com.example.evansontemplate.utils.extensions.closeActivity

class SplashScreenActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachUI()
    }

    private fun attachUI() {
        setContentView(R.layout.activity_splash_screen)

        if (!isTaskRoot
            && intent.hasCategory(Intent.CATEGORY_LAUNCHER)
            && intent.action != null
            && intent.action.equals(Intent.ACTION_MAIN)
        ) {
            closeActivity()
            return
        }

        val configuration = resources.configuration
        configuration.fontScale = 1.toFloat()
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        metrics.scaledDensity = configuration.fontScale * metrics.density
        baseContext.resources.updateConfiguration(configuration, metrics)
    }

    private fun getDeviceName(): String {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        return "$manufacturer$model".replace(" ", "")
    }

    private fun getVersion(): String {
        return try {
            val packageInfo: PackageInfo = applicationContext.packageManager.getPackageInfo(applicationContext.packageName, 0)
            packageInfo.versionName.replace("[^0-9.]".toRegex(), "").trim()
        } catch (e: PackageManager.NameNotFoundException) {
            Log.e(mTAG, e.message.toString())
            ""
        }
    }
}