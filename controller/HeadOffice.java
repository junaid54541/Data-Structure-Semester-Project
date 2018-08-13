/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.PasswordField;

/**
 *
 * @author Hp
 */
public class HeadOffice {

    public String path_current="C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\currentaccount.txt";
    public String path_saving="C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\savingaccount.txt";
    public String path_monsaving="C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\monthlysavingaccount.txt";
    public String path_fixdep="C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\fixeddepositaccount.txt";
    public String path_password="C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\passward.txt";
    public String path_requests="C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\requests.txt";
    
    protected ArrayList<String> Information = new ArrayList<String>();
    protected ArrayList<String> Customers = new ArrayList<String>();
    protected double balance = -2;
    protected String branch_code;
    protected int Branch;
    protected int account_no;
    private int period;
    private String pin1,pin2;
    private int check;
    protected double period1;
    protected double amount;
    protected double profit;
    private boolean flag = false;
    protected String bal1 = "0";
    protected String name, br_code, bal, phone, add, nic, dist, prov, type;
    String line = "";
    public String path1;
    String key = "safi";
    String pass, pass1, pass2;
    double day, month, year;
    Scanner reader = new Scanner(System.in);
    Random rnd = new Random();
    DateFormat dateFormat = new SimpleDateFormat("dd,MM,yyyy");
    Date date = new Date();
    String date1 = dateFormat.format(date);
    Compression cm=new Compression();

    public void readBalance(String name, double acc_no, double br_code, String pin, String path) throws FileNotFoundException, IOException {
        String s=cm.getCompressedString(pin);
        File f = new File(path);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while ((line = br.readLine()) != null) {
            Customers.add(line);
        }
        for (int i = 0; i < Customers.size(); i++) {
            String[] split = Customers.get(i).split(",");

            if ((name.equals(split[0])) && (acc_no == Double.parseDouble(split[1])) && (br_code == Double.parseDouble(split[2])) && (s.equals(split[3]))) {
                bal1 = split[4];
                if (path.equals(path_monsaving) || path.equals(path_fixdep)) {
                    day = Double.parseDouble(split[10]);
                    month = Double.parseDouble(split[11]);
                    year = Double.parseDouble(split[12]);
                }
                if (path.equals(path_fixdep)) {
                    period1 = Double.parseDouble(split[13]);
                    amount = Double.parseDouble(split[14]);
                }
                break;
            }
        }
        br.close();
    }

