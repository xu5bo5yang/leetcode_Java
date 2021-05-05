/**
 * https://leetcode.com/problems/top-k-frequent-words/submissions/
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length < 1 || k < 1) {
            return new ArrayList();
        }
        
        List<String> result = new ArrayList<>();
        Map<String, Integer> wordsCount = new HashMap<>();
        
        for (String word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
        
        for (Map.Entry<String, Integer> entry: wordsCount.entrySet()) {
            queue.offer(entry);
            
            if (queue.size() > k) {
                queue.poll();
            }
        }

        while (!queue.isEmpty()) {
            result.add(0, queue.poll().getKey());
        }
        
        return result;
    }
}