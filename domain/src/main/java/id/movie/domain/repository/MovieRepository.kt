package id.movie.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import id.movie.common.resources.Resource
import id.movie.data.model.Movie


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


interface MovieRepository {

    suspend fun getNowPlaying(): LiveData<PagingData<Movie>>

    suspend fun getUpcoming(): LiveData<PagingData<Movie>>

    suspend fun getPopular(): LiveData<PagingData<Movie>>

    suspend fun search(query: String) : LiveData<PagingData<Movie>>

}