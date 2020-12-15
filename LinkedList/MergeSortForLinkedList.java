/** Merge Sort for Linked List
 Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
 Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

 Input:
 Example 1:
 N = 5
 value[]  = {3,5,2,4,1}
 Output: 1 2 3 4 5
 Explanation: After sorting the given linked list, the resultant matrix will be 1->2->3->4->5.

 Example 2:
 N = 3
 value[]  = {9,15,0}
 Output: 0 9 15
 Explanation: After sorting the given linked list , resultant will be 0->9->15.

 Example 3:
 N = 3
 value[]  = {9,15,0}
 Output: 0 9 15
 Explanation: After sorting the given linked list , resultant will be 0->9->15.
**/

class LinkedList{
    static Node mergeSort(Node head){
        if(head == null && head.next == null){
            return null;
        }
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node newHead = slow.next;
        slow.next = null;
        Node l = mergeSort(head);
        Node r = mergeSort(newHead);
        return merge(l, r);
    }

    private static Node merge(Node l, Node r){
        Node fin = new Node(0);
        Node ans = fin;
        while(l != null && r != null){
            if(l.data < r.data){
                fin.next = new Node(l.data);
                fin = fin.next;
                l = l.next;
            }else {
                fin.next = new Node(r.data);
                fin = fin.next;
                r = r.next;
            }
        }

        while( l != null){
            fin.next = new Node(l.data);
            fin = fin.next;
            l = l.next;
        }
        while(r != null){
            fin.next = new Node(r.data);
            fin = fin.next;
            r = r.next;
        }
        return ans.next;
    }
}