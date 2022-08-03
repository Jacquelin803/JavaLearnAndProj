package algorithm.C05_Arrays;

public class Array {

    private int[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data=new int[capacity];
        size=0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize(){
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index,int e){
        if (size==data.length){
            throw new IllegalArgumentException("Add failed. Array is full, couldn`t add anymore!");
        }
        if (index<0 || index>size){
            throw new IllegalArgumentException("Add failed. Require index>=0 and index < size");
        }

        for (int i=size-1;i>=index;i --){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    // 在所有元素前添加一个新元素
    public void addFirst(int e){
        add(0,e);
    }

    // 向所有元素后添加一个新元素
    public void addLast(int e){
        add(size,e);
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public int remove(int index){
        if (index<0 || index>=size){
            throw new IllegalArgumentException("Remove failed, index illegal. ");
        }
        int ret=data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public int removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public int removeLast(){
        return remove(size-1);
    }

    // 从数组中删除元素e
    public void removeEle(int e){
        for(int i=0;i<size;i++){
            if (data[i]==e){
                remove(i);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append((String.format("Array: size= %d, capacity= %d, ",size,data.length)));
        res.append("[");
        for (int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();

    }


    public static void main(String[] args) {
        Array arr=new Array(20);
        System.out.println(arr.getCapacity());
        for (int i=0;i<10;i++){
            arr.add(i,i);
        }
        System.out.println(arr);
         arr.add(2,100);
         arr.addFirst(100);
         arr.addLast(100);
//        arr.remove(3);
        System.out.println(arr);
        arr.removeEle(190);
        System.out.println(arr);

    }
}
