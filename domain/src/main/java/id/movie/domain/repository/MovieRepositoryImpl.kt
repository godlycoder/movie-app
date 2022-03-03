package id.movie.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import id.movie.data.model.Movie
import id.movie.data.repository.MovieRemoteDataSource
import id.movie.domain.CustomPagingSource


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


class MovieRepositoryImpl(
    private val remoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    override suspend fun getNowPlaying(): LiveData<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = true, pageSize = CustomPagingSource.PAGE_SIZE),
            pagingSourceFactory = {
                object : CustomPagingSource<Movie>() {
                    override suspend fun creteLoader(page: Int): Loader<Movie> {
                        val data = remoteDataSource.getNowPlaying(page)
                        return Loader(
                            data.results,
                            if (data.total_pages >= page) page + 1 else null
                        )
                    }
                }
            }
        ).liveData
    }

    override suspend fun getUpcoming(): LiveData<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = true, pageSize = CustomPagingSource.PAGE_SIZE),
            pagingSourceFactory = {
                object : CustomPagingSource<Movie>() {
                    override suspend fun creteLoader(page: Int): Loader<Movie> {
                        val data = remoteDataSource.getUpcoming(page)
                        return Loader(
                            data.results,
                            if (data.total_pages >= page) page + 1 else null
                        )
                    }
                }
            }
        ).liveData
    }

    override suspend fun getPopular(): LiveData<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = true, pageSize = CustomPagingSource.PAGE_SIZE),
            pagingSourceFactory = {
                object : CustomPagingSource<Movie>() {
                    override suspend fun creteLoader(page: Int): Loader<Movie> {
                        val data = remoteDataSource.getPopular(page)
                        return Loader(
                            data.results,
                            if (data.total_pages >= page) page + 1 else null
                        )
                    }
                }
            }
        ).liveData
    }


    override suspend fun search(query: String): LiveData<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = true, pageSize = CustomPagingSource.PAGE_SIZE),
            pagingSourceFactory = {
                object : CustomPagingSource<Movie>() {
                    override suspend fun creteLoader(page: Int): Loader<Movie> {
                        val data = if (query.isNotBlank())  {
                            remoteDataSource.search(page, query)
                        } else {
                            null
                        }
                        return Loader(
                            data?.results ?: listOf(),
                            if (data != null && data.total_pages >= page) page + 1 else null
                        )
                    }
                }
            }
        ).liveData
    }
}