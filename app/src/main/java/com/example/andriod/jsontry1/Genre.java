package com.example.andriod.jsontry1;

//import javax.annotation.Generated;
import android.content.Intent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Genre {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * Returns the genre id in integer
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the Genre id
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *  Get the Genre Name
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the Genre name
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getNameFromId(Integer id){
        return name;
    }
}