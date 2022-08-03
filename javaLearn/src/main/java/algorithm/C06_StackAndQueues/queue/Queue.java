package algorithm.C06_StackAndQueues.queue;

/**
 * 队列：先进先出
 * 实现多态，使用接口。后面要实现ArrayQueue和LoopQueue
 */

public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();

}
