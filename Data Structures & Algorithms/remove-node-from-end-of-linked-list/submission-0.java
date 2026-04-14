/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        if(n == 1){
            prev = prev.next;
        }
        else{
            ListNode rem = prev;
            for(int i = 1; i < n-1; i++){
                rem = rem.next;
            }
            rem.next = rem.next.next;
        }
        curr = prev;
        ListNode res = null;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = res;
            res = curr;
            curr = nextNode;
        }
        return res;
    }
}
