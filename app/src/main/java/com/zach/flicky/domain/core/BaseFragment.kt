package com.zach.flicky.domain.core


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext



/**
 * Created by Salman Zach on 2/1/19.
 * Email - zach.salmansaifi@gmail.com
 */
abstract class BaseFragment<B : ViewDataBinding> : Fragment(), CoroutineScope {

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()

    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: ViewDataBinding =
            DataBindingUtil.inflate(LayoutInflater.from(container?.context), layoutResId, container, false)
        onFragmentReady(savedInstanceState, rootView as B)
        return rootView.root

    }

    @get:LayoutRes
    protected abstract val layoutResId: Int

    protected abstract fun onFragmentReady(instanceState: Bundle?, binding: B)


    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}