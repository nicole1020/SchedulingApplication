package controller;

import DAO.CustomersHelper;
import model.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
// Initializes CustomerController
public class CustomerController implements Initializable {
    public TableView <Customers> customersTable;
    public TableColumn customersTableCustomerNameCol;
    public TableColumn customersTableAddressCol;
    public TableColumn customersTablePostalCodeCol;
    public TableColumn customersTablePhoneCol;
    public TableColumn customersTableCustomerID;
    public TableColumn customersTableCountry;
    public TableColumn customersTableDivision;
    public Label resultsLBL;
    public Button deleteCustomer;
    public Button exitButton;
    public Label resultsLBLAppointments;
    public Button editCustomer;
    public Customers selectedCustomer = null;
    public Button addCustomer;
    public Button appointmentsButton;
    int countingClicks = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Customer Database Main Screen");
        exitButton.setOnAction(e ->{
            countingClicks++;
            System.out.println(countingClicks);
            System.out.println("Exit Button Pressed");
            System.exit(0);
        });
    //Customers Table Initialized
        customersTable.setItems(CustomersHelper.getAllCustomers());

        customersTableCustomerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customersTableAddressCol.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        customersTablePostalCodeCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        customersTablePhoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        customersTableCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        customersTableCountry.setCellValueFactory(new PropertyValueFactory<>("Country"));
        customersTableDivision.setCellValueFactory(new PropertyValueFactory<>("Division"));

        System.out.println("Customer IDs:");
        for (int i = 0; i < CustomersHelper.getAllCustomers().size(); i++) {
            System.out.println(CustomersHelper.getAllCustomers()
                    .get(i).getCustomerID());

        }
        System.out.println("");
        resultsLBL.setText("Report: " + CustomersHelper.getAllCustomers().size() + " Customers in database");


    }
    public void customerIsSelected(MouseEvent mouseEvent) {
    }

    public void lookupCustomer(KeyEvent keyEvent) {
    }

    public void onCustomerTextField(ActionEvent actionEvent) {
    }

    public void onCustomerSearch(ActionEvent actionEvent) {
    }

    public void onDeleteCustomer(ActionEvent actionEvent) {

        Customers p = (Customers) this.customersTable.getSelectionModel().getSelectedItem();
       // int customerID = Integer.parseInt(customersTableCustomerID.getText());
      //  String DivisionID = customersTableDivision.getText();


        CustomersHelper.deleteCustomer( p.getCustomerID() );
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Delete Customer Warning");
        alert.setContentText( "'s customer record is being deleted.");
        alert.showAndWait();

            }





    public void onExitButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }



    public void onEditCustomer(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/UpdateCustomer.fxml"));
            Parent UpdateCustomerScreen = loader.load();
            UpdateCustomerController controller = loader.getController();
            controller.editedCustomer((Customers)this.customersTable.getSelectionModel().getSelectedItem());
            System.out.println("Update Customer Clicked");
            Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(UpdateCustomerScreen);
            stage.setTitle("Update Customer Record");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var7) {
            var7.printStackTrace();
        }
    }

    public void onAddCustomer(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/View/AddNewCustomer.fxml"));
            Parent root = (Parent)loader.load();
            Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Add New Customer");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }

    public void onAppointmentsButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/AppointmentsScreen.fxml"));
            Parent root = (Parent)loader.load();
            Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Appointments Scheduler and Reports");
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            var6.printStackTrace();

        }
    }
}
