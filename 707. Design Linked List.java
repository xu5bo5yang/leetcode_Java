/**
 * https://leetcode.com/problems/design-linked-list/submissions/
 */
class MyLinkedList {

    class Node {
        int val;
        Node pre;
        Node next;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    private Node head;
    private Node tail;
    int size;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        
        Node cur = head;
        
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        
        Node cur = head;
        
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        
        Node newNode = new Node(val);
        newNode.next = cur.next;
        newNode.next.pre = newNode;
        cur.next = newNode;
        newNode.pre = cur;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        
        Node cur = head;
        
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }

        cur.next.pre = cur.pre;
        cur.pre.next = cur.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */