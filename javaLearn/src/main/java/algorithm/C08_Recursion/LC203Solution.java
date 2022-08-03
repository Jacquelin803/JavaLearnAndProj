package algorithm.C08_Recursion;


/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 */
public class LC203Solution {

    public ListNode removeElements01(ListNode head, int val) {

        // head.val==val
        if(head!=null){
            while(head.val==val){
                ListNode delNode=head;
                head=head.next;
                delNode.next=null;
            }
        }else {
            return head;
        }
        // head.val != val
        ListNode prev=head;
        while(prev.next!=null){
            if(prev.next.val==val){
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode=null;
            }else {
                prev=prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements02(ListNode head,int val){

        if(head!=null){
            while(head.val==val){
                head=head.next;
            }
        }else {
            return head;
        }
        // head.val != val
        ListNode prev=head;
        while(prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else {
                prev=prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements03(ListNode head,int val){

        ListNode dummyHead=new ListNode(-1,head);
        ListNode prev=dummyHead;
        while(prev.next!=null){
            if(prev.next.val==val){
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }else {
                prev=prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums={6,2,6,2,4,5,6};
        ListNode head=new ListNode(nums);
        System.out.println(head);

//        ListNode removeRes = (new LC203Solution()).removeElements01(head, 6);
//        System.out.println(removeRes);
//        ListNode removeRes02 = (new LC203Solution()).removeElements02(head, 6);
//        System.out.println(removeRes02);
        ListNode removeRes03 = (new LC203Solution()).removeElements03(head, 6);
        System.out.println(removeRes03);


    }
}
