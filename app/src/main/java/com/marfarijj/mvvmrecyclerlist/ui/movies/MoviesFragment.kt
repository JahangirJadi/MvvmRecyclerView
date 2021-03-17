package com.marfarijj.mvvmrecyclerlist.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.marfarijj.mvvmrecyclerlist.R
import com.marfarijj.mvvmrecyclerlist.data.models.Movie
import com.marfarijj.mvvmrecyclerlist.data.network.MoviesApi
import com.marfarijj.mvvmrecyclerlist.data.repositories.MoviesRepository
import com.marfarijj.mvvmrecyclerlist.databinding.MoviesFragmentBinding

class MoviesFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel
    private lateinit var binding: MoviesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<MoviesFragmentBinding>(
            LayoutInflater.from(context),
            R.layout.movies_fragment,
            container,
            false

        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MoviesApi()
        val repository =
            MoviesRepository(api)
        factory =
            MoviesViewModelFactory(
                repository
            )
        viewModel = ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java)

        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            binding.recyclerMovies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    MoviesAdapter(movies, this)
            }
        })

    }

    override fun onRecyclerViewClick(view: View, movie: Movie) {
        when (view.id) {

            R.id.button_book -> {
                Toast.makeText(requireContext(), "${movie.title} is booked.", Toast.LENGTH_SHORT)
                    .show()
            }

            R.id.layout_like -> {
                Toast.makeText(requireContext(), "You liked the ${movie.title}", Toast.LENGTH_SHORT)
                    .show()

            }

        }
    }
}

