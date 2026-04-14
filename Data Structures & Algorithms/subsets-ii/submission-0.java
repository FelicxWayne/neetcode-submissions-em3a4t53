class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currSet = new ArrayList<>();
        helper(0,nums,currSet,res);
        return res;
    }
    public void helper(int i,int[] nums ,List<Integer> currSet ,List<List<Integer>> res){
        if(i >= nums.length){
            res.add(new ArrayList<>(currSet));
            return;
        }

        currSet.add(nums[i]);
        helper(i+1,nums,currSet,res);
        currSet.remove(currSet.size()-1);

        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        helper(i+1,nums,currSet,res);
    }
}
