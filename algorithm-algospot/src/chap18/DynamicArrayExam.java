package chap18;

/*
Dynamic Array
기존 배열의 장점 
+ resize,append
=> resize == O(N)
=> append == O(1) 
=> append는 호출할 때마다 수행 시간이 달라지는 함수
 	=> 시간복잡도 == 연산을 여러 번 반복 & 수행 시간 계산(분할 상환 분석)
=> 
e.g) 텅빈 배열, N번의 append()
-> 재할당의 수 K = O(N/M)
-> M은 상수이므로 N이 아주 커지면 K=O(N)
-> + 복사하는 원소이 개수 M,2M,...KM => total = {(K+1)K}*k*M/2 = O(K^2) = O(N^2)
-> N번의 append에 O(N^2) 이면 append 연산에 드는 시간은 평균적으로  O(N^2)/N = O(N)
-> append() == O(1) 불가능

==> 재할당을 할 때마다 정해진 개수의 여유분을 확보하는게 아니라, 현재 가진 원소의 개수에 비례해서 여유분 확보

e.g) 처음 배열 용량 1에서 시작 꽉차면 2, 4 ...
재할당 시점		1	2	4	8	16	32	..	2048	4096	8192
새배열 크기		2	4	8	16	32	64	..	4096	8192	16384
=> 복사의 총 수 1+2+4+...8192 = 16383

=>i(i>=0)번 재할당 시에 복사하는 원소의 수 2^i
=>마지막에 K-1번 복사 , K-2번복사( (K-1)/2) , k-3번 복사( (K-1)/4 ) ...
=>2^K-1번 복사하는게 O(N)이고 나머지는 (K-2번 + ....1)는 K-1번 복사하는 것과 비슷하므로 결국 O(N)
=>append 연산을 N 번하는데 O(N)이면 결국 한번의 append()는 상수시간을 가짐.

====> c++ == vector , java,c# == arraylist
====> 동적 배열 시 append()연산을 여러번 수행할 경우 미리 capacity를 늘려둬서 재할당 낭비 없애기
 */

class SimpleDynamicArray {
	static final int M = 10;
	static final int DEFAULT_CAPACITY = 10;
	int size;
	int capacity;
	int[] arr;	
	
	public SimpleDynamicArray(int capacity) {
		this.capacity = capacity;
		size = 0;
	}
	
	public SimpleDynamicArray() {
		this(DEFAULT_CAPACITY);
	}	
	
	public void add(int value) {
		if(size == capacity) {
			int newCapacity = capacity + M;
			int[] newArr = new int[newCapacity];
			for(int i=0;i<capacity;i++) {
				newArr[i] = arr[i];
			}			
			arr = newArr;
			capacity = newCapacity;
		}
		arr[size++]  = value;
	}	
	
	public void add2(int value) {
		if(size == capacity) {
			int newCapacity = capacity*2;
			int[] newArr = new int[newCapacity];
			for(int i=0;i<capacity;i++) {
				newArr[i] = arr[i];
			}			
			arr = newArr;
			capacity = newCapacity;
		}
		arr[size++]  = value;
	}
	
}



public class DynamicArrayExam {
	

}
