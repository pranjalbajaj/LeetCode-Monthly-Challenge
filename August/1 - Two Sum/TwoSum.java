/*
Time: O(n)
Space: O(n)
*/

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            
            int a = nums[i];
            
            int b = target - a;
            
            if (map.containsKey(b)) {
                
                return new int[] {i, map.get(b)};
            }
            
            map.put(a, i);
        }
        
        return null;
    }
}
