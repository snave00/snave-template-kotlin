package com.example.evansontemplate.utils

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.evansontemplate.utils.Constants.GLOBAL_TAG
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEventV2<T> : MutableLiveData<T>() {
    private val mTAG = GLOBAL_TAG + javaClass.simpleName

    private val mPending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {

        if (hasActiveObservers()) {
            Log.e(mTAG, "Multiple observers registered but only one will be notified of changes")
        }

        super.observe(owner, {
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(it)
            }
        })
    }

    @MainThread
    override fun setValue(t: T?) {
        mPending.set(true)
        super.setValue(t)
    }

    @MainThread
    fun call() {
        value = null
    }
}