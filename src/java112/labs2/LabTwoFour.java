package java112.labs2;


import java.util.*;


/**
 * This class initializes,
 * checks and compares values
 * for {@link #map#anotherMap}
 */
public class LabTwoFour {
    private Map<String, Integer> map;
    private Map<String, Integer> anotherMap;

    /**
     * Entry point of the application
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        LabTwoFour output = new LabTwoFour();
        output.run();
    }

    /**
     * Initializes, checks and compares
     * values for {@link #map#anotherMap},
     */
    public void run(){
        map = new HashMap();
        map.put("one", 1);
        map.put("two", 2);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.printf("Key: %s, value: %d%n", pair.getKey(),
                    pair.getValue());
        }
        System.out.println(map);

        String neededKey = "three";
        if (!map.containsKey(neededKey)){
            System.out.println("Error! There wasn't key with a key \"three\"");
        } else {
            System.out.println(System.out.printf("{%s=%d}%n",
                    neededKey, map.get(neededKey)));
        }

        anotherMap = new TreeMap(map);
        System.out.printf("map.equals(anotherMap) //%b%n", anotherMap.equals(map));
    }
}
