public class OperationController
{

    private Storage storage = new Storage();
    private AddWorker[] addWorkers;
    private SubWorker[] subWorkers;
    
    private Thread[] addThreads;
    private Thread[] subThreads;

    public OperationController(int nAddCount,int nSubCount,boolean nFunky)
    {
        addWorkers = new AddWorker[nAddCount];
        subWorkers = new SubWorker[nSubCount];

        addThreads = new Thread[nAddCount];
        subThreads = new Thread[nSubCount];

        for(int i=0;i<nAddCount;i++)
        {
            addWorkers[i] = new AddWorker(storage,nFunky);
            addThreads[i] = new Thread(addWorkers[i]);
        }

        for(int i=0;i<nSubCount;i++)
        {
            subWorkers[i] = new SubWorker(storage,nFunky);
            subThreads[i] = new Thread(subWorkers[i]);
        }

        for(int i=0;i<nAddCount;i++)
        {
            addThreads[i].start();
        }

        for(int i=0;i<nSubCount;i++)
        {
            subThreads[i].start();
        }

        for(int i=0;i<nAddCount;i++)
        {
            try
            {
                addThreads[i].join();
            }
            catch (Exception e) {}
        }

        for(int i=0;i<nSubCount;i++)
        {
            try
            {
                subThreads[i].join();
            }
            catch (Exception e) {}
        }

        System.out.println("Completion! Final counter is :"+storage.getCounter());
        
    }

}