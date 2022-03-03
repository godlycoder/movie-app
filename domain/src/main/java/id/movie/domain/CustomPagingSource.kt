package id.movie.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import java.io.IOException


/**
 * Created by Muhamad Ribani on 11/10/21.
 */


abstract class CustomPagingSource<T : Any> : PagingSource<Int, T>() {


    companion object {
        const val STARTING_PAGE_INDEX = 1
        const val PAGE_SIZE = 10
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val page = params.key ?: STARTING_PAGE_INDEX

        return try {
            val loader = creteLoader(page)
            LoadResult.Page(
                data = loader.data,
                prevKey = if (page == 1) null else page - 1,
                nextKey = loader.nextKey
            )
        } catch (exception: IOException) {
            val error = IOException("Please Check Internet Connection")
            LoadResult.Error(error)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition
    }

    abstract suspend fun creteLoader(page: Int) : Loader<T>

    data class Loader<T>(
        val data: List<T>,
        val nextKey: Int?
    )
}