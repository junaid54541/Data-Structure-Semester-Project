/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class Cwcd1Controller extends HeadOffice implements Initializable {

  
    @FXML
    private TextField brcode;

    @FXML
    private TextField acnumber;

    @FXML
    private TextField title;

    @FXML
    private TextField amount;

    @FXML
    private PasswordField pin;

    @FXML
    private Label check;
    @FXML
    private Label check1;
    
    @FXML
    private Button back;

    private String path2;


    Trie t,ac,br;
    public Cwcd1Controller() throws IOException{
this.t= new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\cwcd1\\title.txt");
this.br= new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\cwcd1\\branch_code.txt");
this.ac= new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\cwcd1\\account_number.txt");

   }
    
    
            public List<String> com_common(String input,Trie tr){   
         List<String> list=tr.autocomplete(input);
         return list;}
    public void action_common(TextField tf,Trie tr){
TextFields.bindAutoCompletion(tf,com_common(tf.getText(),tr));
    }
public void enter_title(){
if(title.getText().length()==0){
    action_common(title,t);
}
}
public void enter_account(){
if(acnumber.getText().length()==0){
    action_common(acnumber,ac);
}
}
public void enter_br(){
if(brcode.getText().length()==0){
    action_common(brcode,br);
}
}



    @FXML
    private ChoiceBox<String> type;
    ObservableList<String> type1 = FXCollections.observableArrayList("Saving Account", "Current Account");

    public void filing(File f,TextField tf) throws IOException{
        System.out.println("       filing          ");
        FileWriter fstream = new FileWriter(f, true);
        BufferedWriter out = new BufferedWriter(fstream);
        out.newLine();   
        out.write(tf.getText());
        out.close(); 
        }

    
    @FXML
    void submit(ActionEvent event) throws IOException {
     if(title.getText().isEmpty() || acnumber.getText().isEmpty() || brcode.getText().isEmpty() ){
            System.out.println(" not write in files ");
            check1.setText("CHECK ALL FIELDS AGAIN");
        }
        else{
            System.out.println(" else");
        File f1=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\cwcd1\\title.txt");
        File f2=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\cwcd1\\branch_code.txt");
        File f3=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\cwcd1\\account_number.txt");
        filing(f1,title);
        filing(f2,brcode);
        filing(f3,acnumber);
        }
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
            check.setText(Double.toString(Double.parseDouble(bal1) + Double.parseDouble(amount.getText())));
            try {
                updateBalance(title.getText(), Double.parseDouble(acnumber.getText()), Double.parseDouble(brcode.getText()), pin.getText(), Double.parseDouble(amount.getText()), '+', path2);
            } catch (FileNotFoundException a) {
                System.out.println("File Not Found");
            }
            catch (IOException ex) {
                Logger.getLogger(Cwcd1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    void back(ActionEvent event){
        try {
            Stage stage=(Stage) back.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/service.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage st = new Stage();
            st.setScene(new Scene(root1));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(Cwcd1Controller.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Cwcd1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        type.setItems(type1);
    }    
    
}
