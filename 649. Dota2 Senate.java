/**
 * https://leetcode.com/problems/dota2-senate/submissions/
 */
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }
        
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int indexRadiant = radiant.poll();
            int indexDire = dire.poll();
            
            if (indexRadiant < indexDire) {
                radiant.add(indexRadiant + senate.length());
            } else {
                dire.add(indexDire + senate.length());
            }
        }
        
        return (radiant.size() > dire.size())? "Radiant" : "Dire";
    }
}