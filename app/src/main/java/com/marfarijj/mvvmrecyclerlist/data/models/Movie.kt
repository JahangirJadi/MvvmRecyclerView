package com.marfarijj.mvvmrecyclerlist.data.models

data class Movie(
    val id: Int,
    val image: String,
    val is_new: Int,
    val language: String,
    val like_percent: Int ?= 0,
    val rating: String,
    val title: String,
    val type: String,
    val vote_count: Int?=0
)