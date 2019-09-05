package com.zach.flicky.domain.core

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext



/**
 * Created by Salman Zach on 2/1/19.
 * Email - zach.salmansaifi@gmail.com
 */

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity(), CoroutineScope {



    //create coroutine scope on main thread
    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    override fun onCreate(savedInstanceState: Bundle?) {
        onPreCreated()
        super.onCreate(savedInstanceState)
        job = Job()
        val binding: ViewDataBinding = DataBindingUtil.setContentView(this, layoutResId)
        setSupportActionBar(getToolBar(binding as B))
        onActivityReady(savedInstanceState, binding)
    }


    protected open fun onPreCreated() {}

    protected abstract fun onActivityReady(instance: Bundle?, binding: B)

    @get:LayoutRes
    protected abstract val layoutResId: Int


    protected abstract fun getToolBar(binding: B): Toolbar?

    fun enableBack() {
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayShowTitleEnabled(false)
        }


    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }


}