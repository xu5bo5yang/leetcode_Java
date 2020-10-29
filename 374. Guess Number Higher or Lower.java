/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/submissions/
 */
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid = low + (high - low) / 2;
        int guessResult = guess(mid);
        
        while (guessResult != 0) {
            if (guessResult == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            
            mid = low + (high - low) / 2;
            guessResult = guess(mid);
        }
        
        return mid;
    }
}