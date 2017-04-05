package com.wbl.JanAutomationFramework.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class LoggerListener extends TestListenerAdapter {


	
	Logger logger = LogManager.getLogger(LoggerListener.class);
	
		@Override
		public void onTestStart(ITestResult tr) {
			logger.info("Test Started....");
		}

		@Override
		public void onTestSuccess(ITestResult tr) {

			logger.info("Test '" + tr.getName() + "' PASSED");
			logger.info("Priority of this method is " + tr.getMethod().getPriority());
		}

		@Override
		public void onTestFailure(ITestResult tr) {
			logger.error("Test '" + tr.getName() + "' FAILED");
			logger.error("Priority of this method is " + tr.getMethod().getPriority());
		}

		@Override
		public void onTestSkipped(ITestResult tr) {
			logger.warn("Test '" + tr.getName() + "' SKIPPED");
		}


	}
