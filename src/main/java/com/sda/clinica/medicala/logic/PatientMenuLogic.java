package com.sda.clinica.medicala.logic;

import com.sda.clinica.medicala.consultation.Consultation;
import com.sda.clinica.medicala.display.DisplayData;
import com.sda.clinica.medicala.doctor.Doctor;
import com.sda.clinica.medicala.patient.Patient;
import com.sda.clinica.medicala.utils.Consts;

import java.util.List;
import java.util.Scanner;

public class PatientMenuLogic {

    private long CNP;
    private Scanner scanner = new Scanner(System.in);

    private List<Patient> patientList;
    private List<Doctor> doctorList;

    public PatientMenuLogic(long CNP, List<Patient> patientList, List<Doctor> doctorList) {
        this.CNP = CNP;
        this.patientList = patientList;
        this.doctorList = doctorList;
    }


    /**
     * Pacientul va putea sa programeze o consultatie la medicul de familie sau sa revina la meniul principal
     * daca pacientul nu apare in DB va primi un mesaj si se aplicatia se intoarce la MAIN MENU
     */

    public void solvePatientOption(int option) {
        boolean isPatientMenuRunning = true;

        while(isPatientMenuRunning) {
            boolean patientIsInList = false;
            Patient actualPatient = null;

            //cautare cnp in lista cu pacienti
            for (Patient element : patientList) {
                if (element.getCNP() == this.CNP) {
                    patientIsInList = true;
                    actualPatient = element;
                    break;
                }
            }

            if (patientIsInList) {
                switch (option) {
                    case 1:
                        long CNPOfDoctorForActualPatient = actualPatient.getCNPOfPatientDoctor();
                        Doctor doctorForActualPatient = null;

                        /**s-a preluat cnp-ul doctorului pacientului, se verifica daca exista in lsita de doctori
                         *trebuie sa exista in lista pt ca doctorii pacientilor s-au setat pe baza listei de doctori
                        */
                        for (Doctor element : doctorList) {
                            if (element.getCNP() == CNPOfDoctorForActualPatient) {
                                doctorForActualPatient = element;
                                break;
                            }
                        }

                        DisplayData.displayMessage(Consts.PATIENT_GIVE_REASON_FOR_CONSULTATION);
                        String reasonForConsultation = scanner.nextLine();

                        /**se programeaza o consultatie pt pacientul actual folosind managerul de consultatii (fiecare
                         *doctor are un astfel de manager
                        */
                        Consultation consultationOfActualPatient = new Consultation(actualPatient, reasonForConsultation);
                        doctorForActualPatient.managerConsultations.scheduleConsultation(consultationOfActualPatient);

                        DisplayData.displayMessage(Consts.PATIENT_YOU_HAVE_A_CONSULTATION + doctorForActualPatient);
                        DisplayData.displayMessage(Consts.PATIENT_WAINT_FOR_YOUR_TURN);
                        DisplayData.newLine();

                        isPatientMenuRunning = false;
                        break;
                    case 2:
                        isPatientMenuRunning = false;
                        break;
                    default:
                        DisplayData.displayMessage(Consts.OPTION_NOT_VALID);
                        isPatientMenuRunning = false;
                }
                /**dupa fiecare operatia a pacientului in meniu se revine la meniul principal
                 * intrucat un pacient poate sa faca o singura programare deocamdata la un singur medic
                 * Cand o sa poata alege medicul la care sa faca programarea, se va verifica daca nu cumva are deja o programare
                 * facuta la acel medic(acum poate face mai multe programari la acelasi medic)
                 */
            } else {
                DisplayData.displayMessage(Consts.PATIENT_NOT_REGISTERED);
                System.out.println("Nu exista optiunea sa va inregistram inca.");
                DisplayData.newLine();
                isPatientMenuRunning = false;
            }
        }

    }
}
