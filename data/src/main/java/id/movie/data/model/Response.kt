package id.movie.data.model


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


data class Response<T>(
    val results: List<T>,
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
)