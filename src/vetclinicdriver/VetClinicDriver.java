/*
 *              Revision History
 * ***************************************************************
 * 
 * 10/2/2019 - Worked on week 6 lab - Thomas Bahun
 *
 */
package vetclinicdriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author aapplin
 * revised by: Thomas Bahun
 */
public class VetClinicDriver {
    Clinic clinic = new Clinic();
    
    /**
     * Reads the data file and store it into a clinic object
     * @param fileName the filename from the command line arguments
     */
    public void readFile(String fileName) {

        // now try to connect the sybolic names to the physical file
        try {
            // if the physical file doesn't exist it throws an exception
            Scanner inFile = new Scanner(new FileReader(fileName));
            if(!inFile.hasNext()) {
                System.err.println("The file is empty. ");
                System.exit(1);
            }
            
            String patientNum, name, breed, owner;
            double weight;
            
            Date dob;
            int month, day, year;
            Patient patient; // declare, do not create
            while(inFile.hasNext()) {
                // read the common fields
                patientNum = inFile.next();
                month = inFile.nextInt();
                day = inFile.nextInt();
                year = inFile.nextInt();
                dob = new Date(month, day, year);
                breed = inFile.nextLine(); // breed has imbedded spaces
                weight = inFile.nextDouble(); // double is on the next line
                name = inFile.next();
                // ShelterDogs have special patient numbers
                if(patientNum.compareTo("70000") < 0) {
                    owner = inFile.next();
                    patient = new Patient(patientNum,
                            new Pet(dob, breed, weight, name, owner));
                } else {
                    patient = new Patient(patientNum,
                            new ShelterDog(dob, breed, weight, name));
                }
                clinic.addPatient(patient);
            }
            inFile.close();
            clinic.sortPatients();
        } catch (FileNotFoundException ex) {
            // we catch it and print an error message
            System.out.println("File data.txt not found");
            // and exit in a controlled manner
            System.exit(1);
        }

    }
    /**
     * The actual driver for this application
     * @param fileName the filename from the command line arguments
     */
    public void run(String fileName) {
        // enroll the competitors
        readFile(fileName);
        System.out.println(clinic.toString());
    }
    /**
     * main method.  The ONLY static method in a class!!!
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // check for a data file name
        if (args.length < 1) {
            System.err.println("usage: progname inputFIle");
            System.exit(1);
        }
        VetClinicDriver driver = new VetClinicDriver();
        driver.run(args[0]);
    }
    
}
