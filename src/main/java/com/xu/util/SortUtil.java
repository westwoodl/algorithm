package com.xu.util;

/**
 * iterate print array
 * @author Ron
 */
public class SortUtil {
    public void showArray(int[] array){
        SortUtil.show(array);
    }
    public static void show(int[] array){
        System.out.print("[");
        for(int a:array){
            System.out.print(a+" ");
        }
        System.out.println("]");
    }
}
