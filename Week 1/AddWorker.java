public class AddWorker implements Runnable
{
    private Storage storage;
    private boolean funky = false;

    public AddWorker(Storage nStorage,boolean nFunky)
    {
        storage = nStorage;
        funky = nFunky;
    }

    public void run()
    {
        if(funky)
        {
            storage.addBadCounter();
        }
        else
        {
            storage.addCounter();
        }
    }
}