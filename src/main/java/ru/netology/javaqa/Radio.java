package ru.netology.javaqa;

public class Radio {

    private int minRadioStation = 0;
    private int maxRadioStation = 9;
    private int currentRadioStation = minRadioStation;

    //    public Radio(int minRadioStation, int maxRadioStation) {
//        this.minRadioStation = minRadioStation;
//        this.maxRadioStation = maxRadioStation;
//        this.currentRadioStation = minRadioStation;
//    }
    public Radio() {
        this.minRadioStation = minRadioStation;
        this.maxRadioStation = maxRadioStation;
        this.currentRadioStation = currentRadioStation;

    }

    public Radio(int size) {
        this.maxRadioStation = size - 1;
    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public int getMinRadioStation() {
        return minRadioStation;
    }

    public int getMaxRadioStation() {
        return maxRadioStation;
    }


    //                              * Методы на станции *
    public void setCurrentRadioStation(int newCurrentRadioStation) {
        if (newCurrentRadioStation < minRadioStation) {
            return;
        }
        if (newCurrentRadioStation > maxRadioStation) {
            return;
        }
        currentRadioStation = newCurrentRadioStation;
    }

    public void next() {
        if (currentRadioStation == maxRadioStation) {       // если достигли максимума →
            currentRadioStation = minRadioStation;          // переключится на минимум
        } else {
            currentRadioStation++;                          // иначе, переход по возрастанию
        }
    }

    public void prev() {
        if (currentRadioStation == minRadioStation) {       // если достигли минимума →
            currentRadioStation = maxRadioStation;          // переключится на максимум
        } else {
            currentRadioStation--;                          // иначе, переход на уменьшение
        }
    }

    //                              * Методы на громкость *

    private int currentSoundVolume = 0;

    public int getCurrentSoundVolume() {
        return currentSoundVolume;
    }

    public void setCurrentSoundVolume(int newCurrentSoundVolume) {
        if (newCurrentSoundVolume < 0) {
            return;
        }
        if (newCurrentSoundVolume > 100) {
            return;
        }
        currentSoundVolume = newCurrentSoundVolume;
    }

    public void increaseVolume() {
        if (currentSoundVolume < 100) {
            currentSoundVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentSoundVolume > 0) {
            currentSoundVolume--;
        }
    }
}

