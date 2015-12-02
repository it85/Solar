package model;

import java.util.ArrayDeque;
import java.util.Deque;

public abstract class MovingIndicator {
	
	public Deque<Double> dataPoints;
	public int period;
	
	public MovingIndicator(int period){
		this.period = period;
		this.dataPoints = new ArrayDeque<Double>();
	}
	
	public abstract double getValue();
	
	protected void addDataPoint(double data){
		this.dataPoints.addLast(data);		
		removeHeadIfFull();
	}
	
	private void removeHeadIfFull(){
		if(this.dataPoints.size() > this.period){
			this.dataPoints.removeFirst();
		}
	}
}
