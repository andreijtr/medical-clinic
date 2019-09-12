/**
 * Aceasta clasa creaza contextul necesar pt a putea rula aplicatia, afiseaza meniul principal:
 * 1.Sunt pacient
 * 2.Sunt medic
 * 3.Inchide aplicatia
 *
 * In functie de optiune, se apeleaza la un obiect de tip PatientMenuLogic pt a rezolva cerintele pacientului sau
 * la un obiect de tip DoctorMenuLogic pt a rezolva cerintele medicului
 *
 *Fisierele din resources contin pt PACIENT :nume, prenume, cnpPacient si cnpDoctor
 *Am pus si cnpDoctor pt ca l-am considerat medic de familie
 * Pacientul poate alege la ce medic sa faca consultatia, iar medicul de familie al pacientului este marcat in lista
 * de medici
 */

package com.sda.clinica.medicala.logic;

import com.sda.clinica.medicala.display.DisplayData;
import com.sda.clinica.medicala.doctor.Doctor;
import com.sda.clinica.medicala.patient.Patient;
import com.sda.clinica.medicala.utils.Consts;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ApplicationLogic {

    private List<Patient> patientsList;
    private List<Doctor> doctorsList;

    private DatabaseManager databaseManager;


    public ApplicationLogic() {
        databaseManager = new DatabaseManager();
        patientsList = databaseManager.getPatientsList();
        doctorsList = databaseManager.getDoctorsList();
    }

    /**
     *Pana aici am creat contextul: am citit pacientii existenti din fisier(doar ei pot face programari pana acum) si doctorii
     *Urrmeaza sa cream meniurile pt cei doi utilizatori (pacient sau doctor)
     *Ambii va trebui sa si insereze cnp-ul pentru ai cauta in "baza de date"
     *
     */

    public void runApplication() {

        PatientMenuLogic patientMenuLogic;
        DoctorMenuLogic doctorMenuLogic;

        Scanner scanner = new Scanner(System.in);
        int userOption;
        boolean isRunningMainMenu = true;
        long userCNP = 0;

        DisplayData.displayMessage(Consts.GENERAL_MESSAGE);
        DisplayData.newLine();

        while (isRunningMainMenu) {
            DisplayData.displayMessage(Consts.SELECT_OPTION);
            DisplayData.displayMainMenu();

            userOption = scanner.nextInt();

            if(userOption == 1 || userOption == 2) {
                DisplayData.displayMessage(Consts.INSERT_CNP);
                try {
                    userCNP = scanner.nextLong();
                } catch (InputMismatchException e) {
                    DisplayData.displayMessage(Consts.INSERT_CNP_WRONG);
                    e.printStackTrace();
                }
            }
            /**
             * Pana aici functioneaza pentru ambele categorii (pacient si doctor) impreuna
             *s-a primit si cnp-ul utilizatorului aplicatiei a.i. de acum sa poata fi cautat in DB si pentru celelalte
             * optiuni
             * in functie de tipul utilizatorului (pacient sau medic) se va afisa urmatorul meniu
             */

            switch (userOption) {
                case 1:
                    patientMenuLogic = new PatientMenuLogic(databaseManager, userCNP);
                    DisplayData.displayPatientMenu();

                    int patientOption = scanner.nextInt();
                    patientMenuLogic.solvePatientOption(patientOption);
                    break;

                case 2:
                    doctorMenuLogic = new DoctorMenuLogic(databaseManager, userCNP);
                    doctorMenuLogic.solveDoctorOption();
                    break;

                case 3:
                    isRunningMainMenu = false;
                    break;

                default:
                    DisplayData.displayMessage(Consts.OPTION_NOT_VALID);
            }
        }
    }
}
