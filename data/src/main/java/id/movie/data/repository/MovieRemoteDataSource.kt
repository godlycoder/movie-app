package id.movie.data.repository

import id.movie.data.model.Movie
import id.movie.data.model.Response


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


interface MovieRemoteDataSource {

    suspend fun getNowPlaying(page: Int) : Response<Movie>

    suspend fun getUpcoming(page: Int) : Response<Movie>

    suspend fun getPopular(page: Int) : Response<Movie>

    suspend fun search(page: Int, query: String) : Response<Movie>

}