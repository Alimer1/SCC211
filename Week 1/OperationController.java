public class OperationController
{

    private Storage storage = new Storage();
    private AddWorker[] addWorkers;
    private RemoveWorker[] removeWorkers;
    
    private Thread[] addThreads;
    private Thread[] removeThreads;

    private int addCount;
    private int removeCount;

    public OperationController(int nAddCount,int nRemoveCount,boolean funky)
    {
        addCount = nAddCount;
        removeCount = nRemoveCount;

        //Making the arrays correct size
        addWorkers = new AddWorker[addCount];
        removeWorkers = new RemoveWorker[removeCount];

        addThreads = new Thread[addCount];
        removeThreads = new Thread[removeCount];

        //Initialising both add and remove classes then assigning them to threads
        for(int i=0;i<addCount;i++)
        {
            addWorkers[i] = new AddWorker(storage,funky);
            addThreads[i] = new Thread(addWorkers[i]);
        }

        for(int i=0;i<removeCount;i++)
        {
            removeWorkers[i] = new RemoveWorker(storage,funky);
            removeThreads[i] = new Thread(removeWorkers[i]);
        }

    }

    public void operationStart()
    {
        //Starting add and remove threads
        for(int i=0;i<addCount;i++)
        {
            addThreads[i].start();
        }

        for(int i=0;i<removeCount;i++)
        {
            removeThreads[i].start();
        }

        //Waiting for both of them to finish
        for(int i=0;i<addCount;i++)
        {
            try
            {
                addThreads[i].join();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }

        for(int i=0;i<removeCount;i++)
        {
            try
            {
                removeThreads[i].join();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }

        //Printing the final result
        System.out.println("Completion! Final stockpile in storage is :"+storage.getCounter());
    }

}