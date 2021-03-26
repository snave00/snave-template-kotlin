package com.example.evansontemplate.ui.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.evansontemplate.R
import org.koin.core.KoinComponent

abstract class BaseActivity : DialogFragmentHandler(), KoinComponent {

    fun fixFont() {
        val configuration = resources.configuration
        configuration.fontScale = 1.toFloat()
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        metrics.scaledDensity = configuration.fontScale * metrics.density
        baseContext.resources.updateConfiguration(configuration, metrics)
    }

    fun animateRecyclerView(recyclerView: RecyclerView) {
        val context = recyclerView.context
        val layoutAnimationController =
            AnimationUtils.loadLayoutAnimation(context, R.anim.layout_scale)
        recyclerView.layoutAnimation = layoutAnimationController
        recyclerView.scheduleLayoutAnimation()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        val newOverride = Configuration(newBase?.resources?.configuration)
        newOverride.fontScale = 1.0f
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            applyOverrideConfiguration(newOverride)
        }
    }

    /** BaseActivity V2 start **/
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e(mTAG, "${javaClass.simpleName} onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        Log.e(mTAG, "${javaClass.simpleName} onDestroy")
        super.onDestroy()
    }

    override fun onResume() {
        Log.e(mTAG, "${javaClass.simpleName} onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e(mTAG, "${javaClass.simpleName} onPause")
        super.onPause()
    }

    // Prevent DialogFragment to crash during onPause state of an activity
    @SuppressLint("MissingSuperCall")
    override fun onSaveInstanceState(outState: Bundle) {
    }

}