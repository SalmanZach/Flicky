package com.zach.flicky.domain.core

import androidx.annotation.LayoutRes

/**
 * Created by Salman Zach on 2/1/19.
 * Email - zach.salmansaifi@gmail.com
 */
interface Binder {
    @get:LayoutRes
    val layoutRes: Int
}