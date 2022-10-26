/**
 * This class will call a method on the given storage class when run() is called
 */
public class AddWorker extends Worker
{
    /**
     * @param storage   //Storage that will be worked on
     * @param funky     //Flag if true will call the bad add operation on storage
     */
    public AddWorker(Storage storage,boolean funky)
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
            getStorage().addCounter();
        }
        else
        {
            getStorage().syncAddCounter();
        }
    }
}