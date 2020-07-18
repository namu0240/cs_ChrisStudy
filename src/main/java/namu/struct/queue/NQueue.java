package namu.struct.queue;

public interface NQueue {

    int pop();

    void push(int value);

    int peek();

    boolean isEmpty();

    boolean isFull();

    int getSize();

}
