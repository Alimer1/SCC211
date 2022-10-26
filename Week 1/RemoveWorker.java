/**
 * This class will call a method on the given storage class when run() is called
 */
public class RemoveWorker extends Worker
{
    /**
     * @param storage   //Storage that will be worked on
     * @param funky     //Flag if true will call the bad remove operation on storage
     */
    public RemoveWorker(Storage storage,boolean funky)
    {
        super(storage, funky);
    }

    /*
     * Calls the method on the given storage depending on the funky value
     */
    public void run()
    {
        if(getFunky())
        {
            getStorage().removeCounter();
        }
        else
        {
            getStorage().syncRemoveCounter();
        }
    }
}