package model;

public class RSI extends MovingIndicator{

	public RSI(int period) {
		super(period);
	}

	@Override
	public double getValue() {
		return 100 - (100 / 1 + calculateRS());
	}
	
	private double calculateRS() {
		double gain = 0;
		double loss = 0;
		
		for(double d : this.dataPoints){
			if(d > 0){
				gain += d;
			}else{
				loss += d;
			}
		}
		
		double avgGain = gain / this.period;
		double avgLoss = loss / this.period;
		
		return avgGain/avgLoss;		
	}
}
