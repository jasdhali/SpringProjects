package com.apress.springrecipes.calculator;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;

public class CalcLogginAspectTest {
	
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private JoinPoint joinPoint;

    //private CalculatorLogginAspect calculatorLogginAspect = new CalculatorLogginAspect();
	
    @Test
    public void testAddingTwoPositiveDoubles() throws Throwable {
		Signature mockSignature = null;
		CalculatorLogginAspect calculatorLogginAspectMock = PowerMockito.mock( CalculatorLogginAspect.class );
		Object[] args = new Object[]{Double.class,Double.class};
		args[0] = 10d;
		args[1] = 20d;
		
		mockSignature = PowerMockito.mock( Signature.class );
		//mockMethod = PowerMockito.mock( Method.class );
		//PowerMockito.when( mockMethod.getName()).thenReturn("MockMethod");
		
		PowerMockito.when( mockSignature.getName()).thenReturn("mockSignature");
		PowerMockito.when( joinPoint.getSignature()).thenReturn(mockSignature);
		PowerMockito.when( joinPoint.getArgs()).thenReturn(args);

    	calculatorLogginAspectMock.logBefore(joinPoint);
        // 'proceed()' is called exactly once
        //verify(joinPoint, times(1));
        verify(calculatorLogginAspectMock,times(1)).logBefore(joinPoint);
        //verify(calculatorLogginAspectMock,times(1)).logAfter(joinPoint);
        // 'proceed(Object[])' is never called
        //verify(proceedingJoinPoint, never());
    }
    
    /*
    @Test
    public void testNegativeNumber() throws Throwable {
        sampleAspect.intercept(proceedingJoinPoint, -22);
        // 'proceed()' is never called
        verify(proceedingJoinPoint, never()).proceed();
        // 'proceed(Object[])' is called exactly once
        verify(proceedingJoinPoint, times(1)).proceed(new Object[] { 22 });
    }
	
    @Test(expected = RuntimeException.class)
    public void testPositiveLargeNumber() throws Throwable {
        sampleAspect.intercept(proceedingJoinPoint, 333);
    }
    */
}
