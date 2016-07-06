package com.example.andriod.jsontry1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by StandleyEugene on 7/5/2016.
 */
public interface TheMovieDBAPIService {
    // List of Movie Genre
    @GET("genre/movie/list") //THE_MOVIE_API_KEY - Is your key ;)
    Call<Genres> readGenresArray(
            @Query("api_key") String api_key
    );

    // List of the Popular Movie
    @GET("movie/popular")
    Call<MovieColl> readPopularMovie(
            @Query("api_key") String api_key
    );

    // List of the Top Rate Movies
    @GET("movie/top_rated")
    Call<MovieColl> readTopRateMovie(
            @Query("api_key") String api_key
    );

    // List of Specified movie Trailer
    @GET("movie/{id}/videos")
    Call<TrailerColl> getMovieTrailer(
            @Path("id") Integer id,
            @Query("api_key") String api_key
    );

    // List of Specified movie Reviews

}
