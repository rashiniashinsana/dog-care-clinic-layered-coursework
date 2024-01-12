package lk.ijse.dogCareClinic.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.dogCareClinic.dto.UserDto;
import lk.ijse.dogCareClinic.dao.IMpl.UserIMPL;
import lk.ijse.dogCareClinic.dao.custom.UserDAO;

import java.io.IOException;
import java.sql.SQLException;


public class LoginFormController {
    @FXML
    private AnchorPane loginPane;

    @FXML
    private Pane pane;

    @FXML
    private TextField textUserName;

    @FXML
    private Text txtCCare;

    @FXML
    private Hyperlink txtForgotPassword;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Text txtSupport;

    @FXML
    private Text txtTerms;

    UserDAO userDAO=new UserIMPL();

    @FXML
    void txtForgotPasswordOnAction(ActionEvent event) throws IOException {
        loginPane.getChildren().clear();
        loginPane.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/forgotpassword-form.fxml")));
    }


    @FXML
    void btnloginOnAction(ActionEvent event) throws IOException {
        String username = textUserName.getText();
        String password = txtPassword.getText();

      //  UserIMPL model = new UserIMPL();
        try {
            UserDto dto = userDAO.search(username);
            if (dto == null) {
                new Alert(Alert.AlertType.ERROR, "Username not found").show();
            } else if (!dto.getPassword().equals(password)) {
                new Alert(Alert.AlertType.ERROR, "Incorrect password").show();
            } else {
                Parent root = FXMLLoader.load(this.getClass().getResource("/view/dashboard-form.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                Stage stage1 = (Stage) loginPane.getScene().getWindow();
                stage1.close();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            new Alert(Alert.AlertType.ERROR, throwables.getMessage()).show();
        }
    }
}
