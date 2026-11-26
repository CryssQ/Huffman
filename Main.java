package task10;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "абабагаламага";

        Map<Character, Integer> freq = SimpleHuffman.getFrequencies(text);
        Node root = SimpleHuffman.buildTree(freq);

        Map<Character, String> codes = new HashMap<>();
        SimpleHuffman.buildCodes(root, "", codes);

        String encoded = SimpleHuffman.encode(text, codes);
        String decoded = SimpleHuffman.decode(encoded, root);

        int huffmanBits = encoded.length();
        int uniformBits = SimpleHuffman.uniformLength(text, freq.size());

        System.out.println("Коди: " + codes);
        System.out.println("Закодовано: " + encoded);
        System.out.println("Розкодовано: " + decoded);
        System.out.println("Довжина Хаффмана: " + huffmanBits + " біт");
        System.out.println("Рівномірний код:   " + uniformBits + " біт");
    }
}