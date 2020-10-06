/**
 * https://leetcode.com/problems/largest-number/submissions/
 */
class Solution {
    public String largestNumber(int[] nums) {
        Comparator<String> comparator = new Comparator<String>(){
		    @Override
		    public int compare(String s1, String s2){
				return (s2 + s1).compareTo(s1 + s2);
		    }
	     };
        
        String[] numsStr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(numsStr, comparator);
        
        if(numsStr[0].charAt(0) == '0') {
            return "0";
        }
            
		StringBuilder result = new StringBuilder();
        
		for(String s: numsStr)
	        result.append(s);
		
		return result.toString();
    }
}