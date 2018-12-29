package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testnglisteners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName());
		
	}

}
