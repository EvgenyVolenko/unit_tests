package seminars.finalHW.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ArrayModuleTest {

    ArrayModule arrayModule;
    Random rnd;

    @BeforeEach
    void setup() {
        arrayModule = new ArrayModule();
        rnd = new Random();
    }

    @Test
    void fillArray() {
        int size = 5;
        int minValue = rnd.nextInt(100);
        int maxValue = minValue + rnd.nextInt(100);
        // Проверяем, что создан массив нужного размера
        assertThat(arrayModule.fillArray(size, maxValue, minValue).length).isEqualTo(5);
    }

    @Test
    void averageValue() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        // Проверяем расчет среднего значения
        assertThat(arrayModule.averageValue(array)).isEqualTo(3);
    }

    @Test
    void compareAveragesA1MoreA() {
        double average = Math.random() * rnd.nextInt(1000);
        double average1 = average + Math.random() * rnd.nextInt(1000);
        // Проверяем сравнение средних значений
        assertThat(arrayModule.compareAverages(average, average1))
                .isEqualTo("Второй список имеет большее среднее значение");
    }

    @Test
    void compareAveragesAMoreA1() {
        double average1 = Math.random() * rnd.nextInt(1000);
        double average = average1 + Math.random() * rnd.nextInt(1000);
        // Проверяем сравнение средних значений
        assertThat(arrayModule.compareAverages(average, average1))
                .isEqualTo("Первый список имеет большее среднее значение");
    }

    @Test
    void compareAveragesAEquallyA1() {
        double average1 = Math.random() * rnd.nextInt(1000);
        double average = average1;
        // Проверяем сравнение средних значений
        assertThat(arrayModule.compareAverages(average, average1))
                .isEqualTo("Средние значения равны");
    }
}