package com.example.andriod.jsontry1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MovieColl {

    @SerializedName("results")
    @Expose
    private List<Movie> results = new ArrayList<Movie>();

    /**
     *
     * @return
     * The results
     */
    public List<Movie> getMovies() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setMovies(List<Movie> results) {
        this.results = results;
    }

}