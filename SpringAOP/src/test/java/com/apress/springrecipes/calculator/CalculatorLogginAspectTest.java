package com.apress.springrecipes.calculator;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
/* Preparing the final FinalService class so that we could mock it*/
//@PrepareForTest(Method.class)
public class CalculatorLogginAspectTest {
	
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    //private Log log = LogFactory.getLog(this.getClass());

	@Test
	public void logBeforeSuccess(){
		CalculatorLogginAspect calculatorLogginAspect =	PowerMockito.mock( CalculatorLogginAspect.class );

		JoinPoint mockJP = null;
		Signature mockSignature = null;
		//Method mockMethod = null;
				
		mockJP = PowerMockito.mock( JoinPoint.class );
		Object[] args = new Object[]{Double.class,Double.class};
		args[0] = 10d;
		args[1] = 20d;
		mockSignature = PowerMockito.mock( Signature.class );
		//mockMethod = PowerMockito.mock( Method.class );
		//PowerMockito.when( mockMethod.getName()).thenReturn("MockMethod");
		
		PowerMockito.when( mockSignature.getName()).thenReturn("mockSignature");
		PowerMockito.when( mockJP.getSignature()).thenReturn(mockSignature);
		PowerMockito.when( mockJP.getArgs()).thenReturn(args);

		calculatorLogginAspect.logBefore( mockJP );
        //verify(mockJP, times(1));
        //verify(mockJP);
		Mockito.verify(calculatorLogginAspect,times(1)).logBefore( mockJP );
	}
	

}
