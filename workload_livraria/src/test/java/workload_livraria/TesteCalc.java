package workload_livraria;

import org.junit.Test;

import data.Calc;
import data.Calc2;
import data.Calc2I;
import junit.framework.Assert;

public class TesteCalc {
	
	@Test
	public void test_soma() {
		// setup
		
		Calc2I calc2 = new Calc2Fake();
		Calc calc = new Calc(calc2);
		
		// executar algo
		String sum = calc.sumCalc2(2, 2);
		String sumCom1 = calc.sumCalc2(1, 1);
		
		// testar saidas da execucao
		Assert.assertNotNull(sum);
		Assert.assertEquals("4", sum);
		Assert.assertEquals("0", sumCom1);
	}

}
