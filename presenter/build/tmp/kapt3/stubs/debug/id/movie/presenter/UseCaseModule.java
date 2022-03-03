package id.movie.presenter;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import id.movie.domain.repository.MovieRepository;
import id.movie.domain.usecase.GetMoviesPlayNowUseCase;
import id.movie.domain.usecase.GetMoviesPopularUseCase;
import id.movie.domain.usecase.GetMoviesUpcomingUseCase;
import id.movie.domain.usecase.SearchMoviesUseCase;

/**
 * Created by Muhamad Ribani on 09/02/22.
 */
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\r"}, d2 = {"Lid/movie/presenter/UseCaseModule;", "", "()V", "providesGetMoviesPlayNowUseCase", "Lid/movie/domain/usecase/GetMoviesPlayNowUseCase;", "repository", "Lid/movie/domain/repository/MovieRepository;", "providesGetMoviesPopularUseCase", "Lid/movie/domain/usecase/GetMoviesPopularUseCase;", "providesGetMoviesUpcomingUseCase", "Lid/movie/domain/usecase/GetMoviesUpcomingUseCase;", "providesSearchMoviesUseCase", "Lid/movie/domain/usecase/SearchMoviesUseCase;", "presenter_debug"})
@dagger.Module()
public final class UseCaseModule {
    
    public UseCaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final id.movie.domain.usecase.GetMoviesPlayNowUseCase providesGetMoviesPlayNowUseCase(@org.jetbrains.annotations.NotNull()
    id.movie.domain.repository.MovieRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final id.movie.domain.usecase.GetMoviesUpcomingUseCase providesGetMoviesUpcomingUseCase(@org.jetbrains.annotations.NotNull()
    id.movie.domain.repository.MovieRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final id.movie.domain.usecase.GetMoviesPopularUseCase providesGetMoviesPopularUseCase(@org.jetbrains.annotations.NotNull()
    id.movie.domain.repository.MovieRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final id.movie.domain.usecase.SearchMoviesUseCase providesSearchMoviesUseCase(@org.jetbrains.annotations.NotNull()
    id.movie.domain.repository.MovieRepository repository) {
        return null;
    }
}