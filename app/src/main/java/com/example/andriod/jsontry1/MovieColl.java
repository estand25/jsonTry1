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
     * Get the list of movies
     * @return
     * The results
     */
    public List<Movie> getMovies() {
        return results;
    }

    /**
     * Set the List of movies
     * @param results
     * The results
     */
    public void setMovies(List<Movie> results) {
        this.results = results;
    }

}