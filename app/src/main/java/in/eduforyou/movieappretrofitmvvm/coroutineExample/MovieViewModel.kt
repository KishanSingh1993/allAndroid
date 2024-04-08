package `in`.eduforyou.movieappretrofitmvvm.coroutineExample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    fun getPopularMovies(apiKey: String) {
        viewModelScope.launch {
            val movies = repository.getPopularMovies(apiKey)
            _movies.postValue(movies)
        }
    }
}