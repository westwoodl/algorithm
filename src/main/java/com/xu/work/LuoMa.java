package com.xu.work;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *  罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。
 * 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，
 * 而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class LuoMa {



    int exe(String str){
        int result=0;
        List list = new ArrayList<Character>();
        list.add('I');
        list.add('V');
        list.add('X');
        list.add('L');
        list.add('C');
        list.add('D');
        list.add('M');
        int[] value = new int[]{1,5,10,50,100,500,1000};
        int[] resultArray = new int[str.length()];
        for(int n=0;n<str.length();n++){
            resultArray[n] = value[list.indexOf(str.charAt(n))];
        }
        for (int n:resultArray) {
            System.out.print(n);
        }
        result = cal(resultArray);
        System.out.println("----"+str+":"+result);
        return result;
    }

    int cal(int[] array){
        int result = 0;
        int max = 0;
        int maxIndex=0;
        for(int n=0;n<array.length;n++){
            if(max<array[n]){
                max = array[n];
                System.out.println("max"+max);
                maxIndex = n;
            }
        }
        System.out.println(maxIndex+":maxIndex");
        if(maxIndex!=0){
            for (int n=0;n<maxIndex;n++){
                result = result - array[n];
            }
        }
        for (int n=maxIndex;n<array.length;n++){
            result = result + array[n];
        }
        return result;
    }


    @Test
    public void test(){
        exe("MMMIV");
        exe("CD");
    }
}
