class Solution {
    public List<String> letterCombinations(String digits) {
       List<String> res = new ArrayList<>();
       if(digits.isEmpty()) return res;

       String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
       StringBuilder sb = new StringBuilder();
       backTrack(0,sb,digits,map,res);
       return res;
    }
    public void backTrack(int i,StringBuilder sb,String digits,String[] map,List<String> res){
        if(sb.length() >= digits.length()){
            res.add(sb.toString());
            return;
        }

        String letter = map[digits.charAt(i)-'0'];
        for(char c:letter.toCharArray()){
            sb.append(c);
            backTrack(i+1,sb,digits,map,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
