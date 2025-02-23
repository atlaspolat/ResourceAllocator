package com.ku.intervalscheduling.time;

public class Time implements com.ku.intervalscheduling.model.Resource, com.ku.intervalscheduling.interval.Interval {

	private int id;
	
	private float startTime;
	
	private float endTime;
	
	private float budget = 1.0f;
	
	
	
	public Time(int id, float startTime, float endTime, float Budget) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.budget = Budget;

		if (startTime >= endTime) {
			throw new IllegalArgumentException("Start time must be less than end time");
		}
		
		if (Budget <= 0) {
			throw new IllegalArgumentException("Budget must be greater than or equal to 0");
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
		
		if (Budget > endTime - startTime) {
			throw new IllegalArgumentException("Budget cannot be greater than the difference between start time and end time");
		}
		
		
	}
	
	public Time(int id, float startTime, float endTime) {
		
		this(id, startTime, endTime, endTime - startTime);
		
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
	
	public float getBudget() {
		return budget;
	}
	
	public String toString() {
		return "Time [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", budget=" + budget + "]";
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		
		Time time = (Time) obj;
		
		return time.getId() == this.getId() && time.getStartTime() == this.getStartTime() && time.getEndTime() == this.getEndTime() && time.getBudget() == this.getBudget();
	}
	
	public int hashCode() {
		return id;

}
}
