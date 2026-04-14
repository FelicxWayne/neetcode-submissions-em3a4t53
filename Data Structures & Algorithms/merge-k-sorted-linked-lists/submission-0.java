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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode node:lists){
            if(node!=null){
                heap.add(node);
            }
        }
        while(!heap.isEmpty()){
            ListNode curr = heap.poll();
            tail.next = curr;
            tail = tail.next;
            if(curr.next!=null){
                heap.add(curr.next);
            }
        }
        return dummy.next;
    }
}
