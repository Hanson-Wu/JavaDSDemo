package dsApp;

public class ShellSort {
    public void shellSort(int[] array, int n) {
        int i, j, gap;
        int temp;
        for (gap = n / 2; gap > 0; gap /= 2) {// 计算gap大小
            for (i = gap; i < n; i++) {// 将数据进行分组
                for (j = i - gap; j >= 0 && array[j] > array[j + gap]; j -= gap) {// 对每组数据进行插入排序
                    temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;
                }
                // 打印每趟排序结果
                for (int m = 0; m <= array.length - 1; m++) {
                    System.out.print(array[m] + "\t");
                }
                System.out.println();
            }
        }
    }
 
    public void mySort(int[] array){
    	int i, j, n = array.length, gap;
        int temp;
        for (gap = n / 3; gap > 0; gap /= 3) {// 计算gap大小
            for (i = gap; i < n; i++) {// 将数据进行分组
                for (j = i - gap; j >= 0; j -= gap) {// 对每组数据进行插入排序
                	if(array[j]>array[j+gap]){
                		temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                	}
                }
                // 打印每趟排序结果
                for (int m = 0; m <= array.length - 1; m++) {
                    System.out.print(array[m] + "\t");
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] array = { 5, 69, 12, 3, 56, 789, 2, 5648, 23 };
        //shellSort.shellSort(array, array.length);// 注意为数组的个数
        shellSort.mySort(array);
        for (int m = 0; m <= array.length - 1; m++) {
            System.out.print(array[m] + "\t");
        }
    }
}
