package namu.struct.heap;

public interface NHeap {

    int remove();

    int peak();

    void add(int value);

    boolean isEmpty();

    boolean isFull();

    int getParent(int index);

    boolean hasLeftNode(int index);

    int getLeftNode(int index);

    boolean hasRightNode(int index);

    int getRightNode(int index);

    void heapUp();

    void heapDown(int index);

    void print();

    int getSize();

}
