package java112.labs1;

/**
 * The Lab three that continue to
 * implement TDD principles.
 */
public class LabThree {

    /**
     * Output first argument of the command line
     *
     * @param str the first command line string/arg
     */
    public void run(String str) {
        System.out.println("input: " + str);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            LabThree labThreeOutput = new LabThree();
            labThreeOutput.run(args[0]);
        }
    }
}
