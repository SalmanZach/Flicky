package com.zach.flicky.utility

import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Salman Zach on 5/8/19.
 * Email - zach.salmansaifi@gmail.com
 */

object Utility {

    fun getFormattedDate(date: String): String {
        return try {
            val dateOnly = date.substringBefore("T")
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            val date = formatter.parse(dateOnly)
            val newFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
            newFormat.format(date)
        } catch (e: Exception) {
            ""
        }
    }


   private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    fun showMessageIfNoNetwork(container:View){
        if (!isNetworkAvailable(container.context)) {
            Snackbar.make(container, "Please check your network", Snackbar.LENGTH_SHORT)
                .show()
        }
    }
}