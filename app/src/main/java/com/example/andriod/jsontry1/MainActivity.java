package com.example.andriod.jsontry1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GenreAPIService service = retrofit.create(GenreAPIService.class);
        Call<JSONObject> jsonArrayCall = service.readJsonArray();
        jsonArrayCall.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                try {
                    JSONObject genrelist = new JSONObject(response.body().toString());
                    JSONArray genreArray = genrelist.getJSONArray("results");
                    for(int i = 0; i< genreArray.length();i++){
                        JSONObject genreInfo = genreArray.getJSONObject(i);
                        Log.e("onResponse", genreInfo.getString("id"));
                        Log.e("onResponse", genreInfo.getString("name"));

                    }
                } catch (JSONException e) {
                    Log.e("onFailure", e.getMessage().toString());
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Log.e("onFailure", t.toString());
            }
        });
    }
}
