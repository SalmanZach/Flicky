package com.zach.flicky.domain.core


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zach.flicky.BR


/**
 * Created by Salman Zach on 2/1/19.
 * Email - zach.salmansaifi@gmail.com
 */
abstract class BaseRecyclerAdapter<T>(diffItemCallback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BaseRecyclerAdapter.BaseViewHolder<T>>(diffItemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return BaseViewHolder(binding)
    }


    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) = holder.bind(getItem(position))


    class BaseViewHolder<T>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: T) {
            binding.setVariable(BR.model, item)
            binding.executePendingBindings()
        }
    }
}