package com.example.andriod.jsontry1;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Genres {

    @SerializedName("genres")
    @Expose
    private List<Genre> genres = new ArrayList<Genre>();

    /**
     *  Returns a List of Genres
     * @return
     * The genres
     */
    public List<Genre> getGenres() {
        return genres;
    }

    /**
     * Set a list of Genres
     * @param genres
     * The genres
     */
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

}