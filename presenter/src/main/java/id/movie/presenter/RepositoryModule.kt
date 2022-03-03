package id.movie.presenter

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.movie.data.repository.MovieRemoteDataSource
import id.movie.data.repository.MovieRemoteDataSourceImpl
import id.movie.domain.repository.MovieRepository
import id.movie.domain.repository.MovieRepositoryImpl


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesMovieRepository(
        remoteDataSource: MovieRemoteDataSource
    ) : MovieRepository {
        return MovieRepositoryImpl(remoteDataSource)
    }
}