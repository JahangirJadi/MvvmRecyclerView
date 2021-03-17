package com.marfarijj.mvvmrecyclerlist.data.repositories

import com.marfarijj.mvvmrecyclerlist.data.network.MoviesApi

class MoviesRepository(private val api: MoviesApi) :
    SafeApiRequest() {
    suspend fun getMovies() = apiRequest { api.getMovies() }
}