package algorithm.C08_Recursion;



public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // 链表节点的构造函数
    //使用arr为参数，创建一个链表，当前的ListNode为链表头结点
    public ListNode(int[] arr){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("Array can not be empty. ");
        }

        this.val=arr[0];
        ListNode current=this;
        for(int i=1;i<arr.length;i++){
            current.next=new ListNode(arr[i]);
            current=current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        ListNode current=this;
        while(current!=null){
            res.append(current.val+"->");
            current=current.next;
        }
        res.append("NULL");
        return res.toString();
    }
}