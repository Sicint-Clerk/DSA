package PC;

import java.util.LinkedList;

class ProducerConcumer
{
    public static void main(String[] args) throws InterruptedException
    {
        final ProduceConsume produceConsume = new ProduceConsume();

        Thread producerThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    produceConsume.produce();
                }

                catch (InterruptedException exception)
                {
                    exception.printStackTrace();
                }
            }
        });

        Thread consumeThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    produceConsume.consume();
                }

                catch (InterruptedException exception)
                {
                    exception.printStackTrace();
                }
            }
        });

        producerThread.start();

        consumeThread.start();

        producerThread.join();

        consumeThread.join();
    }

    public static class ProduceConsume
    {
        LinkedList<Integer> list = new LinkedList<Integer>();

        int capacity = 2;

        public void produce() throws InterruptedException
        {
            int value = 0;

            while (true)
            {
                synchronized (this)
                {
                    while (list.size() == capacity)
                    {
                        wait();
                    }

                    System.out.println("Producer produced-" + value);

                    list.add(value++);

                    notify();

                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {
                    while (list.size() == 0)
                    {
                        wait();
                    }

                    int val = list.removeFirst();

                    System.out.println("Consumer consumed-" + val);

                    notify();

                    Thread.sleep(1000);
                }
            }
        }
    }
}


