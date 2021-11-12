package sortingAlgorithms;

import java.time.Instant;
import java.util.*;

public class CompareAlgorithmSpeed {

    public static void main(String[] args) {
        List<Integer> listBubble = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            listBubble.add(new Random().nextInt(500));
        }

        List<Integer> listSelection = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            listBubble.add(new Random().nextInt(500));
        }

        List<Integer> listQuick = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            listQuick.add(new Random().nextInt(500));
        }

        long startBubble = Instant.now().getEpochSecond();
        bubbleSort(listBubble);
        long finishBubble = Instant.now().getEpochSecond();
        long bubbleSpeed = finishBubble - startBubble;
        System.out.println("Bubble sort speed: " + bubbleSpeed);

        long startSelection = Instant.now().getEpochSecond();
        selectionSort(listSelection);
        long finishSelection = Instant.now().getEpochSecond();
        long selectionSpeed = finishSelection - startSelection;
        System.out.println("Selection sort speed: " + selectionSpeed);

        long startQuickSort = Instant.now().getEpochSecond();
        Collections.sort(listQuick);
        long finishQuickSort = Instant.now().getEpochSecond();
        long speedQuickSort = finishQuickSort - startQuickSort;
        System.out.println("Quick sort speed: " + speedQuickSort);



    }

    public static List<Integer> bubbleSort(List<Integer> list) {
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
        return list;
    }

    public static List<Integer> selectionSort(List<Integer> list) {
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
        return list;
    }

}
