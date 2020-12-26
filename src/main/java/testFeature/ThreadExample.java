package testFeature;

public class ThreadExample {

    public static void main(String[] args){
        final PC pc = new PC();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static class PC{
        BlockingQueue blockingQueue = new BlockingQueue();
        public void produce() throws InterruptedException {
            int counter = 0;
            while(counter < 25){
                blockingQueue.enqueue(counter++);
            }

        }

        public void consume() throws InterruptedException {
            int counter = 0;
            while(counter < 25){
               Integer ret = (Integer) blockingQueue.dequeue();
                System.out.println("pulled "+ret);
                counter = ret;
            }
        }

    }
}
