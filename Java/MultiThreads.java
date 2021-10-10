package Thread;

class NewThread implements Runnable
{
    String name;

    Thread thread;

    NewThread(String threadName)
    {
        name = threadName;

        thread = new Thread(this, name);

        System.out.println("New thread: " + thread);

        thread.start();
    }

    public void run()
    {
        try
        {
            for(int i = 5; i > 0; i--)
            {
                System.out.println(name + ": " + i);

                Thread.sleep(1000);
            }
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        System.out.println(name + " exiting.");
    }
}

public class MultiThreads
{
    public static void main(String []args)
    {
        new NewThread("One");

        new NewThread("Two");

        new NewThread("Three");

        try {

            Thread.sleep(10000);

        }
        catch (Exception exception)
        {
           exception.printStackTrace();
        }

        System.out.println("Main thread exiting.");
    }
}


