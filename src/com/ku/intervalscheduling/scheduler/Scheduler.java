package com.ku.intervalscheduling.scheduler;

import java.util.ArrayList;
import java.util.List;

import com.ku.intervalscheduling.model.Request;
import com.ku.intervalscheduling.model.Resource;

public abstract class Scheduler<T extends Resource, P extends Request<T>> {
	
	
	protected List<P> requests;
	
	protected List<T> resources;
	
	protected final Class<T> resourceType;
	protected final Class<P> requestType;
	
	public Scheduler(Class<T> resource, Class<P> request) {
		
		requests = new ArrayList<P>();
		resources = new ArrayList<T>();
		
		resourceType = resource;
		requestType = request;
		
	}
	
	
	public void addRequest(P request) { // ✅ Accepts P directly
	    if (requests == null) {
	        requests = new ArrayList<>();
	    }
	    requests.add(request);
	}
	
	public void addResource(T resource) { // ✅ Accepts P directly
	    if (resources == null) {
	    	resources = new ArrayList<>();
	    }
	    resources.add(resource);
	}
	
	public void removeRequest(P request) {
		
		if(requests != null) {
			requests.remove(request);
		}
	}
	
	public void removeResource(T resource) {
		
		if(resources != null) {
			resources.remove(resource);
		}
	}
	
	public void clearRequests() {
		
		if(requests != null) {
			requests.clear();
		}
	}
	
	public void clearResources() {
		
		if(resources != null) {
			resources.clear();
		}
	}
	
	public void clear()	{
		
		clearRequests();
		clearResources();
	}
	

	public void setRequests(List<P> requests) {
		
		this.requests = new ArrayList<>(requests);;
	}
	
	public void setResources(List<T> resources) {
		
		this.resources = new ArrayList<>(resources);;
	}

	public List<P> getRequests() {
		return (List<P>) requests;
	}
	
	public List<T> getResources() {
		return (List<T>) resources;
	}
	
	public abstract void schedule();

}
