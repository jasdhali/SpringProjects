package com.apress.springrecipes.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
/* Preparing the final FinalService class so that we could mock it*/
//@PrepareForTest(Method.class)
public class CalculatorLogginAspectTest {
	
	//@Rule
    //public PowerMockRule rule = new PowerMockRule();
	//private Log log = LogFactory.getLog(this.getClass());
	
	@Test
	public void logBeforeSuccess(){
		JoinPoint mockJP = null;
		Signature mockSignature = null;
		//Method mockMethod = null;
		
		CalculatorLogginAspect calculatorLogginAspect = null;

		calculatorLogginAspect = PowerMockito.mock(CalculatorLogginAspect.class);
		
		mockJP = PowerMockito.mock( JoinPoint.class );
		Object[] args = new Object[]{Double.class,Double.class};
		mockSignature = PowerMockito.mock( Signature.class );
		//mockMethod = PowerMockito.mock( Method.class );
		//PowerMockito.when( mockMethod.getName()).thenReturn("MockMethod");
		
		PowerMockito.when( mockSignature.getName()).thenReturn("mockSignature");
		PowerMockito.when( mockJP.getSignature()).thenReturn(mockSignature);
		PowerMockito.when( mockJP.getArgs()).thenReturn(args);
		calculatorLogginAspect.logBefore( mockJP );
		Mockito.verify(calculatorLogginAspect).logBefore( mockJP );
	}
	

}
