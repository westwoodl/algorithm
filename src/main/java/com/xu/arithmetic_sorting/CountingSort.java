package com.xu.arithmetic_sorting;

import com.xu.util.O;
import com.xu.util.S;
import org.junit.Test;

/**
 * 计数排序
 *     Θ(k+n)  只适用于小整数排序，
 */
public class CountingSort {
    @Test public void exe(){
        int[] A = new int[]{2,5,3,0,2,3,0,3};
        S.s(countSort(A, new int[A.length], 6));
    }

    /**
     *
     * @param A
     * @param B 存放排序的输出
     * @param k C[]的大小，C[]提供临时存储空间，A中的值就是C的下标
     * @return
     */
    int[] countSort(int[] A, int[] B, int k){
        int[] C = new int[k];
        //C[] 置零
        for(int i=0;i<k;i++)
            C[i] = 0;
        //A中的值就是C的下标
        for(int j=0;j<A.length;j++)
            C[A[j]] = C[A[j]]+1;
        //通过这个，就能确定有多少个输入元素是小于或等于i(i=0...k)的(即有C[A[j]]个元素小于或等于A[j])
        for(int i=1;i<k;i++)
            C[i] = C[i] + C[i-1];
        //知道了A中的每个元素有多少个小于等于自己，就能知道自己在B中的下标了
        for(int j=A.length-1;j>=0;j--){
            B[C[A[j]]-1] = A[j];
            C[A[j]]--;
        }

        return B;
    }
}
