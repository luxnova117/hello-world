/**
 * Created by Alex Guo on 12/1/2016.
 This has been edited on github :D
 */
import java.util.*;
public class SearchNSort {
    private static final int SIZE = 10;
    public static void main(String args[]){
        /*ArrayList<Integer> a = new ArrayList<Integer>();
        int[] numbs = new int[SIZE];
        Random r = new Random();
        for(int i = 0; i < SIZE; i++){
            numbs[i] = (r.nextInt(100) + 1);
        }
        selectionSort(numbs);
        for(int i = 0; i < SIZE; i++){
            a.add(numbs[i]);
        }
        System.out.println(a);
        int value = numbs[r.nextInt(SIZE)];
        System.out.println("Searching for: " + value);
        binarySearch(a, value);
        */
        //int[] a = new int[]{1,2,3,5};
        //int[] b = new int[]{4,5,6,7,8,11,34,56,89};
        int[] merge = new int[]{3,9,97,4,98,99,50,48};
        System.out.println(Arrays.toString(mergeSort(merge)));

    }

    //binary search algorithm
    public static void binarySearch(ArrayList<Integer> a, int num){
        int midPoint = a.size() / 2;
        int minIndex = 0;
        int maxIndex = a.size();
        if(a.size()>0){
            while(minIndex <= maxIndex) {
                midPoint = (maxIndex + minIndex) / 2;
                System.out.println(a.get(midPoint));
                if(a.get(midPoint) == num){
                    break;
                } else if(num < a.get(midPoint)){
                    maxIndex = midPoint - 1;
                } else if(num > a.get(midPoint)){
                    minIndex = midPoint + 1;
                }

            }
        }
        if(a.get(midPoint) == num) {
            System.out.println("Found " + num + " at index of " + midPoint);
        } else {
            System.out.println("Not found");
        }

    }

    //selectionSort  algorithm
    public static void selectionSort(int[] a){
        for(int i = 0; i < a.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < a.length; j++){
               if(a[j] < a[min]){
                   min = j;
               }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        System.out.println(Arrays.toString(a));
    }

    //recursive merge sort
    public static int[] mergeSort(int[] a){
        if(a.length > 2) {
            int[] sortedLeft = mergeSort(Arrays.copyOfRange(a, 0, a.length / 2));
            int[] sortedRight = mergeSort(Arrays.copyOfRange(a, a.length / 2, a.length));
            System.out.println(Arrays.toString(sortedLeft) + " " + Arrays.toString(sortedRight));
            return merge(sortedLeft, sortedRight);
        } else {
            if (a.length > 1){
            swap(a);
            }
            return a;
        }

    }

    //swaps the elements if not in order.
    //the array will only have 2 elements
    public static void swap(int[] a){
        if(a[0] > a[1]){
            int temp = a[0];
            a[0] = a[1];
            a[1] = temp;
        }
    }

    //merges two arrays that are sorted in order
    public static int[] merge(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        for(int i = 0; i < c.length; i++){
            if(bIndex >= b.length || (aIndex < a.length && a[aIndex] <= b[bIndex])){
                c[i] = a[aIndex];
                    aIndex++;

            } else if(bIndex < b.length){
                c[i] = b[bIndex];
                    bIndex++;
            }
        }
        return c;
    }
}
