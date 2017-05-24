import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by byuwa on 2017/3/30.
 *
 *  生产者消费者模式
 */
public class ProducerConsumer<T> {
    /**
     * 消息总队列
     */
    static  class MsgQueueManager<T> {
        public final BlockingQueue<T> messageQueue;
        MsgQueueManager(BlockingQueue<T> messageQueue) {
            this.messageQueue = messageQueue;
        }
        MsgQueueManager() {
            this.messageQueue = new LinkedBlockingQueue<T>();
        }

        public void put(T msg) {
            try {
                messageQueue.put(msg);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        public T take() {
            try {
                return messageQueue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return null;
        }
    }

    static  class Producer extends Thread {
        //jiava中创建线程
        // 继承Thread类，重写Thread的run()方法，将线程运行的逻辑放在其中
        private MsgQueueManager msgQueueManager;
        public Producer(MsgQueueManager msgQueueManager) {
            this.msgQueueManager = msgQueueManager;
        }
        @Override
        public void run() {
            msgQueueManager.put(new Object());
        }
    }
    static class Consumer extends Thread{
        private MsgQueueManager msgQueueManager;
        public Consumer(MsgQueueManager msgQueueManager) {
            this.msgQueueManager = msgQueueManager;
        }
        @Override
        public void run() {
            Object o = msgQueueManager.take();
        }
    }

    public static void main(String[] args) {
        MsgQueueManager<String> msgQueueManager = new MsgQueueManager<String>();

        for(int i = 0; i < 100; i ++) {
            new Producer(msgQueueManager).start();

        }
        for(int i = 0; i < 100; i ++) {
            new Consumer(msgQueueManager).start();

        }
    }
}
