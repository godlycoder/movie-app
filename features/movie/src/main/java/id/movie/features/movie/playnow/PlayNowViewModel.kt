package id.movie.features.movie.playnow

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.movie.domain.usecase.GetMoviesPlayNowUseCase
import javax.inject.Inject


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


@HiltViewModel
class PlayNowViewModel @Inject constructor(
    private val getMoviesPlayNowUseCase: GetMoviesPlayNowUseCase
) : ViewModel() {

    suspend fun getMoviesPlayNow() = getMoviesPlayNowUseCase.execute()

}