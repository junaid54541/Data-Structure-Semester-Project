/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class New1Controller extends HeadOffice {

    /**
     * Initializes the controller class.
     */
    protected int account_no;
    @FXML
    private Button Confirmationbutton;

    @FXML
    private TextField name;

    @FXML
    private ChoiceBox<String> selectbranch;

    @FXML
    private Label brcode;

    @FXML
    private PasswordField PIN;

    @FXML
    private TextField amount;

    @FXML
    private TextField phone;

    @FXML
    private TextField address;

    @FXML
    private TextField CNIC;

    @FXML
    private TextField district;

    @FXML
    private Label labelacnumber;

    @FXML
    private Label check;
    @FXML
    private Label check1;

    @FXML
    private Button back;

//    @FXML
//    void getaccountnumber(ActionEvent event) {
//        account_no = 10000000 + rnd.nextInt(90000000);
//        labelacnumber.setText(Integer.toString(account_no));
//
//    }
    Trie t,cnic;
    Trie adres,ph_no,dist;

    public New1Controller() throws IOException {

      this.t = new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\names.txt");
      this.ph_no = new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\phone_number.txt");
      this.adres = new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\address_pr.txt");
      this.dist = new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\district.txt");
      this.cnic = new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\cnic.txt");
        
        //List<String> list=t.autocomplete("anas");
//   System.out.println("IN NEW1CONTROLLER CONSTRUCTOR");
//            for (int i = 0; i < list.size(); i++) {
// 	    System.out.println(list.get(i));
//           
    }

    @FXML
    void getaccountnumber(ActionEvent event) {
        account_no = 10000000 + rnd.nextInt(90000000);
        labelacnumber.setText(Integer.toString(account_no));
    }

    public List<String> com(String input) {
        System.out.println("======= COM =======");
        List<String> list = t.autocomplete(input);
        System.out.println("======= last COM =======");

//          System.out.println("after auto complete");
//            for (int i = 0; i < list.size(); i++) {
// 	    System.out.println(list.get(i));
        //}
        return list;
    }

    public void enter() {
        name.setOnKeyPressed(new EventHandler<KeyEvent>() {

            public void handle(KeyEvent event) {

                if (event.getCode().equals(KeyCode.ENTER)) {
                    System.out.println("entered in tree i.e " + name.getText());
                    t.insert(name.getText());
                    initialize();
                }
            }
        });

    }
//    public void enter2(TextField tf,Trie tr) {
//        tf.setOnKeyPressed((KeyEvent event) -> {
//            if (event.getCode().equals(KeyCode.ENTER)) {
//                tr.insert(tf.getText());
//            }
//        });}
//    
     public List<String> com_common(String input,Trie tr){   
         List<String> list=tr.autocomplete(input);
         return list;}
    public void action_common(TextField tf,Trie tr){
TextFields.bindAutoCompletion(tf,com_common(tf.getText(),tr));
    }
    ///////////////    CNIC   ///////////////////////
    
//     public List<String> com_cnic(String input){ //list for fetching strings from trie structure
//        System.out.println("======= COM ======="); 
//        List<String> list=cnic.autocomplete(input);
//        System.out.println("======= last COM =======");
//            return list;
//}
//    public void action_cnic(){
//    System.out.println("   IN ACTION WORDS   ");
//TextFields.bindAutoCompletion(CNIC,com_cnic(CNIC.getText()));
//}
public void enter_cnic(){
if(CNIC.getText().length()==0){
    action_common(CNIC,cnic);
}
}
/////////////// ADDRESS ////////////////////
//    public List<String> com_addr(String input){ //list for fetching strings from trie structure
//        System.out.println("======= COM ======="); 
//        List<String> list=adres.autocomplete(input);
//        System.out.println("======= last COM =======");
//            return list;
//}
//    public void action_address(){
//    System.out.println("   IN ACTION WORDS   ");
//TextFields.bindAutoCompletion(address,com_addr(address.getText()));
//}
public void enter_address(){
if(address.getText().length()==0){
action_common(address,adres);
}
}
  
    ///////// phone number ////////////////
//    public List<String> com_ph(String input){ //list for fetching strings from trie structure
//        System.out.println("======= COM ======="); 
//        List<String> list=ph_no.autocomplete(input);
//        System.out.println("======= last COM =======");
//            return list;
//}
//    public void action_phone_number(){
//    System.out.println("   IN ACTION WORDS   ");
//TextFields.bindAutoCompletion(phone,com_ph(phone.getText()));
//}
public void enter_ph(){
if(phone.getText().length()==0){
action_common(phone,ph_no);
}
}
//////////// district ///////////
//public List<String> com_dist(String input){ //list for fetching strings from trie structure
//       System.out.println("======= COM ======="); 
//       List<String> list=dist.autocomplete(input);
//       System.out.println("======= last COM =======");
//       return list;
//}
//    public void action_district(){
//    System.out.println("   IN ACTION WORDS   ");
//TextFields.bindAutoCompletion(district,com_dist(district.getText()));
//}
public void enter_dist(){
if(district.getText().length()==0){
action_common(district,dist);
}
}
public void filing(File f,TextField tf) throws IOException{
        System.out.println("       filing          ");
        FileWriter fstream = new FileWriter(f, true);
        BufferedWriter out = new BufferedWriter(fstream);
        out.newLine();   
        out.write(tf.getText());
        out.close(); 
        }
    
    @FXML
    void confirmdetails(ActionEvent event) throws IOException {
        if(name.getText().isEmpty() || phone.getText().isEmpty() || CNIC.getText().isEmpty() || address.getText().isEmpty() || district.getText().isEmpty()){
            System.out.println(" not write in files ");
            check1.setText("CHECK ALL FIELDS AGAIN");
        }
        else{
            System.out.println(" else");
        File f1=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\names.txt");
        File f2=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\cnic.txt");
        File f3=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\phone_number.txt");
        File f4=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\district.txt");
        File f5=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\address_pr.txt");   
        filing(f5,address);
        filing(f4,district);
        filing(f1,name);
        filing(f2,CNIC);
        filing(f3,phone);
        }
//      System.out.println("In confirm detailed   "+name.getText());
//  
//  File f=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\names.txt");
//       FileWriter fstream = new FileWriter(f, true);
//        BufferedWriter out = new BufferedWriter(fstream);
//        out.newLine();   
//        out.write(name.getText());
//        out.close();     
//        

        //comfirm butto actions
        Writer output = new BufferedWriter(new FileWriter(path_requests, true));
        //name
        Information.add(name.getText());
        //accountnumber
        Information.add(labelacnumber.getText());
        //branch code
        Information.add(brcode.getText());
//pin

        String Pin = PIN.getText();
//encryption
        Compression cm = new Compression();
        Pin = cm.getCompressedString(Pin);
//convert and setting pin to encrypt string value

//adding encrypted pin in array list
        Information.add(Pin);
        //amount
        Information.add(amount.getText());
//phone
        Information.add(phone.getText());
//address
        Information.add(address.getText());
        //cnic
        Information.add(CNIC.getText());
        //district
        Information.add(district.getText());
        //province
        Information.add(province.getValue());
        //date
        Information.add(date1);

        //if fixed deposit then enter years
        if (selectAccount.getValue().equals("fixeddepositaccount")) {
            if (duration.getValue().equals("1year")) {
                profit = (Double.parseDouble(Information.get(4))) * (Math.pow((1 + (0.05 / 4)), 4));
                Information.add("1");
                Information.add(Double.toString(profit));
            } else if (duration.getValue().equals("3year")) {
                profit = (Double.parseDouble(Information.get(4))) * (Math.pow((1 + (0.0522 / 4)), 4 * 3));
                Information.add("3");
                Information.add(Double.toString(profit));
            } else if (duration.getValue().equals("5year")) {
                profit = (Double.parseDouble(Information.get(4))) * (Math.pow((1 + (0.0539 / 4)), 4 * 5));
                Information.add("5");
                Information.add(Double.toString(profit));
            } else if (duration.getValue().equals("10year")) {
                profit = (Double.parseDouble(Information.get(4))) * (Math.pow((1 + (0.0635 / 4)), 4 * 10));
                Information.add("10");
                Information.add(Double.toString(profit));
            }
        }
        //select account
        Information.add(selectAccount.getValue());
        output.append("\n");

        for (int i = 0; i < Information.size(); i++) {
            output.append(Information.get(i) + ",");
        }
        Information.clear();
        output.close();

        check.setText("Your request has been proceeded successfully");
    }

    @FXML
    void getbrcode(ActionEvent event) {
        switch (selectbranch.getValue()) {
            case "North Nazimabad":
                brcode.setText("1605");
                break;
            case "Gulshan-e-Iqbal":
                brcode.setText("2548");
                ;
                break;
            case "Liaquatabad":
                brcode.setText("3749");
                break;
            case "I.I.Chundrigarh(head office)":
                brcode.setText("4535");
                break;
            case "Defence":
                brcode.setText("5302");
                break;
            case "Sharah_e_Faisal Branch":
                brcode.setText("6471");
                break;
        }
    }

    @FXML
    void handledisablityoffda(ActionEvent event) {
        if (selectAccount.getValue().equals("fixeddepositaccount")) {
            duration.setDisable(false);

        } else if ((selectAccount.getValue().equals("savingaccount")) || (selectAccount.getValue().equals("currentaccount")) || (selectAccount.getValue().equals("monthlysavingaccount"))) {
            duration.setDisable(true);
        }

    }

    @FXML
    private ComboBox<String> selectAccount;

    @FXML
    private ComboBox<String> duration;
    ObservableList<String> years = FXCollections.observableArrayList(
            "1year", "3year", "5year", "10year");

    ObservableList<String> AList = FXCollections.observableArrayList(
            "savingaccount", "currentaccount", "monthlysavingaccount", "fixeddepositaccount");
    ObservableList<String> branchlist = FXCollections.observableArrayList(
            "North Nazimabad", "Gulshan-e-Iqbal", "Liaquatabad", "I.I.Chundrigarh(head office)", "Defence", "Sharah_e_Faisal Branch");
    @FXML
    private ChoiceBox<String> province;
    ObservableList<String> prolist = FXCollections.observableArrayList(
            "Sindh", "Punjab", "Baluchistan", "Kheber pakhtun khwan", "FATA");

    public void initialize() {
        // TODO

        province.setItems(prolist);
        selectbranch.setItems(branchlist);
        selectAccount.setItems(AList);
        duration.setItems(years);
        //selectAccount.setDisable(true);
          // System.out.println("........INTIALIZE.........");
       TextFields.bindAutoCompletion(name,com(name.getText()));
       //System.out.println("........ last INTIALIZE.........");
       
       Object ex = null;
     Logger.getLogger(New1Controller.class.getName()).log(Level.SEVERE, null, ex);
    }

    @FXML
    void back(ActionEvent event) {
        try {
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/service.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage st = new Stage();
            st.setScene(new Scene(root1));
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(New1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
