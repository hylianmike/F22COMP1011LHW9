package com.example.f22comp1011lhw9;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class MovieDetail {
    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    @SerializedName("Rated")
    private String rated;

    @SerializedName("Runtime")
    private String runtime;

    @SerializedName("Director")
    private String director;

    @SerializedName("Actors")
    private String actors;

    @SerializedName("BoxOffice")
    private String boxoffice;

//    @SerializedName("Ratings")
//    private HashMap<String, String> ratings;

}
