/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/submissions/
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<ListIterator<NestedInteger>> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack();
        stack.add(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        return stack.peek().next().getInteger(); 
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            if(!stack.peek().hasNext()) {
                stack.pop();
            } else {
                NestedInteger nestedInteger=stack.peek().next();
                
                if(nestedInteger.isInteger()) {
                    stack.peek().previous();
                    return true;
                }
                
                stack.add(nestedInteger.getList().listIterator());
            }
        }
        
        return false; 
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */