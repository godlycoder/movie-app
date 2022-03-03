package id.movie.domain.usecase

import id.movie.domain.repository.MovieRepository


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


class GetMoviesPopularUseCase(
    private val repository: MovieRepository
) {

    suspend fun execute() = repository.getPopular()

}