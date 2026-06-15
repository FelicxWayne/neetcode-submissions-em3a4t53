class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int ladderLen = 1;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0;i < size;i++){
                String curr = queue.poll();
                char[] wordArr = curr.toCharArray();
                if(curr.equals(endWord)){
                    return ladderLen;
                }

                for(int j = 0;j < curr.length();j++){
                    char originalChar = curr.charAt(j);
                    for(char c = 'a'; c <= 'z';c++){
                        if(c == originalChar){
                            continue;
                        }
                        wordArr[j] = c;
                        String newStr = new String(wordArr);

                        if(wordSet.contains(newStr) && !visited.contains(newStr)){
                            visited.add(newStr);
                            queue.add(newStr);
                        }
                    }
                    wordArr[j] = originalChar;
                }
            }
            ladderLen++;
        }
        return 0;
    }
}
