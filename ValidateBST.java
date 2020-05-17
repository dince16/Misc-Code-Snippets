/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        }
    }

    public boolean isValidBST(TreeNode root, int lower, int upper) {
        boolean left = true;
        boolean right = true;
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null) {
            if (root.left.val >= root.val || root.left.val <= lower || root.left.val >= upper) {
                return false;
            }
            left = isValidBST(root.left, lower, root.val);
        }
        if (root.right != null) {
            if (root.right.val <= root.val || root.right.val <= lower || root.right.val >= upper) {
                return false;
            }
            right = isValidBST(root.right, root.val, upper);
        }
        return left && right;
    }
}
