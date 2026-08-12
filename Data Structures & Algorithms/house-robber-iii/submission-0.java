class Solution {
    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }
    
    // returns {maxIfNotRobbed, maxIfRobbed}
    private int[] robHelper(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        
        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);
        
        // If we rob this node, we can't rob its children
        int robbed = node.val + left[0] + right[0];
        
        // If we don't rob this node, take the best of each child (robbed or not)
        int notRobbed = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{notRobbed, robbed};
    }
}