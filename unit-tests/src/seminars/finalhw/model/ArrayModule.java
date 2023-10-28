package seminars.finalhw.model;

import java.util.Random;

public class ArrayModule {

    private Random rnd = new Random();

    public int[] fillArray(final int size, int maxValue, final int minValue) {

        if (maxValue == minValue) {
            maxValue += 10;
        }

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rnd.nextInt(maxValue - minValue) + minValue;
        }
        return array;
    }

    public double averageValue(final int[] arr) {
        int sum = 0;
        int count = arr.length;
        for (int digit : arr) {
            sum = Math.addExact(sum, digit);
        }
        return (double) sum / count;
    }

    public String compareAverages(final double aver1, final double aver2) {
        if (aver1 > aver2) {
            return "Первый список имеет большее среднее значение";
        } else if (aver2 > aver1) {
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }
}
