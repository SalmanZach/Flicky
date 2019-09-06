package com.zach.flicky.ui.activity

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.zach.flicky.R
import com.zach.flicky.adapter.TabsAdapter
import com.zach.flicky.databinding.ActivityHomeBinding
import com.zach.flicky.domain.Constants
import com.zach.flicky.domain.ViewModelFactory
import com.zach.flicky.domain.core.BaseActivity
import com.zach.flicky.ui.fragment.ListFragment
import com.zach.flicky.utility.Utility
import com.zach.flicky.viewModel.FeedsViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */
class HomeActivity : BaseActivity<ActivityHomeBinding>(),KodeinAware {

    override val layoutResId: Int
        get() = R.layout.activity_home

    override val kodein by closestKodein()
    private lateinit var viewModel: FeedsViewModel
    private val viewModelFactory: ViewModelFactory by instance()



    override fun onActivityReady(instance: Bundle?, binding: ActivityHomeBinding) {

        // make an instance of viewModel so that child can access
        viewModel = ViewModelProviders.of(this@HomeActivity, viewModelFactory)
            .get(FeedsViewModel::class.java)

        val adapter = TabsAdapter(supportFragmentManager)
        adapter.addFragment(
            ListFragment.getInstance(Constants.TAG_CATS),
            resources.getString(R.string.tab1)
        )
        adapter.addFragment(
            ListFragment.getInstance(Constants.TAG_DOGS),
            resources.getString(R.string.tab2)
        )
        adapter.addFragment(
            ListFragment.getInstance(Constants.TAG_BIRDS),
            resources.getString(R.string.tab3)
        )

        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        Utility.showMessageIfNoNetwork(binding.container)

    }

    override fun getToolBar(binding: ActivityHomeBinding): Toolbar? {
        return null
    }


}
