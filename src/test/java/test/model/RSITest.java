package test.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.RSI;

public class RSITest {

	private RSI rsi;
	private int period;
	
	@Before
	public void setUp() throws Exception {
		this.period = 3;
		rsi = new RSI(period);
	}
	
	@Test
	public void testDataPointSize() {
		
		for(int i = 0; i<period; i++){
			rsi.addDataPoint(1.0);
		}
		
		rsi.addDataPoint(1.0);		
		assertEquals(period, rsi.dataPoints.size());
	}
	
	@Test
	public void testPopHead() {
		
		rsi.addDataPoint(1.0);
		rsi.addDataPoint(2.0);
		rsi.addDataPoint(3.0);		
		rsi.addDataPoint(4.0);
		
		assertEquals(2.0, rsi.dataPoints.getFirst());
	}

	@Test
	public void testGetValue() {
		//fail("Not yet implemented");
	}

	
}
