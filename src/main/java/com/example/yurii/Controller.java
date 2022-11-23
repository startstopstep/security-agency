package com.example.yurii;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    Application application = new Application();

    public String tempString1 = "";

    @FXML
    private Button addNewButton,
            exitButton,
            toLoginButton,
            addEmployeeBack,
            addCountryBack,
            addOfficeBack,
            addHeadBack,
            addCustomerBack;

    @FXML
    private ChoiceBox<String> choiceBox,
            headChoiceBox,
            customerChoiceBox,
            employeeChoiceBox,
            countryChoiceBox,
            officeChoiceBox;

    @FXML
    private TextField loginField,
            passwordField,
            registerLoginField,
            registerPasswordField,
            registerNameField,
            registerSurnameField,
            registerEmailField,
            registerPhoneField,
            addEmployeeField,
            addCountryField,
            addCityField,
            addAddressField,
            addHeadField,
            addEmailField,
            addCustomerField;

    @FXML
    private TableView<Customer> customerTableView;

    @FXML
    private TableView<Employee> employeeTableView;

    @FXML
    private TableView<Office> officeTableView;

    @FXML
    private TableView<Head> headTableView;

    @FXML
    private TableView<Country> countryTableView;

    @FXML
    private TableView<Agency> agencyTableView;

    //---------------------------------------------------------------------

    @FXML
    private TableColumn<Customer, Integer> customerIdColumn;

    @FXML
    private TableColumn<Customer, String> customerCustomerColumn;

    //----------------------------------------------------------------------

    @FXML
    private TableColumn<Employee, Integer> employeeIdColumn;

    @FXML
    private TableColumn<Employee, String> employeeEmployeeColumn;

    //-----------------------------------------------------------------------

    @FXML
    private TableColumn<Office, Integer> officeIdColumn;

    @FXML
    private TableColumn<Office, String> officeCityColumn;

    @FXML
    private TableColumn<Office, String> officeAddressColumn;

    //-----------------------------------------------------------------------

    @FXML
    private TableColumn<Head, Integer> headIdColumn;

    @FXML
    private TableColumn<Head, String> headHeadColumn;

    @FXML
    private TableColumn<Head, Integer> headEmailColumn;

    //-----------------------------------------------------------------------

    @FXML
    private TableColumn<Country, Integer> countryIdColumn;

    @FXML
    private TableColumn<Country, String> countryCountryColumn;

    //-----------------------------------------------------------------------

    @FXML
    private TableColumn<Agency, Integer> agencyIdColumn;

    @FXML
    private TableColumn<Agency, String> agencyHeadColumn;

    @FXML
    private TableColumn<Agency, String> agencyCustomerColumn;

    @FXML
    private TableColumn<Agency, String> agencyEmployeeColumn;

    @FXML
    private TableColumn<Agency, String> agencyCountryColumn;

    @FXML
    private TableColumn<Agency, String> agencyNameColumn;

    @FXML
    private TableColumn<Agency, String> agencyWebsiteColumn;

    @FXML
    private TableColumn<Agency, String> agencyOfficeColumn;

    //-----------------------------------------------------------------------

    @FXML
    private Label currentTable;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private HBox topHBox;

    @FXML
    private CheckBox nameCheck,
            websiteCheck;

    private String sqlDeleteId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setBackground() {
        //Встановлюємо колір фону через Color Picker
        topHBox.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), CornerRadii.EMPTY, new Insets(0))));
    }

    public void login() throws SQLException, IOException {
        //Логування
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) loginField.getScene().getWindow();
        var login = loginField.getText();
        var pass = passwordField.getText();
        if(application.login(login, pass)) {
            stage.setScene(scene);
            loginField.clear();
            passwordField.clear();
        } else {
            System.out.println("Nope");
        }
    }

    public void update() {
        //Виведення таблиць
        application.updateData();
        TableView.TableViewSelectionModel<Agency> agencySelectionModel = agencyTableView.getSelectionModel();
        TableView.TableViewSelectionModel<Customer> customerSelectionModel = customerTableView.getSelectionModel();
        TableView.TableViewSelectionModel<Employee> employeeSelectionModel = employeeTableView.getSelectionModel();
        TableView.TableViewSelectionModel<Office> officeSelectionModel = officeTableView.getSelectionModel();
        TableView.TableViewSelectionModel<Head> headSelectionModel = headTableView.getSelectionModel();
        TableView.TableViewSelectionModel<Country> countrySelectionModel = countryTableView.getSelectionModel();
        agencySelectionModel.selectedItemProperty().addListener(new ChangeListener<Agency>() {
            @Override
            public void changed(ObservableValue<? extends Agency> observableValue, Agency agency, Agency t1) {
                if(t1 != null) {
                    sqlDeleteId = Integer.toString(t1.getId_agency());
                }
            }
        });
        customerSelectionModel.selectedItemProperty().addListener(new ChangeListener<Customer>() {
            @Override
            public void changed(ObservableValue<? extends Customer> observableValue, Customer customer, Customer t1) {
                if(t1 != null) {
                    sqlDeleteId = Integer.toString(t1.getId_customer());
                }
            }
        });
        employeeSelectionModel.selectedItemProperty().addListener(new ChangeListener<Employee>() {
            @Override
            public void changed(ObservableValue<? extends Employee> observableValue, Employee employee, Employee t1) {
                if(t1 != null) {
                    sqlDeleteId = Integer.toString(t1.getId_employee());
                }
            }
        });
        officeSelectionModel.selectedItemProperty().addListener(new ChangeListener<Office>() {
            @Override
            public void changed(ObservableValue<? extends Office> observableValue, Office office, Office t1) {
                if(t1 != null) {
                    sqlDeleteId = Integer.toString(t1.getId_office());
                }
            }
        });
        headSelectionModel.selectedItemProperty().addListener(new ChangeListener<Head>() {
            @Override
            public void changed(ObservableValue<? extends Head> observableValue, Head head, Head t1) {
                if(t1 != null) {
                    sqlDeleteId = Integer.toString(t1.getId_head());
                }
            }
        });
        countrySelectionModel.selectedItemProperty().addListener(new ChangeListener<Country>() {
            @Override
            public void changed(ObservableValue<? extends Country> observableValue, Country country, Country t1) {
                if(t1 != null) {
                    sqlDeleteId = Integer.toString(t1.getId_country());
                }
            }
        });
        customerTableView.setItems(application.customers);
        employeeTableView.setItems(application.employees);
        officeTableView.setItems(application.offices);
        headTableView.setItems(application.heads);
        countryTableView.setItems(application.countrys);
        agencyTableView.setItems(application.agencys);
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("id_customer"));
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id_employee"));
        officeIdColumn.setCellValueFactory(new PropertyValueFactory<Office, Integer>("id_office"));
        headIdColumn.setCellValueFactory(new PropertyValueFactory<Head, Integer>("id_head"));
        countryIdColumn.setCellValueFactory(new PropertyValueFactory<>("id_country"));
        agencyIdColumn.setCellValueFactory(new PropertyValueFactory<>("id_agency"));
        agencyHeadColumn.setCellValueFactory(new PropertyValueFactory<>("head"));
        agencyCustomerColumn.setCellValueFactory(new PropertyValueFactory<>("customer"));
        agencyEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("employee"));
        agencyCountryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        agencyNameColumn.setCellValueFactory(new PropertyValueFactory<>("active"));
        agencyWebsiteColumn.setCellValueFactory(new PropertyValueFactory<>("private_security"));
        agencyOfficeColumn.setCellValueFactory(new PropertyValueFactory<>("office"));
        countryCountryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        headHeadColumn.setCellValueFactory(new PropertyValueFactory<Head, String>("head"));
        headEmailColumn.setCellValueFactory(new PropertyValueFactory<Head, Integer>("email"));
        customerCustomerColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("customer"));
        officeCityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        officeAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        employeeEmployeeColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employee"));
        System.out.println("update()");
    }


    public void deleteItem() {
        if(choiceBox.getSelectionModel().getSelectedItem() != null) {
            var table = choiceBox.getSelectionModel().getSelectedItem();
            if(table.equals("Agency")) {
                var sql = "delete from agency\n" +
                        "where id_agency = " + sqlDeleteId;
                System.out.println(application.addNewData(sql));
                update();
            } else if(table.equals("Head")) {
                var sql = "delete from head\n" +
                        "where id_head = " + sqlDeleteId;
                System.out.println(application.addNewData(sql));
                update();
            } else if (table.equals("Customer")) {
                var sql = "delete from customer\n" +
                        "where id_customer = " + sqlDeleteId;
                System.out.println(application.addNewData(sql));
                update();
            } else if (table.equals("Employee")) {
                var sql = "delete from employee\n" +
                        "where id_employee = " + sqlDeleteId;
                System.out.println(application.addNewData(sql));
                update();
            } else if (table.equals("Office")) {
                var sql = "delete from office\n" +
                        "where id_office = " + sqlDeleteId;
                System.out.println(application.addNewData(sql));
                update();
            } else if (table.equals("Country")) {
                var sql = "delete from country\n" +
                        "where id_country = " + sqlDeleteId;
                System.out.println(application.addNewData(sql));
                update();
            } else {
                currentTable.setText("Select row!");
            }
        } else {
            currentTable.setText("Select Table!");
        }

    }

    public void addNew() throws IOException {
        //Додавання нових даних у базу даних
        Parent employee = FXMLLoader.load(getClass().getResource("addEmployee.fxml"));
        Scene employeeScene = new Scene(employee);
        Parent country = FXMLLoader.load(getClass().getResource("addCountry.fxml"));
        Scene countryScene = new Scene(country);
        Parent office = FXMLLoader.load(getClass().getResource("addOffice.fxml"));
        Scene officeScene = new Scene(office);
        Parent head = FXMLLoader.load(getClass().getResource("addHead.fxml"));
        Scene headScene = new Scene(head);
        Parent customer = FXMLLoader.load(getClass().getResource("addCustomer.fxml"));
        Scene customerScene = new Scene(customer);
        Parent agency = FXMLLoader.load(getClass().getResource("addAgency.fxml"));
        Scene agencyScene = new Scene(agency);
        Stage stage = (Stage) addNewButton.getScene().getWindow();

        if(choiceBox.getSelectionModel().getSelectedItem() != null) {
            currentTable.setText("");
            tempString1 = choiceBox.getSelectionModel().getSelectedItem();

            if (tempString1.equals("Agency")) {
                application.updateData();
                stage.setScene(agencyScene);
            } else if(tempString1.equals("Employee")) {
                stage.setScene(employeeScene);
            } else if(tempString1.equals("Country")) {
                stage.setScene(countryScene);
            } else if(tempString1.equals("Head")) {
                stage.setScene(headScene);
            } else if(tempString1.equals("Office")) {
                stage.setScene(officeScene);
            } else {
                stage.setScene(customerScene);
            }

        } else {
            currentTable.setText("Select Table");
        }
    }

    public void toRegisterForm() throws IOException {
        //Перехід на форму реєстрації
        Parent root = FXMLLoader.load(getClass().getResource("registerForm.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) loginField.getScene().getWindow();
        stage.setScene(scene);
    }

    public void register() {
        //Реалізація кнопки реєстрації
        var log = registerLoginField.getText();
        var pass = registerPasswordField.getText();
        var name = registerNameField.getText();
        var sname = registerSurnameField.getText();
        var email = registerEmailField.getText();
        var phone = registerPhoneField.getText();
        if(application.register(log, pass, name, sname, email, phone)) {
            System.out.println("Done");
            registerLoginField.clear();
            registerPasswordField.clear();
            registerNameField.clear();
            registerSurnameField.clear();
            registerEmailField.clear();
            registerPhoneField.clear();
        } else {
            System.out.println("Error");
        }
    }

    public void toLoginFrom() throws IOException {
        //перехід на форму Login
        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) toLoginButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void exit() {
        //Вихід з програми
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void setChoiceBox() {
        //Виведення даних у ChoiceBox
        choiceBox.getItems().clear();
        choiceBox.getItems().addAll("Agency", "Head", "Office", "Country", "Employee", "Customer");
    }

    public void addEmployeeQuery() {
        //Додавання даних у таблицю Employee
        var sql = "insert into employee(Employee)\n"
                + "values('" + addEmployeeField.getText() + "')";
        application.addNewData(sql);
        addEmployeeField.clear();
    }

    public void addEmployeeCancel() throws IOException {
        //повернення на головну сторінку
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) addEmployeeBack.getScene().getWindow();
        stage.setScene(scene);
    }

    public void addCountryQuery() {
        //Додавання даних у таблицю Country
        var sql = "insert into country(country)\n"
                + "values('" + addCountryField.getText() + "')";
        application.addNewData(sql);
        addCountryField.clear();
    }

    public void addCountryCancel() throws IOException {
        //повернення на головну сторінку
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) addCountryBack.getScene().getWindow();
        stage.setScene(scene);
    }

    public void addOfficeQuery() {
        //Додавання даних у таблицю Office
        var sql = "insert into office(city, address)\n"
                + "values('" + addCityField.getText() + "','" + addAddressField.getText() + "')";
        application.addNewData(sql);
        addCityField.clear();
        addAddressField.clear();
    }

    public void addOfficeCancel() throws IOException {
        //повернення на головну сторінку
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) addOfficeBack.getScene().getWindow();
        stage.setScene(scene);
    }

    public void addHeadQuery() {
        //Додавання даних у таблицю Head
        var sql = "insert into head(head, email)\n"
                + "values('" + addHeadField.getText() + "','" + addEmailField.getText() + "')";
        application.addNewData(sql);
        addHeadField.clear();
        addEmailField.clear();
    }

    public void addHeadCancel() throws IOException {
        //повернення на головну сторінку
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) addHeadBack.getScene().getWindow();
        stage.setScene(scene);
    }

    public void addCustomerQuery() {
        //Додавання даних у таблицю Customer
        var sql = "insert into customer(customer)\n"
                + "values('" + addCustomerField.getText() + "')";
        application.addNewData(sql);
        addCustomerField.clear();
    }

    public void addCustomerCancel() throws IOException {
        //повернення на головну сторінку
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) addCustomerBack.getScene().getWindow();
        stage.setScene(scene);
    }

    public void setAgencyChoiceBox() {
        //Додавання елементів у Choce Box`s
        headChoiceBox.getItems().clear();
        customerChoiceBox.getItems().clear();
        employeeChoiceBox.getItems().clear();
        countryChoiceBox.getItems().clear();
        officeChoiceBox.getItems().clear();
        application.updateData();
        headChoiceBox.setItems(application.headChoice);
        customerChoiceBox.setItems(application.customerChoice);
        employeeChoiceBox.setItems(application.employeeChoice);
        countryChoiceBox.setItems(application.countryChoice);
        officeChoiceBox.setItems(application.officeChoice);
    }

    public void addAgency() {
        //Додавання даних до таблиці Phone
        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;
        int temp4 = 0;
        String temp5 = "";
        String temp6 = "";
        int temp7 = 0;

        for(Map.Entry<Integer, String> item : application.headMap.entrySet()) {
            if(headChoiceBox.getValue().equals(item.getValue())) {
                temp1 = item.getKey();
            }
        }
        for(Map.Entry<Integer, String> item : application.customerMap.entrySet()) {
            if(customerChoiceBox.getValue().equals(item.getValue())) {
                temp2 = item.getKey();
            }
        }
        for(Map.Entry<Integer, String> item : application.employeeMap.entrySet()) {
            if(employeeChoiceBox.getValue().equals(item.getValue())) {
                temp3 = item.getKey();
            }
        }
        for(Map.Entry<Integer, String> item : application.countryMap.entrySet()) {
            if(countryChoiceBox.getValue().equals(item.getValue())) {
                temp4 = item.getKey();
            }
        }
        for(Map.Entry<Integer, String> item : application.officeMap.entrySet()) {
            if(officeChoiceBox.getValue().equals(item.getValue())) {
                temp7 = item.getKey();
            }
        }

        if(nameCheck.isSelected()) {
            temp5 = "Yes";
        } else {
            temp5 = "No";
        }

        if(websiteCheck.isSelected()) {
            temp6 = "Yes";
        } else {
            temp6 = "No";
        }

        var sql = "insert into agency(id_head, id_customer, id_employee, id_country, name, website, id_office)\n" +
                "values(" + temp1 + "," + temp2 + "," + temp3 + "," + temp4 + ",'" + temp5 + "','" + temp6 + "'," + temp7 + ")";

        application.addNewData(sql);
        System.out.println(sql);

    }

    public void addAgencyCancel() throws IOException {
        //повернення на головну сторінку
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) headChoiceBox.getScene().getWindow();
        stage.setScene(scene);
    }

}