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
//

//        Set<String> myLexical = new TreeSet<>();
//        ArrayList<String> additionalLexical = new ArrayList<>();
//
//
//        try (
//                BufferedReader bufferedReader = new BufferedReader(
//                        new FileReader("functionals.txt"));
//                BufferedReader br = new BufferedReader(
//                        new FileReader("nonlexical_big_file.txt"));
//                PrintWriter printWriter = new PrintWriter(
//                        new BufferedWriter(new FileWriter("nonlexical_big_file.txt",true)));
//        ) {
//            while(bufferedReader.ready()){
//                String[] words = bufferedReader.readLine().split("\\s");
//                for(String word : words){
//                    if(!word.isEmpty() && !word.equals(".")){
//                        myLexical.add(word.trim());
//                    }
//                }
////                myLexical.add(bufferedReader.readLine().trim());
//            }
//            while(br.ready()) {
//                String[] words = br.readLine().split("\\s");
//                for(String word : words){
//                    if(!word.isEmpty() && !word.equals(".")){
//                        myLexical.add(word.trim());
//                    }
//                }
//            }
////            for(String s : additionalLexical) {
//////                System.out.println(s);
////                if(!myLexical.contains(s) && !s.isEmpty()) {
////                    System.out.println(s);
////                }
////            }
//            for(String s : myLexical){
//                printWriter.println(s);
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
