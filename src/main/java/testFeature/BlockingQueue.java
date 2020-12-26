package testFeature;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

    private List queue = new LinkedList();
    private int limit =10;

    public synchronized void enqueue(Object object) throws InterruptedException {
        System.out.println("trying to add "+ object.toString());
        while (this.queue.size() == this.limit){
            System.out.println("waiting with "+ object.toString());
            wait();
        }
        queue.add(object);
        if(this.queue.size() == 1){
            notifyAll();
        }
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (this.queue.size() == 0){
            System.out.println("waiting to dequeue ");
            wait();
        }
        if(this.queue.size() == this.limit){
            notifyAll();
        }

        return this.queue.remove(0);

    }
}
