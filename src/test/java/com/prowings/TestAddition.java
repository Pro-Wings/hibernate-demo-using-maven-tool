package com.prowings;

import org.junit.Test;

import junit.framework.Assert;

public class TestAddition {
	
	@Test
	public void testAddMethod()
	{
		System.out.println("inside test method add() of TestAddition class!!");
		Addition a = new Addition();
		
		int res = a.add(10, 20);
		
		Assert.assertEquals(30, res);
	}

}
