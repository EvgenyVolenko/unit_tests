package seminars.finalhw.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.finalhw.model.ArrayModule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ControllerTest {

    int size;
    int maxValue;
    int minValue;
    int[] array;
    double average;
    ArrayModule arrayModule;
    Controller controller;

    @BeforeEach
    void setUp() {
        size = 5;
        maxValue = 5;
        minValue = 1;
        array = new int[]{1, 2, 3, 4, 5};
        average = 3;
        arrayModule = mock(ArrayModule.class);
        controller = new Controller(arrayModule);
    }

    @Test
    void fillArrayControllerTest() {
    // Проверяем, что контроллер корректно работает, транслирует создание массива нужного размера.
        when(arrayModule.fillArray(size, maxValue, minValue)).thenReturn(array);

        int[] newArray = controller.fillArrayController(5, 5, 1);

        verify(arrayModule, times(1)).fillArray(5, 5, 1);
        assertThat(newArray.length).isSameAs(5);
    }

    @Test
    void averageValueControllerTest() {
    // Проверяем, что контроллер корректно работает, транслирует расчет среднего значение.
        when(arrayModule.averageValue(array)).thenReturn(average);

        double newAverage = controller.averageValueController(array);

        verify(arrayModule, times(1)).averageValue(array);
        assertThat(newAverage).isEqualTo(average);
    }

    @Test
    void compareAveragesControllerTest(){
    // Проверяем, что контроллер корректно работает, транслирует сравнение средних и выдает верное сообщение.
        double newAverage = 3.01;

        when(arrayModule.compareAverages(average, newAverage))
                .thenReturn("Второй список имеет большее среднее значение");

        String request = controller.compareAveragesController(average, newAverage);

        verify(arrayModule, times(1)).compareAverages(average, newAverage);
        assertThat(request).isEqualTo("Второй список имеет большее среднее значение");
    }
}