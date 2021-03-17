package com.marfarijj.mvvmrecyclerlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marfarijj.mvvmrecyclerlist.R
import com.marfarijj.mvvmrecyclerlist.data.network.MoviesApi
import com.marfarijj.mvvmrecyclerlist.data.repositories.MoviesRepository
import com.marfarijj.mvvmrecyclerlist.util.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    }