/**
 * https://leetcode.com/problems/binary-watch/submissions/
 */
class Solution {
    public List<String> readBinaryWatch(int num) {
        int[] hourNums = new int[]{8, 4, 2, 1};
        int[] minuteNums = new int[]{32, 16, 8, 4, 2, 1};
        
        List<String> results = new ArrayList();
        for (int i = 0; i <= num; i++) {
            List<Integer> hours = generateDigit(hourNums, i);
            List<Integer> minutes = generateDigit(minuteNums, num - i);
            
            for (int hour : hours) {
                if(12 <= hour) continue;
            
                for (int minute : minutes) {
                    if(60 <= minute) continue;
                    
                    results.add(hour + ":" + (minute < 10 ? "0" + minute : minute));
                }
            }
        }
        
        return results;
    }
    
    List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> result = new ArrayList();
        
        generateDigitHelper(nums, count, 0, 0, result);
        
        return result;
    }
    
    void generateDigitHelper(int[] nums, int count, int prev, int sum, List<Integer> result) {
        if (count == 0) {
            result.add(sum);
            
            return;
        }
        
        for (int i = prev; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], result);    
        }
    }
}