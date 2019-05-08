package com.xu.arithmetic_sorting;

import org.junit.Test;

/**
 * 桶排序
 *     假设数据服从均匀分布(均匀、独立的分布在[0, 1)上)，平均情况下他的时间代价为O(n)，期望运行时间为Θ(n)
 *     将[0, 1)划分为n个大小相同的子区间(桶)，先对每个桶排序，然后再排序每个桶
 *
 *     即使桶排序不服从均匀分布，只要每个桶的大小的平方和与总的元素呈线性关系，桶排序仍然能在线性时间内完成
 */
public class BucketSort {
    @Test public void execute(){
        double[] A = new double[10];
        for(int i=0;i<A.length;i++){
            A[i] = (int)(Math.random()*100)/100;
        }
        bucketSort(A);
    }

    /**
     * 如果A为如上，这有10个桶，每个桶的区间分别为[0, 0.10)、[0.10, 0.20)...，
     * 而临时数组B则用来存放链表（即这10个桶），每个桶为一个链表
     * B(?没学，将会学到:存在一种用于维护这些链表的机制)
     * @param A
     */
    void bucketSort(double[] A){
        int n = A.length;
        double[] B = new double[n];//new Array B[0,n-1]
        for(int i=0;i<n;i++)
            B[i] = 0;//make B[i] an empty list
        //将A中的元素放入桶中
        for(int i=0;i<n;i++)
            B[(int)(n*A[i])] = A[i];
        //对每个桶进行排序
        for(int i=0;i<n;i++){
            //使用插入排序法排序B[i]
        }

        //concatenate the list B[0] B[1] B[2]...B[n]

    }

}
