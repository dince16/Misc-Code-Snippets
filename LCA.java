import java.lang.StringBuilder;
import java.util.ArrayList;

import java.util.HashSet;

public class LCA {

  public static Node findLCA(Node node1, Node node2) {
    Node temp = node2.parent;
    Node lca = null;

    node1 = node1.parent;
    while (node1 != null && lca == null) {

      while (temp != null && lca == null) {
        if (node1.val == temp.val) {
          lca = temp;
        }
        temp = temp.parent;
      }
      node1 = node1.parent;
      temp = node2.parent;
    }
    return lca;
	}

  public static Node partThree(Node node1, Node node2) {
    HashSet<Node> node1Ancestors = new HashSet<Node>();
    Node lca = null;

    node1 = node1.parent;
    while (node1 != null) {
      node1Ancestors.add(node1);
      node1 = node1.parent;
    }

    node2 = node2.parent;
    while (node2 != null && lca == null) {
      if (node1Ancestors.contains(node2)) {
        lca = node2;
      }
      node2 = node2.parent;
    }
    return lca;
	}

	public static Node partOne(Node root, Node node1, Node node2) {
    if (root == null) {
      return null;
    }

    // Node left = findLCA(root.left, node1, node2);
    // Node right = findLCA(root.right, node1, node2);

    Node left = null;
    Node right = null;

    if (root.val == node1.val || root.val == node2.val) {
      if (left != null || right != null) {
        return root.parent;
      } else {
        return root;
      }
    }

    if (left != null && right != null) {
      return root;
    } else if (left != null) {
      return left;
    } else {
      return right;
    }
	}

  public static int findLCAHelper(Node root, Node node1, Node node2, Node lca) {
    if (root == null) {
      return 0;
    }
    int left = findLCAHelper(root.left, node1, node2, lca);
    int right = findLCAHelper(root.right, node1, node2, lca);

    if (root.val == node1.val || root.val == node2.val) {
      return 1 + left + right;
    }

    if (left + right == 2) {
      lca = new Node(root.val);
      System.out.println(root.val);
      return 0;
    }
    return left + right;
  }

	public static void main(String[] args) {
    Node root = new Node(0);
    Node one = new Node(1);
    Node two = new Node(2);

    root.left = one;
    root.left.parent = root;
    root.right = two;
    root.right.parent = root;

    //Node result = findLCA(root, one, two);
    Node result = findLCA(one, two);
    System.out.println(result.val);

    Node three = new Node(3);
    Node four = new Node(4);

    one.left = three;
    one.left.parent = root;
    one.right = four;
    one.right.parent = root;

    //result = findLCA(root, one, four);
    result = findLCA(one, four);
    System.out.println(result.val);


	}

  public static class Node {
    private int val;
    private Node parent;
    private Node left;
    private Node right;

    public Node(int val) {
      this.val = val;
    }

    public Node(int val, Node left, Node right, Node parent) {
      this.val = val;
      this.left = left;
      this.right = right;
      this.parent = parent;
    }
  }
}
