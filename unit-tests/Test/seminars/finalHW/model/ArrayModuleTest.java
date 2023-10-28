package seminars.finalHW.model;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArrayModuleTest {

    ArrayModule arrayModule;
    Random rnd;
    int minValue;
    int maxValue;

    @BeforeEach
    void setup() {
        arrayModule = new ArrayModule();
        rnd = new Random();
        minValue = rnd.nextInt(100);
        maxValue = minValue + rnd.nextInt(100);
    }

    @RepeatedTest(10)
    void checkArrayIsNotEmpty() {
        int size = rnd.nextInt(100);

        int[] array = arrayModule.fillArray(size, maxValue, minValue);
        // Проверяем массив на то, что он не пустой
        assertThat(array).isNotEmpty();
    }

    @RepeatedTest(10)
    void fillArray() {
        int size = 5;
        // Проверяем, что создан массив нужного размера
        assertThat(arrayModule.fillArray(size, maxValue, minValue).length).isSameAs(5);
    }

    @RepeatedTest(10)
    void fillArrayThenMinMaxEqual() {
        int size = rnd.nextInt(100);
        // Проверяем, что при тестировании обеспечивается положительное значение bound передаваемое в Random
        assertThat(arrayModule.fillArray(size, maxValue, maxValue)).isNotEmpty();
    }

    @Test
    void averageValueTypeOverFlow() {
        int[] array = new int[]{Integer.MAX_VALUE, 1};
        // Проверяем поведение программы в процессе суммирования для расчета среднего на переполнение типа int.
        assertThatThrownBy(() -> arrayModule.averageValue(array))
                .isInstanceOf(ArithmeticException.class);
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
        // Проверяем сравнение средних значений
        assertThat(arrayModule.compareAverages(average1, average1))
                .isEqualTo("Средние значения равны");
    }
}