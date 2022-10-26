/**
 * This class holds the stockpile value and the methods to modify it
 */
public class Storage
{

    private int stockpile = 0;

    public Storage()
    {

    }

    /**
     * Returns the stockpile value
     * 
     * @return  Current stockpile value
     */
    public int getCounter()
    {
        return(stockpile);
    }

    /**
     * Syncronized add method that will increment the stockpile 
     */
    public synchronized void syncAddCounter()
    {
        stockpile++;
        System.out.println("Added. Stockpile size = "+stockpile);
    }

    /**
     * Syncronized remove method that will reduce the stockpile 
     */
    public synchronized void syncRemoveCounter()
    {
        stockpile--;
        System.out.println("Removed. Stockpile size = "+stockpile);
    }

    /**
     * Non-syncronized add method that will increment the stockpile incorrectly 
     */
    public void addCounter()    //There methods still give the correct result if they were syncronised
    {
        int temp = stockpile;
        stockpile = temp+((int)(Math.random()*100));
        sleep(Math.min(Math.abs(10+(stockpile/100)),100));
        temp++;
        stockpile = temp;
        System.out.println("Added. Stockpile size = "+stockpile);
    }

    /**
     * Non-syncronized remove method that will reduce the stockpile incorrectly 
     */
    public void removeCounter()
    {
        int temp = stockpile;
        stockpile = temp+((int)(Math.random()*100));
        sleep(Math.min(Math.abs(10+(stockpile/100)),100));
        temp--;
        stockpile = temp;
        System.out.println("Removed. Stockpile size = "+stockpile);
    }

    /**
     * Sleeps the thread by the given amount
     * 
     * @param time  //Time to sleep the thread in ms
     */
    private void sleep(int time)
    {
        try
        {
            Thread.sleep(time);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
