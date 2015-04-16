package factorial;

import java.math.BigInteger;

public class Factorial {

	public Factorial() {
		super();
	}
	
	public BigInteger getSolve (int value) {
		if (value < 0) return BigInteger.valueOf(0);
		else if (value == 0) return BigInteger.valueOf(1);
		else return getSolve(value-1).multiply(BigInteger.valueOf(value));
	}
}
