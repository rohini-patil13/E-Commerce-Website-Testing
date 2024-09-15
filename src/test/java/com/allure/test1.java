package com.allure;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
  @Test
  public void testMethod1() {
	  Assert.assertTrue(true);
	  System.out.println("test1 failed");
  }
}
