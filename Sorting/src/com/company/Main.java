package com.company;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static int n = 10000;
    static int [] A = new int[n];
    public static void main(String[] args) {

        fillArray();
        MergeSort mergeSort = new MergeSort(A);
////        SelectionSort selectionSort = new  SelectionSort(A);
//        mergeSort.sort();
//       mergeSort.print();
//        System.out.println(mergeSort.inversions);
//        selectionSort.sort();
//        selectionSort.print();
//
//        InsertionSortRecursive insertionSortRecursive = new InsertionSortRecursive(A);
//        insertionSortRecursive.sort();
//        insertionSortRecursive.print();

//        testBinarySearch();
//        testAdditionSearch();

//        BubbleSort bubbleSort = new BubbleSort(A);
//        bubbleSort.sort();;
//        bubbleSort.print();
        MaximumSubarray maximumSubarray = new MaximumSubarray(A);
        maximumSubarray.start();
        int resultLinear = maximumSubarray.linearMethod()[2];
        maximumSubarray.stop();


        maximumSubarray.start();
        int resultReqursive = maximumSubarray.reсursiveMethod()[2];
        maximumSubarray.stop();
        System.out.println(resultLinear + " " + resultReqursive);
        System.out.println(maximumSubarray.bruteForceMethod()[2]);


    }
    public static int randInt(int min, int max) {


        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    static void fillArray()
    {

        for (int i=0; i<n; i++) A[i] = randInt(-1000,1000);
    }

    static void sortArray(){
        java.util.Arrays.sort(A);
    }

    static void testBinarySearch(){
        sortArray();


        for (int i = 0; i<1500; ++i) {
            int element = (int) (Math.random() * 100);
            BinarySearch binarySearch = new BinarySearch(A);
            int systemResult = java.util.Arrays.binarySearch(A,element);
            int myResult = binarySearch.search(element);
            if (systemResult == myResult && myResult>0)
            {
                System.out.println("success: find "+ myResult);
            }
            else if (systemResult<0 && myResult<0){
                System.out.println("success: null ");
            }
            else {
                System.out.println("fail");
            }




        }
    }

    static void testAdditionSearch(){
        AdditionSearch additionSearch = new AdditionSearch(A);
        for (int i = 0;i<1000; i++) {
            int sum = randInt(-10000, 10000);
            int myResult = additionSearch.search(sum);    //int represents boolean 1 or 0
            boolean sysResult = additionSearch.sillyAdditionSearch(sum);
            if (myResult == 1 && sysResult){
                System.out.println("Find");
            }
            else if (myResult == 0 && !sysResult){
                System.out.println("There aren't such indexes");

            }
            else {
                System.out.println("fail.....");
            }
        }



    }


}
