package Base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class AllureTestListener implements ITestListener {


    public void onStart(ITestContext context) {
        System.out.println(context.getName() + " started ***");
    }

    public void onFinish(ITestContext context) {

        System.out.println((context.getName() + " ending ***"));
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("*** Executed " + result.getMethod().getMethodName() + " test method successfully...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("*** Execution of a test method" + result.getMethod().getMethodName() + " of a test class " + result.getMethod().getRealClass().getName() + " failed...");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("*** Tests " + result.getMethod().getMethodName() + " skipped...");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Tests failed but within percentage % " + result.getMethod().getMethodName());
    }
}