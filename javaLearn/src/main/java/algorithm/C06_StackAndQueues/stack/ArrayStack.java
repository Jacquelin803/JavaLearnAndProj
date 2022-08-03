package algorithm.C06_StackAndQueues.stack;



public class ArrayStack<E> implements Stack<E> {

    private Array<E> array; // 存放数据

    public ArrayStack(int capacity){
        array=new Array<E>(capacity);
    }

    public ArrayStack(){
        array=new Array<E>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("Stack: [");
        for(int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i!= array.getSize()-1){
                res.append(",");
            }
        }
        res.append("] top ");
        return res.toString();
    }



    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<Integer>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }

}
