package com.example.f22comp1011lhw9;

public class DetailsViewController {
    public void getMovieDetails(String imdbID) {

        //call the API with something like
        //http://www.omdbapi.com/?apikey=4a1010ab&i=tt0076759
        MovieDetail movieDetail = APIUtility.getMovieDetails(imdbID);

    }
}
