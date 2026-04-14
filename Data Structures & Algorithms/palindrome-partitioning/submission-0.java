class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> res = new ArrayList<>();
       List<String> curr = new ArrayList<>();
       backTrack(0,s,curr,res);
       return res;
    }
    public void backTrack(int start,String s,List<String> curr,List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList(curr));
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s,start,i)){
                curr.add(s.substring(start,i+1));
                backTrack(i+1,s,curr,res);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
