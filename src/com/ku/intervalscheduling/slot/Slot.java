package com.ku.intervalscheduling.slot;

import com.ku.intervalscheduling.time.Time;

public class Slot implements com.ku.intervalscheduling.model.Request<Time>, com.ku.intervalscheduling.interval.Interval {

	private int id;
	
	private float startTime;
	
	private float endTime;
	
	private float cost = 0.0f;
	
	private float value = 0.0f;
	
	
	
	public Slot(int id, float startTime, float endTime, float cost, float value) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.cost = cost;
		this.value = value;
	

		if (startTime >= endTime) {
			throw new IllegalArgumentException("Start time must be less than end time");
		}
		
		if (startTime < 0) {
			throw new IllegalArgumentException("Start time must be greater than or equal to 0");
		}
		
		if (endTime < 0) {
			throw new IllegalArgumentException("End time must be greater than or equal to 0");
		}
		
		if (startTime == endTime) {
			throw new IllegalArgumentException("Start time must not be equal to end time");
		}
		
		if (cost < 0) {
			throw new IllegalArgumentException("Cost must be greater than or equal to 0");
		}
		
		if (value < 0) {
			throw new IllegalArgumentException("Value must be greater than or equal to 0");
		}
		
		
	}
	

	public int getId() {
		return id;
	}
	
	public float getStartTime() {
		return startTime;
	}
	
	public float getEndTime() {
		return endTime;
	}
	
	
	@Override
	public String toString() {
		return "Slot [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", cost=" + cost + ", value=" + value + "]";
	}

	@Override
	public Time getResource() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public float getCost() {
		// TODO Auto-generated method stub
		return this.cost;
	}


	@Override
	public float getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

}
