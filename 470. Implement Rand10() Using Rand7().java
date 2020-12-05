/**
 * https://leetcode.com/problems/implement-rand10-using-rand7/submissions/
 */
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int random = 40;
    
        while (random >= 40) {
            random = 7 * (rand7() - 1) + (rand7() - 1);
        }
    
        return random % 10 + 1;
    }
}