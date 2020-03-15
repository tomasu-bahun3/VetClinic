/**
 *                  Revision History (Newest First)
 * **************************************************************
 * 
 * 10/2/19 - Worked on week 6 lab - Thomas Bahun
 * 
 */

package vetclinicdriver;

/**
 * Course: CSCI 160
 * Class Description: Class representing a patient in the vet clinic 
 * Project Name: VetClinicDriver
 * Due Date: 10/5/19
 * Depends on:
 * Extends:
 * Implements:
 * @author thomas
 */
public class Patient implements Comparable<Patient> {
    
    private String patientNumber;
    private Dog patient;

    /**
     *
     * @param patientNumber
     * @param patient
     */
    public Patient(String patientNumber, Dog patient) {
        this.patientNumber = patientNumber;
        this.patient = patient;
    }

    /**
     *
     * @return
     */
    public String getPatientNumber() {
        return patientNumber;
    }

    /**
     *
     * @return
     */
    public Dog getPatient() {
        return patient;
    }
    
    @Override
    public String toString() {
        return patientNumber + "  " + patient.toString();
    }
    
    /**
     * compareTo (abstract method of the Comparable Interface) is implemented to
     * impose a natural ordering on a group of objects. compareTo is used by the
     * Collections.sort routine to allow us to sort the competitors belonging to
     * some Java collection.
     *
     * @param that is the Dog object we are comparing this one to
     * @return a negative integer, zero, or a positive integer if this object
     * comes before, is equal to, or comes after the specified object.
     */
    @Override
    public int compareTo(Patient that) {
        // some constants for clarity
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        // shouldn't be any null objects, but if there are
        // put them at the end
        if (that == null) {
            return AFTER;
        }
        //this optimization is usually worthwhile, and can
        //always be added - if the addresses are the same... they are equal
        if (this == that) {
            return EQUAL;
        }
        // we sort by patientNumber
        return this.patientNumber.compareTo(that.getPatientNumber());
    }

}
