public class SubWorker implements Runnable
{
    private Storage storage;
    private boolean funky = false;

    public SubWorker(Storage nStorage,boolean nFunky)
    {
        storage = nStorage;
        funky = nFunky;
    }

    public void run()
    {
        if(funky)
        {
            storage.subBadCounter();
        }
        else
        {
            storage.subCounter();
        }
    }
}