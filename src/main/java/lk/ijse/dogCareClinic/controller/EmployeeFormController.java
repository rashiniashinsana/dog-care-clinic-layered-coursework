package lk.ijse.dogCareClinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dogCareClinic.bo.custom.EmployeeBODAO;
import lk.ijse.dogCareClinic.bo.impl.EmployyeBO;
import lk.ijse.dogCareClinic.dto.EmployeeDto;
import lk.ijse.dogCareClinic.dto.tm.EmployeeTm;
import lk.ijse.dogCareClinic.dao.IMpl.EmployeeIMPL;
import lk.ijse.dogCareClinic.dao.custom.EmployeeDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class EmployeeFormController {

    @FXML
    private AnchorPane employee;

    @FXML
    private JFXButton btn;

    @FXML
    private JFXButton btn1;

    @FXML
    private JFXButton btn11;

    @FXML
    private JFXButton btn111;

    @FXML
    private TableColumn<?, ?> colContacts;

    @FXML
    private TableColumn<?, ?> colEmployeeID;

    @FXML
    private TableColumn<?, ?> colEmployeeName;

    @FXML
    private TableColumn<?, ?> colJobRole;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colSex;

    @FXML
    private TableView<EmployeeTm> tblEmployee;

    @FXML
    private TextField txtEmployeeID;

    @FXML
    private TextField txtEmployeeName;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtRole;

    @FXML
    private TextField txtSex;

    @FXML
    private TextField txtContact;

    //EmployeeDAO employeeDAO=new EmployeeIMPL();
    EmployeeBODAO employeeBODAO=new EmployyeBO();

    public void initialize() {
        setCellValueFactory();
        loadAllEmployee();

    }


    private void setCellValueFactory() {
        colEmployeeID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colEmployeeName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colSex.setCellValueFactory(new PropertyValueFactory<>("Sex"));
        colContacts.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        colJobRole.setCellValueFactory(new PropertyValueFactory<>("JobRole"));

    }

    private void loadAllEmployee() {

        ObservableList<EmployeeTm> obList = FXCollections.observableArrayList();

        try {
            List<EmployeeDto> dtoList = employeeBODAO.getAllEmployess();

            for (EmployeeDto dto : dtoList) {
                obList.add(
                        new EmployeeTm(
                                dto.getEmployeeId(),
                                dto.getEmployeeName(),
                                dto.getNIC(),
                                dto.getSex(),
                                dto.getContact(),
                                dto.getJobRole()
                        )
                );
            }

            tblEmployee.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearFields() {
        txtEmployeeID.setText("");
        txtEmployeeName.setText("");
        txtNIC.setText("");
        txtSex.setText("");
        txtContact.setText("");
        txtRole.setText("");

    }

    private boolean validateEmployee() {
        String idText = txtEmployeeID.getText();
        boolean isIdValid = idText.matches("[E][0-9]{1,}");
        if (!isIdValid) {
            new Alert((Alert.AlertType.ERROR), "Invalid ID").show();
            return false;
        }
        String nameText = txtEmployeeName.getText();
        boolean isNameValid = Pattern.compile("[A-Za-z].{2,}").matcher(nameText).matches();
        if (!isNameValid) {
            new Alert(Alert.AlertType.ERROR, "Invalid Employee Name").show();
            return false;
        }
        String numberText = txtNIC.getText();
        boolean isNumberValid = Pattern.compile("[0-9]{12,}").matcher(numberText).matches();
        if (!isNumberValid) {
            new Alert(Alert.AlertType.ERROR, "Invalid Employee NIC").show();
            return false;
        }
        String contactText = this.txtContact.getText();
        boolean isContactValid = Pattern.compile("^[0-9]{10}$").matcher(contactText).matches();
        if (!isContactValid) {
            new Alert(Alert.AlertType.ERROR, "Invalid Contact").show();
            return false;
        }

        return true;
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws IOException {
        boolean isEmployeeValid = validateEmployee();
        if (isEmployeeValid) {
            String id = txtEmployeeID.getText();
            String name = txtEmployeeName.getText();
            String NIC = txtNIC.getText();
            String Sex = txtSex.getText();
            String Contact = txtContact.getText();
            String JobRole = txtRole.getText();

            var dto = new EmployeeDto(id, name, NIC, Sex, Contact, JobRole);

            try {
                boolean isSaved = employeeBODAO.saveEmployee(dto);
                if (isSaved) {
                    loadAllEmployee();
                    new Alert(Alert.AlertType.CONFIRMATION, "Employee Saved!").show();
                    clearFields();
                }
            } catch (SQLException | ClassNotFoundException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }

    }

    @FXML
    void btnAppointmentOnAction(ActionEvent event) throws IOException {
        employee.getChildren().clear();
        employee.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/appointment-form.fxml"))));

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        employee.getChildren().clear();
        employee.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboard-form.fxml"))));

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnCommunityOnAction(ActionEvent event) throws IOException {
        employee.getChildren().clear();
        employee.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/communitypro-form.fxml")));
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        employee.getChildren().clear();
        employee.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/dashboard-form.fxml")));
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtEmployeeID.getText();

        try {
            boolean isDeleted = employeeBODAO.deleteEmployee(id);

            if (isDeleted) {
                loadAllEmployee();
                tblEmployee.refresh();
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Deleted!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnDogOnAction(ActionEvent event) throws IOException {
        employee.getChildren().clear();
        employee.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/dog-form.fxml")));
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        employee.getChildren().clear();
        employee.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/employee-form.fxml")));
    }

    @FXML
    void btnInventoryOnAction(ActionEvent event) throws IOException {
        employee.getChildren().clear();
        employee.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/inventory-form.fxml")));
    }

    @FXML
    void btnOwnerOnAction(ActionEvent event) throws IOException {
        employee.getChildren().clear();
        employee.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/owner-form.fxml")));
    }

    @FXML
    void btnPaymentOnAction(ActionEvent event) throws IOException {
//        employee.getChildren().clear();
//        employee.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/payment-form.fxml")));

        employee.getChildren().clear();
        employee.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/payment-form.fxml")));
    }

    @FXML
    void btnReportOnAction(ActionEvent event) throws IOException {
        employee.getChildren().clear();
        employee.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/reportForm.fxml")));
    }

    @FXML
    void btnRecordOnAction(ActionEvent event) throws IOException {
        employee.getChildren().clear();
        employee.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/record-form.fxml")));
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String id = txtEmployeeID.getText();

        try {
            EmployeeDto dto = employeeBODAO.searchEmployee(id);

            if (dto != null) {
                fillFields(dto);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Employee not found!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void fillFields(EmployeeDto dto) {
        txtEmployeeID.setText(dto.getEmployeeId());
        txtEmployeeName.setText(dto.getEmployeeName());
        txtNIC.setText(dto.getNIC());
        txtSex.setText(dto.getSex());
        txtContact.setText(dto.getContact());
        txtRole.setText(dto.getJobRole());
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        boolean isEmployeeValid = validateEmployee();
        if (isEmployeeValid) {
            String id = txtEmployeeID.getText();
            String Name = txtEmployeeName.getText();
            String NIC = txtNIC.getText();
            String Sex = txtSex.getText();
            String Contact = txtContact.getText();
            String JobRole = txtRole.getText();

            var dto = new EmployeeDto(id, Name, NIC, Sex, Contact, JobRole);

            boolean isUpdated = employeeBODAO.updateEmployee(dto);
            if (isUpdated) {
                loadAllEmployee();
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Updated!").show();
            }
        }
    }

    public JFXButton getBtn() {
        return btn;
    }

    public JFXButton getBtn1() {
        return btn1;
    }

    public void setBtn1(JFXButton btn1) {
        this.btn1 = btn1;
    }

    public JFXButton getBtn11() {
        return btn11;
    }

    public void setBtn11(JFXButton btn11) {
        this.btn11 = btn11;
    }

    public JFXButton getBtn111() {
        return btn111;
    }

    public void setBtn111(JFXButton btn111) {
        this.btn111 = btn111;
    }

    public AnchorPane getEmployee() {
        return employee;
    }

    public void setEmployee(AnchorPane employee) {
        this.employee = employee;
    }

    public TextField getTxtNIC() {
        return txtNIC;
    }

    public void setTxtNIC(TextField txtNIC) {
        this.txtNIC = txtNIC;
    }

    public TextField getTxtRole() {
        return txtRole;
    }

    public void setTxtRole(TextField txtRole) {
        this.txtRole = txtRole;
    }

    public TextField getTxtSex() {
        return txtSex;
    }

    public void setTxtSex(TextField txtSex) {
        this.txtSex = txtSex;
    }

    public TextField getTxtContact() {
        return txtContact;
    }

    public void setTxtContact(TextField txtContact) {
        this.txtContact = txtContact;
    }
}