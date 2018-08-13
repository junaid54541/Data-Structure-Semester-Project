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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class Admin2Controller extends HeadOffice implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button chapassword;

    @FXML
    private Button reaccount;

    @FXML
    private Button acrequest;

    @FXML
    private Button exit;
    
    @FXML
    void change_password(ActionEvent event) throws IOException {
        Stage stage=(Stage) chapassword.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/Chpassword.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage st = new Stage();
        st.setScene(new Scene(root1));
        st.show();
    }

    @FXML
    void chk_Account_requests(ActionEvent event) throws IOException {
        Stage stage=(Stage) acrequest.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/Requests.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage st = new Stage();
        st.setScene(new Scene(root1));
        st.show();
    }

    @FXML
    void exit(ActionEvent event) {
        try {
            Stage stage=(Stage) exit.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/FXMLDocument.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage st = new Stage();
            st.setScene(new Scene(root1));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(Admin2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void remove_account(ActionEvent event) throws IOException {
        Stage stage=(Stage) reaccount.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/remove1.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage st = new Stage();
        st.setScene(new Scene(root1));
        st.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
