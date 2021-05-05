/**
 * https://leetcode.com/problems/word-ladder/submissions/
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        int result = 1;
        
        Map<String, List<String>> wordMap = new HashMap();
        Set<String> visitedWords = new HashSet();
        
        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "." + word.substring(i+1, len);
                List<String> words = wordMap.getOrDefault(newWord, new ArrayList());
                words.add(word);
                wordMap.put(newWord, words);
            }
        }
        
        Queue<String> wordQueue = new LinkedList();
        wordQueue.add(beginWord);
        
        while(true) {
            Queue<String> newQueue = new LinkedList();
            
            while (!wordQueue.isEmpty()) {
                String word = wordQueue.poll();
            
                for (int i = 0; i < len; i++) {
                    String newWord = word.substring(0, i) + "." + word.substring(i+1, len);

                    for (String transform : wordMap.getOrDefault(newWord, new ArrayList<String>())) {
                        if (transform.equals(endWord)) {
                            return result + 1;
                        } else {
                            if (!visitedWords.contains(transform)) {
                                visitedWords.add(transform);
                                newQueue.add(transform);
                            }
                        }
                    }
                }
            }
            
            if (newQueue.isEmpty()) {
                break;
            }
            
            result++;
            wordQueue.addAll(newQueue);
        }
        
        return 0;
    }
}