public class OperationController implements Runnable
{

    private int counter = 0;

    public OperationController()
    {

    }

    public void run()
    {
        if(Thread.currentThread().getName().compareTo("add") == 0)
        {
            ++counter;
            System.out.println((counter-1)+"+1="+counter);
        }
        else
        {
            --counter;
            System.out.println((counter+1)+"-1="+counter);
        }
    }
}