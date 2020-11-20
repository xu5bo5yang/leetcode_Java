/**
 * https://leetcode.com/problems/zuma-game/submissions/
 */
public class Solution {
    int result = Integer.MAX_VALUE;
    
    public int findMinStep(String board, String hand) {
        dfs(board, hand, 0, 0);
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    void dfs(String board, String hand, int index, int count){
        if (board.length() == 0) {
            result = Math.min(result, count);
            
            return;
        }
        
        if (result < count) {
            return;
        }
        
        for (int i = index; i < hand.length(); i++){
            char c = hand.charAt(i);
            
            for (int j = 0; j < board.length(); j++){
                String newboard = getNewBoard(board, j, c);
                dfs(newboard, hand, i + 1, count + 1);
            }
        }
    }
    
    String getNewBoard(String board, int index, char c){
        char cur = c;
        int left = index;
        int right = index + 1;
        int count = 1;
        
        while (left >= 0 && right < board.length()){
            int oldLeft = left;
            int oldRight = right;
            
            while (left >= 0 && board.charAt(left) == cur){
                count++;
                left--;
            }
            
            while (right < board.length() && board.charAt(right) == cur){
                count++;
                right++;
            }
            
            if (count < 3){
                left = oldLeft;
                right = oldRight;
                break;
            }
            
            if (left < 0 || right >= board.length() || board.charAt(left) != board.charAt(right)) {
                break;
            }
            
            cur = board.charAt(left);
            count = 0;
        }
        
        if (left == index && right == index + 1) {
            return board.substring(0, left + 1) + c + board.substring(right, board.length());
        }
        
        StringBuilder newBoard = new StringBuilder();
        
        if (left >= 0) {
            newBoard.append(board.substring(0, left + 1));
        }
        
        if (right < board.length()) {
            newBoard.append(board.substring(right, board.length()));
        }
        
        return newBoard.toString();
    }
}