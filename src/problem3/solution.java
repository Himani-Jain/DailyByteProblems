package problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class solution {

    static class Node {
        int data;
        Node left, right;
        public Node(int data) { this.data = data; }
    }

    static int max = 0;
    static int count = 1;
    static List<Integer> list = new ArrayList<>();
    static Node prev = null;

    public static int[] findMode(Node root) {
        getModes(root, list);
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static void getModes(Node root, List<Integer> list) {
        if(root == null) {
            return;
        }
        getModes(root.left, list);
        if(prev != null) {
            if(prev.data == root.data) {
                count++;
            } else {
                count = 1;
            }
        }
        if(count > max) {
            max = count;
            list.clear();
            list.add(root.data);
        } else if(count == max) {
            list.add(root.data);
        }
        prev = root;
        getModes(root.right, list);
    }


    public static void main(String[] args)
    {
        Node root1 = new Node(29);
        root1.left = new Node(29);
        root1.right = new Node(50);
        root1.left.left = new Node(1);
        root1.right.left = new Node(42);
        root1.right.right = new Node(59);

        int[] modes = findMode(root1);
        System.out.println("Modes are:");
        for (int i=0; i<modes.length; i++){
            System.out.print(" " + modes[i]+ " ");
        }
    }
}
