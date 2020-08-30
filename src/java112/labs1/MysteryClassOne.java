package java112.labs1;

/**
 * 
 * The app provided TDD
 * practice
 * 
 * @author mturchanov
 * 
 */
public class MysteryClassOne {
    /**
     * 
     * the app returns int value
     * 
     * @return needed integer value according to tests
     */
    public int mysteryMethodOne() { return 1; }

    /**
     * Entry point of the app
     * 
     * @param args command line arguments
     */
    public static void main(String[] args){
        System.out.println("returned " + new MysteryClassOne().mysteryMethodOne());
    }
}
