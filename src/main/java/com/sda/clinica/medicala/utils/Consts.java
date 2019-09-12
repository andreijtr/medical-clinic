package com.sda.clinica.medicala.utils;

public interface Consts {


    /**
     *mesaje generale
     */
    String GENERAL_MESSAGE = "Bine ati venit la clinica SDA!";
    String INSERT_CNP = "Introduceti CNP-ul dvs: ";
    String INSERT_CNP_WRONG = "CNP-ul introdus nu este valid";


    /**
     *mesaje OPTION
     */
    String SELECT_OPTION = "Selectati optiunea dorita:";
    String OPTION_NOT_VALID = "Optiunea selectata nu este valida!";

    /**
     *cai catre fisiere
     */
    public final static String PATH_TO_PATIENTS_FILE = "C:\\SSD\\JAVA\\ClinicaMedicala\\src\\main\\resources\\patients.txt";
    String PATH_TO_DOCTORS_FILE = "C:\\SSD\\JAVA\\ClinicaMedicala\\src\\main\\resources\\doctors.txt";

    /**
     *mesaje manager consultatii
     */
    String NO_CONSULTATION_IN_QUEUE = "Nu exista consultatii programate in acest moment!";
    String CHOOSE_CONSULTATION = "Ati ales sa oferiti o consultatie.";
    String CONSULTATION_IN_PROGRESS = "Consultatia este in desfasurare...";
    String CONSULTATION_FINISH = "Consultatia s-a terminat!";
    String NUMBER_OF_CONSULTATION = "Numarul de consultatii ramase: ";

    /**
     *mesaje meniu principal
     */
    String MAIN_MENU_FOR_PATIENT = "1.Sunt pacient";
    String MAIN_MENU_FOR_DOCTOR = "2.Sunt medic";
    String MAIN_MENU_EXIT_APPLICATION = "3.Inchide aplicatia";


    /**
     *mesaje meniu pacient
     */
    String PATIENT_MENU_SCHEDULE_CONSULTATION = "1.Programeaza o consultatie";
    String PATIENT_MENU_BACK_TO_MAIN_MENU = "2.Inapoi la meniul principal";
    String PATIENT_NOT_REGISTERED = "Nu v-am gasit in baza de date!";
    String PATIENT_REGISTERED = "V-am gasit in baza de date!";
    String PATIENT_GIVE_REASON_FOR_CONSULTATION = "Care este motivul consultatiei?";
    String PATIENT_YOU_HAVE_A_CONSULTATION = "Felicitari! Ati programat o consultatie la medicul ";
    String PATIENT_WAINT_FOR_YOUR_TURN = "Asteptati-va randul";

    /**
     *mesaje meniu doctor
     */
    String DOCTOR_MENU_CHECK_CONSULTATIONS = "1.Vezi consultatiile de astazi";
    String DOCTOR_MENU_OFFER_CONSULTATION= "2.Ofera o consultatie";
    String DOCTOR_MENU_BACK_TO_MAIN_MENU = "3.Inapoi la meniul principal";
    String DOCTOR_NOT_REGISTERED = "Nu v-am gasit in baza de date!";

    /**
     *mesaje inregistrare pacient
     */
    String REGISTER_PATIENT_REGISTER_ME = "1.Inregistreaza-ma ";
    String REGISTER_PATIENT_BACK_TO_MAIN_MENU = "2.Inapoi la meniul principal";
    String REGISTER_PATIENT_GIVE_FIRST_NAME = "Introducteti prenumele dvs: ";
    String REGISTER_PATIENT_GIVE_LAST_NAME = "Introducteti numele dvs: ";
    String REGISTER_PATIENT_GIVE_CNP = "Introducteti CNP-ul dvs: ";
    String REGISTER_PATIENT_CHOOSE_DOCTOR = "Alegeti doctorul de familie din lista: ";
    String REGISTER_PATIENT_DOCTOR_SPECIALIZATION = "generala";


}
