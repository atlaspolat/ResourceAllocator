package com.ku.intervalscheduling.util.sorting.heapsort;

import java.util.Comparator;
import java.util.List;

public class Heap<T> {
	
	protected T[] heap;
	
	protected int size;
	
	private boolean isHeaped  = false;
	
	public Heap(T[] array, int size) {
		this.heap = array;
		this.size = size;	
	}
	
	public Heap(T[] array) {
		this.heap = array;
		this.size = array.length;	
	}
	
	@SuppressWarnings("unchecked")
	public Heap(List<T> list) {
		this.heap = (T[]) list.toArray();
		this.size = list.size();
	}
	
	
	
	public T getRoot() {
		// Get the root of the heap
		if(!isHeaped) {
			return null;
		}
		
		return heap[0];
	}
	
	protected void swap(int i, int j) {
		T temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
	
	protected int getLeftChild(int i) {
		return 2*i + 1;
	}
	
	protected int getRightChild(int i) {
		return 2*i + 2;
	}

	protected void heapify(int target, int size, Comparator<T> comparator) {
		
		int left = getLeftChild(target);
		int right = getRightChild(target);
		
		int largest = target;
		
		if(left < size && comparator.compare(heap[left], heap[largest]) > 0) {
			largest = left;
		}
		
		if(right < size && comparator.compare(heap[right], heap[largest]) > 0) {
			largest = right;
		}
		
		if(largest != target) {
			swap(target, largest);
			heapify(largest, size, comparator);
		}
		
		
	}
	
	public void buildHeap(Comparator<T> comparator) {
		
		
		for(int i = size/2 - 1; i >= 0; i--) {
			heapify(i, size, comparator);
		}
		
		isHeaped = true;
	}
	
	
	
	

}
