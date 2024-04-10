/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;

import com.sun.jdi.connect.spi.Connection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
        
public class DoctorPageController implements Initializable{
    
    @FXML
    private CheckBox login_checkBox;

    @FXML
    private TextField login_doctorID;

    @FXML //c
    private AnchorPane login_form;

    @FXML
    private Button login_loginBtn;

    @FXML
    private PasswordField login_password;

    @FXML
    private Hyperlink login_registerHere;

    @FXML
    private TextField login_showPassword;

    @FXML
    private ComboBox<?> login_user;

    @FXML
    private AnchorPane main_form;

    @FXML
    private CheckBox register_checkBox;

    @FXML
    private TextField register_doctorID;

    @FXML
    private TextField register_email;

    @FXML
    private AnchorPane register_form;

    @FXML
    private TextField register_fullName;

    @FXML
    private Hyperlink register_loginHere;

    @FXML
    private PasswordField register_password;

    @FXML
    private TextField register_showPassword;

    @FXML
    private Button register_signupBtn;
    
    
    private Connection connection;
    private PreparedStatement prepare;
    private ResultSet result;
    
    private final AlertMessage alert = new AlertMessage();
    

    @FXML
    void loginAccount(ActionEvent event) {

    }

    @FXML
    void loginShowPassword(ActionEvent event) {

    }

    @FXML
    void registerAccount(ActionEvent event) {

    }

    @FXML
    void registerShowPassword(ActionEvent event) {

    }
    
    public void userList() {
        List<String> listU = new ArrayList<>();
        
        for(String data: Users.user) {
            listU.add(data);
        }
        
        ObservableList listData = FXCollections.observableList(listU);
        login_user.setItems(listData);
    }
    
    
    public void switchPage() {
        if(login_user.getSelectionModel().getSelectedItem() == "Admin Portal") {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                
                stage.setTitle("Hospital Management System");
                
                stage.setMinWidth(340);
                stage.setMinHeight(580);
                
                stage.setScene(new Scene(root));
                stage.show();
            }
            
            catch(Exception e) {
                System.out.println(e);
            }
        }
        
        else if (login_user.getSelectionModel().getSelectedItem() == "Doctor Portal") {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("DoctorPage.fxml"));
                Stage stage = new Stage();
                
                stage.setTitle("Hospital Management System");
                
                stage.setMinWidth(340);
                stage.setMinHeight(580);
                
                stage.setScene(new Scene(root));
                stage.show();
                
                
            }
            
            catch(Exception e) {
                System.out.println(e);
            }
        }
        
        else if (login_user.getSelectionModel().getSelectedItem() == "Patient Portal") {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("PatientPage.fxml"));
                Stage stage = new Stage();
                
                stage.setTitle("Hospital Management System");
                
                stage.setMinWidth(340);
                stage.setMinHeight(580);
                
                stage.setScene(new Scene(root));
                stage.show();
            }
            
            catch(Exception e) {
                System.out.println(e);
            }
        }
    
        login_user.getScene().getWindow().hide();
    
    }

    @FXML
    void switchForm(ActionEvent event) {
        if(event.getSource() == register_loginHere){
            login_form.setVisible(true);
            register_form.setVisible(false);
        }
        
        else if (event.getSource() == login_registerHere) {
            login_form.setVisible(false);
            register_form.setVisible(true);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
