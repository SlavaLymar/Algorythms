package leetcode;

public class TreeRootSearch {

    //
    //               5
    //            /  |  \
    //           2   7   10          => sum1 = 34
    //         /  \
    //        4   6
    //
    // children only
    // [2,7,10,4,6]                  => sum2 = 29
    //
    // return 34 - 29 = 5
    //
    // t: O (N * C)
    // space: O (1)
    //
    private static Node search(Node[] nodes) {
        int sum1 = 0, sum2 = 0;
        for (Node node : nodes) {
            sum1 += node.val;
            if (node.children != null) {
                for (Node child : node.children) {
                    sum2 += child.val;
                }
            }
        }
        for (Node node : nodes) {
            if (node.val == sum1 - sum2) return node;
        }
        return null;
    }

    public static void main(String[] args) {
        Node n6 = new Node(6, null);
        Node n5 = new Node(5, null);
        Node n4 = new Node(4, null);
        Node n3 = new Node(3, null);
        Node n2 = new Node(2, new Node[]{n5, n6});
        Node n1 = new Node(1, new Node[]{n2,n3,n4});
        System.out.println(search(new Node[]{n1,n2,n3,n4,n5,n6}).val);
    }

    static class Node {
        int val;
        Node[] children;

        public Node(int val, Node[] children) {
            this.val = val;
            this.children = children;
        }
    }
}
