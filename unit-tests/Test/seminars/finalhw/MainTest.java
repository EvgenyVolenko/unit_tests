package seminars.finalhw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.finalhw.controllers.Controller;
import seminars.finalhw.model.ArrayModule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MainTest {

    int size;
    int maxValue;
    int minValue;
    int[] array;
    int[] array1;
    double average;
    ArrayModule arrayModule;
    Controller controller;

    @BeforeEach
    void setUp() {
        size = 5;
        maxValue = 5;
        minValue = 1;
        array = new int[]{1, 2, 3, 4, 5};
        array1 = new int[]{6, 7, 8, 9, 10};
        average = 3;
        arrayModule = new ArrayModule();
        controller = new Controller(arrayModule);
    }

    @Test
    void integrationFillArray() {
        int[] newArray = controller.fillArrayController(5, 5, 1);

        assertThat(newArray.length).isSameAs(5);
    }

    @Test
    void integrationAverage() {
        double newAverage = controller.averageValueController(array);

        assertThat(newAverage).isEqualTo(average);
    }

    @Test
    void integrationCompare() {
        String str = controller.compareAveragesController(controller.averageValueController(array),
                controller.averageValueController(array1));

        assertThat(str).isEqualTo("Второй список имеет большее среднее значение");
    }
}