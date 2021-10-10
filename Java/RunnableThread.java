package Thread;

class Another
{
    public void myMethod()
    {
        System.out.println("Hello Visitors");
    }
}

public class RunnableThread extends Another implements Runnable
{
    public static void main(String[] args)
    {
        RunnableThread runnableThread = new RunnableThread();

        runnableThread.myMethod();

        Thread thread = new Thread(runnableThread);

        thread.start();

        System.out.println("Outside the Thread Part!!");
    }

    public void run()
    {
        System.out.println("Thread is Running...");
    }
}
