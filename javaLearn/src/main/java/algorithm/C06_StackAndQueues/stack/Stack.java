package algorithm.C06_StackAndQueues.stack;

/**
 * 一个栈具有的功能
 * @param <E>
 */
// 后进先出

public interface Stack<E> {

    // 获取栈大小
    int getSize();

    // 栈是否为空
    boolean isEmpty();

    // 插入元素
    void push(E e);

    // 删除元素
    E pop();

    // 栈顶元素
    E peek();
}
