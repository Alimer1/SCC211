public class RemoveWorker extends Worker implements Runnable
{
    public RemoveWorker(Storage nStorage,boolean nFunky)
    {
        super(nStorage, nFunky);
    }

    public void run()
    {
        if(funky)
        {
            storage.removeCounter();
        }
        else
        {
            storage.syncRemoveCounter();
        }
    }
}