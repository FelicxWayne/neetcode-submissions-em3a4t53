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
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode dummy =  new ListNode();
       dummy.next = head;
       ListNode curr = head;
       ListNode prevTail = dummy;
       while(curr!=null){
        ListNode temp = curr;
        for(int i = 0 ; i<k;i++){
            if(temp == null) return dummy.next;
            temp = temp.next;
        }
        ListNode groupHead = curr;
        ListNode reverseHead = reverse(groupHead, k);

        prevTail.next = reverseHead;
        groupHead.next = temp;

        curr = temp;
        prevTail = groupHead;
       }
       return dummy.next; 
    }
    public ListNode reverse(ListNode node , int k){
        ListNode curr = node;
        ListNode prev = null;
        while(k>0){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            k--;
        }
        return prev;
    }
}
