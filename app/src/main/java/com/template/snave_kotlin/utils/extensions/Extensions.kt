package com.template.snave_kotlin.utils.extensions

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.template.snave_kotlin.R
import com.template.snave_kotlin.utils.Constants.GLOBAL_TAG
import com.template.snave_kotlin.utils.DialogFragmentBundle
import java.io.Serializable

private const val mTAG = GLOBAL_TAG + "Extensions"

// Determine if an object is null
fun Any?.isNull(): Boolean {
    return this == null
}

// Determine if an object is not null
fun Any?.isNotNull(): Boolean {
    return this != null
}

// Prevent rapid clicks
// Default interval 500ms
fun View.setSafeOnClickListener(debounceTime: Long = 500L, action: () -> Unit) {
    setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0
        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) {
                return
            } else {
                action()
            }
            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

// Force dialog fragment to use 'commitAllowingStateLoss' during show event
// Prevent 'java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState'
// Prevent 'java.lang.IllegalStateException: Fragment already added'
private var previousHashCode: Int = 0
fun DialogFragment.safeShow(fragmentManager: FragmentManager, bundle: Bundle.() -> Unit = {}) {
    if (hashCode() == previousHashCode) {
        Log.e(mTAG, "Only 1 instance of that dialog fragment is permitted")
        return
    } else {
        previousHashCode = hashCode()
    }

    arguments = Bundle().apply(bundle)
    fragmentManager.beginTransaction().add(this, hashCode().toString()).commitAllowingStateLoss()
}

// Force dialog fragment to use 'commitAllowingStateLoss' during dismiss event
// Prevent 'java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState'
// Prevent 'java.lang.IllegalStateException: Fragment already added'
fun DialogFragment.safeDismiss(fragmentManager: FragmentManager) {
    previousHashCode = 0
    fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss()
}

// Sending icon with enum as key
fun Bundle.sendIcon(icon: Int) {
    putInt(DialogFragmentBundle.ICON.value, icon)
}

// Sending strings with enum as key
fun Bundle.sendString(key: DialogFragmentBundle, value: String) {
    putString(key.value, value)
}

// Sending cancellable value with enum as key
fun Bundle.sendCancellable(value: Boolean) {
    putBoolean(DialogFragmentBundle.CANCELLABLE.value, value)
}

// Sending unit with enum as key
fun Bundle.sendUnit(key: DialogFragmentBundle, value: () -> Unit) {
    putSerializable(key.value, { value.invoke() } as Serializable)
}

// Receiving icon with enum as key
fun Bundle.receiveIcon(): Int {
    // TODO: Change Icon Image
    return getInt(DialogFragmentBundle.ICON.value, R.color.black)
}

// Receiving strings with enum as key
fun Bundle.receiveString(key: DialogFragmentBundle): String {
    return getString(key.value, "")
}

// Receiving cancellable value with enum as key
fun Bundle.receiveCancellable(): Boolean {
    return getBoolean(DialogFragmentBundle.CANCELLABLE.value, true)
}

// Receiving unit with enum as key
fun Bundle.receiveUnit(key: DialogFragmentBundle): () -> Unit {
    return (getSerializable(key.value) ?: {}) as () -> Unit
}

// Hide view and remove bounds
fun View.gone() {
    visibility = View.GONE
}

// Hide view and maintain bounds
fun View.hide() {
    visibility = View.INVISIBLE
}

// Show view
fun View.show() {
    visibility = View.VISIBLE
}

// Identify if view can be seen
fun View.isVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

// Hide keyboard for all AppCompatActivity views
fun AppCompatActivity.hideKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
}

// Show keyboard for all AppCompatActivity views
fun AppCompatActivity.showKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }
}

// Hide keyboard for all Fragment views
fun Fragment.hideKeyboard() {
    val activity = this.activity
    if (activity is AppCompatActivity) {
        activity.hideKeyboard()
    }
}

// Show keyboard for all Fragment views
fun Fragment.showKeyboard() {
    val activity = this.activity
    if (activity is AppCompatActivity) {
        activity.showKeyboard()
    }
}

// Finish current activity with transition animation
fun Activity.closeActivity() {
    this.finish()
    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
}