package id.movie.features.movie

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import id.movie.domain.usecase.GetMoviesPlayNowUseCase
import id.movie.domain.usecase.GetMoviesPopularUseCase
import id.movie.domain.usecase.GetMoviesUpcomingUseCase


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


@EntryPoint
@InstallIn(ViewModelComponent::class)
interface MovieModuleDependencies {

    fun getMoviesPlayNowUseCase() : GetMoviesPlayNowUseCase

    fun getMoviesUpcomingUseCase() : GetMoviesUpcomingUseCase

    fun getMoviesPopularUseCase() : GetMoviesPopularUseCase

}