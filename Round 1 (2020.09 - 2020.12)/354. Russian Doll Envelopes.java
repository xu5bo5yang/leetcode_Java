/**
 * https://leetcode.com/problems/russian-doll-envelopes/submissions/
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length < 1 || envelopes[0].length < 2) {
            return 0;
        }
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2){
                if(a1[0] == a2[0])
                    return a2[1] - a1[1];
                else
                    return a1[0] - a2[0];
           }
        });
        
        int[] lengths = new int[envelopes.length];
        lengths[0] = 1;
        
        int result = 1;
        
        for (int i = 1; i < lengths.length; i++) {
            int tmpMax = 0;
            
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    tmpMax = Math.max(tmpMax, lengths[j]);
                }
            }
            
            lengths[i] = tmpMax + 1;
            
            result = Math.max(result, lengths[i]);
        }
        
        return result;
    }
}