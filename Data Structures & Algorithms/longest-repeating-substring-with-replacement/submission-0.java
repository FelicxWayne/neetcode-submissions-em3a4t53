class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0, maxFreq = 0,left = 0;
        int[] freq = new int[26];
        for(int right = 0 ; right <s.length(); right++){
            int idx = s.charAt(right)-'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq,freq[idx]);
            int window = right-left+1;
            if(window-maxFreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}
