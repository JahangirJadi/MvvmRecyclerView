package com.marfarijj.mvvmrecyclerlist.data.network

import com.marfarijj.mvvmrecyclerlist.util.AppConstants
import com.marfarijj.mvvmrecyclerlist.data.models.Movie
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {

    @GET("MoviesList")
    suspend fun getMovies(): Response<List<Movie>>


    companion object {
        operator fun invoke(): MoviesApi {

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()


            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppConstants.baseUrl)
                .client(okHttpClient)
                .build()
                .create(MoviesApi::class.java)
        }
    }
}