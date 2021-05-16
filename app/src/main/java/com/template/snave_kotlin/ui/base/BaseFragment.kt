package com.template.snave_kotlin.ui.base

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.template.snave_kotlin.utils.Constants.GLOBAL_TAG

abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(GLOBAL_TAG, "${javaClass.simpleName} onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Log.d(GLOBAL_TAG, "${javaClass.simpleName} onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(GLOBAL_TAG, "${javaClass.simpleName} onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(GLOBAL_TAG, "${javaClass.simpleName} onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d(GLOBAL_TAG, "${javaClass.simpleName} onDestroy")
        super.onDestroy()
    }

}