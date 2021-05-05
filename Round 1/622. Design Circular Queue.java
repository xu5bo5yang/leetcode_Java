/**
 * https://leetcode.com/problems/design-circular-queue/submissions/
 */
class MyCircularQueue {
    int[] queue;
    int size;
    int rear;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
        size = 0;
        rear = -1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size == queue.length) {
            return false;
        }
        
        size++;
        rear++;
        
        if (rear == queue.length) {
            rear = 0;
        }
        
        queue[rear] = value;

        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        
        size--;
        
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (size == 0) {
            return -1;
        }
        
        return queue[(rear - size + 1 + queue.length) % queue.length];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (size == 0) {
            return -1;
        }
        
        return queue[rear];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */