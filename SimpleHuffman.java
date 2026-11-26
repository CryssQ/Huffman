
package task10;

import java.util.*;

public class SimpleHuffman {
    public static Map<Character, Integer> getFrequencies(String text) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : text.toCharArray()) {
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }
        return freq;
    }

    public static Node buildTree(Map<Character, Integer> freq) {

        PriorityQueue<Node> queue = new PriorityQueue<>(
                (a, b) -> a.freq - b.freq);

        for (char c : freq.keySet()) {
            queue.add(new Node(c, freq.get(c)));
        }

        while (queue.size() > 1) {

            Node left = queue.poll();
            Node right = queue.poll();

            Node parent = new Node(
                    left.freq + right.freq,
                    left,
                    right);

            queue.add(parent);
        }

        return queue.poll();
    }

    public static void buildCodes(
            Node node,
            String code,
            Map<Character, String> codes) {

        if (node == null) {
            return;
        }

        if (node.isLeaf()) {
            codes.put(node.ch, code);
            return;
        }

        buildCodes(node.left, code + "0", codes);
        buildCodes(node.right, code + "1", codes);
    }

    public static String encode(
            String text,
            Map<Character, String> codes) {

        String result = "";

        for (char c : text.toCharArray()) {
            result += codes.get(c);
        }

        return result;
    }

    public static String decode(String bits, Node root) {

        String result = "";
        Node current = root;

        for (char bit : bits.toCharArray()) {

            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.isLeaf()) {
                result += current.ch;
                current = root;
            }
        }

        return result;
    }

    public static int uniformLength(String text, int uniqueCount) {

        int bitsPerChar = 0;
        int count = 1;

        while (count < uniqueCount) {
            count *= 2;
            bitsPerChar++;
        }

        return text.length() * bitsPerChar;
    }
}
