/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ChbalanceController extends HeadOffice implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField brcode;

    @FXML
    private TextField acnumber;

    @FXML
    private TextField title;

    @FXML
    private PasswordField pin;

    @FXML
    private Label check;

    @FXML
    private Button back;

    private String path2;
    @FXML
    private Button submit;

    @FXML
    void titleofaccount(ActionEvent event) {

    }

    @FXML
    void accountnumber(ActionEvent event) {

    }

    @FXML
    void branchcode(ActionEvent event) {

    }

    @FXML
    void pinnumber(ActionEvent event) {

    }

    @FXML
    private ChoiceBox<String> type;
    ObservableList<String> type1 = FXCollections.observableArrayList("Saving Account", "Current Account");

    @FXML
    void submit(ActionEvent event) {
        System.out.println("hai");
        if (type.getValue().equals("Saving Account")) {
            path2 = path_saving;
        } else if (type.getValue().equals("Current Account")) {
            path2 = path_current;
        }
        try {
            readBalance(title.getText(), Double.parseDouble(acnumber.getText()), Double.parseDouble(brcode.getText()), pin.getText(), path2);
        } catch (IOException ex) {
            Logger.getLogger(ChbalanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (bal1.equals("0")) {
            check.setText("Incorrect Information");
        } else {
            check.setText(bal1);

        }
            
    }

    @FXML
    void back(ActionEvent event) {
        try {
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Others.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage st = new Stage();
            st.setScene(new Scene(root1));
            st.show();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }
    @FXML
    void newaccount(ActionEvent event) {
         try {
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/new1.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage st = new Stage();
            st.setScene(new Scene(root1));
            st.show();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        type.setItems(type1);
    }

}
