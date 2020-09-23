/*
 * Date: 2020-09-20
 * File rj222nq_assign1.java
 * Author: Rebecca Seiron
 * 
 */
package rj222nq_assign1;

public class ArraysMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Arrays arrs = new Arrays();

        /* Average */
        int arr[] = {10,2,3,4,5,6,7,8,9};
        //   System.out.println(Arrays.average(arr)); 

        /* Max */
        int maxNum[] = {10,2,3,4,5,6,7,8,9};
        // System.out.println(Arrays.max(maxNum)); 


        /* Add number */
        int n = 2;
        //  arrs.addN(arr, n);

        /* Reverse*/
        //	arrs.reverse(arr);

        /* Replace */
        int old = 5;
        int nw = 2;
        //  arrs.replaceAll(arr, old, nw);

        /* Sort */
         arrs.sort(arr);

        /* Contains */
        int[] sub = {2,3,5};

        if (arrs.hasSubString(arr, sub)) { // If the method return true
            //     System.out.print("true"); // Print true
        } else { // else
            //   System.out.print("false");  / print false
        }

        /* Different */
        int arr1[] = {1,2,3,4,5};
        int arr2[] = {1,1,1,1,1};

      //  arrs.absDif(arr1, arr2);
    }
}