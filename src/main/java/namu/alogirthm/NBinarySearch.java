package namu.alogirthm;

public class NBinarySearch {

    public static void main(String[] args) {

        int[] array = new int[]{1, 5, 8, 14, 17, 20, 21, 24, 30, 37};

        System.out.println(nBinarySearch(array, 30, 0, array.length));

    }

    public static int nBinarySearch(int[] array, int search, int start, int end) {
        System.out.println("nBinarySearch() called with: search = [" + search + "], start = [" + start + "], end = [" + end + "]");

        int mid = (end - start) / 2 + start;

        // 검색값이 중간값과 같다면
        if (search == array[mid]) {
            System.out.println(String.format("array[%d] is %d", mid, search));
            return mid;
        }

        // 검색값이 중간값보다 작다면
        if (search < array[mid]) {
            return nBinarySearch(array, search, start, mid);
        }

        // 검색값이 중간값보다 크다면
        return nBinarySearch(array, search, mid, end);

    }

}
