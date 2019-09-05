package com.zach.flicky.ui.activity

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.zach.flicky.R
import com.zach.flicky.databinding.ActivityDetailBinding
import com.zach.flicky.domain.core.BaseActivity
import com.zach.flicky.domain.glide.ImageLoader
import com.zach.flicky.utility.Utility


const val TITLE ="title"
const val IMAGE = "image"
const val DATE ="date"
class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    override val layoutResId: Int
        get() = R.layout.activity_detail

    override fun getToolBar(binding: ActivityDetailBinding): Toolbar? {
          return null
     }

    override fun onActivityReady(instance: Bundle?, binding: ActivityDetailBinding) {
             intent.extras?.let {bundle->
                 val imageUrl = bundle.getString(IMAGE)
                 imageUrl?.let {
                     ImageLoader.loadImage(binding.image,it)
                 }
                 binding.title.text = bundle.getString(TITLE)
                 binding.date.text = Utility.getFormattedDate(bundle.getString(DATE))
                 Utility.showMessageIfNoNetwork(binding.container)

             }

    }

}
