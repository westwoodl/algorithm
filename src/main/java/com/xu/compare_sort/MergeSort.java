package com.xu.compare_sort;

import com.xu.util.SortUtil;
import org.junit.Test;

/**
 * 归并排序 Θ(nlg n)
 */
public class MergeSort {

    @Test
    public void testest(){
        new SortUtil().showArray(up_merge_sort(new int[]{4, 3, 2, 9, 0, -1, 4, 8}, 0, 7));
        new SortUtil().showArray(up_merge_sort(new int[]{3, 1, 6, 4, 0, 9, 2, 8, -1, 5, 4, 3, 2, 9, 0, 7}, 0, 15));
    }

    //升序
    int[] up_merge_sort(int[] array, int p, int r){

        if(p<r){
            int q = (p+r-1)/2;
            if(q!=0){
                up_merge_sort(array, p, q);
                up_merge_sort(array, q+1, r);
            }
            upmerge(array, p, q, r);
        }
        return array;
    }

    //返回升序数组 ┭┮﹏┭┮
    int[] upmerge_1(int[] array1, int[] array2){
        int[] result = new int[array1.length+array2.length];
        int x1 = 0, x2 = 0;

        for (int x= 0; x<result.length; x++){
            if(x1 >= array1.length&&x2 >= array2.length){
                break;
            }
            if(x1 >= array1.length){
                result[x] = array2[x2];
                x2++;
                continue;
            }
            if(x2>=array2.length){
                result[x] = array1[x1];
                x1++;
                continue;
            }
            if(array1[x1] < array2[x2]){
                result[x] = array1[x1];
                x1++;
                continue;
            }
            if(array1[x1] > array2[x2]){
                result[x] = array2[x2];
                x2++;
                continue;
            }if(array1[x1] == array2[x2]){
                result[x] = array2[x2];
                result[++x] = array1[x1];
                x1++;
                x2++;
            }
            System.out.println(result[x]);
        }
        return result;
    }

    //merge 2.0
    int[] upmerge(int[] array, int p, int q, int r){
        //定义两个新的数组，将array的前部赋给L，后部赋给R
        int[] L = new int[q-p+1];
        int[] R = new int[r-q];
        for(int n=0;n<L.length;n++){
            L[n] = array[p+n];
        }
        for(int n=0;n<R.length;n++){
            R[n] = array[q+n+1];
        }
        //遍历array，比较R和L取最小值并赋给array
        int i = 0, j = 0;
        for(int n=p;n<r+1;n++){
            //因为i和j中的其中一个的值很有可能提前溢出（并不是同步自增），如下三个if防止溢出
            if(i>=L.length&&j>=R.length)break;
            if(i>=L.length){
                array[n] = R[j];
                j++;continue;
            }
            if (j>=R.length){
                array[n] = L[i];
                i++;continue;
            }
            //判断大小并赋给array
            if(L[i]<=R[j]){
                array[n] = L[i];
                i++;
            }else{
                array[n] = R[j];
                j++;
            }
        }
        return array;
    }

    @Test
    public void testMerge(){
        new SortUtil().showArray(
                upmerge(new int[]{3,4,2,9}, 0, 1, 3));
    }
}
