package com.xu.compare_sort;

/**
 * 插入排序 Θ(n^2)
 */
public class InsertionSort{
	public static void main(String[] args) {
		int[] array = {2,3,1,4,5,9,5,6,3,0};
		new InsertionSort().uptest(array);

	}
	int[] uptest(int[] array){
		for(int j=1;j<array.length;j++){
			int i = j-1;
			int key = array[i+1];
			while(i>=0&&array[i]<key){
				
				array[i+1] = array[i];
				i--;
			}
			array[i+1] = key;
		}
		showArray(array);
		return array;
	}
	int[] downtest(int[] array){
		for(int j=1;j<array.length;j++){
			int key = array[j];
			int i = j-1;

			showArray(array);
			while(i>=0&&array[i]>key){//为什么将array[j]换成key就成功了:因为array[j]会变，但是key没变

				array[i+1] = array[i];

				System.out.print("    ");showArray(array);
				i--;
			}
			array[i+1] = key;
		}

		System.out.print("the last result:");showArray(array);
		return array;
	}
	void showArray(int[] array){
		for(int a:array){
			System.out.print(a);
		}
		System.out.println();
	}
}