package id.movie.features.movie.upcoming

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.movie.domain.usecase.GetMoviesUpcomingUseCase
import javax.inject.Inject


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


@HiltViewModel
class UpcomingViewModel @Inject constructor(
    private val getMoviesUpcomingUseCase: GetMoviesUpcomingUseCase
) : ViewModel() {

    suspend fun getMoviesUpcoming() = getMoviesUpcomingUseCase.execute()
}