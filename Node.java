package task10;

public class Node {
    char ch;
    int freq;
    Node left;
    Node right;

    public Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    public Node(int freq, Node left, Node right) {
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
