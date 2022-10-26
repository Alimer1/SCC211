/**
 * General abstract worker class
 */
public abstract class Worker implements Runnable
{
    private Storage storage;
    private boolean funky = false;

    public Worker(Storage storage,boolean funky)
    {
        this.storage = storage;
        this.funky = funky;
    }

    /**
     * 
     * @return
     */
    public Storage getStorage()
    {
        return storage;
    }

    /**
     * 
     * @return
     */
    public boolean getFunky()
    {
        return funky;
    } 
    
    public abstract void run();

}
