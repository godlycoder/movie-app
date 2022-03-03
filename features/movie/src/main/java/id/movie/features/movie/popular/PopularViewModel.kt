package id.movie.features.movie.popular

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.movie.domain.usecase.GetMoviesPopularUseCase
import javax.inject.Inject


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


@HiltViewModel
class PopularViewModel @Inject constructor(
    private val getMoviesPopularUseCase: GetMoviesPopularUseCase
): ViewModel() {

    suspend fun getMoviesPopular() = getMoviesPopularUseCase.execute()

}