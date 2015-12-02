package model;

public class RSI extends MovingIndicator{

	public RSI(int period) {
		super(period);
	}

	@Override
	public double getValue() {
		try{
			return 100 - (100 / 1 + calculateRS());
		}catch(ArithmeticException e){
			return 0.0;
		}
	}
	
	private double calculateRS() throws ArithmeticException{
		double gain = 0;
		double loss = 0;
		
		for(double d : this.dataPoints){
			if(d > 0){
				gain += d;
			}else{
				loss += (d*-1);
			}
		}
		
		double avgGain = gain / this.period;
		double avgLoss = loss / this.period;
		
		return avgGain/avgLoss;		
	}
}
