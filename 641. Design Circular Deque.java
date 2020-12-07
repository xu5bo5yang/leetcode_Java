/**
 * https://leetcode.com/problems/design-circular-deque/submissions/
 */
class MyCircularDeque {
    int[] queue;
    int size;
    int front;
    int rear;
    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        queue = new int[k];
        size = 0;
        front = 0;
        rear = -1;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == queue.length) {
            return false;
        }
        
        size++;
        front = (front - 1 + queue.length) % queue.length;
        queue[front] = value;

        if (size == 1) {
            rear = front;
        }
        
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == queue.length) {
            return false;
        }
        
        size++;
        rear = (rear + 1) % queue.length;
        queue[rear] = value;

        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        
        size--;
        front = (front + 1) % queue.length;
        
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        
        size--;
        rear = (rear - 1 + queue.length) % queue.length;
        
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        
        return queue[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        
        return queue[rear];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == queue.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */