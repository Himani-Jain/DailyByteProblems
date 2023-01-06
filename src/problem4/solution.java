package problem4;

import java.util.ArrayList;
import java.util.List;

public class solution {

    static class Node {
        int data;
        Node left, right;
        public Node(int data) { this.data = data; }
    }

    static Node getBst(int[] values) {
        return getRoot(values, 0, values.length-1);
    }

    static Node getRoot(int[] values, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (end + start)/2;
        Node root = new Node(values[mid]);
        root.left = getRoot(values, start, mid-1);
        root.right = getRoot(values, mid+1, end);
        return root;
    }

   //to check
    static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args)
    {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        Node root = getBst(arr);
        preOrder(root);
    }
}
