package com.utils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RandUtilsTest 
    extends TestCase
{
    
    public RandUtilsTest( String testName )
    {
        super( testName );
    }

    
    public static Test suite()
    {
        return new TestSuite( RandUtilsTest.class );
    }

    
    public void testRandomLargerEqualsThanZero()
    {    	
        Double randomNumber = RandUtils.randomize();
        assertTrue(randomNumber>=0);
    }
    
    public void testRandomSmallerEqualsThanOne()
    {    	
        Double randomNumber = RandUtils.randomize();
        assertTrue(randomNumber<=1);
    }
}
