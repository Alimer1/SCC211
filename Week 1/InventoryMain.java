public class InventoryMain
{
    public static void main(String[] args) throws InterruptedException
    {
        /* Might use later
        switch(args.length)
        {
            case 1:

            break;
        }
        */

        int[] intArgs = new int[3];

        intArgs[0] = Integer.parseInt(args[0]);
        intArgs[1] = Integer.parseInt(args[1]);
        intArgs[2] = Integer.parseInt(args[2]);

        OperationController operation1 = new OperationController();

        Thread[] addThreads = new Thread[intArgs[0]];
        Thread[] subThreads = new Thread[intArgs[1]];

        for(int i = 0;i<intArgs[0];i++)
        {
            addThreads[i] = new Thread(operation1,"add");
            addThreads[i].start();
        }

        for(int i = 0;i<intArgs[1];i++)
        {
            subThreads[i] = new Thread(operation1,"sub");
            subThreads[i].start();
        }
    }
}