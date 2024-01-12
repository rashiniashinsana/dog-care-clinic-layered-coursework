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
import lk.ijse.dogCareClinic.bo.custom.SupplierBODAO;
import lk.ijse.dogCareClinic.bo.impl.SupplierBO;
import lk.ijse.dogCareClinic.dto.SupplierDto;
import lk.ijse.dogCareClinic.dto.tm.SupplierTm;
import lk.ijse.dogCareClinic.dao.IMpl.SupplierIMPL;
import lk.ijse.dogCareClinic.dao.custom.SupplierDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class SupplierFormController {

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
    private TableColumn<?, ?> colSupplierID;

    @FXML
    private TableColumn<?, ?> colSupplierName;

    @FXML
    private TableColumn<?, ?> colSupplierment;

    @FXML
    private AnchorPane supplierPane;

    @FXML
    private TableView<SupplierTm> tblSupplier;

    @FXML
    private TextField txtItemID;

    @FXML
    private TextField txtItemID1;

    @FXML
    private TextField txtItemID11;

    @FXML
    private TextField txtItemID2;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtSupplierID;

    @FXML
    private TextField txtSupplierName;

    @FXML
    private TextField txtSupplierment;

   // SupplierDAO supplierDAO=new SupplierIMPL();

    SupplierBODAO supplierBODAO =new SupplierBO();


    public void initialize() {
        setCellValueFactory();
        loadAllSupplier();
    }


    private void setCellValueFactory() {
        colSupplierID.setCellValueFactory(new PropertyValueFactory<>("SupplierID"));
        colSupplierName.setCellValueFactory(new PropertyValueFactory<>("SupplierName"));
        colContacts.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        colSupplierment.setCellValueFactory(new PropertyValueFactory<>("Supplierment"));

    }

    private void loadAllSupplier() {
      //  var model = new SupplierIMPL();
        ObservableList<SupplierTm> obList = FXCollections.observableArrayList();

        try {
            List<SupplierDto> dtoList = supplierBODAO.getAllSupplier();

            for (SupplierDto dto : dtoList) {
                obList.add(
                        new SupplierTm(
                                dto.getSupplierID(),
                                dto.getSupplierName(),
                                dto.getContact(),
                                dto.getSupplierment()
                        )
                );
            }

            tblSupplier.setItems(obList);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean validateSupplier() {
        String idText = txtSupplierID.getText();
        boolean isIdValid = idText.matches("[S][0-9]{3,}");
        if (!isIdValid) {
            new Alert((Alert.AlertType.ERROR), "Invalid Supplier ID").show();
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
    void btnAddOnAction(ActionEvent event) {
        boolean isSupplierValid = validateSupplier();
        if (isSupplierValid) {
            String id = txtSupplierID.getText();
            String name = txtSupplierName.getText();
            String contact = txtContact.getText();
            String supplierment = txtSupplierment.getText();

            var dto = new SupplierDto(id, name, contact, supplierment);

            //var model = new SupplierIMPL();
            try {
                boolean isSaved =supplierBODAO.saveSupplier(dto);
                if (isSaved) {
                    loadAllSupplier();
                    new Alert(Alert.AlertType.CONFIRMATION, "Supplier Saved!").show();
                    clearFields();
                }
            } catch (SQLException | ClassNotFoundException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
    }

    private void clearFields() {
        txtSupplierID.setText("");
        txtSupplierName.setText("");
        txtContact.setText("");
        txtSupplierment.setText("");
    }


    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtSupplierID.getText();

       // var supplierModel = new SupplierModel();
        try {
          //  boolean isDeleted = SupplierModel.deleteSupplier(id);
            boolean isDeleted=supplierBODAO.deleteSupplier(id);

            if (isDeleted) {
                loadAllSupplier();
//                tblCustomer.refresh();
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Deleted!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        boolean isSupplierValid = validateSupplier();
        if (isSupplierValid) {
            String id = txtSupplierID.getText();
            String name = txtSupplierName.getText();
            String diagnosis = txtContact.getText();
            String supplierment = txtSupplierment.getText();


            var dto = new SupplierDto(id, name, diagnosis, supplierment);

            //var model = new SupplierIMPL();
            try {
                boolean isUpdated = supplierBODAO.updateSupplier(dto);
                if (isUpdated) {
                    loadAllSupplier();
                    new Alert(Alert.AlertType.CONFIRMATION, "Supplier Updated!").show();
                }
            } catch (SQLException | ClassNotFoundException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtSupplierID.getText();

        var model = new SupplierIMPL();
        SupplierDto dto = model.search(id);

        if (dto != null) {
            fillFields(dto);
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Supplier not found!").show();
        }
    }

    private void fillFields(SupplierDto dto) {
        txtSupplierID.setText(dto.getSupplierID());
        txtSupplierName.setText(dto.getSupplierName());
        txtContact.setText(dto.getContact());
        txtSupplierment.setText(dto.getSupplierment());
    }


    public void backOnAction(ActionEvent actionEvent) throws IOException {
        supplierPane.getChildren().clear();
        supplierPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboard-form.fxml"))));
    }
}

