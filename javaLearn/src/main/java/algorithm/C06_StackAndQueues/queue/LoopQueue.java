package algorithm.C06_StackAndQueues.queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    // constructor
    public LoopQueue(int capacity) {
        // 初始化
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    // 队列为空的判断条件就是front==tail
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        // 判断队列是否满了
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from a empty queue. ");
        }

        E ret=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if(size==getCapacity()/4 && getCapacity()/2!=0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    /**
     * resize
     * 关键代码解释 newData[i] = data[(i + front) % data.length];
     * 把原来在front位置上的元素放在新队列的第一个，front由于之前队列有出队情况可能是原来队列最后一个，如果给front再加1会越界，所以要取余。举例，data={a,b,c,d,e,f,null,A},length=8，front=7也即原队列最后一个位置，tail=6，front与tail中间即是浪费掉的那个空间，
     * resize过程：
     * i=0,front=7,newData[0]=data[(0+7)%8]=data[7]=A
     * i=1,front=7,newData[1]=data[(1+7)%8]=data[0]=a
     * i=2,newData[2]=data[(2+7)%8]=data[1]=b
     * ...
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty. ");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(String.format("Queue : size : %d, capacity : %d .  front [ ",size,getCapacity()));
        for(int i=front;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length!=tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue=new LoopQueue<Integer>(5);
        for(int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
