package com.example.andriod.jsontry1;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by StandleyEugene on 7/5/2016.
 */
public interface GenreAPIService {
    @GET("movie/popular?api_key=d2919c2333e0f291ccf58c5e5ec88543") //THE_MOVIE_API_KEY - Is your key ;)
    Call<JSONArray> readJsonArray();
}
