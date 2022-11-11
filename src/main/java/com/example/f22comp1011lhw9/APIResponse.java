package com.example.f22comp1011lhw9;

public class APIResponse {
    private Movie[] search;
    private String totalResults;
    private String response;


    public APIResponse(String totalResults, String response, Movie[] search) {
        setTotalResults(totalResults);
        setResponse(response);
        setSearch(search);
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Movie[] getSearch() {
        return search;
    }

    public void setSearch(Movie[] search) {
        this.search = search;
    }
}