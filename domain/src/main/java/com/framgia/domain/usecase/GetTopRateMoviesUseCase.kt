package com.framgia.domain.usecase

import com.framgia.domain.base.UseCase
import com.framgia.domain.model.Movie
import com.framgia.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created: 02/08/2018
 * By: Sang
 * Description:
 */
class GetTopRateMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : UseCase<GetTopRateMoviesUseCase.Params, Single<List<Movie>>>() {

    override fun createObservable(params: Params): Single<List<Movie>> =
        movieRepository.getTopRateMovies(params.page)

    override fun onCleared() {
        // No-op
    }

    data class Params(val page: Int)
}
