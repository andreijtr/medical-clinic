/**
 *Un obiect de acest tip afiseaza si rezolva optiunile medicului
 */

package com.sda.clinica.medicala.logic;

import com.sda.clinica.medicala.display.DisplayData;
import com.sda.clinica.medicala.doctor.Doctor;
import com.sda.clinica.medicala.utils.Consts;

import java.util.List;
import java.util.Scanner;

public class DoctorMenuLogic {

    private List<Doctor> doctorList;
    private Scanner scanner;
    private DatabaseManager databaseManager;

    private long CNP;

    public DoctorMenuLogic(DatabaseManager databaseManager, long CNP) {
        this.scanner = new Scanner(System.in);
        this.CNP = CNP;
        this.databaseManager = databaseManager;
        this.doctorList = databaseManager.getDoctorsList();
    }

    /**
     *Doctorul daca va fi gasit in DB va putea
     * 1. sa vada ce consultatii mai sunt de facut astazi
     * 2.sa ofera o consultatie (dureaza 3 sec)
     * 3. sa revina la meniul principal
     */

    public void solveDoctorOption() {
        boolean isDoctorMenuRunning = true;

        boolean isDoctorInList = false;
        Doctor actualDoctor = null;

        for (Doctor element : doctorList) {
            if (element.getCNP() == this.CNP) {
                actualDoctor = element;
                isDoctorInList = true;
                break;
            }
        }
        /**
         *daca doctorul a fost gasit in lista, se va afisa meniul medicului iar el va putea interactiona cu el pana cand
         * decide sa paraseasca aplicatia
         * pentru ca:  intai poate verifica ce consultatii mai are,
         *              apoi poate alege sa faca una sau mai multe(nu simultan)
         * de aceea meniul ramane afisat pana cand decide sa revina la meniul principal
         * in functie de alegerea doctorului, se apeleaza la variabila de instanta "managerul de consultatii" pentru a
         * opera cerintele
         */
        if(isDoctorInList) {
            while (isDoctorMenuRunning) {
                DisplayData.displayMessage(Consts.SELECT_OPTION);
                DisplayData.displayDoctorMenu();

                int doctorOption = scanner.nextInt();
                switch (doctorOption) {
                    case 1:
                        actualDoctor.managerConsultations.checkConsultations();
                        break;

                    case 2:
                        actualDoctor.managerConsultations.offerConsultation();
                        break;

                    case 3:
                        isDoctorMenuRunning = false;
                        break;

                    default:
                        DisplayData.displayMessage(Consts.OPTION_NOT_VALID);
                }
            }
        } else {
            DisplayData.displayMessage(Consts.DOCTOR_NOT_REGISTERED);
        }
    }

}
