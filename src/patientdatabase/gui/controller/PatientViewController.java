/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import patientdatabase.be.Patient;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class PatientViewController implements Initializable
{
    private Patient patient;

    @FXML
    private Label lblId;
    @FXML
    private Label lblName;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblDiagnosis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }
    
    /**
     * Gets the information of the patient and then set the information.
     * @param patient The patient in question.
     */
    public void setPatient(Patient patient)
    {
        this.patient = patient;
        setPatientInfo();
    }    
    
    /**
     * Updates the view with all the information.
     */
    private void setPatientInfo()
    {
        lblId.setText(patient.getId() + "");
        lblName.setText(patient.getName());
        lblEmail.setText(patient.getEmail());
        lblDiagnosis.setText(patient.getDiagnosis());
    }
}
