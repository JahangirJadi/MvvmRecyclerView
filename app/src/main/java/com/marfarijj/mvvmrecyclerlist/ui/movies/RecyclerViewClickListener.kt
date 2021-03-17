package com.marfarijj.mvvmrecyclerlist.ui.movies

import android.view.View
import com.marfarijj.mvvmrecyclerlist.data.models.Movie

interface RecyclerViewClickListener {

    fun onRecyclerViewClick(view: View, movie:Movie)
}