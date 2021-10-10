package Thread;

class Counter
{
    int count;

    public void increment()
    {
        count++;
    }
}

public class ThreadSafety
{
    public static void main(String []args)
    {
        try
        {
            final Counter object = new Counter();

            Thread thread1 = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 1000; i++)
                    {
                        object.increment();
                    }
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 1000; i++)
                    {
                        object.increment();
                    }
                }
            });

            thread1.start();

            thread2.start();

            thread1.join();

            thread2.join();

            System.out.println(object.count);

        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
