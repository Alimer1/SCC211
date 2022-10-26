/**
 * Controls the operation of workers that remove and add stuff to the storage(stockpile).
 */
public class OperationController
{

    private Storage storage = new Storage();    //Storage that every worker will be working on

    private Worker[] workers;
    private Thread[] workerThreads;

    private int totalWorkerCount;               //Total number of total workers that will be working on the stockpile


    /**
     * Creates and assigns worker classes to threads to be run by the operationStart() method
     * 
     * @param addWorkerCount    Number of workers that are going to add to the stockpile
     * @param removeWorkerCount Number of workers that are going to remove from the stockpile
     * @param funky             Bug flag (Funky flag) if it is true the result of the program will be not syncronised and will give an incorrect result.
     */
    public OperationController(int addWorkerCount,int removeWorkerCount,boolean funky)
    {

        totalWorkerCount = addWorkerCount + removeWorkerCount;

        //Creating the threads and the workers
        workers = new Worker[totalWorkerCount];
        workerThreads = new Thread[totalWorkerCount];

        //We first add AddWorkers to the Worker array
        for(int i=0;i<addWorkerCount;i++)
        {
            workers[i] = new AddWorker(storage,funky);
        }

        //Then we continue from where we left of and add the RemoveWorkers to the array
        for(int i=0;i<(removeWorkerCount);i++)
        {
            workers[i+addWorkerCount] = new RemoveWorker(storage,funky);
        }

        //We add all the workers to the threads
        for(int i=0;i<totalWorkerCount;i++)
        {
            workerThreads[i] = new Thread(workers[i]);
        }

    }

    /**
     * Stars the treads initialised in the constructor.
     * Waits for them to finish before displaying the final stockpile amount. 
     */
    public void operationStart()
    {
        //Starting all the threads
        for(int i=0;i<workerThreads.length;i++)
        {
            workerThreads[i].start();
        }


        //Waiting for threads to finish
        for(int i=0;i<workerThreads.length;i++)
        {
            try
            {
                workerThreads[i].join();
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