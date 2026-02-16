package ru.netology.javaqa;

public class Radio {
    private int currentRadioStation;
    private int currentSoundVolume;

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int newCurrentRadioStation) {
        if (newCurrentRadioStation < 0) {
            return;
        }
        if (newCurrentRadioStation > 9) {
            return;
        }
        currentRadioStation = newCurrentRadioStation;
    }

    public void next() {
        if (currentRadioStation == 9) {
            currentRadioStation = 0;
        } else currentRadioStation++;
    }

    public void prev() {
        if (currentRadioStation == 0) {
            currentRadioStation = 9;
        } else currentRadioStation--;
    }

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

    public void dereaseVolume() {
        if (currentSoundVolume > 0) {
            currentSoundVolume--;
        }
    }
}

