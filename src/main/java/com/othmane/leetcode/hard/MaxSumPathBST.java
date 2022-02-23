package com.othmane.leetcode.hard;


public class MaxSumPathBST {
    public int maxPathSum(TreeNode root) {
        pathSummingInOneDirection(root);
        return result;
    }

    int result = Integer.MIN_VALUE;


    public int pathSummingInOneDirection(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //Recursive call
        // In every recursion, We are in a node, and we go the direction when we have a maximum value
        // If the left and the right are negative number we hold our position
        // We use final this value, to sanitize our return from negative numbers
        // Actually, any negative number when added to a number reduce it's value.
        // Test the code with the binary tree [2,-1], and you will understand
        var left = Math.max(0, pathSummingInOneDirection(root.left));
        var right = Math.max(0, pathSummingInOneDirection(root.right));

        // Result is an instance variable that will be updated each time in recursion
        // It will store the max between itself and the sum of the body of the tree in each recursion
        // Body of the tree (AKA the head (actual node val) + both arms left and right)
        result = Math.max(result, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
