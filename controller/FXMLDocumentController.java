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
import javafx.stage.Stage;

/**
 *
 * @author Hp
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private Button admin;
    
    @FXML
    private Button button;
    
    @FXML
    private Button exit;

    @FXML
    void handleAdminAction(ActionEvent event) throws IOException {
        Stage stage=(Stage) admin.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/admin.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage st = new Stage();
        st.setScene(new Scene(root1));
        st.show();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            Stage stage=(Stage) button.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/service.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage st = new Stage();
            st.setScene(new Scene(root1));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void exit(ActionEvent event) {
        Stage stage=(Stage) exit.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
