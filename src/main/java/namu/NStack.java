package namu;

import java.util.ArrayList;
import java.util.List;

public class NStack<T> {

    private int size;
    private int sp;
    private T[] array;

    public NStack(int size) {
        this.size = size;
        this.sp = -1;
        this.array = (T[]) new Object[size];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return sp < 0;
    }

    public boolean isFull() {
        return sp >= size;
    }

    public int getSp() {
        return sp;
    }

    public T[] getArray() {
        return array.clone();
    }

    public T getTop() {
        if (isEmpty()) {
            return null;
        }
        return array[sp];
    }

    public T get(int index) {
        return array[index];
    }

    public void push(T data) {
        array[++sp] = data;
    }

    public T pop() {
        return array[sp--];
    }

    @Override
    public String toString() {
        List<T> tList = new ArrayList<>();
        for (T t : array) {
            if (t == null) {
                break;
            }
            tList.add(t);
        }
        return "NStack{" +
                "size=" + size +
                ", sp=" + sp +
                ", array=" + tList +
                '}';
    }

    public NStack<T> reverse() {
        NStack<T> reverseStack = new NStack<>(size);
        while(!isEmpty()) {
            reverseStack.push(pop());
        }
        return reverseStack;
    }
}
