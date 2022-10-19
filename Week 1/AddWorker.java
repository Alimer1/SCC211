public class AddWorker extends Worker implements Runnable
{
    public AddWorker(Storage nStorage,boolean nFunky)
    {
        super(nStorage, nFunky);
    }

    public void run()
    {
        if(funky)
        {
            storage.addCounter();
        }
        else
        {
            storage.syncAddCounter();
        }
    }
}