    public void updateBalance(String name, double acc_no, double br_code, String pin, double amount, char sign, String path) throws FileNotFoundException, IOException {
       String d=cm.getCompressedString(pin);
        File f1 = new File(path);
        FileOutputStream fos = new FileOutputStream(f1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (int i = 0; i < Customers.size(); i++) {
            String[] split = Customers.get(i).split(",");
            if ((name.equals(split[0])) && (acc_no == Double.parseDouble(split[1])) && (br_code == Double.parseDouble(split[2])) && (d.equals(split[3]))){
                balance = Double.parseDouble(split[4]);
                if (sign == '-') {
                    split[4] = Double.toString(balance - amount);
                    Customers.set(i, split[0] + "," + split[1] + "," + split[2] + "," + split[3] + "," + split[4] + "," + split[5] + "," + split[6] + "," + split[7] + "," + split[8] + "," + split[9] + "," + split[10] + "," + split[11] + "," + split[12]);
                } else if (sign == '+') {
                    split[4] = Double.toString(balance + amount);
                    Customers.set(i, split[0] + "," + split[1] + "," + split[2] + "," + split[3] + "," + split[4] + "," + split[5] + "," + split[6] + "," + split[7] + "," + split[8] + "," + split[9] + "," + split[10] + "," + split[11] + "," + split[12]);
                }
                break;
            }
        }
        for (int j = 0; j < Customers.size(); j++) {
            bw.write(Customers.get(j));
            bw.newLine();
        }
        bw.close();
    }

    public void updateDate(String name, double acc_no, double br_code, String pin, String path) throws FileNotFoundException, IOException {
        String s=cm.getCompressedString(pin);
        File f1 = new File(path);
        FileOutputStream fos = new FileOutputStream(f1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (int i = 0; i < Customers.size(); i++) {
            String[] split = Customers.get(i).split(",");
            if ((name.equals(split[0])) && (acc_no == Double.parseDouble(split[1])) && (br_code == Double.parseDouble(split[2])) && (s ==(split[3]))) {
                String date2[] = date1.split(",");
                Customers.set(i, split[0] + "," + split[1] + "," + split[2] + "," + split[3] + "," + split[4] + "," + split[5] + "," + split[6] + "," + split[7] + "," + split[8] + "," + split[9] + "," + split[10] + "," + date2[1] + "," + date2[2] + "," + split[13]);
                break;
            }
        }
        for (int j = 0; j < Customers.size(); j++) {
            bw.write(Customers.get(j));
            bw.newLine();
        }
        bw.close();
    }

    public void newAccount(String type) throws FileNotFoundException, IOException {
        Writer output = new BufferedWriter(new FileWriter(path_requests, true));
        System.out.println("Enter Title of Account/Name");
        Information.add(reader.next());
        account_no = 10000000 + rnd.nextInt(90000000);
        Information.add(Integer.toString(account_no));
        System.out.println("Select Branch:\n1.North Nazimabad Branch\n2.Gulshan-e-Iqbal Baranch\n3.Liaquatabad Branch\n4.I.I.Chundrigarh Road/Head Office\n5.Defence No.4\n6.Sharah_e_Faisal Branch");
        try {
            Branch = reader.nextInt();
            switch (Branch) {
                case 1:
                    branch_code = "1605";
                    break;
                case 2:
                    branch_code = "2548";
                    break;
                case 3:
                    branch_code = "3749";
                    break;
                case 4:
                    branch_code = "4535";
                    break;
                case 5:
                    branch_code = "5302";
                    break;
                case 6:
                    branch_code = "6471";
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
        }
        Information.add(branch_code);

        System.out.println("Enter PIN Number");
        try {
            pin1=reader.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
        }
        Compression cm=new Compression();
         pin2=cm.getCompressedString(pin1);
        
        Information.add(pin2);
        System.out.println("Enter Amount To Open an Account");
        Information.add(reader.next());
        System.out.println("Enter Phone Number");
        Information.add(reader.next());
        System.out.println("Enter Address");
        Information.add(reader.next());
        System.out.println("Enter CNIC Number");
        Information.add(reader.next());
        System.out.println("Enter District");
        Information.add(reader.next());
        System.out.println("Enter Province");
        Information.add(reader.next());
        Information.add(date1);

        if (type.equals("fixeddepositaccount")) {
            System.out.println("Enter period:\n1. 1 year\n2. 3 years\n3. 5 years\n4. 10 years");
            period = reader.nextInt();
            switch (period) {
                case 1:
                    profit = (Double.parseDouble(Information.get(4))) * (Math.pow((1 + (0.05 / 4)), 4));
                    Information.add("1");
                    Information.add(Double.toString(profit));
                    break;
                case 2:
                    profit = (Double.parseDouble(Information.get(4))) * (Math.pow((1 + (0.0522 / 4)), 4 * 3));
                    Information.add("3");
                    Information.add(Double.toString(profit));
//                    System.out.println("Your Account Number is: " + account_no + " and Branch Code is: " + Information.get(2) + " and you got: " + profit + " after 3 years");
                    break;
                case 3:
                    profit = (Double.parseDouble(Information.get(4))) * (Math.pow((1 + (0.0539 / 4)), 4 * 5));
                    Information.add("5");
                    Information.add(Double.toString(profit));
//                    System.out.println("Your Account Number is: " + account_no + " and Branch Code is: " + Information.get(2) + " and you got: " + profit + " after 5 years");
                    break;
                case 4:
                    profit = (Double.parseDouble(Information.get(4))) * (Math.pow((1 + (0.0635 / 4)), 4 * 10));
                    Information.add("10");
                    Information.add(Double.toString(profit));
//                    System.out.println("Your Account Number is: " + account_no + " and Branch Code is: " + Information.get(2) + " and you got: " + profit + " after 10 years");
                    break;
            }
        }
        Information.add(type);

        output.append("\n");
        for (int i = 0; i < Information.size(); i++) {
            output.append(Information.get(i) + ",");
        }
        output.close();
    }

    public int checkpassward(PasswordField passward) throws FileNotFoundException, IOException {
        File f = new File(path_password);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        line = br.readLine();
        br.close();
        
        Compression c=new Compression();
      
        
        
         String result=c.getCompressedString(passward.getText());
         
          
         
        if ((line).equals(result)) {
            return 1;
        } else {
            return 2;
        }
    }

    public void changePassward(PasswordField newpassword) throws FileNotFoundException, IOException {
        File f1 = new File(path_password);
        FileOutputStream fos = new FileOutputStream(f1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
       Compression c=new Compression();
       String result = c.getCompressedString(newpassword.getText());
        bw.write(result);
        bw.close();
    }

    public int checkRequests() throws FileNotFoundException, IOException {
        File f = new File(path_requests);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while ((line = br.readLine()) != null) {
            Customers.add(line);
        }
        if (Customers.size() <= 1) {
            File f1 = new File(path_requests);
            FileOutputStream fos = new FileOutputStream(f1);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (int j = 0; j < Customers.size(); j++) {
                bw.write(Customers.get(j));
            }
            bw.close();
            return 1;
        } else {
            String[] split = Customers.get(1).split(",");
            name = split[0];
            br_code = split[2];
            bal = split[4];
            phone = split[5];
            add = split[6];
            nic = split[7];
            dist = split[8];
            prov = split[9];

            if (split[split.length - 1].equals("savingaccount")) {
                path1 = path_saving;
                type = split[split.length - 1];
            } else if (split[split.length - 1].equals("currentaccount")) {
                path1 = path_current;
                type = split[split.length - 1];
            } else if (split[split.length - 1].equals("monthlysavingaccount")) {
                path1 = path_monsaving;
                type = split[split.length - 1];
            } else if (split[split.length - 1].equals("fixeddepositaccount")) {
                path1 = path_fixdep;
                type = (split[split.length - 1] + "/" + split[13]);
            }
            br.close();
        }
        return 0;
    }

    public int removeAccount(String name, double acc_no, double br_code, String path2) throws FileNotFoundException, IOException {
        File f = new File(path2);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while ((line = br.readLine()) != null) {
            Customers.add(line);
        }
        for (int i = 0; i < Customers.size(); i++) {
            String[] split = Customers.get(i).split(",");

            if ((name.equals(split[0])) && (acc_no == Double.parseDouble(split[1])) && (br_code == Double.parseDouble(split[2]))) {
                Customers.remove(i);
                File f1 = new File(path2);
                FileOutputStream fos = new FileOutputStream(f1);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

                for (int j = 0; j < Customers.size(); j++) {
                    bw.write(Customers.get(j));
                    bw.newLine();
                }
                bw.close();
                flag = true;
                break;
            }
        }
        if (flag == false) {
            return 1;
        } else {
            return 2;
        }
    }

    public void checkAccount(String name, String path) throws FileNotFoundException, IOException {
        File f = new File(path);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while ((line = br.readLine()) != null) {
            Information.add(line);
        }
        for (int i = 0; i < Information.size(); i++) {
            String[] split = Information.get(i).split(",");

            if ((name.equals(split[0])) && path.equals("C:\\Users\\Hp\\Documents\\NetBeansProjects\\BankAccount\\BankAccount\\src\\bankaccount\\monthlysavingaccount.txt")) {
                System.out.println("Your Account Number is: " + split[1] + " and Branch Code is: " + split[2] + " and monthly profit is: " + ((Double.parseDouble(split[4]) / 100000) * 400));
            } else if ((name.equals(split[0])) && (path.equals("C:\\Users\\Hp\\Documents\\NetBeansProjects\\BankAccount\\BankAccount\\src\\bankaccount\\savingaccount.txt")) || (path.equals("C:\\Users\\Hp\\Documents\\NetBeansProjects\\BankAccount\\BankAccount\\src\\bankaccount\\currentaccount.txt"))) {
                System.out.println("Your Account Number is: " + split[1] + " and Branch Code is: " + split[2]);
            } else if ((name.equals(split[0])) && path.equals("C:\\Users\\Hp\\Documents\\NetBeansProjects\\BankAccount\\BankAccount\\src\\bankaccount\\fixeddepositaccount.txt")) {
                System.out.println("Your Account Number is: " + split[1] + " and Branch Code is: " + split[2] + " and you got: " + split[14] + " after " + split[13] + " year/s");
            }
        }
    }
}
