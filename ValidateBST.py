# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def isValidHelper(self, root, lower, upper):
        if not root:
            return True
        if root.val >= upper or root.val <= lower:
            return False
        return self.isValidHelper(root.left, lower, root.val) and self.isValidHelper(root.right, root.val, upper)


    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        return self.isValidHelper(root, float('-inf'), float('inf'))
