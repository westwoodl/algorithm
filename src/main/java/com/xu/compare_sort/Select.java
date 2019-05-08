package com.xu.compare_sort;

import com.xu.util.O;
import org.junit.Test;

/**
 * 期望为线性时间的选择算法
 *     选择第i小的元素 期望运行时间为Θ(n)
 */
public class Select {

    /**
     * 分治法的思想，调用了快速排序法的partition方法，但我们这里只处理划分的一边
     * @param A
     * @param p
     * @param r
     * @param i
     * @return A[p, r]数组中第i顺序统计量
     */
    int randomized_select(int[] A, int p, int r, int i){
        if(p==r)
            return A[p];
        //返回一个随机的主元下标
        int q = new QuickSort().partition(A, p, r, true);
        int k = q-p+1;//子数组[p, q]的元素个数
        if(i==k)
            return A[q];
        if(i<k)
            return randomized_select(A, p, q-1, i);
        else
            return randomized_select(A, q+1, r, i-k);
    }

    @Test public void exe(){
        O.o(randomized_select(new int[]{2,1,4,3}, 0, 3, 1));}
}
