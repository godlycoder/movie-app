package id.movie.features.movie.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.movie.domain.usecase.SearchMoviesUseCase
import javax.inject.Inject


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {

    suspend fun search(query: String) = searchMoviesUseCase.execute(query)

}