package algorithm.C06_StackAndQueues.queue;

import java.util.Random;

public class Compare {

    private static double testQueue(Queue<Integer> q,int opCount){
        long startTime=System.nanoTime();

        Random random=new Random();
        for(int i=0;i<opCount;i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<opCount;i++){
            q.dequeue();
        }

        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {

        int opCount=10000000;

        ArrayQueue<Integer> arrayQ=new ArrayQueue<Integer>();
        double t1=testQueue(arrayQ,opCount);
        System.out.println("ArrayQueue time "+t1+"s");

        LoopQueue<Integer> loopQ=new LoopQueue<Integer>();
        double t2=testQueue(loopQ,opCount);
        System.out.println("LoopQueue time "+t2+"s");

    }
}
