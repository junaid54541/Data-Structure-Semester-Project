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
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class OthersController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private RadioButton fd;

    @FXML
    private RadioButton uinfo;

    @FXML
    private RadioButton chkbal;
    
    @FXML
    private Button exit;

    @FXML
    void FixedDeposit(ActionEvent event) throws IOException {
        Stage stage=(Stage) fd.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/fixdep.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage st = new Stage();
        st.setScene(new Scene(root1));
        st.show();
    }

    @FXML
    void checkbalance(ActionEvent event) throws IOException {
        Stage stage=(Stage) chkbal.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/chbalance.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage st = new Stage();
        st.setScene(new Scene(root1));
        st.show();
    }

    @FXML
    void updateinformation(ActionEvent event) throws IOException {
        Stage stage=(Stage) uinfo.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/Profinfo.fxml"));
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
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/service.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage st = new Stage();
            st.setScene(new Scene(root1));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(OthersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
