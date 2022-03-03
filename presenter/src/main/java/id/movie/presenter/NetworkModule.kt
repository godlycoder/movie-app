package id.movie.presenter

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.movie.common.network.okHttpClient
import id.movie.common.network.retrofitClient
import okhttp3.OkHttpClient
import id.movie.data.BuildConfig
import id.movie.data.services.MovieService


/**
 * Created by Muhamad Ribani on 09/02/22.
 */

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesOkHttp() : OkHttpClient {
        val client = okHttpClient(BuildConfig.DEBUG)
        return client.build()
    }

    @Provides
    fun providesMoviesServices(okHttpClient: OkHttpClient) : MovieService {
        val client = retrofitClient(okHttpClient, BuildConfig.MOVIE_URL)
        return client.create(MovieService::class.java)
    }

}