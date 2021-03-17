package com.marfarijj.mvvmrecyclerlist.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.marfarijj.mvvmrecyclerlist.R
import com.marfarijj.mvvmrecyclerlist.data.models.Movie
import com.marfarijj.mvvmrecyclerlist.databinding.ItemMovieBinding

class MoviesAdapter(
    private val movies: List<Movie>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {


    private lateinit var binding: ItemMovieBinding

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =


        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_movie,
                parent,
                false

            )
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerViewBinding.movie = movies[position]
        holder.recyclerViewBinding.buttonBook.setOnClickListener {
            print("CLicked")

            listener.onRecyclerViewClick(holder.recyclerViewBinding.buttonBook,movies[position])
        }

        holder.recyclerViewBinding.layoutLike.setOnClickListener {
            print("CLicked")

            listener.onRecyclerViewClick(holder.recyclerViewBinding.layoutLike,movies[position])
        }
    }

    inner class MoviesViewHolder(
        val recyclerViewBinding: ItemMovieBinding

    ) : RecyclerView.ViewHolder(recyclerViewBinding.root)

}