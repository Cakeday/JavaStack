import java.util.ArrayList;
import java.util.Arrays;

public class Basics {

    public void printTo255(){
        for(int i=1; i<256; i++){
            System.out.println(i);
        }
    }

    public void printOddTo255(){
        for(int i=1; i<256; i+=2){
            System.out.println(i);
        }
    }

    public void printSumTo255(){
        int sum = 0;
        for(int i=1; i<256; i++){
            System.out.println("New number = "+i);
            sum += i;
            System.out.println("sum = "+sum);

        }
    }

    public void iterate(int[] arr){
        if(arr.length>0){
            for(int i=0; i<arr.length; i++){
                System.out.println(arr[i]);
            }
        }
    }
    
    public void findMax(int[] arr){
        if (arr.length > 0) {
            int max = arr[0];
            for(int i=0; i<arr.length; i++){
                if (arr[i]>max){
                    max = arr[i];
                }
            }
            System.out.println(max);
        }
    }

    public void findAvg(int[] arr){
        if (arr.length > 0) {
            // int max = arr[0];
            // int min = arr[0];
            int sum = arr[0];
            for(int i=0; i<arr.length; i++){
                // if (arr[i]>max){
                //     max = arr[i];
                // }
                // if (arr[i]<min){
                //     min = arr[i];
                // }
                sum+=arr[i];
            }
            int avg = sum/arr.length;
            // System.out.println(max);
            // System.out.println(min);
            System.out.println(avg);
        }
    }

    public void arrPush(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=1; i<256; i+=2){
            arr.add(i);
        }
        System.out.println(arr);
    }

    public void greaterThanY(int[] arr, int index){
        if(arr.length>0){
            int counter = 0;
            for(int i=0; i<arr.length; i++){
                if(arr[i]<index){
                    counter += 1;
                }
            }
            System.out.println(counter);
        }
    }

    public void square(int[] arr){
        if(arr.length>0){
            for(int i=0; i<arr.length; i++){
                arr[i] = arr[i]*arr[i];
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    
    public void noNeg(int[] arr){
        if(arr.length>0){
            for(int i=0; i<arr.length; i++){
                if(arr[i] < 0){
                    arr[i] = 0;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public void findMaxMinAvg(int[] arr){
        if (arr.length > 0) {
            int max = arr[0];
            int min = arr[0];
            int sum = arr[0];
            for(int i=0; i<arr.length; i++){
                if (arr[i]>max){
                    max = arr[i];
                }    
                if (arr[i]<min){
                    min = arr[i];
                }    
                sum+=arr[i];
            }    
            int avg = sum/arr.length;
            System.out.println(max);
            System.out.println(min);
            System.out.println(avg);
        }    
    }        

    public void shift(int[] arr) {
        if(arr.length > 0) {
            for(int i = 0; i < arr.length-1; i++) {
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = 0;
            System.out.println(Arrays.toString(arr));
        }
    }







    
}