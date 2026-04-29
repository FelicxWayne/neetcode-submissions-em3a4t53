class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()+1];
        Set<String> set = new HashSet<>(wordDict);
        return solve(0,s,set);
    }
    public boolean solve(int start,String s,Set<String> set){
        if(start == s.length()){
            return true;
        }
        if(memo[start] != null){
            return memo[start];
        }

        for(int end = start; end <= s.length(); end++){
            String prefix = s.substring(start,end);
            if(set.contains(prefix)){
                if(solve(end,s,set)){
                    return memo[start] = true;
                }
            }
        }
        return memo[start] = false;
    }
}
