package com.example.f22comp1011lhw9;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class APIResponse {
    @SerializedName("Search")
    private Movie[] search;

    private String totalResults;

//    @SerializedName("Response")
//    private String response;


    public APIResponse(String totalResults, String response, Movie[] search) {
        setTotalResults(totalResults);
//        setResponse(response);
        setSearch(search);
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

//    public String getResponse() {
//        return response;
//    }
//
//    public void setResponse(String response) {
//        this.response = response;
//    }

    public Movie[] getSearch() {
        return search;
    }

    public List<Movie> getMovies()
    {
        return Arrays.asList(search);
    }

    public void setSearch(Movie[] search) {
        this.search = search;
    }
}
