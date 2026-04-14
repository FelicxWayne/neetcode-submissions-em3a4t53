class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(!set.contains(ch)){
                set.add(ch);
                maxLen = Math.max(maxLen,right-left+1);
            }
            else{
                while(set.contains(ch)){
                    char leftChar = s.charAt(left);
                    set.remove(leftChar);
                    left++;
                }
                set.add(ch);
            }
        }
        return maxLen;        
    }
}
