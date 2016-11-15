/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.dal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import patientdatabase.be.Patient;

/**
 *
 * @author Rasmus
 */
public class PatientDAO
{
    private static final String FILE_NAME = "src/patientDatabase/resource/MOCK_DATA.csv";
    private static PatientDAO instance = null;
    
    public static PatientDAO getInstance()
    {
        if(instance == null)
        {
            instance = new PatientDAO();
        }
        return instance;
    }
    
    private PatientDAO()
    {
        
    }
    
    public List<Patient> getAllPatients()
    {
        List<Patient> returnList = new ArrayList<>();
        try(BufferedReader CSVFile = new BufferedReader(new FileReader(FILE_NAME)))
        {
            CSVFile.readLine(); //Skips the first line aka. the header.
            String line = CSVFile.readLine();
            while(line != null)
            {
                String[] dataArray = line.split(",");
                returnList.add(
                        new Patient(Integer.parseInt(dataArray[0]), dataArray[1], dataArray[2], dataArray[3]));
                line = CSVFile.readLine(); //Read next line.
            }
        } 
        catch (IOException ioe)
        {
            System.out.println(ioe);
            return null;
        }
        return returnList;
    }
}
