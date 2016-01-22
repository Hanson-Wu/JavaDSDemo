package dsApp.Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import basicDS.Heap;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap myHeap = new Heap();
		 List<Integer> array = new ArrayList<Integer>(Arrays.asList(null, 1, 2, 5, 10, 3, 7, 11, 15, 17, 20, 9, 15, 8, 16));
	        myHeap.adjust(array);//����ʹarray��Ϊ����
	       
	        myHeap.delete(array,8);//����ɾ���±���8��Ԫ��
	        System.out.println("ɾ����");
	        myHeap.print(array);

	        myHeap.insert(array, 99);//���в���
	        myHeap.print(array); 

	        myHeap.heapSort(array);//����
	        System.out.println("���������:");
	        myHeap.print(array);
	        System.out.println("-------------------------");
	        List<Integer> array1=new ArrayList<Integer>();
	        myHeap.insert(array1,0);
	        myHeap.insert(array1, 1);myHeap.insert(array1, 2);myHeap.insert(array1, 5);
	        myHeap.insert(array1, 10);myHeap.insert(array1, 3);myHeap.insert(array1, 7);
	        myHeap.insert(array1, 11);myHeap.insert(array1, 15);myHeap.insert(array1, 17);
	        myHeap.insert(array1, 20);myHeap.insert(array1, 9);
	        myHeap.insert(array1, 15);myHeap.insert(array1, 8);myHeap.insert(array1, 16);
	        myHeap.print(array1);
	        
	        System.out.println("==============================");
	        array=new ArrayList<Integer>(Arrays.asList(null,45,36,18,53,72,30,48,93,15,35));
	        myHeap.adjust(array);
	        myHeap.insert(array, 80);//���в���
	        myHeap.print(array);
	        myHeap.delete(array,2);//����ɾ��80��Ԫ��
	        myHeap.print(array);
	        myHeap.delete(array,2);//����ɾ��72��Ԫ��
	        myHeap.print(array);
	}

}
