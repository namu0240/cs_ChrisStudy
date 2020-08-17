package namu.alogirthm.sort;

import java.util.Arrays;

public class SortAlgorithm {
    public static void main(String[] args) {

        System.out.println("Bubble Sort");
        System.out.println(Arrays.toString(NBubbleSort.sort(new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8})));
        System.out.println("Merge Sort");
        System.out.println(Arrays.toString(NMergeSort.sort(new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8})));
        System.out.println("QuickSort");
        System.out.println(Arrays.toString(NQuickSort.sort(new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8})));
    }
}
