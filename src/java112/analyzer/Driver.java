package java112.analyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * This program reads a text-file,
 * analyzes its tokens,
 * creates summary-report on it,
 * creates a list with all unique words
 *
 * @author mturchanov
 * @since 1.0
 */
public class Driver {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
//        System.out.println(" it,-is a different".replaceAll("\\W"," "));
        FileAnalysis output = new FileAnalysis();
        output.analyze(args);
//        Set<String> myLexical = new TreeSet<>();
//        ArrayList<String> additionalLexical = new ArrayList<>();
//
//
//        try (
//                BufferedReader bufferedReader = new BufferedReader(
//                        new FileReader("nonlexical2.txt"));
//                BufferedReader br = new BufferedReader(
//                        new FileReader("nonlexical1.txt"));
//                PrintWriter printWriter = new PrintWriter(
//                        new BufferedWriter(new FileWriter("additionalLexical.txt")));
//        ) {
//            while(bufferedReader.ready()) myLexical.add(bufferedReader.readLine().trim());
//            while(br.ready()) {
//                String[] words = br.readLine().split("\\s");
//                for(String s : words) additionalLexical.add(s.trim());
//            }
//            for(String s : additionalLexical) {
////                System.out.println(s);
//                if(!myLexical.contains(s) && !s.isEmpty()) {
//                    System.out.println(s);
//                }
//            }
//        } catch (FileNotFoundException fileNotFoundException) {
//            System.out.println("The file was not found");
//            fileNotFoundException.printStackTrace();
//            return;
//        } catch (IOException ioException) {
//            System.out.println("There was problem input/output error");
//            ioException.printStackTrace();
//            return;
//        } catch (Exception e) {
//            System.out.println("There was problem");
//            e.printStackTrace();
//            return;
//        }
    }
}
