package java112.labs1;

/**
 * 
 * The app provides TDD
 * practice
 * 
 * @author mturchanov
 * 
 */
public class MysteryClassOne {
    /**
     * 
     * the app is returning int value
     * 
     * @return needed integer value according to tests
     */
    public int mysteryMethodOne() { return 1; }

    /**
     * main run method
     * 
     * @param args
     */
    public static void main(String[] args){
        System.out.println("returned " + new MysteryClassOne().mysteryMethodOne());
    }
}
