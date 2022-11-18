package com.example.f22comp1011lhw9;

import java.io.IOException;

public class DetailsViewController {
    public void getMovieDetails(String imdbID) throws IOException, InterruptedException {

        //call the API with something like
        //http://www.omdbapi.com/?apikey=4a1010ab&i=tt0076759
        MovieDetail movieDetail = APIUtility.getMovieDetails(imdbID);

        System.out.println(movieDetail);
    }
}
