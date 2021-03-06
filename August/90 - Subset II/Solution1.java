/*
Idea: Generate all possible subsets and add it to a resultant set so that the duplicates are removed.
      To ease object comparison while adding subset to a set, we sort the intial nums array.
      
Time : O(n*2^n)
Space : O(n) - if rescurion stack is considered, otherwise O(1)
*/
class Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        int n = nums.length;
        
        Arrays.sort(nums);
        
      // resultant set
        Set<List<Integer>> result = new HashSet<List<Integer>>();
       
      // we need to generate all subsets of size 0 to n
        for (int i = 0; i <= n; i++) {
            
            formSubsets(nums, result, i, new ArrayList<Integer>(), 0);
        }
        
      // convert set to arraylist and return
        return new ArrayList(result);
    }
    
    private void formSubsets(int[] nums, Set<List<Integer>> result, int size, List<Integer> temp, int idx) {
        
        if (temp.size() == size) {
            
            result.add(new ArrayList<Integer>(temp));
            
            return;
        }
        
        for (int i = idx; i < nums.length; i++) {
                
            temp.add(nums[i]);
                
            formSubsets(nums, result, size, temp, i + 1);
                
            temp.remove(temp.size() - 1);
        }
    }
}
