public class Storage
{

    private int counter = 0;

    public Storage()
    {

    }

    public int getCounter()
    {
        return(counter);
    }

    public synchronized void addCounter()
    {
        int temp = counter;
        temp=temp+1;
        counter = temp;
        System.out.println("Added 1. Currently :"+counter);
    }

    public synchronized void subCounter()
    {
        int temp = counter;
        temp=temp-1;
        counter = temp;
        System.out.println("Subbed 1. Currently :"+counter);
    }

    public void addBadCounter()
    {
        int temp = counter;
        temp=temp+1;
        counter = temp;
        System.out.println("Added 1. Currently :"+counter);
    }

    public void subBadCounter()
    {
        int temp = counter;
        temp=temp-1;
        counter = temp;
        System.out.println("Subbed 1. Currently :"+counter);
    }
}
