package `in`.eduforyou.movieappretrofitmvvm.coroutineExample

import retrofit2.http.GET

interface MovieService {

    @GET("/movie/popular")
    suspend fun getPopularMovies(apiKey: String): MovieResponse
}

data class MovieResponse(val results: List<Movie>)