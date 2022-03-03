package id.movie.data.repository

import id.movie.data.model.Movie
import id.movie.data.services.MovieService
import id.movie.data.model.Response


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


class MovieRemoteDataSourceImpl(
    private val service: MovieService
) : MovieRemoteDataSource {

    override suspend fun getNowPlaying(page: Int): Response<Movie> {
        return service.getPlayNow(page)
    }

    override suspend fun getUpcoming(page: Int): Response<Movie> {
        return service.getUpcoming(page)
    }

    override suspend fun getPopular(page: Int): Response<Movie> {
        return service.getPopular(page)
    }

    override suspend fun search(page: Int, query: String): Response<Movie> {
        return service.search(page, query)
    }
}