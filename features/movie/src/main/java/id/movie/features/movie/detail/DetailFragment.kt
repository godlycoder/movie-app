package id.movie.features.movie.detail

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import id.movie.common.core.BaseFragment
import id.movie.data.model.Movie
import id.movie.features.movie.databinding.FragmentDetailBinding


/**
 * Created by Muhamad Ribani on 10/02/22.
 */


@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    @SuppressLint("SetTextI18n")
    override fun FragmentDetailBinding.initialBinding() {
        val bundle = arguments?.getString("movie")
        val item = Gson().fromJson(bundle, Movie::class.java)

        if (item != null) {
            Glide.with(root.context)
                .load("https://image.tmdb.org/t/p/w500${item.poster_path}")
                .into(ivMovies)

            tvTitle.text = item.title
            tvRating.text = "${item.vote_average}/ 10"
            tvDesc.text = item.overview
        }
    }
}