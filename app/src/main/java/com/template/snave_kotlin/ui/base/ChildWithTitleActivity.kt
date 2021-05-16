package com.template.snave_kotlin.ui.base

import android.view.MenuItem
import com.template.snave_kotlin.R
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