package com.sda.clinica.medicala.observer;

public interface Subject {

    public void registerObserver();
    public void removeObserver();
    public void notifyObservers();
}
