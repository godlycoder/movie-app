package id.movie.presenter

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.movie.data.repository.MovieRemoteDataSource
import id.movie.data.repository.MovieRemoteDataSourceImpl
import id.movie.data.services.MovieService


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    fun providesMovieRemoteDataSource(services: MovieService) : MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(services)
    }

}