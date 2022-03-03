package id.movie.presenter

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.movie.domain.repository.MovieRepository
import id.movie.domain.usecase.GetMoviesPlayNowUseCase
import id.movie.domain.usecase.GetMoviesPopularUseCase
import id.movie.domain.usecase.GetMoviesUpcomingUseCase
import id.movie.domain.usecase.SearchMoviesUseCase


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun providesGetMoviesPlayNowUseCase(
        repository: MovieRepository
    ) : GetMoviesPlayNowUseCase {
        return GetMoviesPlayNowUseCase(repository)
    }

    @Provides
    fun providesGetMoviesUpcomingUseCase(
        repository: MovieRepository
    ) : GetMoviesUpcomingUseCase {
        return GetMoviesUpcomingUseCase(repository)
    }

    @Provides
    fun providesGetMoviesPopularUseCase(
        repository: MovieRepository
    ) : GetMoviesPopularUseCase {
        return GetMoviesPopularUseCase(repository)
    }

    @Provides
    fun providesSearchMoviesUseCase(
        repository: MovieRepository
    ) : SearchMoviesUseCase {
        return SearchMoviesUseCase(repository)
    }

}