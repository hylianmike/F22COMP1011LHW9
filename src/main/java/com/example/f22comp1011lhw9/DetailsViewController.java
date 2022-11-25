package com.example.f22comp1011lhw9;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;

public class DetailsViewController {
    @FXML
    private ListView<String> actorsListView;

    @FXML
    private Label boxOfficeLabel;

    @FXML
    private Label directorLabel;

    @FXML
    private Label ratingLabel;

    @FXML
    private Label runtimeLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private Label yearLabel;


    public void getMovieDetails(String imdbID) throws IOException, InterruptedException {

        //call the API with something like
        //http://www.omdbapi.com/?apikey=4a1010ab&i=tt0076759
        MovieDetail movieDetail = APIUtility.getMovieDetails(imdbID);

        System.out.println(movieDetail);
    }
}
