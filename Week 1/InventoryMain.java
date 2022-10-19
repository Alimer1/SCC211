public class InventoryMain
{
    public static void main(String[] args) throws InterruptedException
    {

        int[] intArgs = new int[3]; //0 = addCount , 1 = removeCount , funky(bug) mode flag
        boolean funky;  //funky(bug) mode flag

        switch(args.length) //Depending on how many arguments are entered we assign the value we can get.
        {
            case 0:
                System.out.println("No arguments were entered.Assuming 0 for every argument.");
                intArgs[0] = 0;
                intArgs[1] = 0;
                intArgs[2] = 0;
                break;
            case 1:
                System.out.println("Only one argument was entered. Assuming 0 for the other arguments.");
                intArgs[0] = Integer.parseInt(args[0]);
                intArgs[1] = 0;
                intArgs[2] = 0;
                break;
            case 2:
                System.out.println("Only two arguments were entered. Assuming 0 (FALSE) for the last argument.");
                intArgs[0] = Integer.parseInt(args[0]);
                intArgs[1] = Integer.parseInt(args[1]);
                intArgs[2] = 0;
                break;
            case 3:
                intArgs[0] = Integer.parseInt(args[0]);
                intArgs[1] = Integer.parseInt(args[1]);
                intArgs[2] = Integer.parseInt(args[2]);
                break;
            default:
                System.out.println("Too many arguments were entered. Ignoring everything after the third argument.");
                intArgs[0] = Integer.parseInt(args[0]);
                intArgs[1] = Integer.parseInt(args[1]);
                intArgs[2] = Integer.parseInt(args[2]);
        }

        switch(intArgs[2])  //Assigning the funky flag acording to the third argument
        {
            case 0:
                funky = false;
                break;
            case 1:
                funky = true;
                break;
            default:
                funky = true;
                System.out.println("Unexpected third argument, interpreting it as 1 (TRUE).");
                break;
        }

        OperationController mainOperation = new OperationController(intArgs[0], intArgs[1], funky);
        mainOperation.operationStart();

    }
}