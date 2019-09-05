package com.zach.flicky.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zach.flicky.domain.repository.FlickerRepository
import com.zach.flicky.viewModel.FeedsViewModel


/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */

class ViewModelFactory(private val repository: FlickerRepository):
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(FeedsViewModel::class.java) ->
                    FeedsViewModel(repository)
                else ->
                    error("Invalid View Model class")
            }
        } as T
}