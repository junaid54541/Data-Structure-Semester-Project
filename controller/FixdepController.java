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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class FixdepController extends HeadOffice implements Initializable {

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
    
    private String path2=path_fixdep;
    
    private double date2;
    @FXML
    private Label depositamount; 
   
    @FXML
    void submit(ActionEvent event) {
        try {
            readBalance(title.getText(), Double.parseDouble(acnumber.getText()), Double.parseDouble(brcode.getText()), pin.getText(), path2);
        } catch (IOException ex) {
            Logger.getLogger(ChbalanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (bal1.equals("0")) {
            check.setText("Incorrect Information");
        } else {
            date2 = year + period1;
            String split[] = date1.split(",");
            if (Double.parseDouble(split[2]) > date2){
                check.setText(Double.toString(amount));
            } else if ((Double.parseDouble(split[2]) == date2) && (Double.parseDouble(split[1]) > month)){
                check.setText(Double.toString(amount));
            } else if ((Double.parseDouble(split[2]) == date2) && (Double.parseDouble(split[1]) == month) && (Double.parseDouble(split[0]) >= day)){
                check.setText(Double.toString(amount));
            } else {check.setText("Date doesn't exceeded");
                    depositamount.setText(Double.toString(Double.parseDouble(bal1)));
            }
        }
    }
    
    @FXML
    void back(ActionEvent event) {
        try {
            Stage stage=(Stage) back.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/Others.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage st = new Stage();
            st.setScene(new Scene(root1));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(FixdepController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void newaccount(ActionEvent event) {
        try {
            Stage stage=(Stage) back.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/new1.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage st = new Stage();
            st.setScene(new Scene(root1));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(FixdepController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
