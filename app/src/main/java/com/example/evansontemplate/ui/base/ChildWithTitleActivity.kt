package com.example.evansontemplate.ui.base

import android.view.MenuItem
import androidx.lifecycle.Observer
import com.example.evansontemplate.R
import kotlinx.android.synthetic.main.app_bar_child_title.*

abstract class ChildWithTitleActivity : BaseActivity() {

    fun setupToolbarTitle(titleToolbar: String) {
        setSupportActionBar(toolbar)
        title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        // toolbar.setNavigationIcon(R.drawable.ic_back)
        // TODO: Change Icon Image
        toolbar.setNavigationIcon(R.color.black)
        toolbarTitle.text = titleToolbar
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        item.let {
            when (it.itemId) {
                android.R.id.home -> onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}