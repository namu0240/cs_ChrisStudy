package namu.alogirthm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanTree {

    public static void main(String[] args) {

        algorithm("안녕하세요");
        algorithm("asdfsadfadsfsa");

    }

    private static void algorithm(String input) {

        // input
        HashMap<Character, Integer> dictionary = new HashMap<>();
        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>(new FrequencyComparator());

        for (char c : input.toCharArray()) {
            if (dictionary.containsKey(c)) {
                dictionary.put(c, dictionary.get(c) + 1);
                continue;
            }
            dictionary.put(c, 1);
        }

        for (Character character : dictionary.keySet()) {
            nodePriorityQueue.add(new Node(character, dictionary.get(character), null, null));
        }

        // doing
        while (nodePriorityQueue.size() != 1) {
            Node firstNode = nodePriorityQueue.poll();
            Node secondNode = nodePriorityQueue.poll();
            nodePriorityQueue.add(new Node(null, firstNode.getFrequency() + secondNode.getFrequency(), firstNode, secondNode));
        }
        makeTable(nodePriorityQueue.peek(), "");

        // print
        for (char c : input.toCharArray()) {
            System.out.print(charToBinaryCode.get(c) + " ");
        }
        System.out.println();

    }

    private static HashMap<Character, String> charToBinaryCode = new HashMap<>();

    private static void makeTable(Node rootNode, String binary) {

        if (rootNode == null) {
            return;
        }

        makeTable(rootNode.getLeft(), binary + '0');
        makeTable(rootNode.getRight(), binary + '1');

        if (rootNode.getCharacter() != null) {
            System.out.println(rootNode.getCharacter() + ":" + binary);
            charToBinaryCode.put(rootNode.getCharacter(), binary);
        }

    }

}

class Node {
    private Character character;
    private Integer frequency;
    private Node left, right;

    public Node(Character character, Integer frequency, Node left, Node right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public Character getCharacter() {
        return character;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "character=" + character +
                ", frequency=" + frequency +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class FrequencyComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.getFrequency() - o2.getFrequency();
    }
}