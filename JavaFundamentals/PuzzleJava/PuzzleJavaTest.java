import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class PuzzleJavaTest{

    public static void main(String[] args) {
        PuzzleJava test = new PuzzleJava();

        // int[] arr = {3,5,1,2,7,9,8,13,25,32};
        // System.out.println(test.first(arr)); 

        // ArrayList<String> names = new ArrayList<String>();
        // names.add("Ishikawa");
        // names.add("Nancy");
        // names.add("Jinichi");
        // names.add("Fujibayashi");
        // names.add("Momochi");
        // Collections.shuffle(names);
        // for(String name : names){
        //     System.out.println(name);
        // }
        // System.out.println(test.names(names)); 

        // test.alphabetShuffle();

        // test.randomTen();
        
        // test.randomTenSorted();

        // System.out.println(test.randomString(20));
        
        test.random10Strings(5);


        }
    }