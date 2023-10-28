package seminars.finalHW.model;

import java.util.Random;

public class ArrayModule {

    public int[] fillArray(int size, int maxValue, int minValue) {
        Random rnd = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rnd.nextInt(maxValue - minValue) + minValue;
        }
        return array;
    }

    public double averageValue(int[] arr){
        int sum = 0;
        int count = arr.length;
        for (int i = 0; i < count; i++) {
            sum = Math.addExact(sum, arr[i]);
        }
        return (double) sum / count;
    }

    public String compareAverages(double average1, double average2){
        if (average1 > average2) {
            return "Первый список имеет большее среднее значение";
        } else if (average2 > average1){
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }
}
