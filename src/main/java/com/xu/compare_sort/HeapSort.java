package com.xu.compare_sort;

import com.xu.util.O;
import com.xu.util.SortUtil;
import org.junit.Test;

/**
 * 堆排序
 *   1.MAX-HEAPIFY(A, i)，维持i节点为最大堆的特性
 *   2.BUILD-MAX-HEAP(A) 非叶结点（num = A.length/2）自底向上的调用MAX-HEAPIFY(A, i)
 *     将大小为n=A.length的数组A[1..n]转化为最大堆
 *   3.HEAPSORT(A)
 */

/**
 * 编程思想：
 *      最大堆：父节点永远比子结点大（没有左结点大于右结点的性质）
 *      1.将数组构建为堆-->2.取数组第一个元素（即为根结点）-->3.保持*前面*最大堆的特性-->2.-->3-->2...
 *      即递归。
 */

/**
 * 数学分析：
 *      max-heap-ify: T(n) <= T(2n/3) + Θ(1)
 *          T(n) = O(lg n) 树的高就是lg n
 *      build-max-heap: O(n)次调用max-heap-ify
 *          T(n) = O(nlg n) 渐进紧确界O(n)
 *      heap-sort: 调用了一次build-max-heap和n-1次max-heap-ify
 *          T(n) = O(nlg n)
 */
public class HeapSort {
    /**
     * 如下三个方法返回的分别为下标为i的结点的父节点、左孩子、右孩子结点的下标
     */
    private int parent(int i){return ((int)((i+1)/2))-1;}//int强制转换为向下取整
    private int left(int i){return 2*i+1;}
    private int right(int i){return 2*i+2;}
    /**
     * 维护堆的性质：左结点大于右结点
     *          0
     *      1        2
     *   3    4   5     6
     * 7  8 9 10 11 12 13 14
     *
     * @param A 需要排序的数组
     * @param i 下标
     */
    private void maxHeapIfy(int[] A, int i, int heap_size){
        int left = left(i);
        int right = right(i);
        int largest;
        //判断i，right，left谁大
        largest = left<heap_size && A[left]>A[i] ? left:i;
        if(right<heap_size && A[right]>A[largest])largest = right;
        //如果最大的不是i自身，需要置换元素
        if(largest!=i) {
            //exchange A[i] with A[largest]
            int key = A[i];
            A[i] = A[largest];
            A[largest] = key;
            //此时i成为最大值，但是largest自己本身会被影响，可能会不满足堆的性质
            //因此递归向下调用，维持堆的性质
            maxHeapIfy(A, largest, heap_size);
        }
            //最大的是自身，堆性质保持完成

    }

    /**
     * 建堆
     * @param A
     * @return 非叶子结点自底向上的调用maxHeapIfy()
     */
    private int[] buildMaxHeap(int[] A){
        for(int n=(int)(A.length/2)-1;n>=0;n--){
            maxHeapIfy(A, n, A.length);
        }
        return A;
    }

    /**
     * 堆排序
     * @param A
     * @return
     */
    private int[] heapSort(int[] A){
        buildMaxHeap(A);
        System.out.print("构建最大堆：");SortUtil.show(A);
        int heap_size = A.length;
        for(int n=A.length-1;n>=0;n--){
            //exchange A[n] with A[0]
            int key = A[n];
            A[n] = A[0];
            A[0] = key;
            //数组后面已经排好序
            heap_size--;
            maxHeapIfy(A, 0, heap_size);
            O.o("排序+保持堆性质：");SortUtil.show(A);
        }
        return A;
    }

    @Test public void testParent(){
        int x = 0;
        for(int ran : new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12}){

            System.out.println(ran+"="+right(ran));

        }
    }
    @Test public void testmaxHeapIfy(){
        int[] A = new int[]{16,8,10,14,7,9,3,2,4,1};
        maxHeapIfy(A, 1, A.length);
        for (int x:A) {
            System.out.print(x+" ");
        }
    }
    @Test public void testBuildHeap(){
        int[] A = new int[]{16,8,7,14,10,9,4,2,3,1};//{16,8,10,14,7,9,3,2,4,1};
        System.out.println((int)(A.length/2)-1);
        buildMaxHeap(A);
        for (int x:A) {
            System.out.print(x+" ");
        }
    }
    @Test public void testHeapSort(){
        int[] A = new int[]{16,8,7,14,10,9,4,2,3,1};//{16,8,10,14,7,9,3,2,4,1};

        heapSort(A);

        SortUtil.show(A);
    }
}
//数组没有heap—size
//class A{
//    public static int length;
//    public static int heap_size;
//    private int[] array;
//
//    public A(int[] array){
//        this.array = array;
//        length = array.length;
//        heap_size = length;
//    }
//}