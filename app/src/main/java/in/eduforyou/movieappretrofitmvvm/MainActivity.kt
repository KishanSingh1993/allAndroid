package `in`.eduforyou.movieappretrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import `in`.eduforyou.movieappretrofitmvvm.databinding.ActivityMainBinding
import `in`.eduforyou.movieappretrofitmvvm.retrofitExample.MovieAdapter
import `in`.eduforyou.movieappretrofitmvvm.retrofitExample.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter : MovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
            movieAdapter.setMovieList(movieList)
        })
    }

    private fun prepareRecyclerView() {
        movieAdapter = MovieAdapter()
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(applicationContext,2)
            adapter = movieAdapter
        }
    }


    private fun getMovieFromCoroutineFolder(){
//        private lateinit var viewModel: MovieViewModel
//        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
//
//        viewModel.getPopularMovies("YOUR_API_KEY") // Replace with your TMDB API Key
//        viewModel.movies.observe(this, { movies ->
//            // Update UI with movie data
//        })

    }
}