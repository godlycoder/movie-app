package id.movie.presenter;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import id.movie.data.repository.MovieRemoteDataSource;
import id.movie.data.repository.MovieRemoteDataSourceImpl;
import id.movie.data.services.MovieService;

/**
 * Created by Muhamad Ribani on 09/02/22.
 */
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lid/movie/presenter/RemoteModule;", "", "()V", "providesMovieRemoteDataSource", "Lid/movie/data/repository/MovieRemoteDataSource;", "services", "Lid/movie/data/services/MovieService;", "presenter_debug"})
@dagger.Module()
public final class RemoteModule {
    
    public RemoteModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final id.movie.data.repository.MovieRemoteDataSource providesMovieRemoteDataSource(@org.jetbrains.annotations.NotNull()
    id.movie.data.services.MovieService services) {
        return null;
    }
}