package com.example.f22comp1011lhw9;

import java.net.http.HttpClient;

public class APIUtility {

    /**
     * This method will call the OMDB API with the specified
     * search term
     * @return ApiResponse is the Java object created from the JSON
     */
    public static APIResponse getMoviesFromOMDB(String searchTerm)
    {
        String uri = "http://www.omdbapi.com/?apikey=4a1010ab&s=wakanda";

        HttpClient client = HttpClient.newHttpClient();

    }
}
