package namu.struct.heap;

public class HeapGround {

    public static void main(String[] args) {
        runMinHeap();
        System.out.println("");
        runMaxHeap();
    }

    private static void runMinHeap() {
        System.out.println("===== [ MinHeap ] =====");

        NMinHeap nMinHeap = new NMinHeap(15);

        for (int i = 1; i < 12; i++) {
            nMinHeap.add(i);
        }

        nMinHeap.print();
        System.out.println("heap min value is = [" + nMinHeap.peak() + "]");
        System.out.println(" ");

        for (int i = 1; i < 6; i++) {
            nMinHeap.remove();
        }

        nMinHeap.print();
        System.out.println("heap min value is = [" + nMinHeap.peak() + "]");
    }

    private static void runMaxHeap() {
        System.out.println("===== [ MaxHeap ] =====");

        NMaxHeap nMaxHeap = new NMaxHeap(15);

        for (int i = 1; i < 12; i++) {
            nMaxHeap.add(i);
        }

        nMaxHeap.print();
        System.out.println("heap max value is = [" + nMaxHeap.peak() + "]");
        System.out.println(" ");

        for (int i = 1; i < 6; i++) {
            nMaxHeap.remove();
        }

        nMaxHeap.print();
        System.out.println("heap max value is = [" + nMaxHeap.peak() + "]");

    }

}
