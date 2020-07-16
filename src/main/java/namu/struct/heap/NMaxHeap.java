package namu.struct.heap;


public class NMaxHeap implements NHeap {

    private static final int FRONT = 1;

    int[] array;
    int size = 0;

    public NMaxHeap(int arraySize) {
        this.array = new int[arraySize + 1];
        this.array[0] = Integer.MAX_VALUE;
    }

    @Override
    public int remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("heap is empty");
        }
        int popValue = array[FRONT];
        array[FRONT] = array[size--];
        heapDown(FRONT);
        return popValue;
    }

    @Override
    public int peak() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("heap is empty");
        }
        return array[FRONT];
    }

    @Override
    public void add(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("heap is full");
        }
        array[++size] = value;
        heapUp();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return array.length == size;
    }

    @Override
    public int getParent(int index) {
        return index / 2;
    }

    @Override
    public boolean hasLeftNode(int index) {
        int leftNode = index * 2;
        return leftNode >= 0 && leftNode <= size;
    }

    @Override
    public int getLeftNode(int index) {
        return index * 2;
    }

    @Override
    public boolean hasRightNode(int index) {
        int rightNode = (index * 2) + 1;
        return rightNode >= 0 && rightNode <= size;
    }

    @Override
    public int getRightNode(int index) {
        return (index * 2) + 1;
    }

    @Override
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" PARENT : ").append(array[i]);
            if (2 * i < size) {
                stringBuilder.append(" LEFT CHILD : ").append(array[2 * i]);
            }
            if (2 * i + 1 < size) {
                stringBuilder.append(" RIGHT CHILD : ").append(array[2 * i + 1]);
            }
            System.out.println(stringBuilder.toString());
        }
        System.out.println();
    }

    @Override
    public void heapUp() {
        int current = size;

        while (array[current] > array[getParent(current)]) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    @Override
    public void heapDown(int index) {
        while (hasLeftNode(index)) {

            // 우선 좌측 노드가 가장 작다고 생각
            int minIndex = getLeftNode(index);

            // 만약 우측 노드가 있고 우측 노드가 더 크다면 최소 인덱스 변경
            if (hasRightNode(index) && array[getLeftNode(index)] < array[getRightNode(index)]) {
                minIndex = getRightNode(index);
            }

            // 현재 노드의 값과 변경할 노드의 값을 비교하여 비교할 노드의 값이 더 작으면 종료
            if (array[index] > array[minIndex]) {
                break;
            }

            // 변경 후 인덱스 이동
            swap(index, minIndex);
            index = minIndex;
        }
    }

    private void swap(int fIndex, int bIndex) {
        int temp = array[fIndex];
        array[fIndex] = array[bIndex];
        array[bIndex] = temp;
    }
}
