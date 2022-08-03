package algorithm.C07_LinkedList;

//import algorithm.C08_Recursion.ListNode;


/**
 * 虚拟头结点
 *
 * @param <E>
 */
public class LinkedList02<E> {
    public class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList02() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index. ");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);  // 为上面隐藏三行的等同写法
        size++;
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的第index(0-based)个位置的元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index. ");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    // 获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index. ");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
        for (Node current = dummyHead.next; current != null; current = current.next) {
            if (current.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains02(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    public E remove(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index. ");
        }

        Node prev=dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        Node retNode=prev.next;
        prev.next=retNode.next;
        retNode.next=null;
        size--;
        return retNode.e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public void removeElement(E e){

        Node prev=dummyHead;
        while(prev.next!=null){
            if(prev.next.e.equals(e)){
                break;  // 符合条件时终止while循环，也即不执行"prev = prev.next;" ,prev还是要删除节点的前一个节点
            }
            prev=prev.next;
        }
        if(prev.next!=null){
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            size--;
        }
    }

    public ListNode removeElements(ListNode head, int val) {

        // 开始部分需要删除的节点全部删除
        while(head!=null && head.val==val){
            ListNode delNode=head;
            head=head.next;
            delNode.next=null;
        }
        // 如果所有节点都是val，那删完了也就剩下null了。返回head
        if(head==null){
            return head;
        }

        // 剩下的head.val绝对已经不是val了，但依然无法确定prev.next.val是否是指定值val，如果是，删除，然后查看prev后的新节点；如果不是val，那就更新prev
        ListNode prev=head;
        while(prev.next!=null){

            if(prev.next.val==val){
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }else {
                prev=prev.next;
            }
        }
        return head;

    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        // function1
        Node current = dummyHead.next;
        while (current != null) {
            res.append(current + "->");
            current = current.next;
        }
        // function2
//        for(Node current=dummyHead.next;current!=null;current=current.next){
//            res.append(current+"->");
//        }
        res.append("null");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList02<Integer> linkedList=new LinkedList02<Integer>();

        for(int i=0;i<5;i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2,99);
        System.out.println(linkedList);

        System.out.println(linkedList.contains(99));
        System.out.println(linkedList.contains02(99));

        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeElement(3);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);

    }
}

