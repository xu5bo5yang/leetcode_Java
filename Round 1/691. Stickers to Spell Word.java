/**
 * https://leetcode.com/problems/stickers-to-spell-word/submissions/
 */
class Solution {
    public int minStickers(String[] stickers, String target) {
        if (stickers == null || stickers.length < 1 || target == null || target.length() < 1) {
            return 0;
        }
        
        int len = stickers.length;
        int[][] charCount = new int[len][26];
        Map<String, Integer> dp = new HashMap();
        
        for (int i = 0; i < len; i++) {
            for (char c : stickers[i].toCharArray()) {
                charCount[i][c-'a']++;
            }
        }
        
        dp.put("", 0);
        
        return helper(dp, charCount, target);
    }
    private int helper(Map<String, Integer> dp, int[][] charCount, String target) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        
        int result = Integer.MAX_VALUE;
        int[] targetCount = new int[26];
        
        for (char c : target.toCharArray()) {
            targetCount[c-'a']++;
        }
        
        for (int[] count : charCount) {
            if (count[target.charAt(0)-'a'] == 0) {
                continue;
            }
            
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < 26; j++) {
                if (targetCount[j] > 0 ) {
                    for (int k = 0; k < Math.max(0, targetCount[j] - count[j]); k++) {
                        sb.append((char)('a' + j));
                    }
                }
            }
            
            String remain = sb.toString();
            int tmp = helper(dp, charCount, remain);
            
            if (tmp != -1) {
                result = Math.min(result, tmp + 1);
            }
        }
        
        dp.put(target, result == Integer.MAX_VALUE? -1 : result);
        
        return dp.get(target);
    }
}