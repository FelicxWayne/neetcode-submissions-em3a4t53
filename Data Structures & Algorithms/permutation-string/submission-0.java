class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = s1.length();
        if(l>s2.length()) return false;
        int[] count = new int[26];
        for(int i = 0; i < l; i++){
            count[s1.charAt(i)-'a']++;
        }
        int[] freq = new int[26];
        for(int i = 0; i < l; i++){
            freq[s2.charAt(i)-'a']++;
        }
        if(isEqual(count,freq)) return true;
        for(int i = l; i < s2.length(); i++){
            freq[s2.charAt(i-l)-'a']--;
            freq[s2.charAt(i)-'a']++;
            if(isEqual(count,freq)) return true;
        }
        return false;
    }
    public boolean isEqual(int[] a, int[] b){
        for(int i = 0; i<26; i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}
