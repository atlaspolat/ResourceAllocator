package com.ku.intervalscheduling.model;

public interface Request<T extends Resource> {

	public float getCost();
		
	public float getValue();

	public T getResource();
	
}
