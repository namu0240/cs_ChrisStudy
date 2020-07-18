package namu.struct.queue;

import namu.struct.heap.NMinHeap;

public class NPriorityQueue implements NQueue {

    private NMinHeap nMinHeap;

    public NPriorityQueue(int size) {
        this.nMinHeap = new NMinHeap(size);
    }

    @Override
    public int pop() {
        return nMinHeap.remove();
    }

    @Override
    public void push(int value) {
        nMinHeap.add(value);
    }

    @Override
    public int peek() {
        return nMinHeap.peak();
    }

    @Override
    public boolean isEmpty() {
        return nMinHeap.isEmpty();
    }

    @Override
    public boolean isFull() {
        return nMinHeap.isFull();
    }

    @Override
    public int getSize() {
        return nMinHeap.getSize();
    }
}
