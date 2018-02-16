package data;

public class Calc {
	
	private Calc2I calc2;

	public Calc(Calc2I calc2) {
		super();
		this.calc2 = calc2;
	}



	public String sumCalc2(int n1, int n2) {
		if (n1 == 1) {
			return "1";
		}
		return calc2.sum(n1, n2);
	}

}
