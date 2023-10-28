package seminars.finalhw;

import seminars.finalhw.controllers.Controller;
import seminars.finalhw.model.ArrayModule;

import java.util.Arrays;

public class Main {

    public static void main(final String[] args) {

        ArrayModule arrayModule = new ArrayModule();
        Controller controller = new Controller(arrayModule);

        int size = 11;
        int maxValue = 120;
        int minValue = 10;

        int[] array1 = controller.fillArrayController(size, maxValue, minValue);
        double average1 = controller.averageValueController(array1);
        int[] array2 = controller.fillArrayController(size, maxValue, minValue);
        double average2 = controller.averageValueController(array2);

        System.out.println("Первый массив: " + Arrays.toString(array1));
        System.out.printf("Среднее значение первого массива: %.3f%n", average1);
        System.out.println("Второй массив: " + Arrays.toString(array2));
        System.out.printf("Среднее значение второго массива: %.3f%n", average2);

        System.out.println(controller.compareAveragesController(average1, average2));
    }
}
