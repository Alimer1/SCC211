public class Storage
{

    private int stockpile = 0;

    public Storage()
    {

    }

    public int getCounter()
    {
        return(stockpile);
    }

    public synchronized void syncAddCounter()
    {
        stockpile++;
        System.out.println("Added 1 to storage. Currently :"+stockpile);
    }

    public synchronized void syncRemoveCounter()
    {
        stockpile--;
        System.out.println("Removed 1 from storage. Currently :"+stockpile);
    }

    public void addCounter()
    {
        int temp = stockpile;
        temp++;
        try
        {
            Thread.sleep(100);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        stockpile = temp;
        System.out.println("Added 1 to storage. Currently :"+stockpile);
    }

    public void removeCounter()
    {
        int temp = stockpile;
        temp--;
        try
        {
            Thread.sleep(100);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        stockpile = temp;
        System.out.println("Removed 1 from storage. Currently :"+stockpile);
    }
}
