package com.example.f22comp1011lhw9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private ListView<Movie> listView;

    @FXML
    private ImageView posterImageView;

    @FXML
    private HBox resultsBox;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox selectedVBox;

    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultsBox.setVisible(false);

        //make the button invisible until the user selects a
        //movie
        selectedVBox.setVisible(false);
        msgLabel.setVisible(false);

        //select a movie from the listview and display the
        //poster art
        listView.getSelectionModel().selectedItemProperty()
                                    .addListener((obs,old,movieSelected)->
        {
            if (movieSelected!=null)
            {
                selectedVBox.setVisible(true);
                try {
                    posterImageView.setImage(new Image(movieSelected.getPoster()));
                } catch (IllegalArgumentException e)
                {
                    posterImageView.setImage(new Image(Main.class
                                    .getResourceAsStream("images/default_poster.png")));
                }
            }
            else
            {
                selectedVBox.setVisible(false);
            }
        });
    }

    /**
     * Call the API with the search term.  If the API
     * returns movie objects, display them in the results area
     */
    @FXML
    private void search() throws IOException, InterruptedException {
        APIResponse apiResponse = APIUtility.getMoviesFromOMDB(searchTextField.getText());

        //check if the API response had any movies in it
        if (apiResponse.resultsReturned())
        {
            listView.getItems().clear();
            msgLabel.setVisible(false);
            resultsBox.setVisible(true);
            List<Movie> movies = apiResponse.getMovies();
            Collections.sort(movies, new Comparator<Movie>() {
                @Override
                public int compare(Movie m1, Movie m2) {
                    if (m2.getYear().compareTo(m1.getYear())==0)
                        return (m1.getTitle().compareTo(m2.getTitle()));
                    else
                        return m2.getYear().compareTo(m1.getYear());
                }
            });
            listView.getItems().addAll(movies);
        }
        else
        {
            resultsBox.setVisible(false);
            listView.getItems().clear();
            msgLabel.setVisible(true);
            msgLabel.setText(apiResponse.getError());
        }
    }

    /**
     * Movie was selected and user pressed the details button
     *
     */
    @FXML
    private void getDetails(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"details-view.fxml");
    }
}
