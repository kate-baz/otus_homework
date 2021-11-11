package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new Random().nextInt(500));
        }
        System.out.println("Before sorting");
        for (int e: list) {
            System.out.print(e + " ");
        }
        System.out.println("");

        for (int i = 0; i < list.size()-1; i++) {
            int minElementIndex = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) < list.get(minElementIndex)) {
                    minElementIndex = j;
                }
            }
            int min = list.get(minElementIndex);
            list.set(minElementIndex, list.get(i));
            list.set(i, min);
        }


        System.out.println("After sorting");
        for (int e: list) {
            System.out.print(e + " ");
        }
    }
}
