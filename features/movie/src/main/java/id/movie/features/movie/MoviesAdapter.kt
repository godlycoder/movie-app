package id.movie.features.movie

import android.annotation.SuppressLint
import android.net.Uri
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.google.gson.Gson
import id.movie.common.core.BasePagingDataAdapter
import id.movie.common.resources.databinding.ItemMoviesBinding
import id.movie.data.model.Movie


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


class MoviesAdapter : BasePagingDataAdapter<Movie, ItemMoviesBinding>(
    object : CustomDiffUtil<Movie>() {
        override fun doCompareContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

    }
) {

    @SuppressLint("SetTextI18n")
    override fun ItemMoviesBinding.bind(item: Movie, position: Int) {
        Glide.with(root.context)
            .load("https://image.tmdb.org/t/p/w500${item.poster_path}")
            .into(ivMovies)

        tvTitle.text = item.title
        tvRating.text = "${item.vote_average}/ 10"

        root.setOnClickListener {
            val data = Gson().toJson(item)
            val uri = Uri.parse("movie://detail/${data}")
            it.findNavController().navigate(uri)
        }
    }
}