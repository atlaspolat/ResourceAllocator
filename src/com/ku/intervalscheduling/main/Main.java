package com.ku.intervalscheduling.main;

import com.ku.intervalscheduling.algorithm.GreedyScheduling;
import com.ku.intervalscheduling.time.Time;
import com.ku.intervalscheduling.slot.Slot;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	
		Time time0 = new Time(0, 8, 16);
		
		
		GreedyScheduling<Time, Slot> greedyScheduling = new GreedyScheduling<Time, Slot>(Time.class, Slot.class);
		
		greedyScheduling.addResource(time0);
		
		greedyScheduling.addRequest(new Slot(1, 8, 10, 0, 1));  // Slot 1: 08:00 - 10:00
		greedyScheduling.addRequest(new Slot(2, 9, 12, 0, 1));  // Overlaps with 1
		greedyScheduling.addRequest(new Slot(3, 10, 11, 0, 1)); // Fits between 1 & 2
		greedyScheduling.addRequest(new Slot(4, 11, 13, 0, 1)); // Overlaps with 2,3
		greedyScheduling.addRequest(new Slot(5, 12, 14, 0, 1)); // Overlaps with 2,4
		greedyScheduling.addRequest(new Slot(6, 13, 15, 0, 1)); // Overlaps with 5
		greedyScheduling.addRequest(new Slot(7, 14, 16, 0, 1)); // Overlaps with 6
		greedyScheduling.addRequest(new Slot(8, 8, 16, 0, 1));  // Covers the entire time (greedy trap)
		greedyScheduling.addRequest(new Slot(9, 8, 9, 0, 1));   // Small slot, fits early
		greedyScheduling.addRequest(new Slot(10, 15, 16, 0, 1)); // Small slot, fits late
		
		greedyScheduling.schedule();
		
		greedyScheduling.printSchedule();
		
		
	}

}
