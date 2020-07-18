package namu.struct.queue;

import java.util.Random;

public class QueueGround {
    public static void main(String[] args) {
        NPriorityQueue nPriorityQueue = new NPriorityQueue(10);
        Random random = new Random();

        while (!nPriorityQueue.isFull()) {
            int value = random.nextInt(Integer.MAX_VALUE);
            nPriorityQueue.push(value);
            System.out.println("push() value is " + value);
        }

        while (!nPriorityQueue.isEmpty()) {
            int value = nPriorityQueue.pop();
            System.out.println("pop() return is " + value);
        }
    }
}
