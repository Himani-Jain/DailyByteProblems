package problem2;

public class solution {

    static class Node {
        int data;
        Node left, right;
        public Node(int data) { this.data = data; }
    }

    static int min = Integer.MAX_VALUE;
    static Integer prev = null;

    public static int minDifference(Node root) {
        if(root == null)
            return min;

        minDifference(root.left);

        if (prev != null) {
            int x = Math.abs(prev-root.data);
            min = Math.min(x, min);
        }
        prev = root.data;
        minDifference(root.right);
        return min;
    }

    public static void main(String[] args)
    {
        Node root1 = new Node(29);
        root1.left = new Node(17);
        root1.right = new Node(50);
        root1.left.left = new Node(1);
        root1.right.left = new Node(42);
        root1.right.right = new Node(59);

        System.out.println("Minimum Difference is: " + minDifference(root1));
    }
}
