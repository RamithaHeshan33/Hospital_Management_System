/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {

    //LETS NAME ALL COMPONENTS WE HAVE ON ADMIN PAGE
    @FXML
    private CheckBox login_checkBox;
    
    @FXML
    private AnchorPane login_form;
    
    @FXML
    private Button login_loginBtn;
    
    @FXML
    private PasswordField login_password;
    
    @FXML
    private Hyperlink login_registerHere;
    
    @FXML
    private ComboBox<?> login_user;
    
    @FXML
    private TextField login_username;
    
    @FXML
    private AnchorPane main_form;
    
    @FXML
    private CheckBox register_checkBox;
    
    @FXML
    private TextField register_email;
    
    @FXML
    private AnchorPane register_form;
    
    @FXML
    private Hyperlink register_loginHere;
    
    @FXML
    private PasswordField register_password;
    
    @FXML
    private Button register_signupBtn;
    
    @FXML
    private TextField register_username;
    
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    private AlertMessage alert = new AlertMessage();
    
    public void registerAccount() {
        if (register_email.getText().isEmpty() || register_username.getText().isEmpty() || register_password.getText().isEmpty()) {
            alert.errorMessage("Fileds cannot be blank");
        } else {
            String checkUsername = "SELECT * FROM admin WHERE username = '" + register_username.getText() + "'";
            
            connect = Database.connectDB();
            
            try {
                prepare = connect.prepareStatement(checkUsername);
                result = prepare.executeQuery();
                
                if(result.next()) {
                    alert.errorMessage(register_username.getText() + "is already exist!!");
                }
                
                else {
                    String insertDataa = "INSERT INTO admin (email, username, password, date) VALUES (?,?,?,?)";

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    
                    prepare = connect.prepareStatement(insertDataa);
                    prepare.setString(1, register_email.getText());
                    prepare.setString(2, register_username.getText());
                    prepare.setString(3, register_password.getText());
                    prepare.setString(4, String.valueOf(sqlDate));
                    
                    prepare.executeUpdate();
                    
                    alert.successMessage("Registration Successful");

                }
                
            } catch (Exception e) {
                System.out.println("ssssssssssss" +e);
            }
        }
    }
    
    public void switchForm(ActionEvent event) {
        if (event.getSource() == login_registerHere) {
            //Register Form will show
            login_form.setVisible(false);
            register_form.setVisible(true);
        } else if (event.getSource() == register_loginHere) {
            //Login Form will show
            login_form.setVisible(true);
            register_form.setVisible(false);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
