/**
 *                  Revision History (Newest First)
 * **************************************************************
 * 
 * 10/2/19 - Worked on week 6 lab - Thomas Bahun
 * 
 */

package vetclinicdriver;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Course: CSCI 160
 * Class Description: A class representing the clinic
 * Project Name: VetClinicDriver
 * Due Date: 10/5/19
 * Depends on:
 * Extends:
 * Implements:
 * @author thomas
 */
public class Clinic {

    ArrayList<Patient> patients;
    
    /**
     *
     */
    public Clinic() {
        patients = new ArrayList<>();
    }

    /**
     *
     * @param p
     */
    public void addPatient(Patient p) {
        patients.add(p);
    }

    /**
     *
     */
    public void sortPatients() {
        Collections.sort(patients);
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator();
        //enhanced for loop works with all Java Collections
        for (Patient p: patients) {
            str.append(p.toString()).append(eol);
        }
        return str.toString();
    }
}
