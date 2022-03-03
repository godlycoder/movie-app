package id.movie.domain.usecase

import id.movie.domain.repository.MovieRepository


/**
 * Created by Muhamad Ribani on 09/02/22.
 */


class GetMoviesUpcomingUseCase(
    private val repository: MovieRepository
) {

    suspend fun execute() = repository.getUpcoming()

}