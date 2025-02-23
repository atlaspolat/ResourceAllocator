package com.ku.intervalscheduling.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.ku.intervalscheduling.interval.Interval;
import com.ku.intervalscheduling.model.Request;
import com.ku.intervalscheduling.model.Resource;
import com.ku.intervalscheduling.scheduler.Scheduler;
import com.ku.intervalscheduling.util.sorting.heapsort.HeapSort;

public class GreedyScheduling<T extends Resource, P extends Request<T> & Interval> extends Scheduler<T,P> {

	public GreedyScheduling(Class<T> resource, Class<P> request) {
		super(resource, request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void schedule() {
		// TODO Auto-generated method stub
		
		List<P> sortedRequests = sortRequests();
		
		scheduledRequests = new ArrayList<P>();
		
		scheduledRequests.add(sortedRequests.get(0));
		
		for(int i = 1; i < sortedRequests.size(); i++) {
			
			P canRequest = sortedRequests.get(i);
			
			boolean canSchedule = true;
			
			for(P req : scheduledRequests) {
				
				if(areClashing(canRequest, req)) {
					canSchedule = false;
					break;
				}
				
			}
			if(canSchedule) scheduledRequests.add(canRequest);
			
		}
		
		
		
	}

	private List<P> sortRequests() {
		// TODO Auto-generated method stub
		
		
		HeapSort<P> heapSort = new HeapSort<P>();
		
		return heapSort.sort(requests, new EarliestFinishTimeComparator<P>());
	}


	protected List<P> getNonClashingRequests(P request) {

		List<P> nonClashingRequests = new ArrayList<P>();
		
		for(P req : requests) {
			
			if(!areClashing(request, req)) {
				nonClashingRequests.add(req);
			}
		}
		
		return nonClashingRequests;
	}

	protected Boolean areClashing(P request1, P request2) {
		// TODO Auto-generated method stub
		return !(request1.getStartTime() >= request2.getEndTime() || request1.getEndTime() <= request2.getStartTime());
		
		
	}
	
	
	public void printSchedule() {
		
		System.out.println("Scheduled Requests:");
		
		for(int i = 0; i < scheduledRequests.size(); i++) {
			System.out.println(scheduledRequests.get(i));
		}
	}
	
	
	
}

class EarliestFinishTimeComparator<P extends Interval> implements java.util.Comparator<P> {

	@Override
	public int compare(P o1, P o2) {
		// TODO Auto-generated method stub
		return (int) (o2.getEndTime() - o1.getEndTime());
	}
	
}
	
	 
