package com.example.andriod.jsontry1;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by StandleyEugene on 7/5/2016.
 */
public interface GenreAPIService {
    @GET("genre/movie/list?api_key=THE_MOVIE_API_KEY") //THE_MOVIE_API_KEY - Is your key ;)
    Call<JSONObject> readJsonArray();
}
