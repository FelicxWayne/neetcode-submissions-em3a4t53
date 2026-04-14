class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        helper(0,target,nums,sum,res);
        return res;
    }
    public void helper(int i,int target,int[] nums,List<Integer> sum,List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(sum));
            return;
        }
        if(target < 0){
            return;
        }
        if(i >= nums.length){
            return;
        }

        sum.add(nums[i]);
        helper(i,target-nums[i],nums,sum,res);
        sum.remove(sum.size()-1);

        helper(i+1,target,nums,sum,res);
    }
}
