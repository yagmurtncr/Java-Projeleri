package com.example.otomasyon2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SignUp implements Initializable {

    @FXML
    private Button btnlogin;

    @FXML
    private Text btnmember;

    @FXML
    private Button btnsignup;
    @FXML
    private Text txtconfpassword;
    @FXML
    private PasswordField txtfconfpassword;
    @FXML
    private PasswordField txtfpassword;

    @FXML
    private TextField txtfusername;
    @FXML
    private Text txtmember;
    @FXML
    private Text txtpassword;

    @FXML
    private Text txtusername;
    @FXML
    private TextField txtfname;
    @FXML
    private TextField txtfsurname;
    @FXML
    private Text txtname;
    @FXML
    private Text txtsurname;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    void actlogin(ActionEvent event) {
        try {
            Stage stage = (Stage) btnsignup.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoggedIn.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 810, 500);
            stage.setTitle("Book References Tracking Automation");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setFullScreen(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static Connection myConn;
    @FXML
    void actsignup(ActionEvent event) {

      registerUser();

    }
    public void registerUser(){
        Methods connectNow = new Methods();
        Connection connectDB = connectNow.getConnection();

        String name,surname,username,password,sql_sorgu;
        name =txtfname.getText();
        surname =txtfsurname.getText();
        username =txtfusername.getText();
        password =txtfpassword.getText();

        sql_sorgu= "INSERT INTO javafx.useraccounts(FirstName,LastName , UserName , Password) VALUES ('"+
                name +"','"+surname+"','"+username+"','"+password+"')";

        try{
            Statement statement =connectDB.createStatement();
            statement.executeUpdate(sql_sorgu);
            txtmember.setText("User has been registered successfully!");

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}

