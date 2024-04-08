package `in`.eduforyou.movieappretrofitmvvm.retrofitExample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("popular?")
    fun getPopularMovies(@Query("api_key") api_key : String) : Call<Movies>

    //657fe2037bf28caca50d9ae8fd75fa5b
}