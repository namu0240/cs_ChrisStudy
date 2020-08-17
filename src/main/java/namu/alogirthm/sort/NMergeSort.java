package namu.alogirthm.sort;

public class NMergeSort {

    public static int[] sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (right + left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int leftPos = left;
        int rightPos = mid + 1;
        int index = left;
        int[] sorted = new int[array.length]; // 정렬된 배열 저장

        // 두개의 어레이를 비교 하면서 정렬
        while (leftPos <= mid && rightPos <= right) {
            if (array[leftPos] <= array[rightPos]) {
                sorted[index++] = array[leftPos++];
            } else {
                sorted[index++] = array[rightPos++];
            }
        }

        // 잔여 값이 있을 경우 한꺼번에 이동
        if (leftPos <= mid) {
            for (int i = leftPos; i <= mid; i++) {
                sorted[index++] = array[i];
            }
        }

        if (rightPos <= right) {
            for (int i = rightPos; i <= right; i++) {
                sorted[index++] = array[i];
            }
        }

        if (right - left >= 0) System.arraycopy(sorted, left, array, left, right - left + 1);
    }

}
