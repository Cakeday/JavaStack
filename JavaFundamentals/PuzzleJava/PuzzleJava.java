import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Random;

import org.omg.CORBA.LongSeqHelper;

public class PuzzleJava {

    public ArrayList first(int[] arr){
        ArrayList<Integer> newarr = new ArrayList<Integer>();
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
            if(arr[i]>10){
                newarr.add(arr[i]);
            }
        }
        return newarr;
    }


    public void alphabetShuffle(){
        ArrayList<Object> alphabet = new ArrayList<Object>();
        alphabet.add("a");
        alphabet.add("b");
        alphabet.add("c");
        alphabet.add("d");
        alphabet.add("e");
        alphabet.add("f");
        alphabet.add("g");
        alphabet.add("h");
        alphabet.add("i");
        alphabet.add("j");
        alphabet.add("k");
        alphabet.add("l");
        alphabet.add("m");
        alphabet.add("n");
        alphabet.add("o");
        alphabet.add("p");
        alphabet.add("q");
        alphabet.add("r");
        alphabet.add("s");
        alphabet.add("t");
        alphabet.add("u");
        alphabet.add("v");
        alphabet.add("w");
        alphabet.add("x");
        alphabet.add("y");
        alphabet.add("z");
        System.out.println(alphabet);
        Collections.shuffle(alphabet);
        System.out.println(alphabet);
        System.out.println(alphabet.get(alphabet.size()-1));
        System.out.println(alphabet.get(0));
        if(alphabet.get(0) == "a" || alphabet.get(0) == "e" || alphabet.get(0) == "i" || alphabet.get(0) == "o" || alphabet.get(0) == "u"){
            System.out.println("The first letter is a vowel");
        }
    }


    public void randomTen(){
        int[] arr;
        arr = new int[10];
        Random ran = new Random();
        for(int i = 0; i<arr.length; i++){
            int nxt = ran.nextInt(100-55) + 55;
            arr[i] = nxt;
        }
        System.out.println(Arrays.toString(arr));
    }


    public void randomTenSorted(){
        int[] arr;
        arr = new int[10];
        Random ran = new Random();
        for(int i = 0; i<arr.length; i++){
            int nxt = ran.nextInt(100-55) + 55;
            arr[i] = nxt;
        }
        ArrayList<Integer> intList = new ArrayList<Integer>();
        for(int i : arr){
            intList.add(i);
        }
        Collections.sort(intList);
        System.out.println(intList);
    }
    
    
    public String randomString(int n){
        // Random ran = new Random();
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvxyz"; 
        StringBuilder sb = new StringBuilder(n);
        for(int i = 0; i<n; i++){
            int index = (int)(AlphaNumericString.length()*Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
    
    
    public void random10Strings(int n){
        ArrayList<String> longArray = new ArrayList<String>();
        for(int j =0; j<10; j++){ 
            // Random ran = new Random();
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvxyz"; 
            StringBuilder sb = new StringBuilder(n);
            for(int i = 0; i<n; i++){
                int index = (int)(AlphaNumericString.length()*Math.random());
                sb.append(AlphaNumericString.charAt(index));
            }
            System.out.println(sb.toString());
            String str = sb.toString();
            longArray.add(str);
        }
        System.out.println(longArray);
    }











}