/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.gui.controller;

import java.io.IOException;
import patientdatabase.be.Patient;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import patientdatabase.bll.bllManager;

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
        bllManager bllM = bllManager.getInstance();
        patientList.addAll(bllM.getAllPatients());
    }

    private void loadPatientDataView(Patient patient) throws IOException
    {
        Stage primStage = (Stage)tblPatients.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/patientdatabase/gui/view/PatientView.fxml"));
        Parent root = loader.load();
        
        //Fetches the controller of the patientView.
        PatientViewController pvController = loader.getController();
        pvController.setPatient(patient);
        
        Stage stagePatientView = new Stage();
        stagePatientView.setScene(new Scene(root));
        
        stagePatientView.initModality(Modality.WINDOW_MODAL);
        stagePatientView.initOwner(primStage);        
        
        stagePatientView.show();
    }

    @FXML
    private void mousePressedOnTableView(MouseEvent event) throws IOException
    {
        //Check double-click left mouse button.
        if(event.isPrimaryButtonDown() && event.getClickCount() == 2)
        {
            Patient selectedPatient = tblPatients.getSelectionModel().getSelectedItem();
            loadPatientDataView(selectedPatient);
        }
    }
    
}
