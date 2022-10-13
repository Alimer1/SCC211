public class OperationController implements Runnable
{
    private Object lockA = new Object();
    private int counter = 0;

    public OperationController()
    {

    }

    public synchronized void run()
    {
        if(Thread.currentThread().getName().compareTo("add") == 0)
        {
            ++counter;
            System.out.println("Thread added 1. Counter is now = "+counter);
        }
        else
        {
            --counter;
            System.out.println("Thread removed 1. Counter is now = "+counter);
        }
    }
}