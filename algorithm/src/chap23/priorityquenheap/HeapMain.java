package chap23.priorityquenheap;

import java.util.ArrayList;
import java.util.List;

/*

대소관계 규칙 : 부모 노드는 자식 노드가 가진 원소 이상
-마지막 레벨을 제외한 모든 레벨에 노드가 꽉차 있음
-마지막 레벨에 노드가 있을 때는, 항상 가장 왼쪽부터 순서대로 채워져 있어야 함
 */
public class HeapMain {
	
	public static void main(String[] args) {
		List<Integer> heap = new ArrayList<>();
		heap.add(8);
		heap.add(7);
		heap.add(6);
		heap.add(6);
		heap.add(6);
		heap.add(6);
		heap.add(5);		
		System.out.println("최대 : "+heap.get(0));
		pop_heap(heap);
		System.out.println("최대 : "+heap.get(0));
		
	}
	
	
	//정수를 담는 최대 힙 heap에 새 원소 newValue를 삽입
	public static void push_heap(List<Integer> heap, int newValue) {
		//힙의 맨 끝에 newValue를 삽입
		heap.add(newValue);
		
		//현재 newVale의 위치
		int idx = heap.size() -1;
		
		//루트에 도달하거나 newValue 이상의 원소를 가진 조상을 만나때 까지
		while( (idx > 0) && (heap.get((idx-1)/2) < heap.get(idx)) ) {
				swap(heap,idx,(idx-1)/2);
				idx = (idx -1) / 2;
		}
	}
	
	// 정수를 담는 최대 힙 heap에서 heap[0]을 제거
	public static void pop_heap(List<Integer> heap) {		
		// 힙의 맨 끝에서 값을 가져와 루트에 덮어 씌운다.
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);		
		int here = 0;
		while(true) {
			int left = here * 2 +1, right = here * 2 + 2;
			// 리프에 도달한 경우
			if(left >= heap.size()) break;
			//heap[here]의 내려갈 위치를 찾음
			int next = here;
			if(heap.get(next) < heap.get(left))
				next = left;
			if(right < heap.size() && heap.get(next) < heap.get(right))
				next = right;
			if(next == here) break;
			swap(heap,here,next);
			here = next;
		}
	}
	
	public static void swap(List<Integer> heap,int idx1,int idx2) {
		int idx1Val = heap.get(idx1);
		heap.set(idx1, heap.get(idx2));
		heap.set(idx2, idx1Val);		
	}
	

}
