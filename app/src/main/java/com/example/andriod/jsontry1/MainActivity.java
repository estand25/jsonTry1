package com.example.andriod.jsontry1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String api_key = "You're Own Movie DB API Key";
    private Integer id_video;
    private Integer id_review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TheMovieDBAPIService service = retrofit.create(TheMovieDBAPIService.class);
        Call<Genres> jsonArrayCall = service.readGenresArray(api_key);
        jsonArrayCall.enqueue(new Callback<Genres>() {
            @Override
            public void onResponse(Call<Genres> call, Response<Genres> response) {
                List<Genre> genreArray = response.body().getGenres();

                for(Genre genre : genreArray){
                    Log.v("OnResponse - Genres",genre.getId()+" "+genre.getName());
                }

                Genres genreList = new Genres();
                genreList.setGenres(genreArray);
            }

            @Override
            public void onFailure(Call<Genres> call, Throwable t) {
                Log.e("onFailure", t.toString());
            }
        });

        Call<MovieColl> jsonPopularMovie = service.readPopularMovie(api_key);
        jsonPopularMovie.enqueue(new Callback<MovieColl>() {
            @Override
            public void onResponse(Call<MovieColl> call, Response<MovieColl> response) {
                List<Movie> popularMovie = response.body().getMovies();

                for(Movie movie : popularMovie){
                    Log.v("OnResponse - PM ",movie.getTitle()+" "+movie.getId());
                    id_video = movie.getId();
                    id_review = movie.getId();
                }
            }

            @Override
            public void onFailure(Call<MovieColl> call, Throwable t) {
                Log.e("onFailure", t.toString());
            }
        });

        Call<MovieColl> jsonTopRateMovie = service.readTopRateMovie(api_key);
        jsonTopRateMovie.enqueue(new Callback<MovieColl>() {
            @Override
            public void onResponse(Call<MovieColl> call, Response<MovieColl> response) {
                List<Movie> topRateMovie = response.body().getMovies();

                for(Movie movie: topRateMovie){
                    Log.v("OnResponse - TP ",movie.getTitle()+" "+movie.getId());
                }
            }

            @Override
            public void onFailure(Call<MovieColl> call, Throwable t) {
                Log.e("onFailure", t.toString());
            }
        });

        id_video = 99861;
        Call<TrailerColl> jsonMovieTrailer = service.getMovieTrailer(id_video,api_key);
        jsonMovieTrailer.enqueue(new Callback<TrailerColl>() {
            @Override
            public void onResponse(Call<TrailerColl> call, Response<TrailerColl> response) {
                List<Trailer> movieTrailers = response.body().getTrailers();

                for(Trailer trailer: movieTrailers){
                    Log.v("OnResponse - Trailer ",trailer.getSite()+" "+trailer.getName());
                }
            }

            @Override
            public void onFailure(Call<TrailerColl> call, Throwable t) {
                Log.e("onFailure", t.toString());
            }
        });

        id_review = 99861;
        Call<ReviewColl> jsonMovieReview = service.getMovieReview(id_review,api_key);
        jsonMovieReview.enqueue(new Callback<ReviewColl>() {
            @Override
            public void onResponse(Call<ReviewColl> call, Response<ReviewColl> response) {
                List<Review> movieReviews = response.body().getReviews();

                for(Review review : movieReviews){
                    Log.v("OnResponse - Review",review.getId()+" "+review.getAuthor());
                }
            }

            @Override
            public void onFailure(Call<ReviewColl> call, Throwable t) {
                Log.e("onFailure", t.toString());
            }
        });
    }
}
