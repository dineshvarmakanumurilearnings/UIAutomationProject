package Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import test.application.basic.BasePage;

public class Listnerz extends BasePage implements ITestListener{

	ExtentReports extent = ExtentRepoterNG.extentReportGenerator();
	public ExtentTest test;
	//Thread local doesn't allow to override the ExtentTest instance
		ThreadLocal<ExtentTest> extest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName());
		 test = extent.createTest(result.getName());
		 extest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extest.get().log(Status.PASS, "Successfully passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		/*
		 * WebDriver fdriver = null; Object obj=result.getInstance(); Class<?> clazz =
		 * result.getTestClass().getRealClass(); try { fdriver = (WebDriver)
		 * clazz.getDeclaredField("threaddriver").get(obj); } catch (Exception e1) {
		 * e1.printStackTrace(); }
		 */
		extest.get().fail(result.getThrowable());
		try {
			extest.get().addScreenCaptureFromPath(getScreenShot(result.getName()), result.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
