package sortingAlgorithms;

import javax.sound.midi.Soundbank;
import java.util.*;

public class BubbleSorting {

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
            for (int j = 0; j < list.size()-1-i; j++) {
                int a = list.get(j);
                int b = list.get(j+1);
                if (a > b) {
                    list.set(j, b);
                    list.set(j+1, a);
                }
            }
        }
        System.out.println("After sorting");
        for (int e: list) {
            System.out.print(e + " ");
        }
    }

}
