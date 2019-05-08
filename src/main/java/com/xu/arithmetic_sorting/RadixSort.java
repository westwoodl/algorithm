package com.xu.arithmetic_sorting;
import com.xu.util.O;
import com.xu.util.S;
import org.junit.Test;

/**
 * 基数排序(LSD)
 *     Θ(d(n+k))
 *     将计数排序(stable sort)用作radix的子过程
 *
 *
 * 博客摘录：
 *     从低位开始（我们采用LSD的方式（非字典模式）），将所有元素对应该位的数字存到相应的桶子里去（对应二维数组的那一列）。
 *     然后将所有桶子里的元素按照桶子标号从小到大取出，对于同一个桶子里的元素，先放进去的先取出，后放进去的
 *     后取出（保证排序稳定性）。这样原数组就按该位排序完毕了，继续下一位操作，直到最高位排序完成。
 *
 * 个人理解：
 *     稳定性：体现点：对比两个数 489 和 482，
 *         1.比较第一位数，后者小在前
 *         2.比较第二位数，他们相等，回顾计数排序的稳定性排序性质，两数相等，前后的相对位置不会发生改变，确保前面的排序不失效
 *     如果没有稳定排序的计数排序，就有可能在排序形同 489 和 482 两数时发生与预期结果不一致的情况
 *
 *     用桶的思想理解：比较个位 放入相应的10个桶中（0，1，2，3，4，5，6，7，8，9）-->和个位一样的方式比较十位
 */

/**
 * 关于LSD和MSD：
 * least significant digit (LSD) 基数排序通常使用以下排序顺序：短键（长度短）在较长的键之前，而长度相同的键按字典顺序排序。
 * 这与整数表示的正常顺序一致，例如顺序1,2,3,4,5,6,7,8,9,10,11。从个位开始向高位挪动
 *
 * most significant digit (MSD)基数排序使用词典顺序，这适合排序字符串，如单词或固定长度整数表示。
 * 诸如“b，c，d，e，f，g，h，i，j，ba”的序列按字典顺序排序为“b，ba，c，d，e，f，g，h，i，j ”。如
 * 果使用词典排序来对可变长度整数表示进行排序，则从1到10的数字的表示将被输出为1,10,2,3,4,5,6,7,8,9，
 */
public class RadixSort {

    @Test public void exe(){
        S.s(radixSort(new int[]{112,324,213,789,876,567,435,907,987,150}, 3));
    }

    /**
     *
     * @param A
     * @param d 最高位d，最低位1
     * @return
     */
    int[] radixSort(int[] A, int d){
        int[] B = null;
        for(int i=1;i<=d;i++){
            int k=10;
            B = new int[A.length];
            countSort(A, B, k, i);
        }
        return B;
    }

    /**
     * 针对d位数的计数排序
     * @param A input
     * @param B output
     * @param k 临时数组C的长度 10
     * @param d 哪一位 10 100
     * @return
     */
    int[] countSort(int[] A, int[] B, int k, int d){
        int[] C = new int[k];
        //C[] 置零
        for(int i=0;i<k;i++)
            C[i] = 0;
        //A中的值就是C的下标
        for(int j=0;j<A.length;j++)
            C[num(A[j], d)] = C[num(A[j], d)]+1;
        //通过这个，就能确定有多少个输入元素是小于或等于i(i=0...k)的(即有C[A[j]]个元素小于或等于A[j])
        for(int i=1;i<k;i++)
            C[i] = C[i] + C[i-1];
        //知道了A中的每个元素有多少个小于等于自己，就能知道自己在B中的下标了
        for(int j=A.length-1;j>=0;j--){
            B[C[num(A[j], d)]-1] = A[j];
            C[num(A[j], d)]--;
        }
        return B;
    }

    //
    @Test public void testWei(){
        S.s(countSort(new int[]{112,324,213,789,876,567,435,907,987,150}, new int[10], 10, 2));
        System.out.println(num(364, 3));
    }

    /**
     * @param num
     * @param d
     * @return num的第d位数字
     */
    int num(int num, int d){
        String str = String.valueOf(num);
        char res = str.charAt(str.length() - d);
        return Integer.parseInt(res+"");
    }
}
