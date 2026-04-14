class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int maj1 = 0;
        int maj2 = 0;
        int count1 = 0;
        int count2 = 0;

        List<Integer> res = new ArrayList<>();

        for(int n:nums){
            if(n == maj1){
                count1++;
            }
            else if(n == maj2){
                count2++;
            }
            else if(count1 == 0){
                maj1 = n;
                count1 = 1;
            }
            else if(count2 == 0){
                maj2 = n;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int n:nums){
            if(n == maj1)count1++;
            else if(n == maj2)count2++;
        }
        if(count1 > nums.length/3)res.add(maj1);
        if(count2 > nums.length/3)res.add(maj2);

        return res;
    }
}