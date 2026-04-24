class Solution {
    public String longestPalindrome(String s) {
        StringBuilder t = new StringBuilder("@");
        for(int i = 0; i < s.length(); i++){
            t.append("#").append(s.charAt(i));
        }
        t.append("#$");

        int n = t.length();
        int[] p = new int[n];
        int c = 0;
        int r = 0;

        int maxLen = 0;
        int cenIdx = 0;

        for(int i = 1; i < n-1; i++){
            int mirror = 2*c-i;

            if(r>i){
                p[i] = Math.min(p[mirror],r-i);
            }

            while(t.charAt(i+1+p[i])==t.charAt(i-1-p[i])){
                p[i]++;
            }

            if(i+p[i] > r){
                c = i;
                r = i+p[i];
            }

            if(p[i] > maxLen){
                maxLen = p[i];
                cenIdx = i;
            }
        }
        int start = (cenIdx - maxLen)/2;
        return s.substring(start,start+maxLen);
    }
}
