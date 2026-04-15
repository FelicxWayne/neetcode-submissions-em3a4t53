class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int i = 3, n1 = 1,n2 = 2;
        while(i <= n){
            int temp = n2;
            n2 = n1+n2;
            n1 = temp;
            i++;
        }
        return n2;
    }
}
