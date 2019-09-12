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
    private Scanner scanner;
    private DatabaseManager databaseManager;

    private List<Patient> patientList;
    private List<Doctor> doctorList;

    public PatientMenuLogic(DatabaseManager databaseManager, long CNP) {
        this.scanner = new Scanner(System.in);
        this.databaseManager = databaseManager;
        this.patientList = databaseManager.getPatientsList();
        this.doctorList = databaseManager.getDoctorsList();
        this.CNP = CNP;
    }

    /**
     * Pacientul va putea sa programeze o consultatie la un medic la alegere sau sa revina la meniul principal
     * daca pacientul nu apare in DB va primi optiunea de a se inregistra, sau de a se intoarce in meniul principal
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
                        Doctor doctorForConsultation;

                        /**s-a preluat cnp-ul doctorului pacientului, i se afiseaza lista de medici pt a alege la care vrea
                         * consultatia. Medicul sau de familie va fi marcat
                        */

                        DisplayData.displayMessage(Consts.PATIENT_CHOOSE_DOCTOR);
                        int index = 1;
                        for (Doctor element : doctorList) {
                            if (element.getCNP() == actualPatient.getCNPOfPatientDoctor()) {
                                DisplayData.displayMessage(index + ". " + element + Consts.PATIENT_FAMILY_DOCTOR_MESSAGE);
                            } else {
                                DisplayData.displayMessage(index + ". " + element);
                            }
                            index++;
                        }

                        int patientOption = scanner.nextInt();
                        scanner.nextLine();

                        if (patientOption < index && patientOption != 0) {
                            doctorForConsultation = doctorList.get(patientOption - 1);

                            //poate avea o singura programare la acelasi medic(nu poate aparea de mai multe ori in coada)
                            if (doctorForConsultation.managerConsultations.validatePatientForConsultation(actualPatient)) {
                                DisplayData.displayMessage(Consts.PATIENT_YOU_ALREADY_HAVE_A_CONSULTATION);
                                isPatientMenuRunning = false;
                                break;
                            } else {
                                DisplayData.displayMessage(Consts.PATIENT_GIVE_REASON_FOR_CONSULTATION);
                                String reasonForConsultation = scanner.nextLine();

                                /**se programeaza o consultatie pt pacientul actual folosind managerul de consultatii (fiecare
                                 *doctor are un astfel de manager)
                                 */
                                Consultation consultationOfActualPatient = new Consultation(actualPatient, reasonForConsultation);
                                doctorForConsultation.managerConsultations.scheduleConsultation(consultationOfActualPatient);

                                DisplayData.displayMessage(Consts.PATIENT_YOU_HAVE_A_CONSULTATION + doctorForConsultation);
                                DisplayData.displayMessage(Consts.PATIENT_WAINT_FOR_YOUR_TURN);
                                DisplayData.newLine();
                            }
                        } else {
                            DisplayData.displayMessage(Consts.OPTION_NOT_VALID);
                            break;
                        }

                        isPatientMenuRunning = false;
                        break;
                    case 2:
                        isPatientMenuRunning = false;
                        break;
                    default:
                        DisplayData.displayMessage(Consts.OPTION_NOT_VALID);
                        isPatientMenuRunning = false;
                }
                /**
                 * dupa fiecare operatia a pacientului in meniu se revine la meniul principal
                 */
            } else {
                DisplayData.displayMessage(Consts.PATIENT_NOT_REGISTERED);
                DisplayData.newLine();
                DisplayData.displayMessage(Consts.REGISTER_PATIENT_REGISTER_ME);
                DisplayData.displayMessage(Consts.REGISTER_PATIENT_BACK_TO_MAIN_MENU);

                int userOption = scanner.nextInt();

                switch (userOption) {
                    case 1:

                        DisplayData.newLine();
                        databaseManager.registerPatient();
                        isPatientMenuRunning = false;
                        break;
                    case 2:
                        isPatientMenuRunning = false;
                        break;
                    default:
                        isPatientMenuRunning = false;

                }
            }
        }

    }
}
