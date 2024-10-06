package com.utility;

import org.testng.ITestListener;
import org.testng.annotations.Test;

import com.base.BaseClass;

import io.qameta.allure.model.TestResult;

public class ListenerCLass extends BaseClass implements ITestListener{
  @Test
  public void onTestFailure(TestResult result) {
	  
	  System.out.println("Test case failed!");
	  try {
		  captureScreenshot(result.getName());
	} catch (Exception e) {
		e.getMessage();
	}
  }
}
