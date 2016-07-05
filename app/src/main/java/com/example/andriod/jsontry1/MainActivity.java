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
        Call<JSONArray> jsonArrayCall = service.readJsonArray();
        jsonArrayCall.enqueue(new Callback<JSONArray>() {
            @Override
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                String Genre2 = "";
                for(int i = 0;i <response.body().length();i++) {
                    try {
                        JSONObject Genres1 = response.body().getJSONObject(i);
                        Log.e("onResponse",Genres1.getString("id"));
                        Log.e("onResponse",Genres1.getString("name"));
                        Genre2 = Genres1.getString("name");
                    }catch (JSONException e){
                        Log.e("onResponse", e.getMessage().toString());
                    }
                }
                TextView textView = (TextView) findViewById(R.id.message);
                textView.setText(Genre2);
            }

            @Override
            public void onFailure(Call<JSONArray> call, Throwable t) {
                Log.e("onFailure", t.toString());
            }
        });
    }
}
