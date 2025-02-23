package com.ku.intervalscheduling.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.ku.intervalscheduling.model.Request;
import com.ku.intervalscheduling.model.Resource;
import com.ku.intervalscheduling.scheduler.Scheduler;

public class GreedyScheduling<T extends Resource, P extends Request<T>> extends Scheduler<T,P> {

	public GreedyScheduling(Class<T> resource, Class<P> request) {
		super(resource, request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void schedule() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
	
	 
