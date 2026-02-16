import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Radio;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    //      *Тесты для радиостанции*
    @Test
    public void shouldCurrentRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(5);
        assertEquals(5, radio.getCurrentRadioStation());
    }

    @Test
    void shouldNotSetStationBelowZero() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(-1);
        assertEquals(0, radio.getCurrentRadioStation()); // остаётся значение по умолчанию (0)
    }

    @Test
    void shouldNotSetStationAboveNine() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(10);
        assertEquals(0, radio.getCurrentRadioStation()); // остаётся значение по умолчанию (0)
    }

    @Test
    public void switchToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(5);    // устанавливаем станцию 5
        radio.next();
        assertEquals(6, radio.getCurrentRadioStation());
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
        assertEquals(0, radio.getCurrentRadioStation()); // ожидаем станцию 4
    }

    //      *Тесты для громкости*
    @Test
    public void shouldCurrentSoundVolume() {
        Radio radio = new Radio();
        radio.setCurrentSoundVolume(50); // устанавливаем любое значение(< 100) громкости радио
        Assertions.assertEquals(50, radio.getCurrentSoundVolume());
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentSoundVolume(100);     //Защиту от переполненияРабота на верхней границе
        radio.increaseVolume();
        Assertions.assertEquals(100, radio.getCurrentSoundVolume());
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
        radio.dereaseVolume();
        Assertions.assertEquals(0, radio.getCurrentSoundVolume());
    }
}