package id.movie.data.services

import id.movie.data.BuildConfig
import id.movie.data.model.Movie
import id.movie.data.model.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


interface MovieService {

    @GET("movie/now_playing?api_key=${BuildConfig.MOVIE_API_KEY}")
    suspend fun getPlayNow(
        @Query("page")
        page: Int
    ) : Response<Movie>

    @GET("movie/popular?api_key=${BuildConfig.MOVIE_API_KEY}")
    suspend fun getPopular(
        @Query("page")
        page: Int
    ) : Response<Movie>

    @GET("movie/upcoming?api_key=${BuildConfig.MOVIE_API_KEY}")
    suspend fun getUpcoming(
        @Query("page")
        page: Int
    ) : Response<Movie>

    @GET("search/movie?api_key=${BuildConfig.MOVIE_API_KEY}")
    suspend fun search(
        @Query("page")
        page: Int,
        @Query("query")
        query: String
    ) : Response<Movie>

}