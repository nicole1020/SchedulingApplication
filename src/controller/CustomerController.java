package controller;

import DAO.AppointmentsHelper;
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
/**
 * @author nicole mau
 * Initializes CustomerController class
  */

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

    /**
     *
     * @param url this initializes the customers table, also the Lambda expression when exit button is pressed, count clicks on exit button, and print exit program, and has an extra Report to show all customers in database
     * @param resourceBundle resources for override
     */
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

    /**
     *
     * @param actionEvent this reacts to when user presses delete customer from database throws error if nothing is selected.
     *                    also Displays custom message with customer ID of the record being deleted
     *
     */
  public void onDeleteCustomer(ActionEvent actionEvent) {
        try {


            Customers p = (Customers) this.customersTable.getSelectionModel().getSelectedItem();
            CustomersHelper.deleteCustomer(p.getCustomerID());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Delete Customer Warning");
            alert.setContentText("Customer record is being deleted from database CustomerID:" + p.getCustomerID() );
            alert.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Please select a customer to delete");
            alert.setContentText( "Please select a customer to delete");
            alert.showAndWait();

        }
    }





    public void onExitButtonPressed(ActionEvent actionEvent) {

    }

    /**
     *
     * @param actionEvent reacts when edit customer button is pushed. if nothing is selected it pops up an alert
     */

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
            stage.centerOnScreen();
            stage.show();
        } catch (Exception var7) {
            var7.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Please select a customer to update");
            alert.setContentText( "Please select a customer to update");
            alert.showAndWait();
        }
    }

    /**
     *
     * @param actionEvent  this reacts when add customer button pushed
     */
    public void onAddCustomer(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/View/AddNewCustomer.fxml"));
            Parent root = (Parent)loader.load();
            Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Add New Customer");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }

    /**
     *
     * @param actionEvent this reacts when appointents screen button pushed
     */
    public void onAppointmentsButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/AppointmentsScreen.fxml"));
            Parent root = (Parent)loader.load();
            Stage stage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Appointments Scheduler and Reports");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (Exception var6) {
            var6.printStackTrace();

        }
    }
}
