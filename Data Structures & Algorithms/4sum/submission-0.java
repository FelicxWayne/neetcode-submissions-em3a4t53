class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            long tempTar = (long)target-nums[i];
            for(int j = i+1;j<nums.length;j++){
                if(j>i+1 && nums[j] == nums[j-1])continue;
                long currTar = tempTar-nums[j];
                int left = j+1;
                int right = nums.length-1;

                while(left<right){
                    if((long)nums[left]+nums[right] < currTar){
                        left++;
                    }
                    else if((long)nums[left]+nums[right] > currTar){
                        right--;
                    }
                    else{
                        List<Integer> gang = new ArrayList<>();

                        gang.add(nums[i]);
                        gang.add(nums[j]);
                        gang.add(nums[left]);
                        gang.add(nums[right]);

                        res.add(gang);

                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}