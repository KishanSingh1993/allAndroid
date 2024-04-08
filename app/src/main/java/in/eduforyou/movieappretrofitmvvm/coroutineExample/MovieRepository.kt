package `in`.eduforyou.movieappretrofitmvvm.coroutineExample

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val service: MovieService) {

    suspend fun getPopularMovies(apiKey: String): List<Movie> {
        val response = withContext(Dispatchers.IO) {
            service.getPopularMovies(apiKey)
        }
        return response.results
    }
}