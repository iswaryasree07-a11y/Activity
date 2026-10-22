class Trie {
    private static class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new Node();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = find(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Node find(String s) {
        Node node = root;

        for (char c : s.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                return null;
            }

            node = node.children[index];
        }

        return node;
    }
}
