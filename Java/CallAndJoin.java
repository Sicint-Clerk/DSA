package Thread;

class Callme
{
    void call(String msg)
    {
        System.out.print("[" + msg);

        try
        {
            Thread.sleep(1000);
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        System.out.println("]");
    }
}

class CallAndJoin implements Runnable
{
    String msg;

    Callme target;

    Thread thread;

    public CallAndJoin(Callme target, String string)
    {
        this.target = target;

        msg = string;

        thread = new Thread(this);

        thread.start();
    }

    public void run()
    {
        synchronized (target)
        {
            target.call(msg);
        }
    }
}

class Synch
{
    public static void main(String args[])
    {
        Callme target = new Callme();

        CallAndJoin object1 = new CallAndJoin(target, "Hello");

        CallAndJoin object2 = new CallAndJoin(target, "Synchronized");

        CallAndJoin object3 = new CallAndJoin(target, "World");

        try
        {
            object1.thread.join();

            object2.thread.join();

            object3.thread.join();
        }

        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}