package com.zach.flicky.ui.fragment


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.zach.flicky.R
import com.zach.flicky.adapter.HomeFeedAdapter
import com.zach.flicky.databinding.FragmentListBinding
import com.zach.flicky.domain.core.BaseFragment
import com.zach.flicky.utility.Utility
import com.zach.flicky.utility.getViewModel
import com.zach.flicky.viewModel.FeedsViewModel
import kotlinx.coroutines.launch


/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */

const val TAG ="tag"
class ListFragment : BaseFragment<FragmentListBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_list

    private lateinit var viewModel: FeedsViewModel
    private lateinit var mBinding:FragmentListBinding
    private val adapter = HomeFeedAdapter()

    override fun onFragmentReady(instanceState: Bundle?, binding: FragmentListBinding) {
        mBinding = binding
        activity?.let {
            viewModel = it.getViewModel()
        }

        val layoutManager = GridLayoutManager(activity!!,2)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.isNestedScrollingEnabled = false
        binding.recyclerView.isFocusable = false
        binding.recyclerView.adapter = adapter



        arguments?.let {
            val tag = it.getString(TAG)
            tag?.let {tag->
                fillData(tag)
            }
        }

    }

    private fun fillData(tag:String)= launch {

        val feeds = viewModel.getFeedByTagAsync(tag).await()
        feeds.observe(this@ListFragment, Observer {
            if (it == null)return@Observer
            mBinding.progress.visibility = View.GONE
            adapter.submitList(it)

        })
    }


    companion object {
        fun getInstance(tag: String): ListFragment {
            val bundle = Bundle()
            bundle.putString(TAG, tag)
            val fragment = ListFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}
