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
    public static void getMoviesFromOMDB(String searchTerm) throws IOException, InterruptedException {
        String uri = "http://www.omdbapi.com/?apikey=4a1010ab&s=wakanda";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<Path> response = client.send(httpRequest, HttpResponse
                                            .BodyHandlers
                                            .ofFile(Paths.get("jsonData.json")));
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
}
