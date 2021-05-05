/**
 * https://leetcode.com/problems/24-game/submissions/
 */
class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> numbers = new ArrayList<>();
        
        for (int num : nums) {
            numbers.add((double) num);
        }
        
        return get24(numbers);
    }
    
    boolean get24(List<Double> numbers) {
        int size = numbers.size();
        
        if (size == 1) {
            if (Math.abs(numbers.get(0) - 24) < 0.001) {
                return true;
            } else {
                return false;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                List<Double> nextRound = new ArrayList();
                
                for (int k = 0; k < size; k++) {
                    if (k != i && k != j) {
                        nextRound.add(numbers.get(k));
                    }
                }
                
                for (double c : computeNums(numbers.get(i), numbers.get(j))) {
                    nextRound.add(c);
                    
                    if (get24(nextRound)) {
                        return true;
                    } else {
                        nextRound.remove(nextRound.size() - 1);
                    }
                }
            }
        }
        
        return false;
    }
    
    List<Double> computeNums(double a, double b) {
        return Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a);
    }
}