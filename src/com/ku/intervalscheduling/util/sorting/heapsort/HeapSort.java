package com.ku.intervalscheduling.util.sorting.heapsort;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

// This class is used to sort the heap using the heap sort algorithm
// This is already static and does not need to be instantiated
public class HeapSort<T> {
	
	public List<T> sort(List<T> list, Comparator<T> comparator){
		
		Heap<T> heap = new Heap<T>(list);
		
		return sort(heap, comparator);
		
		
	}
	
	public List<T> sort(T[] array, Comparator<T> comparator){
		
		Heap<T> heap = new Heap<T>(array);
		
		return sort(heap, comparator);
		
	}

	
	public List<T> sort(Heap<T> heap, Comparator<T> comparator) {
		
		heap.buildHeap(comparator);
		
		List<T> sorted = new ArrayList<T>();
		
		for(int i = heap.size - 1; i >= 0; i--) {
			heap.swap(0, i);
			sorted.add(heap.heap[i]);
			heap.heapify(0, i, comparator);
		}
		
		return sorted;
	}
	
	

}
