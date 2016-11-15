/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.bll;

import java.util.List;
import patientdatabase.be.Patient;
import patientdatabase.dal.PatientDAO;

/**
 *
 * @author Rasmus
 */
public class bllManager
{
    private static bllManager instance = null;
    public static bllManager getInstance()
    {
        if(instance == null)
        {
            instance = new bllManager();
        }
        return instance;
    }
    
    private bllManager()
    {
        
    }
    
    public List<Patient> getAllPatients()
    {
        return PatientDAO.getInstance().getAllPatients();
    }
}
