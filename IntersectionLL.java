/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int c1 = 0;
        while(curr!=null){
            c1++;
            curr = curr.next;
        }
        curr = headB;
        int c2 = 0;
        while(curr!=null){
            c2++;
            curr = curr.next;
        }
        ListNode currA = headA;
        ListNode currB = headB;
        
        if(c1 > c2){
            for(int i = 0;i<c1-c2;i++){
                currA = currA.next; //cut down the extra part mathematically
            }
        }
        if(c1 < c2){
            for(int i = 0;i<c2-c1;i++){
                currB = currB.next;
            }
        }
        //now traverse both of the equal length linked lists
        while(currA!=null){ //currB != null
            if(currA == currB)return currA; //or currB
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
}
