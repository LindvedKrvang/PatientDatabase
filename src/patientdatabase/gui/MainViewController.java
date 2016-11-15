/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.gui;

import patientdatabase.be.Patient;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Rasmus
 */
public class MainViewController implements Initializable
{
    @FXML
    private TableView<Patient> tblPatients;
    @FXML
    private TableColumn<Patient, String> columName;
    @FXML
    private TableColumn<Patient, String> columEmail;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        readDataIntoList();
    }    

    private void readDataIntoList()
    {
        ObservableList<Patient> patientList = FXCollections.observableArrayList(
                        new Patient(0, "Jeppe", "jle@easv.dk", "Full retardo"),
                        new Patient(1, "Lukas", "luc2517@easv365.dk", "Mental ill")
                );
        columName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tblPatients.setItems(patientList);
    }
    
}
