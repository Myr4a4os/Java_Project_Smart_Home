import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Radio;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    //      *Тесты для радиостанции*
    @Test
    public void shouldCurrentRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(5);    // задаем значение номера станции
        assertEquals(5, radio.getCurrentRadioStation());    // прнимает заданое значение
    }

    @Test
    void shouldNotSetStationBelowZero() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(-1);   // номер станции не принимает отрицательное значение
        assertEquals(0, radio.getCurrentRadioStation()); // остаётся значение по умолчанию (0)
    }

    @Test
    void shouldNotSetStationAboveNine() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(10);   //  номер станции недолжен переключиться выше, а вернуться к начальной (0)
        assertEquals(0, radio.getCurrentRadioStation()); // остаётся значение по умолчанию (0)
    }

    @Test
    public void switchToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(5);    // устанавливаем станцию 5
        radio.next();
        assertEquals(6, radio.getCurrentRadioStation());    // ожидаем станцию 6
    }

    @Test
    public void switchToNextStationFromFirst() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(0);    // устанавливаем станцию 0
        radio.next();
        assertEquals(1, radio.getCurrentRadioStation());    // ожидаем станцию 1
    }

    @Test
    public void switchToNextStationFromLast() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(9);    // устанавливаем станцию 9
        radio.next();                       //вызывается метод next, в котором указывается, что при переключении на следующую станцию, попадем на станцию 0
        assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void switchToPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(5);  // устанавливаем станцию 5
        radio.prev();                // переключаемся назад
        assertEquals(4, radio.getCurrentRadioStation()); // ожидаем станцию 4
    }

    @Test
    public void switchPrevToNull() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(1);  // устанавливаем станцию 1
        radio.prev();                // переключаемся назад
        assertEquals(0, radio.getCurrentRadioStation()); // ожидаем станцию 0
    }

    @Test
    public void switchPrevToNine() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(0);  // устанавливаем станцию 0
        radio.prev();                // переключаемся назад
        assertEquals(9, radio.getCurrentRadioStation()); // ожидаем станцию 9
    }

    @Test
    public void switchPrevToEight() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(9);  // устанавливаем станцию 9
        radio.prev();                // переключаемся назад
        assertEquals(8, radio.getCurrentRadioStation()); // ожидаем станцию 8
    }

    //      *Тесты для громкости*
    @Test
    public void shouldCurrentSoundVolume() {
        Radio radio = new Radio();
        radio.setCurrentSoundVolume(50); // устанавливаем любое значение(< 100) громкости радио
        Assertions.assertEquals(50, radio.getCurrentSoundVolume());
    }

    @Test
    public void shouldSetMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentSoundVolume(0);     // задаем минимальное значение громкости
        Assertions.assertEquals(0, radio.getCurrentSoundVolume());  // значение = 0
    }

    @Test
    public void shouldSetMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentSoundVolume(100);       // задаем максимальное значение громкости
        Assertions.assertEquals(100, radio.getCurrentSoundVolume());    //значение = 100
    }

    @Test
    public void shouldSetNegativeMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentSoundVolume(30);        // задаем начальное значение 30
        radio.setCurrentSoundVolume(-5);        //  отрицательное значние по методу игнорируется
        Assertions.assertEquals(30, radio.getCurrentSoundVolume()); // значение громкости остается начальное
    }

    @Test
    public void shouldSetNegativeMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentSoundVolume(30);        // задаем начальное значение 30
        radio.setCurrentSoundVolume(105);       // значение выше граници игнорируется
        Assertions.assertEquals(30, radio.getCurrentSoundVolume()); // значение останется начальное
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentSoundVolume(100);     //Защита от переполнения Работа на верхней границе
        radio.increaseVolume();
        Assertions.assertEquals(100, radio.getCurrentSoundVolume());    // уровень громкости не выйдет за границу значения (100)
    }

    @Test
    public void shouldVolume99() {
        Radio radio = new Radio();
        radio.setCurrentSoundVolume(99);    //Работа на верхней границе
        radio.increaseVolume();
        Assertions.assertEquals(100, radio.getCurrentSoundVolume());
    }

    @Test
    public void shouldVolume0() {
        Radio radio = new Radio();
        radio.setCurrentSoundVolume(1);     // Работа на нижней границе
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentSoundVolume());
    }

    @Test
    public void shouldDecreaseMiddleVolume() {
        Radio radio = new Radio();
        radio.setCurrentSoundVolume(50);     // Работа на нижней границе
        radio.decreaseVolume();
        Assertions.assertEquals(49, radio.getCurrentSoundVolume());
    }

    @Test
    public void shouldNotDecreaseBelowZero() {
        Radio radio = new Radio();
        radio.setCurrentSoundVolume(0);     // Работа на нижней границе
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentSoundVolume());
    }

    @Test
    public void shouldDecreaseFromMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentSoundVolume(100);     // Работа на нижней границе
        radio.decreaseVolume();
        Assertions.assertEquals(99, radio.getCurrentSoundVolume());
    }
}