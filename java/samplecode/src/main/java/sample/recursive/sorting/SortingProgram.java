package sample.Recursive.sorting;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SortingProgram {
    public static void main(String[] args) {
        int LEN = 100;
        int[] unsorted = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            unsorted[i] = (int)(Math.random() * 100) + 1;
        }
        log.info("Unsorted Array : ");
        printArray(unsorted);
        int[] sorted = sort(unsorted);
        log.info("\n\nSorted Array : ");
        printArray(unsorted);
    }

    private static void printArray(int[] unsorted) {
        log.info("");
        for (int i = 0; i < unsorted.length; i++) {
            if(unsorted[i] < 10){
                log.info(" ");
            }
            log.info(unsorted[i] + "  ");
            if((i +1) % 20 == 0){
                log.info("   ");
            }
        }
    }

    private static int[] a;

    private static int[] sort(int[] unsorted) {
        a = unsorted;
        sort(0, unsorted.length - 1);
        return unsorted;
    }

    private static void sort(int low, int high) {
        if( low >= high ){
            return;
        }

        int p = partition(low, high);
        sort(low, p);
        sort(p+1, high);
    }

    private static int partition(int low, int high) {
        int pivot = a[low];
        int i = low -1;
        int j = high + 1;
        while (i < j){
            for(i ++ ; a[i] < pivot; i ++);
            for(j -- ; a[j] > pivot; j --);
            if( i < j )
                swap(i ,j);
        }
        return j;
    }

    public static void swap(int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
