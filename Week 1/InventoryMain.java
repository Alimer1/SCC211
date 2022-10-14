public class InventoryMain
{
    public static void main(String[] args) throws InterruptedException
    {

        int[] intArgs = new int[3];
        boolean funky = false;

        switch(args.length)
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
                System.out.println("Only two arguments were entered. Assuming 0 for the other argument.");
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
                System.out.println("Too many arguments were entered. Ignoring everything after the third.");
                intArgs[0] = Integer.parseInt(args[0]);
                intArgs[1] = Integer.parseInt(args[1]);
                intArgs[2] = Integer.parseInt(args[2]);
        }

        if(intArgs[2] != 0)
        {
            funky = true;
        }

        OperationController mainOperation = new OperationController(intArgs[0], intArgs[1], funky);

    }
}