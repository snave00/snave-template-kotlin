package com.template.snave_kotlin.ui.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.template.snave_kotlin.R
import com.template.snave_kotlin.common.LocalStorage
import com.template.snave_kotlin.utils.Constants.GLOBAL_TAG
import com.template.snave_kotlin.utils.KoinQualifier
import com.template.snave_kotlin.utils.NavigationDirection
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

abstract class BaseActivityUtils : AppCompatActivity() {
    val mTAG = GLOBAL_TAG + javaClass.simpleName

    // Detect availability of network connections
    fun isConnectionAvailable(): Boolean {
        val availability by inject<Boolean>(qualifier = named(KoinQualifier.CONNECTION.value))
        return availability
    }

    // Navigate to next desired activity
    inline fun <reified T : Activity> navigate(navigationDirection: NavigationDirection, finishCurrent: Boolean = true, requestCode: Int = -1, configIntent: Intent.() -> Unit = {}) {
        val intent = newIntent<T>(this)
        intent.configIntent()

        LocalStorage.previousActivity = this.javaClass.simpleName

        if (requestCode == -1) {
            startActivity(intent)
        } else {
            startActivityForResult(intent, requestCode, Bundle())
        }

        if (finishCurrent) {
            (this as Activity).finish()
        }

        when (navigationDirection) {
            NavigationDirection.FORWARD -> {
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
            NavigationDirection.BACKWARD -> {
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        }
    }

    // Generate intent
    inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)

    // Get java class simple name
    inline fun <reified T> getClassName(): String {
        return T::class.java.simpleName
    }
}