class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 1;
        for(int p:piles){
            maxPile = Math.max(maxPile,p);
        }
        int left = 1,right = maxPile;
        while(left<right){
            int mid = left+(right-left)/2;
            if(canEat(mid,piles,h)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    public boolean canEat(int k,int[] piles,int h){
        int hr = 0;
        for(int pi:piles){
            hr += (pi+k-1)/k;
            if(hr > h) return false;
        }
        return true;
    }
}
