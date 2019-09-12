/**
 Aceasta clasa se ocupa cu controlul consultatiilor unui medic.
 Astfel fiecare medic are un "manager de consultatii" care poate adauga o connsultatie in coada(programare consutatie,
 sterge o consultatie din coada (ofera consultatie), si sa verifice consultatiile de astazi.(cele ramase nefacute)
 */

package com.sda.clinica.medicala.consultation;

import com.sda.clinica.medicala.display.DisplayData;
import com.sda.clinica.medicala.patient.Patient;
import com.sda.clinica.medicala.utils.Consts;

import java.util.LinkedList;
import java.util.Queue;

public class ManagerConsultations {

    private Queue<Consultation> consulatationsWaitingQueue;

    /**
     *Am folosit o coada de asteptare pentru a ilustra coada la cabinetul unui medic:
     * primul pacient care vine, se aseaza in coada de asteptare si asteapta sa-l primeasca doctorul (offerConsulation)
     * urmatorii se aseaza in coada si isi astepta randul.
     */

    public ManagerConsultations() {
        this.consulatationsWaitingQueue = new LinkedList<>();
    }

    public void scheduleConsultation(Consultation consultation) {
        consulatationsWaitingQueue.add(consultation);
    }

    /**
     *dupa fiecare consultatie se sterge primul pacient din coada.
     */

    public void offerConsultation() {
        if (consulatationsWaitingQueue.isEmpty()) {
            DisplayData.displayMessage(Consts.NO_CONSULTATION_IN_QUEUE);
        } else {
            DisplayData.displayMessage(Consts.CHOOSE_CONSULTATION);
            DisplayData.newLine();
            try {
                Thread.sleep(1000);

                DisplayData.displayMessage(Consts.CONSULTATION_IN_PROGRESS);
                DisplayData.newLine();
                Thread.sleep(2000);

                consulatationsWaitingQueue.remove();

                DisplayData.displayMessage(Consts.CONSULTATION_FINISH);
                Thread.sleep(1000);
                DisplayData.newLine();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    /**
     Se afiseaza toate consultatiile ramase (din coada)
     */

    public void checkConsultations() {
        int numberOfConsultations = this.consulatationsWaitingQueue.size();

        DisplayData.displayMessage(Consts.NUMBER_OF_CONSULTATION + numberOfConsultations);
        DisplayData.newLine();
        if (numberOfConsultations == 0) {
            DisplayData.displayMessage(Consts.NO_CONSULTATION_IN_QUEUE);
        } else {
            int i = 1;
            for (Consultation element : consulatationsWaitingQueue) {
                System.out.print(i + ". ");
                DisplayData.displayConsultation(element);
                i++;
            }
        }
        DisplayData.newLine();
    }

    public boolean validatePatientForConsultation(Patient patient) {
        boolean hasConsultation = false;

        for (Consultation c : consulatationsWaitingQueue) {
            if (c.getPatient().equals(patient)) {
                hasConsultation = true;
                break;
            }
        }

        return hasConsultation;
    }
}
