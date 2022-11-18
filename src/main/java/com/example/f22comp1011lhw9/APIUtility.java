package com.example.f22comp1011lhw9;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    /**
     * This method will call the OMDB API with the specified
     * search term
     * @return ApiResponse is the Java object created from the JSON
     */
    public static APIResponse getMoviesFromOMDB(String searchTerm) throws IOException, InterruptedException {
        // "star wars" -> "star%20wars"
        searchTerm = searchTerm.replaceAll(" ", "%20");

        String uri = "http://www.omdbapi.com/?apikey=4a1010ab&s="+searchTerm;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //This will call the API and save the JSON to a file
//        HttpResponse<Path> response = client.send(httpRequest, HttpResponse
//                                            .BodyHandlers
//                                            .ofFile(Paths.get("jsonData.json")));

        //this will call the API and return a HttpResponse object
        //the "body" of the HttpResponse is the JSON string
        HttpResponse<String> response = client.send(httpRequest,
                                                    HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), APIResponse.class);
    }

    /**
     * This method will read the jsonData.json from the root
     * of the project and create an APIResponse object
     */
    public static APIResponse getMoviesFromJsonFile()
    {
        //create a GSON object
        Gson gson = new Gson();
        APIResponse apiResponse = null;

        //try with resources...what ever is in the ( ) will automatically be closed
        try(
                FileReader fileReader = new FileReader("jsonData.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            //jsonReader - the object that is parsing through the json file
            //APIResponse.class - this is what ever type of object you want the JSON
            //                    to be converted into
            apiResponse = gson.fromJson(jsonReader, APIResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return apiResponse;
    }

    public static MovieDetail getMovieDetails(String imdbID) throws IOException, InterruptedException {

        String uri = "http://www.omdbapi.com/?apikey=4a1010ab&i="+imdbID;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = client.send(httpRequest,
                                                HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), MovieDetail.class);
    }
}
