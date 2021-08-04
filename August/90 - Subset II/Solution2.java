
/*
Idea: Solution1 is less effective beacause we are having an extra operation of checking whether subset already exist in set or not 
      and then converting entire set to arraylist.
      If we remove the set operation, solution will get optimized.
      
      we will apply a logic to not add duplicate into the list in the recursion itself.
      
Time : O(n*2^n)
Space : O(n) - if rescurion stack is considered, otherwise O(1)
*/

class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        int n = nums.length;
        
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
            
        formSubsets(nums, result, new ArrayList<Integer>(), 0);
        
        return result;
    }
    
    private void formSubsets(int[] nums, List<List<Integer>> result, List<Integer> temp, int idx) {
            
        result.add(new ArrayList<Integer>(temp));
        
        for (int i = idx; i < nums.length; i++) {
            
            if (i !=idx && nums[i] == nums[i - 1]) continue;
            
            temp.add(nums[i]);
                
            formSubsets(nums, result, temp, i + 1);
                
            temp.remove(temp.size() - 1);
        }
    }
}
