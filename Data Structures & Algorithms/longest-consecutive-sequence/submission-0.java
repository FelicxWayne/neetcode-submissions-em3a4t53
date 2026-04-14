class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int num:nums){
            set.add(num);
        }
        int curr = 0;
        int count = 1;
        int maxCount = Integer.MIN_VALUE;
        for(int n:set){
            if(!set.contains(n-1)){
                curr = n;
                while(set.contains(curr+1)){
                    count++;
                    curr++;
                }
                maxCount = Math.max(maxCount,count);
            }
            count = 1;
        }
        return maxCount;
    }
}
