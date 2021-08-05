/*
Idea: Apply DFS and for every path (root to leaf) check if the sum equals the target sum.
Time : O(N * log(N)) [N = number of nodes in the  tree]
Space : O(log(N)) if recusrion stack is taken into account otherwise O(1);
        O(N) to store all the paths.
*/
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
     
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        dfs(root, targetSum, result, new ArrayList<Integer>());
        
        return result;
    }
    
    private void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> temp) {
     
        if (root == null) return;
        
        temp.add(root.val);
        
        if (root.left == null && root.right == null && targetSum == root.val) {
            
            result.add(new ArrayList(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        
        dfs(root.left, targetSum - root.val, result, temp);
        
        dfs(root.right, targetSum - root.val, result, temp);
        
        temp.remove(temp.size() - 1);
    }
}
